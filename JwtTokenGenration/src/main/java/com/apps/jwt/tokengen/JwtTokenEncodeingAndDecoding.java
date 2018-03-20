package com.apps.jwt.tokengen;

import java.util.Date;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;

public class JwtTokenEncodeingAndDecoding {
    public void tokenGenration() {
    	String jwtb = Jwts.builder().setId("123456").claim("user", "sairam").claim("password", "sairam").setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(2018, 5, 26)).setIssuer("sairam").signWith(SignatureAlgorithm.HS256, "hello world!").compact();
    	System.out.println("final String is "+jwtb);
    	Jws claimString = Jwts.parser().setSigningKey("hello world!").parseClaimsJws(jwtb);
    	DefaultClaims defaultClaims = (DefaultClaims)claimString.getBody();
    	Set set = defaultClaims.entrySet();
    	Iterator itr =  set.iterator();
    	while(itr.hasNext()) {
    		Entry entry = (Entry)itr.next();
    		System.out.println(entry.getKey() +"----"+entry.getValue());
    	}
    }
    public static void main(String[] args) {
    	JwtTokenEncodeingAndDecoding jwttest = new JwtTokenEncodeingAndDecoding();
    	jwttest.tokenGenration();
	}
}
