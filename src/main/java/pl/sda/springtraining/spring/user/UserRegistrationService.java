package pl.sda.springtraining.spring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    private UserRegistratrationDAO userRegistratrationDAO;
    private UserRegistrationDtoToUserBuilder userRegistrationDtoToUserBuilder;

    @Autowired
    public UserRegistrationService(UserRegistratrationDAO userRegistratrationDAO, UserRegistrationDtoToUserBuilder userRegistrationDtoToUserBuilder) {
        this.userRegistratrationDAO = userRegistratrationDAO;
        this.userRegistrationDtoToUserBuilder = userRegistrationDtoToUserBuilder;
    }

    public void registerUser(UserRegistratrationDTO userRegistratrationDTO) {
        User user = userRegistrationDtoToUserBuilder.rewriteDtoToUser(userRegistratrationDTO);
        userRegistratrationDAO.saveNewUser(user);
    }
}
