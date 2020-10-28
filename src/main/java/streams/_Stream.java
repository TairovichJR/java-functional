package streams;

import imperative.Main;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _Stream {
    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Aisha", Gender.FEMALE),
                new Person("Alex", Gender.MALE),
                new Person("Alice", Gender.FEMALE),
                new Person("Robbin", Gender.PREFER_NOT_TO_SAY)
        );

        //streaming all unique genders
        people.stream()
                //map does transformation
                .map(person -> person.gender)
                //collecting to set removing duplicates
                .collect(Collectors.toSet())
                //printing each gender, for each accepts Consumer, acting as a void
                .forEach(gender -> System.out.println(gender));

       //streaming all names
        people.stream()
                .map(person -> person.name)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        Function<Person, String> personStringFunction = person -> person.name;
        Function<String, Integer> length = name -> name.length();
        Consumer<Integer> println = i -> System.out.println(i);

        people.stream()
                //mapping to name as a string
                .map(personStringFunction)
                //mapping to int from string
                .map(length)
                .forEach(println);

        boolean containsOnlyFemales = people.stream()
                .allMatch(person -> person.gender.equals(Gender.FEMALE));

        boolean containsAnyFemales = people.stream()
                //you can also apply nonMatch() to check if none matches the condition
                .anyMatch(person -> person.gender.equals(Gender.FEMALE));

        System.out.println("Contains only females: " + containsOnlyFemales);
        System.out.println("Contains any females: " + containsAnyFemales);

    }
    static class Person{
        private final String name;
        private final _Stream.Gender gender;

        public Person(String name, _Stream.Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }
    enum  Gender{
        MALE, FEMALE, PREFER_NOT_TO_SAY
    }

}