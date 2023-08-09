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
    public User registerUser(@RequestBody User user) throws ServicesException {
        return userService.registerUser(user);
    }

    // Login a User
    @PostMapping("login")
    public User loginUser(@RequestBody User user) throws ServicesException{
        return userService.login(user);
    }

    //updating a user's information
    @PatchMapping("update")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    //deleting a user's account
    @DeleteMapping("delete")
    public User deleteUser(@RequestBody User user) {
        return userService.deleteUser(user);
    }

    // get a user by their id
    @GetMapping("{id}")
    public User getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    // Following methods will be working with the Users shopping: adding, removing, and paying for their cart items

    // add product to the cart
    @PostMapping("{uid)/addProduct/{pid}")
    public User addProductToCart(@PathVariable int uid, @PathVariable int pid) throws ServicesException{
        return userService.addToCart(uid, pid);
    }

    // remove a product from the cart
    @PostMapping("{uid)/removeProduct/{pid}")
    public User removeProductToCart(@PathVariable int uid, @PathVariable int pid){
        return userService.removeFromCart(uid, pid);
    }

    // empties the cart
    @PostMapping("{id}/emptyCart")
    public User emptyCart(@PathVariable int id){
        return userService.emptyCart(id);
    }

}
