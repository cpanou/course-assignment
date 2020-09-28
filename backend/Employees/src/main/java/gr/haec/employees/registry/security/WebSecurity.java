package gr.haec.employees.registry.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import gr.haec.employees.registry.employee.EmployeeMapper;
import gr.haec.employees.registry.employee.EmployeeService;
import gr.haec.employees.registry.exception.Error;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.io.OutputStream;

@EnableWebSecurity
@AllArgsConstructor
public class WebSecurity extends WebSecurityConfigurerAdapter {
    private final EmployeeService employeeService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final Environment environment;
    private final EmployeeMapper employeeMapper;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/employees").permitAll()
                .antMatchers( "/swagger-ui.html").permitAll()
                .antMatchers( "/swagger-ui/*").permitAll()
                .antMatchers( "/api-docs/*").permitAll()
                .antMatchers( "/api-docs").permitAll()
                .anyRequest().authenticated()
                .and()
                //Spring Security Exception Handling
                .exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> {
                    Error error = new Error("UnAuthorized",1 );

                    response.setStatus(401);
                    response.setContentType("application/json");

                    OutputStream out = response.getOutputStream();
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.writeValue(out, error);
                    out.flush();
                })
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager(), environment, employeeMapper))
                .addFilter(new JWTAuthorizationFilter(authenticationManager(), environment))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(employeeService)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return urlBasedCorsConfigurationSource;
    }

}