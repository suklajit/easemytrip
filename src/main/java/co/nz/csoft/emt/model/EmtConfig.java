package co.nz.csoft.emt.model;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class EmtConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
