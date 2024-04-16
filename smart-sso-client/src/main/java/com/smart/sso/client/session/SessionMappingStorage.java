package com.smart.sso.client.session;

import javax.servlet.http.HttpSession;

/**
 * 借鉴CAS
 */
public interface SessionMappingStorage {

    HttpSession removeSessionByMappingId(String accessToken);

    void removeBySessionById(String sessionId);

    void addSessionById(String accessToken, HttpSession session);
}
