package functional_interface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

//acts as a function that takes an argument and does something with like print and return NOTHING (void)
//BiConsumer pretty much takes two arguments and does something with them and return NOTHING (void)
public class _Consumer {
    public static void main(String[] args) {

        Customer maria = new Customer("Maria", "1223243");
        greetCustomer(maria);

        //Using Functional Interface: Consumer
        greetCustomerConsumer.accept(maria);
        greetCustomerConsumerV2.accept(maria, false);

    }

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer,  showPhoneNumber) ->

            System.out.println("Hello " + customer.name + ", thanks for registering phone number: "
                    + (showPhoneNumber ? customer.phoneNumber: "********"));

    static Consumer<Customer> greetCustomerConsumer = customer ->
        System.out.println("Hello " + customer.name + ", thanks for registering phone number: " + customer.phoneNumber);

    static void greetCustomer(Customer customer){
        System.out.println("Hello " + customer.name + ", thanks for registering phone number: " + customer.phoneNumber);
    }

    static void greetCustomerV2(Customer customer, Boolean showPhoneNumber){
        System.out.println("Hello " + customer.name + ", thanks for registering phone number: "
                + (showPhoneNumber? customer.phoneNumber: "**********"));
    }

    static class Customer{
        private final String name;
        private final String phoneNumber;

        public Customer(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }
    }
}
