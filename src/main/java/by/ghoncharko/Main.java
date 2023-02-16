package by.ghoncharko;

import by.ghoncharko.model.Animal;
import by.ghoncharko.model.Car;
import by.ghoncharko.model.Flower;
import by.ghoncharko.model.House;
import by.ghoncharko.model.Person;
import by.ghoncharko.util.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
//        task1();
//        task2();
//        task3();
//        task4();
//        task5();
//        task6();
//        task7();
//        task8();
//        task9();
//        task10();
//        task11();
//        task12();
//        task13();
        task14();
        task15();
    }

    private static void task1() throws IOException {
        List<Animal> animals = Util.getAnimals();
        animals.
                stream().
                filter(x -> x.getAge() >= 10 && x.getAge() <= 20).
                sorted(Comparator.comparingInt(Animal::getAge)).
                skip(14).limit(7).
                forEach(System.out::println);
    }

    private static void task2() throws IOException {
        List<Animal> animals = Util.getAnimals();
        animals.
                stream().
                filter(x -> "Japanese".equals(x.getOrigin())).
                map(x -> "Female".equals(x.getGender()) ? x.getBread().toUpperCase() : x.getBread()).
                forEach(System.out::println);

    }

    private static void task3() throws IOException {
        List<Animal> animals = Util.getAnimals();
        animals.
                stream().
                filter(x -> x.getAge() > 30 && x.getOrigin().startsWith("A")).distinct().
                forEach(System.out::println);
    }

    private static void task4() throws IOException {
        List<Animal> animals = Util.getAnimals();
        long countFemaleAnimals = animals.
                stream().
                filter(x -> "Female".equals(x.getGender())).count();
        System.out.println(countFemaleAnimals);
    }

    private static void task5() throws IOException {
        List<Animal> animals = Util.getAnimals();
        boolean hasRequiredAnimal = animals.
                stream().
                anyMatch(x -> x.getAge() >= 20 && x.getAge() <= 30 && "Hungarian".equals(x.getOrigin()));
        System.out.println(hasRequiredAnimal);
    }

    private static void task6() throws IOException {
        List<Animal> animals = Util.getAnimals();
        boolean animalGenderNotFemaleOrMale = animals.
                stream().
                anyMatch(x -> !"Male".equals(x.getGender()) && !"Female".equals(x.getGender()));
        System.out.println(animalGenderNotFemaleOrMale);
    }

    private static void task7() throws IOException {
        List<Animal> animals = Util.getAnimals();
        boolean dontHaveAnimalsFromOceania = animals.
                stream().
                anyMatch(x -> !"Oceania".equals(x.getOrigin()));
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
                map(x -> x.getBread().toCharArray()).
                min(Comparator.comparing(x -> x.length)).
                ifPresent(x -> System.out.println(x.length));
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
                filter(x -> "Indonesian".equals(x.getOrigin())).
                mapToInt(Animal::getAge).
                average().
                ifPresent(System.out::println);
    }

    private static void task12() throws IOException {
        List<Person> people = Util.getPersons();
        people.
                stream().
                filter(x -> "Male".equals(x.getGender()) && (2023 - x.getDateOfBirth().getYear() >= 18) && (2023 - x.getDateOfBirth().getYear() <= 20)).
                sorted(Comparator.comparing(Person::getRecruitmentGroup)).
                limit(200).
                forEach(System.out::println);
    }

    private static void task13() throws IOException {
        List<House> houses = Util.getHouses();
        List<List<Person>> personsListFromHospital = houses.
                stream().
                filter(x -> x.getBuildingType().equals("Hospital")).
                toList().stream().map(House::getPersonList).
                toList();
        List<List<Person>> personsListFromSecondGroup = houses.
                stream().
                filter(x -> !"Hospital".equals(x.getBuildingType())).
                map(House::getPersonList).
                toList().
                stream().
                map(x -> x.stream().filter(y -> 2023 - y.getDateOfBirth().getYear() < 18 || 2023 - y.getDateOfBirth().getYear() >= 65).collect(Collectors.toList())).
                toList();
        personsListFromHospital.forEach(x -> personsListFromSecondGroup.forEach(x::addAll));
        List<List<Person>> otherPeoples = houses.
                stream().
                filter(x -> !"Hospital".equals(x.getBuildingType())).
                map(House::getPersonList).
                toList().
                stream().
                map(x -> x.stream().collect(Collectors.toList())).
                toList();
        personsListFromHospital.forEach(x -> otherPeoples.forEach(x::addAll));
        personsListFromHospital.stream().distinct().limit(500).forEach(System.out::println);
    }

    private static void task14() throws IOException {
        List<Car> cars = Util.getCars();
        List<Car> turkmenistanCars = cars.
                stream().
                filter(x -> "Jaguar".equals(x.getCarMake()) || "White".equals(x.getColor())).
                toList();
        List<Car> uzbekistanCars = cars.
                stream().
                filter(x -> !"Jaguar".equals(x.getCarMake()) || !"White".equals(x.getColor())).
                filter(x -> x.getMass() < 1500 && "BMW".equals(x.getCarMake()) && "Lexus".equals(x.getCarMake()) && "Chrysler".equals(x.getCarMake()) && "Toyota".equals(x.getCarMake())).toList();
        List<Car> kazakstanCars = cars.
                stream().
                filter(x -> !"Jaguar".equals(x.getCarMake()) || !"White".equals(x.getColor())).
                filter(x -> x.getMass() >= 1500 && !"BMW".equals(x.getCarMake()) && !"Lexus".equals(x.getCarMake()) && !"Chrysler".equals(x.getCarMake()) && !"Toyota".equals(x.getCarMake())).
                filter(x -> x.getMass() > 4000 || ("GMC".equals(x.getCarMake()) || "Dodge".equals(x.getCarMake()))).
                toList();
        List<Car> kirgistanCars = cars.
                stream().
                filter(x -> !"Jaguar".equals(x.getCarMake()) || !"White".equals(x.getColor())).
                filter(x -> x.getMass() >= 1500 && !"BMW".equals(x.getCarMake()) && !"Lexus".equals(x.getCarMake()) && !"Chrysler".equals(x.getCarMake()) && !"Toyota".equals(x.getCarMake())).
                filter(x -> x.getMass() <= 4000 || (!"GMC".equals(x.getCarMake()) || !"Dodge".equals(x.getCarMake()))).
                filter(x -> x.getReleaseYear() < 1982 || ("Cherokee".equals(x.getCarModel()) || "Civic".equals(x.getCarModel()))).
                toList();
        List<Car> russiaCars = cars.
                stream().
                filter(x -> !"Jaguar".equals(x.getCarMake()) || !"White".equals(x.getColor())).
                filter(x -> x.getMass() >= 1500 && !"BMW".equals(x.getCarMake()) && !"Lexus".equals(x.getCarMake()) && !"Chrysler".equals(x.getCarMake()) && !"Toyota".equals(x.getCarMake())).
                filter(x -> x.getMass() <= 4000 || (!"GMC".equals(x.getCarMake()) || !"Dodge".equals(x.getCarMake()))).
                filter(x -> x.getReleaseYear() >= 1982 || (!"Cherokee".equals(x.getCarModel()) || !"Civic".equals(x.getCarModel()))).
                filter(x -> !"Yellow".equals(x.getColor()) && !"Red".equals(x.getColor()) && !"Green".equals(x.getColor()) && !"Blue".equals(x.getColor()) || x.getPrice() > 40000).
                toList();
        List<Car> mongoliaCars = cars.
                stream().
                filter(x -> !"Jaguar".equals(x.getCarMake()) || !"White".equals(x.getColor())).
                filter(x -> x.getMass() >= 1500 && !"BMW".equals(x.getCarMake()) && !"Lexus".equals(x.getCarMake()) && !"Chrysler".equals(x.getCarMake()) && !"Toyota".equals(x.getCarMake())).
                filter(x -> x.getMass() <= 4000 || (!"GMC".equals(x.getCarMake()) || !"Dodge".equals(x.getCarMake()))).
                filter(x -> x.getReleaseYear() >= 1982 || (!"Cherokee".equals(x.getCarModel()) || !"Civic".equals(x.getCarModel()))).
                filter(x -> "Yellow".equals(x.getColor()) && "Red".equals(x.getColor()) && "Green".equals(x.getColor()) && "Blue".equals(x.getColor()) || x.getPrice() <= 40000).
                filter(x -> x.getVin().contains("59")).
                toList();

        long massSumTurkmenistanCars = turkmenistanCars.stream().mapToInt(Car::getMass).sum();
        long massSumUzbekistanCars = uzbekistanCars.stream().mapToInt(Car::getMass).sum();
        long massSumKazakstanCars = kazakstanCars.stream().mapToInt(Car::getMass).sum();
        long massSumKirgistanCars = kirgistanCars.stream().mapToInt(Car::getMass).sum();
        long massSumRussiaCars = russiaCars.stream().mapToInt(Car::getMass).sum();
        long massSumMongoliaCars = mongoliaCars.stream().mapToInt(Car::getMass).sum();
        System.out.println("mass = " + massSumTurkmenistanCars + " money = " + (massSumTurkmenistanCars * 7.14));
        System.out.println("mass = " + massSumUzbekistanCars + " money = " + (massSumUzbekistanCars * 7.14));
        System.out.println("mass = " + massSumKazakstanCars + " money = " + (massSumKazakstanCars * 7.14));
        System.out.println("mass = " + massSumKirgistanCars + " money = " + (massSumKirgistanCars * 7.14));
        System.out.println("mass = " + massSumRussiaCars + " money = " + (massSumRussiaCars * 7.14));
        System.out.println("mass = " + massSumMongoliaCars + " money = " + (massSumMongoliaCars * 7.14));

    }

    private static void task15() throws IOException {
        List<Flower> flowers = Util.getFlowers();
        List<Flower> flowerList = flowers.
                stream().
                sorted(Comparator.comparing(Flower::getOrigin)).
                toList();
        Collections.reverse(flowerList);
        List<Flower> sortedFlowerList = flowerList.
                stream().
                sorted(Comparator.comparing(Flower::getPrice)).sorted(Comparator.comparing(Flower::getWaterConsumptionPerDay)).
                toList();
        Collections.reverse(sortedFlowerList);
        List<Flower> flowersAfterAllSort = sortedFlowerList.
                stream().
                filter(x->x.getCommonName().startsWith("S") && x.getCommonName().endsWith("C")).filter(x->x.isShadePreferred() && (x.getFlowerVaseMaterial().stream().anyMatch(y->y.equals("Glass")||x.getFlowerVaseMaterial().stream().anyMatch(z->z.equals("Aluminum") || x.getFlowerVaseMaterial().stream().anyMatch(p->p.equals("Steel")))))).
                toList();
        double costAllPlants = flowersAfterAllSort.stream().mapToDouble(Flower::getPrice).sum();
        double costWaterForFiveYearsAndCostAllPlants = flowersAfterAllSort.stream().mapToDouble(Flower::getWaterConsumptionPerDay).reduce(0,(acc,elem)->acc+elem)*5*365*1.39+costAllPlants;
        System.out.println(costWaterForFiveYearsAndCostAllPlants);
    }
}