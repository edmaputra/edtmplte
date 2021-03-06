package io.github.edmaputra.edtmplte.configuration;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.UUID;

@Component
public class LogContextFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String transactionId = UUID.randomUUID().toString();

        MDC.put("TRANS_ID", transactionId);

        try {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        finally {
            MDC.clear();
        }
    }
}
