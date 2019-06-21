package ex6;

import java.util.*;

public class SetRunner {
    public static void main(String[] args) {

        Set<Car> sixCars = new HashSet<>();

        sixCars.add(new Car("VW", "Golf", 45));
        sixCars.add(new Car("Audi", "A3", 60));
        sixCars.add(new Car("VW", "Polo", 35));
        sixCars.add(new Car("BMW", "Z4", 120));
        sixCars.add(new Car("BMW", "440i", 200));

        Set<Car> europeCar = new HashSet<>();

        europeCar.add(new Car("Toyota", "Auris", 40));
        europeCar.add(new Car("Reno", "Clio", 30));
        europeCar.add(new Car("Reno", "Megan", 50));
        europeCar.add(new Car("VW", "Golf", 45));
        europeCar.add(new Car("VW", "Polo", 35));

        NavigableSet<Car> uniqueCars = new TreeSet<>(sixCars);
        uniqueCars.addAll(europeCar);

        SortedSet<Car> cars = uniqueCars.headSet(new Car("Toyota", "Auris", 40));

        print(cars);
//        print(uniqueCars);

        //разница (A-B)
//         europeCar.removeAll(sixCars);
//         print(europeCar);

         //Пересечение
//        sixCars.retainAll(europeCar);
//        print(sixCars);

        //только не пересекающиесь элементы (симметричая разность)

//        uniqueCars.removeAll(sixCars);
        print(uniqueCars);

        System.out.println("\n\nHigher\n");
        System.out.println(uniqueCars.higher(new Car("Toyota", "Auris", 40)));

        System.out.println("\n\nLower\n");
        System.out.println(uniqueCars.lower(new Car("Toyota", "Auris", 40)));




    }

    private static void print(Set<Car> cars) {

        System.out.printf("%-20s %-20s %-20s", "Car brand", "Model", "Price per day");


        for (Car car: cars) {
            System.out.printf("\n%-20s %-20s %-20d", car.getCarBrand(), car.getModel(), car.getPricePerDay());
        }

    }

}
