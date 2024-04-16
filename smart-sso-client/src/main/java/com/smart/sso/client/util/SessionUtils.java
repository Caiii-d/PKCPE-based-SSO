package com.smart.sso.client.util;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.smart.sso.client.constant.SsoConstant;
import com.smart.sso.client.rpc.RpcAccessToken;
import com.smart.sso.client.rpc.SsoUser;
import com.smart.sso.client.session.SessionAccessToken;

/**
 * Session工具
 */
public class SessionUtils {
    
    public static SessionAccessToken getAccessToken(HttpServletRequest request) {
        return (SessionAccessToken) request.getSession().getAttribute(SsoConstant.SESSION_ACCESS_TOKEN);
    }
    
	//获取用户信息
public static SsoUser getUser(HttpServletRequest request) {
	    //从请求中获取AccessToken
	    return Optional.ofNullable(getAccessToken(request)).map(u -> u.getUser()).orElse(null);
	}
	
	public static Integer getUserId(HttpServletRequest request) {
        return Optional.ofNullable(getUser(request)).map(u -> u.getId()).orElse(null);
    }

	public static void setAccessToken(HttpServletRequest request, RpcAccessToken rpcAccessToken) {
		SessionAccessToken sessionAccessToken = null;
		if (rpcAccessToken != null) {
			// 创建SessionAccessToken对象
			sessionAccessToken = createSessionAccessToken(rpcAccessToken);
		}
		// 将SessionAccessToken对象存储到Session中
		request.getSession().setAttribute(SsoConstant.SESSION_ACCESS_TOKEN, sessionAccessToken);
	}

	private static SessionAccessToken createSessionAccessToken(RpcAccessToken accessToken) {
		// 计算过期时间
		long expirationTime = System.currentTimeMillis() + accessToken.getExpiresIn() * 1000;
		// 创建SessionAccessToken对象
		return new SessionAccessToken(accessToken.getAccessToken(), accessToken.getExpiresIn(),
				accessToken.getRefreshToken(), accessToken.getUser(), expirationTime);
	}

	public static void invalidate(HttpServletRequest request) {
		// 设置访问令牌为空
		setAccessToken(request, null);
		// 销毁Session
		request.getSession().invalidate();
	}
}