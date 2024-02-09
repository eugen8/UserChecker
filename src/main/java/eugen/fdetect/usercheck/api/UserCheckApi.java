package eugen.fdetect.usercheck.api;

import eugen.fdetect.usercheck.model.User;
import eugen.fdetect.usercheck.service.PhoneValidationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserCheckApi {
    private final PhoneValidationService phoneValidationService;
    private final List<User> someUsers = new ArrayList<>();

    public UserCheckApi(PhoneValidationService phoneValidationService) {
        this.phoneValidationService = phoneValidationService;

//        A stub of users, just to have something to return for getUsers
        someUsers.addAll(List.of(
                User.builder()
                        .id("9320432")
                        .email("user@example.com")
                        .firstName("U1")
                        .lastName("last2")
                        .build(),
                User.builder()
                        .id("4932432")
                        .email("user323@example.com")
                        .firstName("Thomas")
                        .lastName("Tomtom2")
                        .build()
        ));
    }


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    Iterable<User> getUsers() {
        return someUsers;
    }

    @PostMapping("/user")
    public ResponseEntity<Boolean> checkUser(@RequestBody User user) {
        boolean isValid = phoneValidationService.isValidPhone("14152007986");
        return ResponseEntity.ok(isValid);
    }


}
