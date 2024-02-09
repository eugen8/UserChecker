package eugen.fdetect.usercheck.api;

import eugen.fdetect.usercheck.model.User;
import eugen.fdetect.usercheck.model.UserValidationResponse;
import eugen.fdetect.usercheck.service.EmailValidationService;
import eugen.fdetect.usercheck.service.PhoneValidationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserCheckApi {
    private final PhoneValidationService phoneValidationService;
    private final EmailValidationService emailValidationService;
    private final List<User> someUsers = new ArrayList<>();

    public UserCheckApi(PhoneValidationService phoneValidationService, EmailValidationService emailValidationService) {
        this.phoneValidationService = phoneValidationService;
        this.emailValidationService = emailValidationService;

//        A stub of users, just to have something to return for getUsers
        someUsers.addAll(List.of(User.builder().id("9320432").email("user@example.com").firstName("U1").lastName("last2").build(), User.builder().id("4932432").email("user323@example.com").firstName("Thomas").lastName("Tomtom2").build()));
    }


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    Iterable<User> getUsers() {
        return someUsers;
    }

    @PostMapping("/user")
    public ResponseEntity<UserValidationResponse> checkUser(@RequestBody User user) {
        boolean isPhoneValid = phoneValidationService.isValidPhone(user.getPhoneNumber());
        boolean isEmailValid = emailValidationService.validateEmail(user.getEmail());
        return ResponseEntity.ok(new UserValidationResponse(isPhoneValid && isEmailValid));
    }

//    more options: https://springframework.guru/exception-handling-in-spring-boot-rest-api/
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity handleUnknownException(Exception someException) {
        return new ResponseEntity("{\"error\":\"Internal Server Error\"}", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
