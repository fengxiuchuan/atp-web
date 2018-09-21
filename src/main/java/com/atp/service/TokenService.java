package com.atp.service;

import com.atp.entity.sys.SysUser;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author: Administrator
 * @Date : 2018/9/21 10 37
 */
@Service
public class TokenService {

    public String getToken(SysUser user) {
        String token="";
        token= JWT.create().withAudience(user.getUserName())
                .sign(Algorithm.HMAC256(user.getUserPwd()));
        return token;
    }
}
