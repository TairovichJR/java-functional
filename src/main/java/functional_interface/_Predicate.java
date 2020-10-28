package functional_interface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

//Predicate acts as a function that takes on argument and return a boolean result, because it has test(Object) method
//BiPredicate on the other hand takes two arguments and returns a boolean result
public class _Predicate {
    public static void main(String[] args) {

        System.out.println(isPhoneNumberValid("07564334534"));
        System.out.println(isPhoneNumberValid("09434343443"));

        System.out.println(isPhoneNumberValidPred.test("07564334534"));
        System.out.println(isPhoneNumberValidPred.test("0756433453434"));
        System.out.println(isPhoneNumberValidPred.test("09564334534"));

        System.out.println(
                "Is phone number valid and contains 3: " +
                isPhoneNumberValidPred.and(containsNumber3).test("07072992266"));

        System.out.println(
                "Is phone number valid and contains 3: " +
                        isPhoneNumberValidPred.or(containsNumber3).test("07072992266"));

        System.out.println(checkIfNamesEqual.test("hello","hello"));

    }

    static Predicate<String> containsNumber3 = number -> number.contains("3");

    static Predicate<String> isPhoneNumberValidPred = number ->
                        number.startsWith("07") && number.length() == 11;

    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("07")
                && phoneNumber.length() == 11;
    }

    static BiPredicate<String,String> checkIfNamesEqual = (s1, s2) -> {
        if (s1 != null && s2 != null){
            return s1.equals(s2);
        }else
            return false;
    };
}
