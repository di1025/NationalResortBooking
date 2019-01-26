package com.chendi.project.extend.security;


import com.chendi.project.domain.User;
import io.jsonwebtoken.Claims;
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


    public Claims getClaimsFromToken(String token){
        Claims claims;
        try{
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e){
            claims=null;
        }
        return claims;
    }

    private Boolean isTokenExpired(String token){
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset){
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }

    public String getUsernameFromToken(String token){
        String username;
        try {
            final Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    public Date getCreatedDateFromToken(String token){
        Date created;
        try{
            final Claims claims = getClaimsFromToken(token);
            created = new Date ((Long) claims.get(CLAIM_KEY_CREATED));
        } catch (Exception e) {
            created = null;
        }
        return created;
    }

    public Date getExpirationDateFromToken(String token){
        Date expiration;
        try{
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e){
            expiration = null;
        }
        return expiration;
    }


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
        claims.put(CLAIM_KEY_AUDIENCE, generateAudience(device));
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

    public Boolean validateToken(String token, UserDetails userDetails){
        User user =(User) userDetails;
        final String username =getUsernameFromToken(token);
        final Date created = getCreatedDateFromToken(token);
//        final Date expiration = getExpirationDateFromToken(token);
        return (
                username.equals(user.getUsername())
                && !isTokenExpired(token));
//                && !isCreatedBeforeLastPasswordReset(created,Date.from(user.getLastResetAt())));
    }
}
