package com.trisul;

import com.trisul.core.security.swagger.ApiSecuritySchemes;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
    info = @Info(title = "Trisul Service", description = "Trisul Service", version = "0.1"))
@ApiSecuritySchemes
@SpringBootApplication
public class TrisulApplication {
  public static void main(String[] args) {
    SpringApplication.run(TrisulApplication.class, args);
  }
}
