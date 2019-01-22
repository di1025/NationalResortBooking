package com.chendi.project.extend.security;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mobile.device.Device;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Component
public class JwtTokenUtil {

    private static final String CLAIM_KEY_USERNAME ="sub";
    private static final String CLAIM_KEY_AUDIENCE ="audience";
    private static final String CLAIM_KEY_CREATED ="created";

    private static final String AUDIENCE_UNKNOWN ="audience";
    private static final String AUDIENCE_TABLET ="tablet";
    private static final String AUDIENCE_MOBILE ="mobile";

//    @Value("#{shareProperties['jwt.secret]}")
    private String secret = "secret";


//    @Value("#{shareProperties['jwt.expiration]}")
    private Long expiration = 86400L;

    private String generateAudience(Device device){
        String audience = AUDIENCE_UNKNOWN;
        if (device.isNormal()){
            audience = AUDIENCE_UNKNOWN;
        } else if (device.isTablet()){
            audience = AUDIENCE_TABLET;
        } else if (device.isMobile()){
            audience = AUDIENCE_MOBILE;
        }
        return audience;
    }
     private Date generateExpirationDate(){
        return new Date (System.currentTimeMillis()+ expiration* 1000);
     }

    public String generateToken(UserDetails userDetails, Device device){
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAIM_KEY_AUDIENCE, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    private String generateToken(Map<String,Object> claims){//claims is payload; output is using Jwts uses payload to generate a token
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

}
