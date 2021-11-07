package com.example.lesson4.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("com.example.lesson4.app.web")
public class MvcConfig implements WebMvcConfigurer {
}
