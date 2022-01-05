package com.butu.blog.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author BUTUbird
 */
public class JwtToken implements AuthenticationToken {
    private String token;

    public JwtToken(String jwt){
        this.token = jwt;
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
