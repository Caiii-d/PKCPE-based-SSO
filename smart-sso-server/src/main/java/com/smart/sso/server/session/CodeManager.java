package com.smart.sso.server.session;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.smart.sso.client.constant.Oauth2Constant;
import com.smart.sso.server.common.CodeContent;
import com.smart.sso.server.common.Expiration;

/**
 * 授权码code管理
 */
public interface CodeManager extends Expiration {
	
	/**
	 * 生成授权码
	 * 
	 * @param tgt
	 * @param redirectUri
	 * @return
	 */
	default String generate(String tgt, boolean sendLogoutRequest, String redirectUri,String codeChallenge, String codeChallengeMethod) {
		String code = "code-" + UUID.randomUUID().toString().replaceAll("-", "");
		create(code, new CodeContent(tgt, sendLogoutRequest, redirectUri,codeChallenge,codeChallengeMethod
		));
		System.out.println("CodeContent:-------------" + codeChallenge);
		return code;
	}

	default String generate(String tgt, boolean sendLogoutRequest, String redirectUri) {
		String code = "code-" + UUID.randomUUID().toString().replaceAll("-", "");
		create(code, new CodeContent(tgt, sendLogoutRequest, redirectUri));
		System.out.println("CodeContent:-------------");
		return code;
	}
    /**
     * 生成授权码
     * 
	 * @param code
	 * @param codeContent
	 */
	public void create(String code, CodeContent codeContent) ;

    /**
     * 查找并删除
     * 
     * @param code
     * @return
     */
	CodeContent getAndRemove(String code);
	
	/* 
	 * code失效时间默认为10分钟
	 */
	@Override
	default int getExpiresIn() {
		return 600;
	}
}
