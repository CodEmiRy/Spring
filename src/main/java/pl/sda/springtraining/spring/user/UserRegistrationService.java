package pl.sda.springtraining.spring.user;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    private UserRegistratrationDAO userRegistratrationDAO;
    private UserRegistrationDtoToUserBuilder userRegistrationDtoToUserBuilder;
    private RoleRepository roleRepository;

    @Autowired
    public UserRegistrationService(RoleRepository roleRepository, UserRegistratrationDAO userRegistratrationDAO, UserRegistrationDtoToUserBuilder userRegistrationDtoToUserBuilder) {
        this.roleRepository = roleRepository;
        this.userRegistratrationDAO = userRegistratrationDAO;
        this.userRegistrationDtoToUserBuilder = userRegistrationDtoToUserBuilder;
    }

    public void registerUser(UserRegistratrationDTO userRegistratrationDTO) {
        User user = userRegistrationDtoToUserBuilder.rewriteDtoToUser(userRegistratrationDTO);
        Role userRole = roleRepository.findRoleByRoleName("ROLE_USER");
        if (userRole == null) {
                userRole = new Role("ROLE_USER");
                roleRepository.save(userRole);
            }
            user.setRoles(Sets.newHashSet(userRole));
            userRegistratrationDAO.saveNewUser(user);
        }
    }
