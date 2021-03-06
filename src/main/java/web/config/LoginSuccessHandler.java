package web.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import web.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException{
        User user = (User) authentication.getPrincipal();
        if (user.getAuthorities()
                .stream()
                .anyMatch(role -> "ADMIN".equals(role.getAuthority()))
        ) {
            httpServletResponse.sendRedirect("/admin/users");
        } else if (user.getAuthorities()
                .stream()
                .anyMatch(role -> "USER".equals(role.getAuthority()))
        ){
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("user", user);
            httpServletResponse.sendRedirect("/user");
        }
    }

}