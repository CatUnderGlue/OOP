package collections.part1;

import collections.part1.exceptions.CantFindLicense;
import collections.part1.mechanics.CarMechanic;
import collections.part1.transports.Car;

public class Main {

    public static void main(String[] args){
        CheckInService.driversInitialise();
        CheckInService.transportInitialise();
        CheckInService.mechanicsInitialise();

        Car car1 = (Car) CheckInService.transports.get(0);
        for (int i = 0; i < 5; i++) {
            car1.addMechanic((CarMechanic) CheckInService.mechanics.get(i));
        }
        System.out.println(car1.getMechanics());
        car1.removeMechanic(car1.getMechanics().get(0));

        System.out.println();
        System.out.println(CheckInService.mechanics.get(0).getTransports());
        System.out.println();

        car1.printInfo();
        System.out.println();

        car1.getDriver().setHasDriveLicense(false);
        try {
            car1.passDiagnostic();
        } catch (CantFindLicense e) {
            System.out.println(e.getMessage());
        }
    }
}
