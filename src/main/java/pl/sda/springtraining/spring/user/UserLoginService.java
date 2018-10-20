package pl.sda.springtraining.spring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {
    @Autowired // field injection
    private UserLoginDAO userLoginDAO ;


}
