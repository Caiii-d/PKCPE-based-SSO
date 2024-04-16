package com.smart.sso.server.common;

import java.io.Serializable;

/**
 * 授权存储信息
 */
public class CodeContent implements Serializable {

	private static final long serialVersionUID = -1332598459045608781L;

	private String tgt;
	private boolean sendLogoutRequest;
	private String redirectUri;
	private String codeChallenge;
	private String codeChallengeMethod;


	public String getCodeChallenge() {
		return codeChallenge;
	}

	public void setCodeChallenge(String codeChallenge) {
		this.codeChallenge = codeChallenge;
	}

	public String getCodeChallengeMethod() {
		return codeChallengeMethod;
	}

	public void setCodeChallengeMethod(String codeChallengeMethod) {
		this.codeChallengeMethod = codeChallengeMethod;
	}

	public CodeContent(String tgt, boolean sendLogoutRequest, String redirectUri, String codeChallenge,
			String codeChallengeMethod) {
		this.tgt = tgt;
		this.sendLogoutRequest = sendLogoutRequest;
		this.redirectUri = redirectUri;
		this.codeChallenge = codeChallenge;
		this.codeChallengeMethod = codeChallengeMethod;
	}

	public CodeContent(String tgt, boolean sendLogoutRequest, String redirectUri) {
		this.tgt = tgt;
		this.sendLogoutRequest = sendLogoutRequest;
		this.redirectUri = redirectUri;
	}

	public String getTgt() {
		return tgt;
	}

	public void setTgt(String tgt) {
		this.tgt = tgt;
	}

	public boolean isSendLogoutRequest() {
		return sendLogoutRequest;
	}

	public void setSendLogoutRequest(boolean sendLogoutRequest) {
		this.sendLogoutRequest = sendLogoutRequest;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}
}