package com.example.project6sort;

public class Person implements Comparable<Person> {
    private int birthYear;
    public Person(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getBirthYear() {
        return birthYear;
    }

    @Override
    public int compareTo(Person otherPerson) {
        return Integer.compare(this.birthYear, otherPerson.birthYear);
    }

    public static void main(String[] args) {
        Person person1 = new Person(1990);
        Person person2 = new Person(1985);

        int comparisonResult = person1.compareTo(person2);

        if (comparisonResult < 0) {
            System.out.println("First person is older");
        } else if (comparisonResult > 0) {
            System.out.println("First person is younger");
        } else {
            System.out.println("Both persons are of the same age");
        }    }
}
