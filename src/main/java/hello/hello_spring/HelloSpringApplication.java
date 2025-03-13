package hello.hello_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		boolean isDevtoolsEnabled = ClassLoader.getSystemResource("META-INF/spring-devtools.properties") != null;
		System.out.println("DevTools Enabled: " + isDevtoolsEnabled);
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
