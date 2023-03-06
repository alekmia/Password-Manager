package alekmia.work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class WpApplication implements WebMvcConfigurer {

    @Autowired
    public void setSecurityInterceptor() {
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    }

    public static void main(String[] args) {
        SpringApplication.run(WpApplication.class, args);
    }
}
