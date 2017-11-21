package org.vc.config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author Vikas Choudhary
 *
 */
@SpringBootApplication
@ComponentScan("org.vc.*")
public class StartApplication implements EmbeddedServletContainerCustomizer{
public static void main(String[] args) {
	SpringApplication.run(StartApplication.class, args);
}

public void customize(ConfigurableEmbeddedServletContainer arg0) {
	// TODO Auto-generated method stub
	arg0.setPort(8888);
	
}

}
