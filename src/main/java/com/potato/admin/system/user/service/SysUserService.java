package com.potato.admin.system.user.service;


import com.potato.admin.system.user.domain.SysUser;

/**
 * Created by dev on 2017/7/4 0004.
 */
public interface SysUserService {

    /**
     * 根据用户名查询用户数据
     * @param username
     * @return
     */
    SysUser selectUserByUsername(String username);
}
