package by.ghoncharko;

import by.ghoncharko.model.Animal;
import by.ghoncharko.model.Car;
import by.ghoncharko.model.Flower;
import by.ghoncharko.model.House;
import by.ghoncharko.model.Person;
import by.ghoncharko.util.Util;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();
        task11();
        task12();
        task13();
        task14();
        task15();
    }

    private static void task1() throws IOException {
        List<Animal> animals = Util.getAnimals();
        animals.
                stream().
                filter(x->x.getAge()>=10 && x.getAge() <=20).
                sorted(Comparator.comparingInt(Animal::getAge)).
                skip(14).limit(7).
                forEach(System.out::println);
    }

    private static void task2() throws IOException {
        List<Animal> animals = Util.getAnimals();
        animals.
                stream().
                filter(x->"Japanese".equals(x.getOrigin())).
                map(x->"Female".equals(x.getGender())?x.getBread().toUpperCase():x.getBread()).
                forEach(System.out::println);

    }

    private static void task3() throws IOException {
        List<Animal> animals = Util.getAnimals();
        animals.
                stream().
                filter(x->x.getAge()>30 && x.getOrigin().startsWith("A")).distinct().
                forEach(System.out::println);
    }

    private static void task4() throws IOException {
        List<Animal> animals = Util.getAnimals();
        long countFemaleAnimals = animals.
                stream().
                filter(x->"Female".equals(x.getGender())).count();
        System.out.println(countFemaleAnimals);
    }

    private static void task5() throws IOException {
        List<Animal> animals = Util.getAnimals();
        boolean hasRequiredAnimal = animals.
                stream().
                anyMatch(x->x.getAge()>=20 && x.getAge()<=30 && "Hungarian".equals(x.getOrigin()));
        System.out.println(hasRequiredAnimal);
    }

    private static void task6() throws IOException {
        List<Animal> animals = Util.getAnimals();
        boolean animalGenderNotFemaleOrMale = animals.
                stream().
                anyMatch(x->!"Male".equals(x.getGender()) && !"Female".equals(x.getGender()));
        System.out.println(animalGenderNotFemaleOrMale);
    }

    private static void task7() throws IOException {
        List<Animal> animals = Util.getAnimals();
        boolean dontHaveAnimalsFromOceania = animals.
                stream().
                anyMatch(x->!"Oceania".equals(x.getOrigin()));
        System.out.println(dontHaveAnimalsFromOceania);
    }

    private static void task8() throws IOException {
        List<Animal> animals = Util.getAnimals();
        animals.
                stream().
                sorted(Comparator.comparing(Animal::getBread)).
                limit(100).max(Comparator.comparing(Animal::getAge)).
                ifPresent(System.out::println);
    }

    private static void task9() throws IOException {
        List<Animal> animals = Util.getAnimals();
        animals.
                stream().
                map(x->x.getBread().toCharArray()).
                min(Comparator.comparing(x->x.length)).
                ifPresent(x-> System.out.println(x.length));
    }

    private static void task10() throws IOException {
        List<Animal> animals = Util.getAnimals();
        int sumAge = animals.
                stream().
                mapToInt(Animal::getAge).
                sum();
        System.out.println(sumAge);
    }

    private static void task11() throws IOException {
        List<Animal> animals = Util.getAnimals();
        animals.
                stream().
                filter(x->"Indonesian".equals(x.getOrigin())).
                mapToInt(Animal::getAge).
                average().
                ifPresent(System.out::println);
    }

    private static void task12() throws IOException {
        List<Person> people = Util.getPersons();
        people.
                stream().
                filter(x->"Male".equals(x.getGender()) && (2023 - x.getDateOfBirth().getYear()>=18) && (2023 - x.getDateOfBirth().getYear()<=20)).
                sorted(Comparator.comparing(Person::getRecruitmentGroup)).
                limit(200).
                forEach(System.out::println);
    }

    private static void task13() throws IOException {
        List<House> houses = Util.getHouses();
        List<List<Person>> personsList = houses.
                stream().
                filter(x->x.getBuildingType().equals("Hospital")).
                toList().stream().map(House::getPersonList).
                toList();

    }

    private static void task14() throws IOException {
        List<Car> cars = Util.getCars();
        //        Продолжить...
    }

    private static void task15() throws IOException {
        List<Flower> flowers = Util.getFlowers();
        //        Продолжить...
    }
}