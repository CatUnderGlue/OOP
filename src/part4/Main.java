package part4;

import part4.drivers.BDriver;
import part4.drivers.CDriver;
import part4.drivers.DDriver;
import part4.transports.Bus;
import part4.transports.Car;
import part4.transports.Transport;
import part4.transports.Truck;

public class Main {
    public static void main(String[] args) {
        BDriver bDriver1 = new BDriver("FIO01", true, 1.0);
        BDriver bDriver2 = new BDriver("FIO02", true, 1.0);
        BDriver bDriver3 = new BDriver("FIO03", true, 1.0);
        BDriver bDriver4 = new BDriver("FIO04", true, 1.0);
        CDriver cDriver1 = new CDriver("FIO05", true, 1.0);
        CDriver cDriver2 = new CDriver("FIO06", true, 1.0);
        CDriver cDriver3 = new CDriver("FIO07", true, 1.0);
        CDriver cDriver4 = new CDriver("FIO08", true, 1.0);
        DDriver dDriver1 = new DDriver("FIO09", true, 1.0);
        DDriver dDriver2 = new DDriver("FIO10", true, 1.0);
        DDriver dDriver3 = new DDriver("FIO11", true, 1.0);
        DDriver dDriver4 = new DDriver("FIO12", true, 1.0);

        Car<BDriver> car1 = new Car<>("Brand1", "Model1", 10.5, bDriver1);
        Car<BDriver> car2 = new Car<>("Brand2", "Model2", 15.0, bDriver2);
        Car<BDriver> car3 = new Car<>("Brand3", "Model3", 20.3, bDriver3);
        Car<BDriver> car4 = new Car<>("Brand4", "Model4", 25.0, bDriver4);
        Truck<CDriver> truck1 = new Truck<>("Brand1", "Model1", 7.0, cDriver1);
        Truck<CDriver> truck2 = new Truck<>("Brand2", "Model2", 9.5, cDriver2);
        Truck<CDriver> truck3 = new Truck<>("Brand3", "Model3", 12.0, cDriver3);
        Truck<CDriver> truck4 = new Truck<>("Brand4", "Model4", 15.5, cDriver4);
        Bus<DDriver> bus1 = new Bus<>("Brand1", "Model1", 4.0, dDriver1);
        Bus<DDriver> bus2 = new Bus<>("Brand2", "Model2", 8.5, dDriver2);
        Bus<DDriver> bus3 = new Bus<>("Brand3", "Model3", 3.0, dDriver3);
        Bus<DDriver> bus4 = new Bus<>("Brand4", "Model4", 7.7, dDriver4);

        car1.pitStop();

        Transport[] transports = {car1, car2, car3, car4, truck1, truck2, truck3, truck4, bus1, bus2, bus3, bus4};
        //printAllTransportInfo(transports);
        printCheckinInformation(transports);

    }

    public static void printAllTransportInfo(Transport... transports) {
        for (Transport transport : transports) {
            System.out.printf("Для %s %s %s\n", transport.getClass().getSimpleName(), transport.getBrand(),
                    transport.getModel());
            System.out.printf("Максимальная скорость: %.2f км/ч\nЛучший круг: %.2f сек\n\n", transport.maxSpeed(),
                    transport.bestLapTime());
        }
    }

    public static void printCheckinInformation(Transport... transports) {
        for (Transport transport : transports) {
            System.out.printf("Водитель: %s управляет автомобилем: %s %s %s и будет участвовать в заезде\n",
                    transport.getDriver().getFullname(), transport.getClass().getSimpleName(), transport.getBrand(),
                    transport.getModel());
        }
        System.out.println();
    }
}
