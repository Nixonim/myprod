package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

@WebFilter("/*")
public class FilterAll implements Filter {

    private final HashSet<String> PUBLIC_URI = new HashSet<>() {{
       add("/login");
       add("/registration");
       add("/images");
       add("/locale");
    }};
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String requestURI = ((HttpServletRequest) servletRequest).getRequestURI();
        if (isPublicUri(requestURI) || isUserInSession((HttpServletRequest)servletRequest)) {
            filterChain.doFilter(servletRequest,servletResponse);
        } else {
            String referer = ((HttpServletResponse) servletResponse).getHeader("referer");
            ((HttpServletResponse)servletResponse).sendRedirect(referer!=null ? referer : "/login");
        }
    }

    private boolean isUserInSession(HttpServletRequest httpServletRequest) {
        Object user = httpServletRequest.getSession().getAttribute("user");
        System.out.println(user != null);
        return user != null;
    }

    private boolean isPublicUri(String requestURI) {
        System.out.println(requestURI);
        return PUBLIC_URI.stream().anyMatch(requestURI::startsWith);
    }

}
