package collections.part2;

import collections.part2.drivers.BDriver;
import collections.part2.drivers.Driver;
import collections.part2.exceptions.CantFindLicense;
import collections.part2.transports.Car;
import collections.part2.transports.Transport;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Driver<?>> drivers = new ArrayList<>();
    public static  List<Transport<?>> transports = new ArrayList<>();
    public static  List<Mechanic<?>> mechanics = new ArrayList<>();
    public static void main(String[] args){
        // Создаём машину, водителя, механика и всех в списки
        Car car = new Car("Car Brand");
        transports.add(car);

        BDriver bDriver = car.getDriver();
        drivers.add(bDriver);

        Mechanic<Car> carMechanic = new Mechanic<>("Ilame Evgenich", "POE Enjoyers");
        Mechanic<Car> carMechanic2 = new Mechanic<>("Recrent Yurich", "COD Enjoyers");
        mechanics.add(carMechanic);
        mechanics.add(carMechanic2);

        // Техобслуживание и починка
        carMechanic.carryOutMaintenance(car);
        carMechanic.fixTransport(car);

        // Новый универсальный механик
        Mechanic<Transport<?>> mechanic = new Mechanic<>("FIO", "Amogus");
        mechanic.carryOutMaintenance(car);

        // Задача из задания (Вывести водителя и механиков автомобиля)
        car.addMechanic(carMechanic);
        car.addMechanic(carMechanic2);
        car.addMechanic(mechanic);
        System.out.println();
        car.printInfo();
        System.out.println();


        // Диагностика по наличию прав - да
        car.getDriver().setHasDriveLicense(false);
        try {
            car.passDiagnostic();
        } catch (CantFindLicense e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printAllTransportInfo(Transport<?>... transports) {
        for (Transport<?> transport : transports) {
            System.out.printf("Для %s %s %s\n", transport.getClass().getSimpleName(), transport.getBrand(),
                    transport.getModel());
            System.out.printf("Максимальная скорость: %.2f км/ч\nЛучший круг: %.2f сек\n\n", transport.maxSpeed(),
                    transport.bestLapTime());
        }
    }

    private static void printCheckinInformation(Transport<?>... transports) {
        for (Transport<?> transport : transports) {
            System.out.printf("Водитель: %s управляет автомобилем: %s %s %s и будет участвовать в заезде\n",
                    transport.getDriver().getFullname(), transport.getClass().getSimpleName(), transport.getBrand(),
                    transport.getModel());
        }
        System.out.println();
    }
}
