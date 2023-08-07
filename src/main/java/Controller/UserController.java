package Controller;

import Model.User;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import Exception.ServicesException;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Registering a new User
    @PostMapping("register")
    public User registerUser(@RequestBody User user, long id) throws ServicesException {
        return userService.registerUser(user, id);
    }

    //updating a user's information
    @PatchMapping("update")
    public User updateUser (long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }


}
