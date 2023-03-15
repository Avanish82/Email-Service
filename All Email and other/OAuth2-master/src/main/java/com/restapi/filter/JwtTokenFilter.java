//package com.restapi.filter;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.GenericFilterBean;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author rajatjain on 24/08/20.
// * @project hfcservice
// */
//@Slf4j
//@Component
//public class JwtTokenFilter extends GenericFilterBean {
//
//    private JwtTokenProvider jwtTokenProvider;
//
//    List<String> openRequests = new ArrayList<>();
//
//    @Autowired
//    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
//        this.jwtTokenProvider = jwtTokenProvider;
//        openRequests.add("/fd/interest/rates");
//        openRequests.add("employee/services/rate/constants");
//        openRequests.add("vnb/target/data/upload");
//        openRequests.add("/fd/application/form/excel/email/test/partial/2");
//        openRequests.add("/fd/application/form/excel/email/test/partial");
//        openRequests.add("/fd/application/form/thirty/min/emails");
//
//        openRequests.add("/broker/dashboard/download/broker/application/form/excel");
//        openRequests.add("/broker/dashboard/download/broker/application/form/pdf");
//
//        openRequests.add("/payout/threshold/data/upload/excel");
//        openRequests.add("/resolution/branch/upload/excel");
//        openRequests.add("/resolution/branch/update");
//        openRequests.add("/resolution/branch/upload/excel/remaining");
//        openRequests.add("/resolution/application/download/resolution/web/application/excel");
//        openRequests.add("/resolution/application/web/send/internal/mails");
//        openRequests.add("/resolution/application/download/resolution/application/excel");
//        openRequests.add("/resolution/dashboard/upload/classification/matrix/excel");
//        openRequests.add("/resolution/download/resolution/application/pdf");
//        openRequests.add("/resolution/application/download/resolution/web/application/pdf");
//        openRequests.add("/resolution/send/bulk/emailer");
//
//        //Generic Emailers
//        openRequests.add("/emailer/send/to/one/recipient");
//        openRequests.add("/emailer/send/to/multiple/recipients");
//        openRequests.add("/emailer/send/with/file");
//        openRequests.add("/emailer/send/with/cc/bcc/recipients");
//
//        //mds calculator
//        openRequests.add("/employee/services/dma/mapping/tma/data/upload");
//        openRequests.add("/employee/services/dma/mapping/tma/upload/excel");
//        openRequests.add("/employee/services/tma/threshold/data/upload/excel");
//        openRequests.add("/employee/services/dma/threshold/data/upload/excel");
//        openRequests.add("/employee/services/dma/calculator/email/scheduler");
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
//            ServletException {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        if(matchURL(httpServletRequest.getRequestURL().toString())) {
//            log.info("Request matched For Open API -> " + httpServletRequest.getRequestURL().toString());
//            String token = jwtTokenProvider.resolveToken(httpServletRequest);
//            log.info("jwt -> " + token);
//            try {
//                if (jwtTokenProvider.validateToken(token, (HttpServletRequest) request)) {
//                    Authentication auth = token != null ? jwtTokenProvider.getAuthentication(token) : null;
//                    SecurityContextHolder.getContext().setAuthentication(auth);
//                    log.info("Authentication matched");
//                }
//            } catch (JWTException ex) {
//                log.error(ex.getMessage(), ex);
//                HttpServletResponse res = (HttpServletResponse) response;
//                res.sendError(401, ex.getMessage());
//                return;
//            }
//        }
//
//        chain.doFilter(request, response);
//
//    }
//
//    private boolean matchURL(String url) {
//        for(String openApi: openRequests) {
//            if(url.contains(openApi)){
//                return true;
//            }
//        }
//        return false;
//    }
//}
