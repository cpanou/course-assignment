//package gr.haec.employees.registry.security;
//
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.exceptions.JWTVerificationException;
//import org.apache.commons.codec.binary.Base64;
//import org.springframework.core.env.Environment;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
//    private String SECRET;
//
//    public JWTAuthorizationFilter(AuthenticationManager authManager, Environment environment) {
//        super(authManager);
//        this.SECRET = environment.getProperty("employees.jwt.secret");
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain filterChain) throws IOException, ServletException {
//
//        String authorization = request.getHeader("Authorization");
//
//        if (authorization == null || (!authorization.contains("Bearer") && !authorization.contains("Basic"))) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//        Authentication usernameAuthToken = null;
//        if (authorization.contains("Bearer")) {
//
//            String token = authorization.replace("Bearer ", "");
//            String username = "";
//            try {
//                username = JWT.require(Algorithm.HMAC256(SECRET.getBytes()))
//                        .build()
//                        .verify(token)
//                        .getSubject();
//            } catch (RuntimeException e) {
//                throw new JWTVerificationException(e.getLocalizedMessage());
//            }
//            usernameAuthToken = new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
//
//        } else if (authorization.contains("Basic")) {
//            String token = authorization.replace("Basic ", "");
//            String basicAuth = new String(Base64.decodeBase64(token));
//            String[] tokens = basicAuth.split(":");
//            usernameAuthToken = new UsernamePasswordAuthenticationToken(
//                    tokens[0],
//                    tokens[1],
//                    new ArrayList<>());
//        }
//        if (usernameAuthToken != null)
//            SecurityContextHolder.getContext().setAuthentication(usernameAuthToken);
//        filterChain.doFilter(request, response);
//    }
//
//
//}