package com.chandlertu.file.manager;

import java.nio.file.Paths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FileManagerApplication {

  public static void main(String[] args) {
    try (ConfigurableApplicationContext context =
        SpringApplication.run(FileManagerApplication.class, args)) {
      FileManagerService service = context.getBean(FileManagerService.class);
      service.countFileNameExtension(Paths.get("D:\\Files"));
    }
  }

}
