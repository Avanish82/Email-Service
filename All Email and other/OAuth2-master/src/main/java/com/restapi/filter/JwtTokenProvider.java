//package com.restapi.filter;
//
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.JwtException;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import javax.servlet.http.HttpServletRequest;
//import java.util.Base64;
//import java.util.Date;
//import java.util.List;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
//@Slf4j
//@Component
//public class JwtTokenProvider {
//
//    @Value("${open.api.jwt.secret}")
//    private String jwtSecret;
//
//    private OpenApiUserDetailsServiceImpl openApiUserDetailsService;
//
////    private ApplicationPropertiesService applicationPropertiesService;
//
////    @Autowired
////    public void setApplicationPropertiesService(ApplicationPropertiesService applicationPropertiesService) {
////        this.applicationPropertiesService = applicationPropertiesService;
////    }
//
//    @Autowired
//    public JwtTokenProvider(OpenApiUserDetailsServiceImpl openApiUserDetailsService) {
//        this.openApiUserDetailsService = openApiUserDetailsService;
//    }
//
//    @PostConstruct
//    protected void init() {
//        jwtSecret = Base64.getEncoder().encodeToString(jwtSecret.getBytes());
//    }
//
//    public String createToken(String creator, List<OpenApiRole> roles, long jwtExpiration) {
//
//        Claims claims = Jwts.claims().setSubject(creator);
//        claims.put("auth", roles.stream().map(s -> new SimpleGrantedAuthority(s.getAuthority()))
//                .filter(Objects::nonNull).collect(Collectors.toList()));
//        log.info(String.valueOf(claims.get("auth")));
//
//        log.info("tokenExpiryTime: " + jwtExpiration + " millisecond");
//
//        Date now = new Date();
//        Date validity = new Date(now.getTime() + jwtExpiration);
//
//        return Jwts.builder()//
//                .setClaims(claims)//
//                .setIssuedAt(now)//
//                .setExpiration(validity)//
//                .signWith(SignatureAlgorithm.HS256, jwtSecret)//
//                .compact();
//    }
//
//    public String resolveToken(HttpServletRequest req) {
//        String bearerToken = req.getHeader("jwt");
//        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
//            return bearerToken.substring(7, bearerToken.length());
//        }
//        return null;
//    }
//
//    public boolean validateToken(String token, HttpServletRequest req) throws JWTException {
//        try {
//            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
//            return true;
//        } catch (JwtException | IllegalArgumentException e) {
//            throw new JWTException("Expired or invalid JWT token");
//        }
//    }
//
//    public Authentication getAuthentication(String token) {
//
//        UserDetails userDetails = openApiUserDetailsService.loadUserByUsername("");
//        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
//    }
//
//}
