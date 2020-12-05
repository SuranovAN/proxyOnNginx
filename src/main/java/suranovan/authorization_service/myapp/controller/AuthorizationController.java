package suranovan.authorization_service.myapp.controller;

import org.springframework.web.bind.annotation.*;
import suranovan.authorization_service.myapp.authorities.Authorities;
import suranovan.authorization_service.myapp.service.AuthorizationService;

import java.util.List;

@RestController
@RequestMapping("/")
public class AuthorizationController {
    final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }
}
