package Service;

import Model.Login;
import Model.User;
import Repository.LoginRepository;
import Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import Exception.ServicesException;

@Service
public class LoginService {
    private final LoginRepository loginRepository;
    private final UserRepository userRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository, UserRepository userRepository) {
        this.loginRepository = loginRepository;
        this.userRepository = userRepository;
    }

    /* Login Story 1: register a new login
    * @param login
    * @return saved Login object
    * @throws Services Exception if Login already exists
    * */
    public Login registerLogin(Login login, long id) throws ServicesException {
        User user = userRepository.findById(id).get();

        if(loginRepository.findByEmail(login.getEmail()) != null) {
            throw new ServicesException("User already exist.");
        }else {
            user.setLogin(login);
            login.setUser(user);
        }

        return loginRepository.save(login);
    }

    /* Login Story 2: User login
    * @param login object
    * @return returns registered user
    * @throws throws an exception if user is not register or if the password doesn't match a current user.
    * */
    public Object login(Login login) throws ServicesException {
        Login currentLogin = loginRepository.findByEmail(login.getEmail());

        if(currentLogin == null) {
            throw new ServicesException("User does not exist.");
        }

        if(BCrypt.checkpw(login.getPassword(), currentLogin.getPassword())) {
            return currentLogin.getUser();
        }else {
            throw new ServicesException("Incorrect password.")
        }
        return null;
    }
}
