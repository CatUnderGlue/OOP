package part5;

import part5.drivers.BDriver;
import part5.drivers.CDriver;
import part5.drivers.DDriver;
import part5.transports.Bus;
import part5.transports.Car;
import part5.transports.Transport;
import part5.transports.Truck;

public class Main {
    public static void main(String[] args) {
        BDriver bDriver1 = new BDriver("FIO01", true, 1.0);
        CDriver cDriver1 = new CDriver("FIO05", true, 1.0);
        DDriver dDriver1 = new DDriver("FIO09", true, 1.0);

        Car car1 = new Car("Brand1", "Model1", 10.5, bDriver1);
        Truck truck1 = new Truck("Brand1", "Model1", 7.0, cDriver1);
        Bus bus1 = new Bus("Brand1", "Model1", 4.0, dDriver1);

//        car1.pitStop();
//
//        Transport<?>[] transports = {car1, truck1, bus1};
//        printAllTransportInfo(transports);
//        printCheckinInformation(transports);
//        System.out.println(car1.getDriver());
//        System.out.println(bDriver1.getCar());
//        System.out.println(truck1.getDriver());
//        System.out.println(cDriver1.getCar());
//        System.out.println(bus1.getDriver());
//        System.out.println(dDriver1.getCar());

        car1.setBodyType(Car.BTypes.MINIVAN);
        car1.printType();
        truck1.setCarrying(Truck.Carrying.N1);
        truck1.printType();
        bus1.setCapacity(Bus.Capacity.SMALL);
        bus1.printType();
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
