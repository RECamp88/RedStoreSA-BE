package com.rachelcampbell.RedStoreSA.Controller;

import com.rachelcampbell.RedStoreSA.Model.User;
import com.rachelcampbell.RedStoreSA.Service.UserService;
import com.rachelcampbell.RedStoreSA.Exception.ServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public User updateUser(long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    //deleting a user's account
    @DeleteMapping("delete")
    public User deleteUser(long id, @RequestBody User user) {
        return userService.deleteUser(id, user);
    }
}
