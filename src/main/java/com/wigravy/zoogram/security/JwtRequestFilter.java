package com.wigravy.zoogram.security;

import com.wigravy.zoogram.exceptions.JwtTokenException;
import com.wigravy.zoogram.services.CustomUserDetailsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@AllArgsConstructor
@Slf4j
public class JwtRequestFilter extends OncePerRequestFilter {
    private final CustomUserDetailsService detailsService;
    private final JwtTokenUtil jwtTokenUtil;


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String jwt = getJwtTokenFromRequest(request);
        try {
            if (StringUtils.hasText(jwt) && jwtTokenUtil.validateToken(jwt)) {
                UserDetails userDetails = detailsService.loadUserByUsername(jwtTokenUtil.getUsernameFromToken(jwt));
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        filterChain.doFilter(request, response);
    }

    private String getJwtTokenFromRequest(HttpServletRequest request) throws JwtTokenException {
        String authHeader = request.getHeader(SecurityConstans.HEADER_STRING);
        if (StringUtils.hasText(authHeader) && authHeader.startsWith(SecurityConstans.TOKEN_PREFIX)) {
            return authHeader.substring(7);
        }
        logger.error("Failed to get token from request");
        throw new JwtTokenException("Failed to get token from request");
    }
}
