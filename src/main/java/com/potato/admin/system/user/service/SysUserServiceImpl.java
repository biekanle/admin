package com.potato.admin.system.user.service;


import com.potato.admin.system.user.domain.SysUser;
import com.potato.admin.system.user.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dev on 2017/7/4 0004.
 */
@Service
public class SysUserServiceImpl implements SysUserService{

    @Autowired
    SysUserMapper sysUserMapper;



    @Override
    public SysUser selectUserByUsername(String username) {
        return sysUserMapper.selectUserByUsername(username);
    }
}
