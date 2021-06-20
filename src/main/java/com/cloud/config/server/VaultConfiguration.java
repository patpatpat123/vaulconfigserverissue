package com.cloud.config.server;

import org.apache.catalina.filters.RemoteIpFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.vault.support.VaultTokenResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.HttpProtocol;
import reactor.netty.http.client.HttpClient;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Objects;

public class VaultConfiguration implements Filter {

    private static final Logger LOGGER    = LogManager.getLogger(VaultConfiguration.class.getName());
    private static final String LOGIN     = "/v1/auth/cert/login";
    private static final String TOKEN     = "X-Config-Token";
    @Value("${client.url.vault}")
    private String              vaultUrl;

    /**
     * Init.
     *
     * @param filterConfig the filter config
     */
    @Override
    public void init(FilterConfig filterConfig) {
        LOGGER.debug("init phase filterConfig={}, filterParameter={}", filterConfig.getFilterName(), filterConfig.getInitParameterNames().asIterator());
    }

    /**
     * Do filter.
     *
     * @param request  the request
     * @param response the response
     * @param chain    the chain
     * @throws IOException      the io exception
     * @throws ServletException the servlet exception
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        final HttpServletRequest               httpRequest       = (HttpServletRequest) request;
//        final HttpClient                       httpClient        = HttpClient.create().wiretap(false).protocol(HttpProtocol.HTTP11);
//        final VaultTokenResponse               result            = WebClient.builder().baseUrl(vaultUrl + LOGIN).defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE, HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE).clientConnector(new ReactorClientHttpConnector(httpClient)).build().post().retrieve().bodyToMono(VaultTokenResponse.class).block();
//        final String                           vaultToken        = Objects.requireNonNullElse(result, new VaultTokenResponse()).getToken().getToken();
//        final RemoteIpFilter.XForwardedRequest xForwardedRequest = new RemoteIpFilter.XForwardedRequest(httpRequest);
//        xForwardedRequest.setHeader(TOKEN, vaultToken);
//        chain.doFilter(xForwardedRequest, response);
    }

    /**
     * Destroy.
     */
    @Override
    public void destroy() {
        LOGGER.debug("Filter config destroy phase");
    }

}
