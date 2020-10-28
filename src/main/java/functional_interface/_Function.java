package functional_interface;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

//Functional Interface that takes an argument (1 or 2) and returns a result
public class _Function {
    public static void main(String[] args) {

        //Function Example: takes 1 argument and produces 1 result
        int increment = incrementByOne(0);
        System.out.println(increment);

        int increment2 = incrementByOneFunction.apply(5);

        System.out.println(increment2);

        int multiply = multiplyBy10Function.apply(increment2);
        System.out.println(multiply);

        Function<Integer, Integer> incrementBy1AndThenMultiplyBy10 = incrementByOneFunction.andThen(multiplyBy10Function);

        Integer incrementAndMultiply = incrementBy1AndThenMultiplyBy10.apply(12);

        System.out.println(incrementAndMultiply);

        //BiFunction example: takes 2 arguments, produces 1 result
        System.out.println(incrementByOneAndMultiply(4, 100));
        System.out.println(incrementByOneAndMultiplyBiFunction.apply(4,100));


        System.out.println(checkNumberFormat.apply("12",12));
    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number+1;

    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

    static int incrementByOne(int number){
        return  number + 1;
    }

    static BiFunction<Integer, Integer, Integer>  incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy) -> (numberToIncrementByOne+1) * numberToMultiplyBy;

    static int incrementByOneAndMultiply(int number, int numToMultiplyBy){
        return (number + 1) * numToMultiplyBy;
    }

    static BiFunction<String,Integer,Boolean> checkNumberFormat = (strNum, intNum) -> {
          if (strNum != null && !strNum.isEmpty()){
              int parsedInt = Integer.parseInt(strNum);
              return parsedInt == intNum;
          }else
              return false;
    };

}
