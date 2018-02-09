package com.example.demo.repository;

import com.example.demo.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by liw on 2018/02/08.
 */
//其接口类型使用了泛型，泛型参数中T代表实体类型，ID则是实体中id的类型。
public interface SysUserRepository extends JpaRepository<SysUser,Integer>{
    /**
     * 按用户名密码查找
     */
    SysUser findFirstByNameAndPassword(String name,String password);
}
