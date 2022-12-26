package part1;

public class Car {
    String brand;
    String model;
    double engineVolume;
    String color;
    int year;
    String country;

    public Car(String brand, String model, int year, String country, String color, double engineVolume) {
        if (brand == null || brand.strip().equals("")) {
            this.brand = "default";
        } else {
            this.brand = brand;
        }

        if (model == null || model.strip().equals("")) {
            this.model = "default";
        } else {
            this.model = model;
        }

        if (year <= 0) {
            this.year = 2000;
        } else {
            this.year = year;
        }

        if (country == null || country.strip().equals("")) {
            this.country = "default";
        } else {
            this.country = model;
        }

        if (color == null || color.strip().equals("")){
            this.color = "White";
        } else {
            this.color = color;
        }

        if (engineVolume <= 0) {
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }
    }


    @Override
    public String toString() {
        return brand + " " + model + " " + year + " " + country + " " + color + " " + engineVolume + "л.";
    }
}
