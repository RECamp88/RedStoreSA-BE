package com.rachelcampbell.RedStoreSA.Service;

import com.rachelcampbell.RedStoreSA.Model.Login;
import com.rachelcampbell.RedStoreSA.Model.Product;
import com.rachelcampbell.RedStoreSA.Model.User;
import com.rachelcampbell.RedStoreSA.Repository.LoginRepository;
import com.rachelcampbell.RedStoreSA.Repository.ProductRepository;
import com.rachelcampbell.RedStoreSA.Repository.UserRepository;
import com.rachelcampbell.RedStoreSA.Exception.ServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final LoginRepository loginRepository;
    private final ProductRepository productRepository;

    @Autowired
    public UserService(UserRepository userRepository, LoginRepository loginRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.loginRepository = loginRepository;
        this.productRepository = productRepository;
    }

    /* User story 1: User Registration
    *  The user should be able to register for an account.
    *  @param Take in a User object and id
    *  @return Returns the saved User
    *  @throws Throws an exception if the User already exists
    * */
    public User registerUser(User user, long id) throws ServicesException {
        Login login = loginRepository.findById(id).get();

        if(login.getId() != null) {
            throw new ServicesException("User Already Exists");
        }else {
            login.setUser(user);
            user.setLogin(login);
        }
        return userRepository.save(user);
    }

    /* User Story 2: Update a User object
    * User should be able to update their information.
    * @param id and user object
    * @ return updated user object
    * */
    public User updateUser( long id, User user){
        if(userRepository.existsById(id)){
            User currentUser = userRepository.findById(id).get();
            user.setId(id);
            user.setLogin(currentUser.getLogin());
            currentUser = user;
            return userRepository.save(currentUser);
        }
        return null;
    }

    /* User Story 3: Delete Account
    *  User should be able to delete their account.
    *  @param id and user to be deleted
    *  @return return deleted user
    *  The only way a user could request to delete account is by actually already being logged in.
    *  Login status will be handled on the front end.
    *  */
    public User deleteUser(long id, User user) {
        User deletedUser = new User();
        if(userRepository.existsById(id)){
            deletedUser = user;
            userRepository.delete(user);
        }
        return deletedUser;
    }

    /* User Story 4: Get a user by their id
    *  @param: id
    *  @return: return the user
    * */
    public User getUserById(long id){
        return userRepository.findById(id).get();
    }

    // Following methods will be working with the Users shopping: adding, removing, and paying for their cart items

    /* Shopping story 1: Adding a product to the cart
     *  @param: user id (uid) and product id (pid)
     *  @return: user with updated cart
     *  @throws: if product is not found
     */
    public User addToCart(long uid, int pid) throws ServicesException{
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
    public User removeFromCart(long uid, int pid){
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
    public User emptyCart(long id){
        User user = userRepository.findById(id).get();
        List<Product> cart = new ArrayList<>();
        user.setBalance(0.00);
        user.setCart(cart);
        return userRepository.save(user);
    }

}
