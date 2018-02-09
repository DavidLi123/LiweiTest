package com.example.demo.service;

import com.example.demo.entity.SysUser;
import com.example.demo.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 服务实现类
 * Created by liw on 2018/02/08.
 */
@Service("SysUserService")
public class SysUserServiceImpl implements SysUserService{

    @Autowired
    private SysUserRepository sysUserRepository;


    @Override
    public SysUser saveUser(SysUser user) {
        return sysUserRepository.save(user);
    }

    @Override
    public SysUser loginCheck(String name, String password) {
        return sysUserRepository.findFirstByNameAndPassword(name,password);
    }
}
