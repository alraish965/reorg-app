package com.reorg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // تعطيل CSRF مؤقتًا أثناء التطوير
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/",
                                "/index.html",
                                "/login.html",
                                "/reorg_dashboard.html",
                                "/api/**",
                                "/webjars/**",
                                "/css/**",
                                "/js/**",
                                "/images/**"
                        ).permitAll() // السماح الكامل لهذه المسارات
                        .anyRequest().authenticated() // أي شيء آخر يتطلب مصادقة
                )
                .formLogin(form -> form.disable()) // لا نستخدم صفحة تسجيل دخول حاليًا
                .httpBasic(httpBasic -> httpBasic.disable()); // لا نستخدم basic auth

        return http.build();
    }
}
