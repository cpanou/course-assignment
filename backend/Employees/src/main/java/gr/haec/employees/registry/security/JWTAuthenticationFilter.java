package gr.haec.employees.registry.security;

import com.auth0.jwt.exceptions.JWTCreationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import gr.haec.employees.registry.employee.Employee;
import gr.haec.employees.registry.employee.EmployeeMapper;
import gr.haec.employees.registry.exception.Error;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private String SECRET;
    private Long lifetime;

    private final AuthenticationManager authenticationManager;
    private final EmployeeMapper employeeMapper;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, Environment environment, EmployeeMapper employeeMapper) {
        this.authenticationManager = authenticationManager;
        this.SECRET = environment.getProperty("employees.jwt.secret");
        this.lifetime = Long.valueOf(Objects.requireNonNull(environment.getProperty("employees.jwt.lifetime")));
        this.employeeMapper = employeeMapper;
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        try {
            Employee userToAuthenticate = new ObjectMapper()
                    .readValue(request.getInputStream(), Employee.class);

            TimeUnit.SECONDS.sleep(2);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userToAuthenticate.getUsername(),
                            userToAuthenticate.getPassword(),
                            new ArrayList<>()));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void successfulAuthentication(HttpServletRequest request,
                                         HttpServletResponse response,
                                         FilterChain chain,
                                         Authentication authentication) {
        try {
            Employee user = ((Employee) authentication.getPrincipal());
            String token = Base64.getEncoder().encodeToString((user.getUsername()+":"+user.getPassword()).getBytes());
            response.addHeader("Authorization", "Basic " + token);
            response.addHeader("Access-Control-Expose-Headers", "Authorization");
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            OutputStream out = response.getOutputStream();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(out, employeeMapper.toResponse(user));
            out.flush();
            TimeUnit.SECONDS.sleep(2);
        } catch (RuntimeException | IOException | InterruptedException e) {
            throw new JWTCreationException(e.getLocalizedMessage(), e);
        }
    }

}