package pl.sda.springtraining.spring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
@Scope(value = "prototype")
@Service
public class UserRegistratrationDAO {

    private UserRepository userRepository ;

@Autowired// constructor injection
    public UserRegistratrationDAO(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveNewUser(User user) {
    if( userExists(user.getEmail())){
     throw new UserExistisException("Użytkownik o takim emailu "+user.getEmail()+"już istnieje");
    }
        userRepository.save(user);

    }
    public boolean userExists(String email) {
        if(userRepository.findAllByEmail(email)!=null){
            return true;
        }
        return false;
    }
}
