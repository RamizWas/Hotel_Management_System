package com.example.hotelmanage.config;

import com.example.hotelmanage.guest.GuestRepo;
import jakarta.ws.rs.POST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final JwtAuthEntryPoint jwtAuthEntryPoint;
    private final CustomAcessDeniedHandler customAcessDeniedHandler;
    private final GuestRepo guestRepo;
    @Autowired
    public SecurityConfig(JwtAuthEntryPoint jwtAuthEntryPoint,
                          CustomAcessDeniedHandler customAcessDeniedHandler, GuestRepo guestRepo
    ) {
        this.jwtAuthEntryPoint=jwtAuthEntryPoint;
        this.customAcessDeniedHandler=customAcessDeniedHandler;
        this.guestRepo = guestRepo;
    }




    @Bean
    public SecurityFilterChain WebSecurityConfigurerAdapter(HttpSecurity http) throws Exception {
        http   .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .authenticationProvider(authenticationProvider())
                .exceptionHandling(e-> e.accessDeniedHandler(customAcessDeniedHandler)
                        .authenticationEntryPoint(jwtAuthEntryPoint))
                .sessionManagement((sessionManagement) ->
                        sessionManagement
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(
                        (authorizeHttpRequests)->
                        authorizeHttpRequests.
                        requestMatchers("/**")
                        .permitAll()
                        .requestMatchers("/error").permitAll()
                        .anyRequest().
                        authenticated());



        http.addFilterBefore(jwtAthFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration
    ) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAthFilter jwtAthFilter(){
        return new JwtAthFilter();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider= new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(new CustomGuestDetailsService(guestRepo));
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }


}
