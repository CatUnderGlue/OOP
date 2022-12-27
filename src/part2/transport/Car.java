package part2.transport;

public class Car {
    public static class Key {
        private final boolean remoteEngineStart;
        private final boolean keylessAccess;

        public Key(boolean remoteEngineStart, boolean keylessAccess) {
            this.remoteEngineStart = remoteEngineStart;
            this.keylessAccess = keylessAccess;
        }

        @Override
        public String toString() {
            return "Keyless access: " + keylessAccess + ". Remote engie start: " + remoteEngineStart;
        }

    }
    private static final String[] CAR_BODY_TYPES =
            {"Micro", "Sedan", "Cuv", "Suv", "Hatchback", "Minivan", "Cabriolet",
            "Coupe", "Roadster", "Supercar", "Pickup", "Van", "Limousine", "Campervan", "Truck"};
    private final String brand;
    private final String model;
    private double engineVolume;
    private String color;
    private final int year;
    private final String country;
    private String gearbox;
    private final String bodyType;
    private String registrationNumber;
    private final int numberOfSeats;
    private boolean winterTires;
    private Key key;


    /*
     * ==============================
     * Task 3
     * ==============================
     */
    public Car(String brand, String model, int year, String country, String color, double engineVolume,
               String gearbox, String bodyType, String registrationNumber, int numberOfSeats, boolean winterTires) {
        if (brand == null || brand.isEmpty() || brand.isBlank()) {
            this.brand = "default";
        } else {
            this.brand = brand;
        }

        if (model == null || model.isEmpty() || model.isBlank()) {
            this.model = "default";
        } else {
            this.model = model;
        }

        if (year <= 0) {
            this.year = 2000;
        } else {
            this.year = year;
        }

        if (country == null || country.isEmpty() || country.isBlank()) {
            this.country = "default";
        } else {
            this.country = country;
        }

        if (color == null || color.isEmpty() || color.isBlank()){
            this.color = "White";
        } else {
            this.color = color;
        }

        if (engineVolume <= 0) {
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }

        if (gearbox == null || gearbox.isEmpty() || gearbox.isBlank()){
            this.gearbox = "Manual";
        } else {
            if (gearbox.equalsIgnoreCase("Manual") || gearbox.equalsIgnoreCase("Automatic")) {
                this.gearbox = gearbox;
            } else {
                throw new IllegalArgumentException("Коробка передач может быть только: \"Manual\" или \"Automatic\"");
            }
        }

        if (isBodyTypeCorrect(bodyType)){
            this.bodyType = bodyType;
        } else {
            this.bodyType = "Sedan";
            }

        if (isRegistationNumberCorrect(registrationNumber)){
            this.registrationNumber = registrationNumber;
        } else {
            this.registrationNumber = "\"o000oo\"";
            }

        if (numberOfSeats <= 0 || numberOfSeats > 40){
            this.numberOfSeats = 4;
        } else {
            this.numberOfSeats = numberOfSeats;
        }

        this.winterTires = winterTires;
    }

    public Car(String brand, String model, int year, String country, String color, double engineVolume, String registrationNumber){
        this(brand, model, year, country, color, engineVolume, "Manual", "Sedan",
                registrationNumber, 4, false);
    }

    public Car(String brand, String model, int year, String color, String registrationNumber){
        this(brand, model, year, "Default", color, 1.5, "Manual", "Sedan",
                registrationNumber, 4, false);
    }


    public void changeTires(int month){
        if (month > 12 || month < 1){
            throw new IllegalArgumentException("Месяц должен быть в приделах от 1 до 12");
        }
        this.winterTires = month != 6 && month != 7 && month != 8;
    }

    private boolean isBodyTypeCorrect(String bodyType){
        boolean flag = false;
        if (bodyType == null || bodyType.isEmpty() || bodyType.isBlank()) {
            return flag;
        }
        for (String type : CAR_BODY_TYPES){
            if (type.equals(bodyType)){
                flag = true;
                break;
            }
        }
        return flag;
    }

    private boolean isRegistationNumberCorrect(String registrationNumber){
        boolean flag = false;
        if (registrationNumber.length() != 6 || registrationNumber == null || registrationNumber.isEmpty() || registrationNumber.isBlank()){
            return flag;
        }
        if (Character.isLetter(registrationNumber.charAt(0)) &&
            Character.isDigit(registrationNumber.charAt(1)) &&
            Character.isDigit(registrationNumber.charAt(2)) &&
            Character.isDigit(registrationNumber.charAt(3)) &&
            Character.isLetter(registrationNumber.charAt(4)) &&
            Character.isLetter(registrationNumber.charAt(5))){
            flag = true;
        }
        return flag;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        if (engineVolume <= 0) {
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color == null || color.isEmpty() || color.isBlank()){
            this.color = "White";
        } else {
            this.color = color;
        }
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        if (gearbox == null || gearbox.isEmpty() || gearbox.isBlank()){
            this.gearbox = "Manual";
        } else {
            if (gearbox.equalsIgnoreCase("Manual") || gearbox.equalsIgnoreCase("Automatic")) {
                this.gearbox = gearbox;
            } else {
                throw new IllegalArgumentException("Коробка передач может быть только: \"Manual\" или \"Automatic\"");
            }
        }
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        if (isRegistationNumberCorrect(registrationNumber)){
            this.registrationNumber = registrationNumber;
        }
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public boolean isWinterTires() {
        return winterTires;
    }

    public void setKey(Key key){
        this.key = key;
    }

    @Override
    public String toString() {
        return "Brand: " + brand + "\n" +
                "Model: " + model + "\n" +
                "Engine Volume: " + engineVolume + "л\n" +
                "Color: " + color + "\n" +
                "Year: " + year + "\n" +
                "Country: " + country + "\n" +
                "Gearbox: " + gearbox + "\n" +
                "Body Type: " + bodyType + "\n" +
                "Registration Number: " + registrationNumber + "\n" +
                "Number of seats: " + numberOfSeats + "\n" +
                "Winter Tires: " + winterTires + "\n" +
                "Key: " + key + "\n";
    }
}
