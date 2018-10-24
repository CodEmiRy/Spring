package pl.sda.springtraining.spring.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.springtraining.spring.Countries;

@Service
public class UserRegistrationDtoToUserBuilder {
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User rewriteDtoToUser(UserRegistratrationDTO userRegistratrationDTO) {

        User user = new User();
        UserAddress userAddress = new UserAddress();
        user.setUserAddress(userAddress);
        user.setFirstName(userRegistratrationDTO.getFirstName());
        user.setLastName(userRegistratrationDTO.getLastName());
        user.getUserAddress().setZipCode(userRegistratrationDTO.getUserAddressDTO().getZipCode());
        user.getUserAddress().setCity(userRegistratrationDTO.getUserAddressDTO().getCity());
        user.getUserAddress().setCountry(Countries.findCountryBbySymbil(userRegistratrationDTO.getUserAddressDTO().getCountry()));
        user.getUserAddress().setStreet(userRegistratrationDTO.getUserAddressDTO().getStreet());
        user.setBirthDate(userRegistratrationDTO.getBirthDate());
        user.setPesel(userRegistratrationDTO.getPesel());
        user.setEmail(userRegistratrationDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userRegistratrationDTO.getPassword()));
        user.setPhone(userRegistratrationDTO.getPhone());
        user.setPreferEmails(userRegistratrationDTO.isPreferEmails());
        return user;

    }
}
