package org.example.lambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Person {

    private String name;
    private Gender gender;
    protected LocalDate dateOfBirth;
    protected String emailAddress;

    public Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public Gender getGender() {
		return gender;
	}

	public String getName() {
		return name;
	}

	public enum Gender {
        MALE, FEMALE
    }

    public static void printPersonsWithPredicate(List<Person> persons,
        Predicate<Person> tester) {
        for (Person person : persons) {
            if (tester.test(person)) {
                System.out.println(person.getName());
            }
        }
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Dan", Gender.MALE));
        persons.add(new Person("Rob", Gender.MALE));
        persons.add(new Person("Alice", Gender.FEMALE));
        printPersonsWithPredicate(persons, p -> p.getGender() == Gender.MALE); // All males
    }
}
