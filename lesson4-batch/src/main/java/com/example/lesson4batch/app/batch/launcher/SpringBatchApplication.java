package com.example.lesson4batch.app.batch.launcher;

import com.example.lesson4batch.config.BatchAppConfig;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;

@Import(BatchAppConfig.class)
@SpringBootApplication
public class SpringBatchApplication {
    public static void main(String[] args) {
        String inputParam = "param=1";
        new SpringApplicationBuilder(SpringBatchApplication.class)
                .web(WebApplicationType.NONE)
                .run(inputParam);
    }
}
