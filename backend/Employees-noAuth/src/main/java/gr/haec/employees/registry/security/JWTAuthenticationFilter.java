//package gr.haec.employees.registry.security;
//
//import com.auth0.jwt.exceptions.JWTCreationException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import gr.haec.employees.registry.employee.Employee;
//import org.springframework.core.env.Environment;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Base64;
//import java.util.Objects;
//
//public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//    private String SECRET;
//    private Long lifetime;
//
//    private AuthenticationManager authenticationManager;
//
//    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, Environment environment) {
//        this.authenticationManager = authenticationManager;
//        this.SECRET = environment.getProperty("employees.jwt.secret");
//        this.lifetime = Long.valueOf(Objects.requireNonNull(environment.getProperty("employees.jwt.lifetime")));
//    }
//
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request,
//                                                HttpServletResponse response) throws AuthenticationException {
//
//        try {
//            Employee userToAuthenticate = new ObjectMapper()
//                    .readValue(request.getInputStream(), Employee.class);
//
//            return authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            userToAuthenticate.getUsername(),
//                            userToAuthenticate.getPassword(),
//                            new ArrayList<>()));
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public void successfulAuthentication(HttpServletRequest request,
//                                         HttpServletResponse response,
//                                         FilterChain chain,
//                                         Authentication authentication) {
//        try {
//            org.springframework.security.core.userdetails.User user = ((org.springframework.security.core.userdetails.User) authentication.getPrincipal());
//            String token = Base64.getEncoder().encodeToString((user.getUsername()+":"+user.getPassword()).getBytes());
//            response.addHeader("Authorization", "Basic " + token);
//        } catch (RuntimeException e) {
//            throw new JWTCreationException(e.getLocalizedMessage(), e);
//        }
//    }
//
//}