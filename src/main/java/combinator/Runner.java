package combinator;

import java.time.LocalDate;
import  static combinator.CustomerRegistrationValidator.*;
public class Runner {

    public static void main(String[] args) {

        Customer customer =
                new Customer("Alica", "alice@gmail.com", "+084545453", LocalDate.of(2000, 1, 1));


        CustomerValidatorService service = new CustomerValidatorService();

        boolean isCustomerValid = service.isCustomerValid(customer);

        if (isCustomerValid){
            System.out.println("customer saved...");
        }else
            System.out.println("customer no valid");

        //Using Combinator pattern

        ValidationResult result = CustomerRegistrationValidator
                .isEmailValid()
                .and(CustomerRegistrationValidator.isPhoneNumberValid())
                .and(CustomerRegistrationValidator.isAdult())
                .apply(customer);


        if (result != ValidationResult.SUCCESS){
            throw new IllegalStateException(result.name());
        }else
            System.out.println("Customer validated successfully");

    }
}
