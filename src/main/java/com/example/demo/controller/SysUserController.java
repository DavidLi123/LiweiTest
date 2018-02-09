package com.example.demo.controller;

import com.example.demo.entity.RestResult;
import com.example.demo.entity.SysUser;
import com.example.demo.service.SysUserService;
import com.example.demo.utils.ResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.ConstraintDeclarationException;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


/**
 * 用户控制层
 * @RestController 表示该类所有返回值默认以JSON格式显示
 * @RequestMapping 匹配URL地址 /user
 * @Validated 表示该类启用参数验证，通过添加注解可以验证参数
 * Created by liw on 2018/02/08.
 */
@RestController
@RequestMapping("/user")
@Validated
public class SysUserController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    private final SysUserService userService;

    private final ResultGenerator generator;

    /**
     * 自动装填
     * @param userService
     * @param generator
     */
    @Autowired
    public SysUserController(SysUserService userService, ResultGenerator generator){
        this.userService = userService;
        this.generator = generator;
    }

    /**
     * 注册功能
     */
    @RequestMapping("/register")
    public RestResult register(@Valid SysUser user, BindingResult bindingResult){
        return generator.getSuccessResult("注册成功",userService.saveUser(user));
    }

    /**
     * 登录功能
     */
    public RestResult login(@NotNull(message = "用户名不能为空") String name, @NotNull(message = "密码不能为空") String password, HttpSession session){
        SysUser user = userService.loginCheck(name, password);
        if(user != null){
            session.setAttribute("user",user);
            return generator.getSuccessResult("登录成功",user);
        }
        return generator.getFailResult("用户账号或密码错误");
    }

    /**
     * 为参数验证添加异常处理器
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public RestResult ConstraintViolationException(ConstraintViolationException cve){
        String errorMessage = cve.getConstraintViolations().iterator().next().getMessage();
        return generator.getFailResult(errorMessage);
    }

    /**
     * 主键/唯一约束违反异常
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public RestResult handlerDataIntegrityViolationException(DataIntegrityViolationException dve){
        return generator.getFailResult("违反主键/唯一约束");

    }




}
