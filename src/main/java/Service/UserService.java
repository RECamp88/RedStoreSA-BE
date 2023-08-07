package Service;

import Model.Login;
import Model.User;
import Repository.LoginRepository;
import Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Exception.ServicesException;

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

    /* User Story 2: Update a User
    * User should be able to update their information.
    * @param id and user object
    * @ return updated user object
    * */
    public User updateUser ( long id, User user){
        if(userRepository.existsById(id)){
            User currentUser = userRepository.findById(id).get();
            user.setId(id);
            user.setLogin(currentUser.getLogin());
            currentUser = user;
            return userRepository.save(currentUser);
        }
        return null;
    }
}
