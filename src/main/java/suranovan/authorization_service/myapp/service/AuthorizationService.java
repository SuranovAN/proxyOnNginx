package suranovan.authorization_service.myapp.service;

import suranovan.authorization_service.myapp.authorities.Authorities;
import suranovan.authorization_service.myapp.exception.InvalidCredentials;
import suranovan.authorization_service.myapp.exception.UnauthorizedUser;
import suranovan.authorization_service.myapp.repository.UserRepository;

import java.util.List;

public class AuthorizationService {
    private final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<Authorities> str) {
        return str == null || str.isEmpty();
    }
}
