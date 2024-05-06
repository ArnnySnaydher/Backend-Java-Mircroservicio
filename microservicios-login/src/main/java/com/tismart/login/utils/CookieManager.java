package com.tismart.login.utils;

import org.springframework.stereotype.Component;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class CookieManager {

    public static Cookie getCookie(HttpServletRequest request, String name) {

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie;
                }
            }
        }
        return null;

    }

    public Cookie create(String key , String value){

        Cookie cookie = new Cookie( key , value);

        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setMaxAge(4500);
        cookie.setPath(key);

        return cookie;
    }


}
