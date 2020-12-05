package suranovan.authorization_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import suranovan.authorization_service.repository.UserRepository;
import suranovan.authorization_service.service.AuthorizationService;

@Configuration
public class JavaConfig {
    @Bean
    public AuthorizationService authorizationService() {
        return new AuthorizationService(userRepository());
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }
}
