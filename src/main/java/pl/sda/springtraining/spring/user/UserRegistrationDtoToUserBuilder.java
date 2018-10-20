package pl.sda.springtraining.spring.user;


import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationDtoToUserBuilder {
    public User rewriteDtoToUser(UserRegistratrationDTO userRegistratrationDTO) {

        User user = new User();
        UserAddress userAddress = new UserAddress();
        user.setUserAddress(userAddress);
        user.setFirstName(userRegistratrationDTO.getFirstName());
        user.setLastName(userRegistratrationDTO.getLastName());
        user.getUserAddress().setZipCode(userRegistratrationDTO.getUserAddress().getZipCode());
        user.getUserAddress().setCity(userRegistratrationDTO.getUserAddress().getCity());
        user.getUserAddress().setCountry(userRegistratrationDTO.getUserAddress().getCountry());
        user.getUserAddress().setStreet(userRegistratrationDTO.getUserAddress().getStreet());
        user.setBirthDate(userRegistratrationDTO.getBirthDate());
        user.setPesel(userRegistratrationDTO.getPesel());
        user.setEmail(userRegistratrationDTO.getEmail());
        user.setPassword(DigestUtils.sha512Hex(userRegistratrationDTO.getPassword()));
        user.setPhone(userRegistratrationDTO.getPhone());
        user.setPreferEmails(userRegistratrationDTO.isPreferEmails());
        return user;

    }
}
