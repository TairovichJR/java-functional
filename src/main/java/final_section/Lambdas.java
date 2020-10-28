package final_section;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {

    public static void main(String[] args) {

   //   Function<String, String> upperCaseName = name -> name.toUpperCase();
   //     Function<String, String> upperCaseName = String::toUpperCase;

        //if you have to do extra logic
//        Function<String, String> upperCaseName = name -> {
//            if (name.isBlank()){
//                throw  new IllegalArgumentException();
//            }
//            return name.toUpperCase();
//        };

        String result = upperCaseName.apply("Alex", 25);
        System.out.println(result);


    }

    //if you are accepting two arguments and return something
   static BiFunction<String, Integer, String> upperCaseName = (name, age) -> {
        if (name.isBlank()) {
            throw new IllegalArgumentException();
        };
        return name.toUpperCase() + " is " + age + " years old";
    };
}