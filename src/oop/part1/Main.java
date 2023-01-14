package oop.part1;

public class Main {
    public static void main(String[] args) {

        /*
         * ==============================
         * Task 1
         * ==============================
         */

        /*
        Car ladaGranta = new Car();
        ladaGranta.brand = "Lada";
        ladaGranta.model = "Granta";
        ladaGranta.year = 2015;
        ladaGranta.country = "Russia";
        ladaGranta.color = "Yellow";
        ladaGranta.engineVolume = 1.7;

        Car audiA8 = new Car();
        audiA8.brand = "Audi";
        audiA8.model = "A8 50 L TDI quattro";
        audiA8.year = 2020;
        audiA8.country = "Germany";
        audiA8.color = "Black";
        audiA8.engineVolume = 3.0;

        Car bmwZ8 = new Car();
        bmwZ8.brand = "BMW";
        bmwZ8.model = "Z8";
        bmwZ8.year = 2021;
        bmwZ8.country = "Germany";
        bmwZ8.color = "Black";
        bmwZ8.engineVolume = 3.0;

        Car kiaSportage = new Car();
        kiaSportage.brand = "Kia";
        kiaSportage.model = "Sportage 4th generation";
        kiaSportage.year = 2018;
        kiaSportage.country = "South Korea";
        kiaSportage.color = "Red";
        kiaSportage.engineVolume = 2.4;

        Car hyundaiAvante = new Car();
        hyundaiAvante.brand = "Hyundai";
        hyundaiAvante.model = "Avante";
        hyundaiAvante.year = 2016;
        hyundaiAvante.country = "South Korea";
        hyundaiAvante.color = "Orange";
        hyundaiAvante.engineVolume = 1.6;
        */

        /*
        * ==============================
        * Task 2
        * ==============================
        */

        Car ladaGranta = new Car("   ", "Granta", 2015, "Russia", " ",
                1.7);
        Car audiA8 = new Car("Audi", "A8 50 L TDI quattro", 2020, "Germany", "Black",
                3.0);
        Car bmwZ8 = new Car("BMW", "Z8", 0, "Germany", "Black", 3.0);
        Car kiaSportage = new Car("Kia", "Sportage 4th generation", 2018, "South Korea",
                "Red", 2.4);
        Car hyundaiAvante = new Car("Hyundai", null, 2016, "South Korea",
                "Orange", 1.6);

        System.out.println(ladaGranta + "\n" + audiA8 + "\n" + bmwZ8 + "\n" + kiaSportage + "\n" + hyundaiAvante);
    }
}
