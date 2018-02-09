package com.example.demo.service;

import com.example.demo.entity.SysUser;
import org.springframework.stereotype.Service;

/**
 * Created by liw on 2018/02/08.
 */
public interface SysUserService {
    /**
     * 注册用户
     * @param user
     * @return 注册成功将信息返回，否则返回null
     */
    SysUser saveUser(SysUser user);

    /**
     * 检测用户名密码
     * @param name
     * @param password
     * @return 验证通过将用户信息返回，否则返回null
     */
    SysUser loginCheck(String name, String password);
}
