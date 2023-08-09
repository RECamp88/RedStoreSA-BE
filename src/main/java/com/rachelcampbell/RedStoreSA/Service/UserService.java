package com.rachelcampbell.RedStoreSA.Service;

import com.rachelcampbell.RedStoreSA.Model.Product;
import com.rachelcampbell.RedStoreSA.Model.User;
import com.rachelcampbell.RedStoreSA.Repository.ProductRepository;
import com.rachelcampbell.RedStoreSA.Repository.UserRepository;
import com.rachelcampbell.RedStoreSA.Exception.ServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Autowired
    public UserService(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    /* User story 1: User Registration
    *  The user should be able to register for an account.
    *  @param Take in a User object and id
    *  @return Returns the saved User
    *  @throws Throws an exception if the User already exists
    * */
    public User registerUser(User user) throws ServicesException {
        User registerUser = userRepository.findById(user.getId()).get();

        if(user.getId() != 0) {
            throw new ServicesException("User Already Exists");
        }else {
            registerUser = user;
        }
        return userRepository.save(registerUser);
    }

    /* User Story 2: User login
     * @param login object
     * @return returns registered user
     * @throws throws an exception if user is not register or if the password doesn't match a current user.
     * */
    public User login(User user) throws ServicesException {
        User currentUser = userRepository.findByEmail(user.getEmail());

        if(currentUser == null) {
            throw new ServicesException("User does not exist.");
        }
        if(BCrypt.checkpw(user.getPassword(), currentUser.getPassword())) {
            return currentUser;
        }else {
            throw new ServicesException("Incorrect password.");
        }
    }


    /* User Story 3: Update a User object
    * User should be able to update their information.
    * @param id and user object
    * @ return updated user object
    * */
    public User updateUser(User user){
        if(userRepository.existsById(user.getId())){
            User currentUser = userRepository.findById(user.getId()).get();
            currentUser = user;
            return userRepository.save(currentUser);
        }
        return null;
    }

    /* User Story 4: Delete Account
    *  User should be able to delete their account.
    *  @param id and user to be deleted
    *  @return return deleted user
    *  The only way a user could request to delete account is by actually already being logged in.
    *  Login status will be handled on the front end.
    *  */
    public User deleteUser(User user) {
        User deletedUser = new User();
        if(userRepository.existsById(user.getId())){
            deletedUser = user;
            userRepository.delete(user);
        }
        return deletedUser;
    }

    /* User Story 5: Get a user by their id
    *  @param: id
    *  @return: return the user
    * */
    public User getUserById(int id){
        return userRepository.findById(id).get();
    }

    // Following methods will be working with the Users shopping: adding, removing, and paying for their cart items

    /* Shopping story 1: Adding a product to the cart
     *  @param: user id (uid) and product id (pid)
     *  @return: user with updated cart
     *  @throws: if product is not found
     */
    public User addToCart(int uid, int pid) throws ServicesException{
        User user = userRepository.findById(uid).get();
        Product product = productRepository.findById(pid).orElseThrow(() -> new ServicesException("Item is not found."));
        List<Product> cart = user.getCart();
        boolean productFound = false;
        for(Product item : cart) {
            if (item.getId() == product.getId()) {
                item.incrementQuantity();
                productFound = true;
                break;
            }
        }
        if (!productFound){
            product.setQuantity(1);
            cart.add(product);
        }
        user.setBalance((user.getBalance()) + product.getPrice());
        user.setCart(cart);
        return userRepository.save(user);
    }

    /* Shopping Story 2: Removing an item from the cart
    * @param: user id (uid) and product id (pid)
    * @return: user object with updated cart
    */
    public User removeFromCart(int uid, int pid){
        User user = userRepository.findById(uid).get();
        Product product = productRepository.findById(pid).get();
        List<Product> cart = user.getCart();
        for(Product item: cart){
            if(item.getId() == product.getId()){
                item.decrementQuantity();
                if(item.getQuantity() == 0){
                    cart.remove(item);
                }
                break;
            }
        }
        user.setBalance((user.getBalance()) - (product.getPrice()));
        user.setCart(cart);
        return userRepository.save(user);
    }

    /* Shopping Story 3: Empty Cart
    *  Empties the cart whether after paying or selecting to remove all items
    *  @param: user id
    *  @return: returns an updated user with an empty cart list
    */
    public User emptyCart(int id){
        User user = userRepository.findById(id).get();
        List<Product> cart = new ArrayList<>();
        user.setBalance(0.00);
        user.setCart(cart);
        return userRepository.save(user);
    }

}
