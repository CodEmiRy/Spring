package pl.sda.springtraining.spring.user;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserRegistratrationDTO {

    @Size(min = 3, max = 20, message = "Imie jest niepoprawne. Należy podać od (min) do (max), podałeś ${validatedValue}")
    private String firstName;
    @Size(min = 3, max = 20, message = "Nazwisko jest niepoprawne. Należy podać od (min) do (max), podałeś ${validatedValue}")
    private String lastName;
    private UserAddressDTO userAddressDTO;
    private String birthDate;
    @Pattern(regexp = "[0-9]{11}", message = "Podałeś nieprawidłowy pesel.")
    private String pesel;
    @Email(message = "Podałeś nieprawidłowy e-mail.")
    private String email;
    private String password;
    private String phone;
    private boolean preferEmails;


}
