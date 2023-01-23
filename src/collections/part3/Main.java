package collections.part3;

import collections.part3.drivers.CDriver;
import collections.part3.drivers.BDriver;
import collections.part3.drivers.Driver;
import collections.part3.transports.Car;
import collections.part3.transports.Transport;
import collections.part3.transports.Truck;

import java.util.*;

public class Main {

    public static Set<Driver<?>> drivers = new HashSet<>();
    public static  Set<Transport<?>> transports = new HashSet<>();
    public static Map<Transport<?>, Set<Mechanic<?>>> mechanics = new HashMap<>();

    public static void main(String[] args){
        // Создаём машину, водителя, механика и всех в списки
        Car car = new Car("Car Brand");
        Truck truck = new Truck("Truck Brand");
        transports.add(car);
        transports.add(car); // "Случайно" добавляем второй раз
        transports.add(truck);

        BDriver bDriver = car.getDriver();
        CDriver cDriver = truck.getDriver();
        drivers.add(bDriver);
        drivers.add(cDriver);

        Mechanic<Car> carMechanic = new Mechanic<>("Ilame Evgenich", "POE Enjoyers");
        Mechanic<Car> carMechanic2 = new Mechanic<>("Recrent Yurich", "COD Enjoyers");
        Mechanic<Truck> truckMechanic = new Mechanic<>("Golovach Daubi", "Dota Enjoyers");

        putMechanics(car, carMechanic, carMechanic2, carMechanic2);
        putMechanics(truck, truckMechanic);

        System.out.println(transports); // Выводит без повторов
        System.out.println(mechanics.get(car)); // Так же без повторов
        System.out.println(mechanics.get(truck));

        Iterator<Driver<?>> iter = drivers.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

//        // Техобслуживание и починка
//        carMechanic.carryOutMaintenance(car);
//        carMechanic.fixTransport(car);
//
//        // Новый универсальный механик
//        Mechanic<Transport<?>> mechanic = new Mechanic<>("FIO", "Amogus");
//        mechanic.carryOutMaintenance(car);
//
//        // Задача из задания (Вывести водителя и механиков автомобиля)
//        car.addMechanic(carMechanic);
//        car.addMechanic(carMechanic2);
//        car.addMechanic(mechanic);
//        System.out.println();
//        car.printInfo();
//        System.out.println();
//
//
//        // Диагностика по наличию прав - да
//        car.getDriver().setHasDriveLicense(false);
//        try {
//            car.passDiagnostic();
//        } catch (CantFindLicense e) {
//            System.out.println(e.getMessage());
//        }
    }

    public static void putMechanics(Transport<?> transport, Mechanic<?>... mechanics){
        HashSet<Mechanic<?>> mech = new HashSet<>(List.of(mechanics));
        Main.mechanics.put(transport, mech);
    }

//    public static void printAllTransportInfo(Transport<?>... transports) {
//        for (Transport<?> transport : transports) {
//            System.out.printf("Для %s %s %s\n", transport.getClass().getSimpleName(), transport.getBrand(),
//                    transport.getModel());
//            System.out.printf("Максимальная скорость: %.2f км/ч\nЛучший круг: %.2f сек\n\n", transport.maxSpeed(),
//                    transport.bestLapTime());
//        }
//    }
//
//    private static void printCheckinInformation(Transport<?>... transports) {
//        for (Transport<?> transport : transports) {
//            System.out.printf("Водитель: %s управляет автомобилем: %s %s %s и будет участвовать в заезде\n",
//                    transport.getDriver().getFullname(), transport.getClass().getSimpleName(), transport.getBrand(),
//                    transport.getModel());
//        }
//        System.out.println();
//    }
}
