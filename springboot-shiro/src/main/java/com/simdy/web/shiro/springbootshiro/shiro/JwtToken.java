package com.simdy.web.shiro.springbootshiro.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Author: Simdy
 * @Date: Created on 2020/1/20 16:46
 * @Version: 0.0.1
 * @Modified By:
 * @Description:
 */

public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}

