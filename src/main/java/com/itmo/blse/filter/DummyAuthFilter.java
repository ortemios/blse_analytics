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
public class DummyAuthFilter extends HttpFilter {

    @Autowired
    UserRepository userRepository;

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        Long userId = Long.valueOf(request.getHeader("user-id").trim());
        User user = userRepository.getUserById(userId);

        try {
            request.setAttribute("user", user);
        }
        catch (EntityNotFoundException ex){ response.sendError(403, "Invalid user");}

        super.doFilter(request, response, chain);
    }
}
