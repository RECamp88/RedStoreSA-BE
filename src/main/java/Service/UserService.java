package Service;

import Model.User;
import Repository.LoginRepository;
import Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final LoginRepository loginRepository;

    @Autowired
    public UserService(UserRepository userRepository, LoginRepository loginRepository) {
        this.userRepository = userRepository;
        this.loginRepository = loginRepository;
    }

    /* User story 1: User Registration
    *  The user should be able to register for an account.
    *  @param Take in a User object
    *  @return Returns the saved User
    *  @throws Throws an exception if the User already exists
    * */
    public User registerUser(User user){
       return null;
    }
}
