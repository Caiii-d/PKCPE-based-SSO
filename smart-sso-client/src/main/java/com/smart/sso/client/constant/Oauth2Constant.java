package com.smart.sso.client.constant;


public class Oauth2Constant {

	/**
	 * 用于保持请求和回调的状态，授权请求后原样带回给第三方。该参数可用于防止 csrf 攻击
	 */
	public static final String STATE = "state";
	public static final String CODE_CHALLENGE = "codeChallenge";
	public static final String CODE_VERIFIER = "codeVerifier";
	public static final String CODE_CHALLENGE_METHOD = "codeChallengeMethod";
	public static final String GRANT_TYPE = "grantType";
	public static final String APP_ID = "appId";

	public static final String APP_SECRET = "appSecret";

	public static final String REFRESH_TOKEN = "refreshToken";

	public static final String AUTH_CODE = "code";

	public static final String USERNAME = "username";

	public static final String PASSWORD = "password";
	public static final String ACCESS_TOKEN_URL = "/oauth2/access_token";
	public static final String REFRESH_TOKEN_URL = "/oauth2/refresh_token";
}
