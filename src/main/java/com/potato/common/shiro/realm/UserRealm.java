package com.potato.common.shiro.realm;

import com.potato.admin.system.user.domain.SysUser;
import com.potato.admin.system.user.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        SimpleAuthenticationInfo info = null;
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();
        SysUser sysUser;
        try {
            sysUser = sysUserService.selectUserByUsername(username);
            if (sysUser != null) {
                info = new SimpleAuthenticationInfo(sysUser, sysUser.getPassword(), ByteSource.Util.bytes(sysUser.getSalt()), getName());
            }
        } catch (Exception e) {

        }
        return info;
    }
}
