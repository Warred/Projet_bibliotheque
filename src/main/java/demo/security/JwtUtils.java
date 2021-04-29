package demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JwtUtils {

    private static final long JWT_VALIDITY_MILLISECOND = 1000 * 60 * 60 * 24;

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(UserDetails user){
        String authorities = user.getAuthorities()                          // list = [ {name: "ROLE_USER"}, {name: "ROLE_ADMIN"} ]
                                 .stream()
                                 .map(GrantedAuthority::getAuthority)       //listString = [ "ROLE_USER", "ROLE_ADMIN" ]
                                 .collect(Collectors.joining(",")); //string = "ROLE_USER,ROLE_ADMIN"
        return Jwts.builder()
                .setClaims(new HashMap<>())
                .setSubject(user.getUsername())
                .claim("authority" , authorities)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_VALIDITY_MILLISECOND))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    private Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    public Date getExpirationDate(String token){
        return getClaims(token).getExpiration();
    }

    public Date getIssuedDate(String token){
        return getClaims(token).getIssuedAt();
    }

    public String getSubject(String token){
        return getClaims(token).getSubject();
    }

    public boolean isTokenExpired(String token) {
        return getExpirationDate(token).before(new Date());
    }

    public boolean isTokenValid(String token, UserDetails user){
        return StringUtils.equalsAnyIgnoreCase(getSubject(token), user.getUsername()) && !isTokenExpired(token);
    }
    
    public static Optional<String> getCurrentUserLogin() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(extractPrincipal(securityContext.getAuthentication()));
    }

    private static String extractPrincipal(Authentication authentication) {
        if (authentication == null) {
            return null;
        } else if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
            return springSecurityUser.getUsername();
        } else if (authentication.getPrincipal() instanceof String) {
            return (String) authentication.getPrincipal();
        }
        return null;
    }

}
