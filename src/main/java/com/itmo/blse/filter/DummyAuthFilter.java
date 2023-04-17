package com.itmo.blse.filter;


import com.itmo.blse.model.User;
import com.itmo.blse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import javax.servlet.*;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
@Order(1)
public class DummyAuthFilter implements Filter {

    @Autowired
    UserRepository userRepository;

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        Long userId = Long.valueOf(httpRequest.getHeader("user-id").trim());
        User user = userRepository.getUserById(userId);

        if (user != null) {
            httpRequest.setAttribute("user", user);
            chain.doFilter(request, response);
        }
        else
            ((HttpServletResponse)response).sendError(403, "Invalid user");


    }

}
