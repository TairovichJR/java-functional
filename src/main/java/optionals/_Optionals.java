package optionals;

import java.util.Optional;

public class _Optionals {
    public static void main(String[] args) {

        Object value = Optional.ofNullable("hello")
                .orElseGet(() -> "default value");

        Object value1 = Optional.ofNullable(null)
                .orElseGet(() -> "default value");

        Object value2 = Optional.ofNullable("hello")
                .orElseThrow(() -> new IllegalStateException("exception happening"));

        System.out.println(value);
        System.out.println(value1);
        System.out.println(value2);

        Optional.ofNullable("john@gmail.com")
                .ifPresent( val ->{
                    System.out.println("Sending email to: " + val);
                } );

        Optional.ofNullable(null)
                .ifPresentOrElse(
                        val -> System.out.println("Sending email to " + val),
                        () -> System.out.println("Cannot send email")
                        );
    }
}
