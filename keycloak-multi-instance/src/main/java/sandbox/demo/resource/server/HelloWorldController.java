package sandbox.demo.resource.server;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController
{
    @GetMapping("/hello")
    ResponseEntity<String> helloWorld(@AuthenticationPrincipal OidcUser user)
    {
        return ResponseEntity.ok("Hello, %s!".formatted(user.getFullName()));
    }
}
