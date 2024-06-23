package com.example.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 스프링 빈으로 등록되는 설정 클래스임을 나타냅니다.
public class CorsConfig implements WebMvcConfigurer {

    private final long MAX_AGE_SECS = 3600; // CORS 요청의 최대 Age를 초 단위로 지정합니다.

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // CORS를 허용할 경로를 지정합니다. 여기서는 모든 경로를 허용하도록 설정합니다.
        registry.addMapping("/**")
                // 허용할 오리진(Origin)을 지정합니다. 여기서는 http://localhost:3000 에서의 요청만 허용합니다.
                .allowedOrigins("http://localhost:3000")
                // 허용할 HTTP 메서드를 지정합니다. 여기서는 GET, POST, PUT, PATCH, DELETE, OPTIONS 메서드를 모두 허용합니다.
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                // 요청 헤더를 허용합니다. 여기서는 모든 헤더를 허용하도록 설정합니다.
                .allowedHeaders("*")
                // 자격 증명(Credentials) 허용 여부를 설정합니다. 여기서는 true로 설정하여 허용합니다.
                .allowCredentials(true)
                // CORS preflight 요청의 결과를 캐시할 시간을 초 단위로 지정합니다.
                .maxAge(MAX_AGE_SECS);
    }
}
