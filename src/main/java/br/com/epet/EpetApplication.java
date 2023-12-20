package br.com.epet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class EpetApplication {

	public static void main(String[] args) {
		SpringApplication.run(EpetApplication.class, args);
	}

}
