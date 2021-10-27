package com.example.lesson4backend.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("com.example.lesson4backend.app.web")
public class MvcConfig implements WebMvcConfigurer {
}
