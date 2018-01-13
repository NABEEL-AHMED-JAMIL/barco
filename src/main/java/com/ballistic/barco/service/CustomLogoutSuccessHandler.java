package com.ballistic.barco.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nabeel on 1/11/2018.
 */
// No Issue Work fine
@Component
public class CustomLogoutSuccessHandler extends AbstractAuthenticationTargetUrlRequestHandler
        implements LogoutSuccessHandler {

    private final Logger log = LoggerFactory.getLogger(CustomLogoutSuccessHandler.class);

    private static final String BEARER_AUTHENTICATION = "Bearer ";
    private static final String HEADER_AUTHORIZATION = "Authorization";

    private final TokenStore tokenStore;

    @Autowired
    public CustomLogoutSuccessHandler(TokenStore tokenStore) {
        this.tokenStore = tokenStore;
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Authentication authentication) throws IOException, ServletException {
        // fetch token from the http-request
        String token = httpServletRequest.getHeader(HEADER_AUTHORIZATION);
        // check if not null and start with 'Bearer'
        if(token != null && token.startsWith(BEARER_AUTHENTICATION)) {
            // Condition true and spilt to access the token and remove from the token-store
            OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(token.split(" ")[0]);
            log.info("User token..... {}", oAuth2AccessToken);
            if(oAuth2AccessToken != null) {
                // remove process after getting the token
                tokenStore.removeAccessToken(oAuth2AccessToken);
            }
        }
        // return the 'Response with 'Ok response''
        httpServletResponse.setStatus(HttpServletResponse.SC_OK, "You are logout");
    }
}
