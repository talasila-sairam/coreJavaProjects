package com.apps.jwt.tokengen;

import java.util.Date;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;

public class JwtTokenEncodeingAndDecoding {
    public void tokenGenration() {
    	String jwtb = Jwts.builder().setId("123456").claim("user", "sairam").claim("password", "sairam").setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(2018, 5, 26)).setIssuer("sairam").compact();
    	System.out.println("final String is "+jwtb);
    }
    public static void main(String[] args) {
    	JwtTokenEncodeingAndDecoding jwttest = new JwtTokenEncodeingAndDecoding();
    	jwttest.tokenGenration();
	}
}
