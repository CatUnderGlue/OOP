package collections.part1;

import collections.part1.drivers.BDriver;
import collections.part1.drivers.CDriver;
import collections.part1.drivers.DDriver;
import collections.part1.drivers.Driver;
import collections.part1.exceptions.CantFindLicense;
import collections.part1.transports.Bus;
import collections.part1.transports.Car;
import collections.part1.transports.Transport;
import collections.part1.transports.Truck;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Driver<?>> drivers = new ArrayList<>();
    public static  List<Transport<?>> transports = new ArrayList<>();
    public static  List<Mechanic<?>> mechanics = new ArrayList<>();
    public static void main(String[] args){
        // Создаём машину, водителя, механика и всех в списки
        Car car = initialiseCar();
        transports.add(car);

        BDriver bDriver = car.getDriver();
        drivers.add(bDriver);

        Mechanic<Car> carMechanic = initialiseCarMechanic();
        mechanics.add(carMechanic);

        // Техобслуживание и починка
        carMechanic.carryOutMaintenance(car);
        carMechanic.fixTransport(car);

        // Новый универсальный механик
        Mechanic<Transport<?>> mechanic = new Mechanic<>("FIO", "Amogus");
        mechanic.carryOutMaintenance(car);

        // Задача из задания (Вывести водителя и механиков автомобиля)
        car.addMechanic(carMechanic);
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

    public static Car initialiseCar(){
        return new Car("Brand", "Model", Math.random() * 100, new BDriver("FIO", true, 1.0), Car.BTypes.SEDAN);
    }
    public static Truck initialiseTruck(){
        return new Truck("Brand", "Model", Math.random() * 100, new CDriver("FIO", true, 1.0), Truck.Carrying.N1);
    }

    public static Bus initialiseBus(){
        return new Bus("Brand", "Model", Math.random() * 100, new DDriver("FIO", true, 1.0), Bus.Capacity.MEDIUM);
    }

    public static Mechanic<Car> initialiseCarMechanic(){
        return new Mechanic<>("FIO","Pepega Comp");
    }
    public static Mechanic<Truck> initialiseTruckMechanic(){
        return new Mechanic<>("FIO","BloodTrail Comp");
    }
    public static Mechanic<Bus> initialiseBusMechanic(){
        return new Mechanic<>("FIO","GG ne budet Comp");
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
