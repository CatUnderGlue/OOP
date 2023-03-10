package oop.part3;

public class Car extends Transport {
    public static class Key {
        private final boolean remoteEngineStart;
        private final boolean keylessAccess;

        public Key(boolean remoteEngineStart, boolean keylessAccess) {
            this.remoteEngineStart = remoteEngineStart;
            this.keylessAccess = keylessAccess;
        }

        public Key() {
            this(false, false);
        }

        @Override
        public String toString() {
            return "Keyless access: " + keylessAccess + ". Remote engie start: " + remoteEngineStart;
        }

        public boolean isRemoteEngineStart() {
            return remoteEngineStart;
        }

        public boolean isKeylessAccess() {
            return keylessAccess;
        }
    }

    private static final String[] CAR_BODY_TYPES =
            {"Micro", "Sedan", "Cuv", "Suv", "Hatchback", "Minivan", "Cabriolet",
                    "Coupe", "Roadster", "Supercar", "Pickup", "Van", "Limousine", "Campervan", "Truck"};
    private double engineVolume;
    private String gearbox;
    private final String bodyType;
    private String registrationNumber;
    private final int numberOfSeats;
    private boolean winterTires;
    private Key key;

    public Car(String brand, String model, int releaseYear, String productionCountry, String bodyColor, int maxSpeed,
               double engineVolume, String gearbox, String bodyType, String registrationNumber, int numberOfSeats,
               boolean winterTires, Key key) {
        super(brand, model, releaseYear, productionCountry, bodyColor, maxSpeed);

        setEngineVolume(engineVolume);
        setGearbox(gearbox);
        setRegistrationNumber(registrationNumber);

        if (isBodyTypeCorrect(bodyType)) {
            this.bodyType = bodyType;
        } else {
            this.bodyType = "Sedan";
        }

        if (numberOfSeats <= 0 || numberOfSeats > 40) {
            this.numberOfSeats = 4;
        } else {
            this.numberOfSeats = numberOfSeats;
        }

        this.winterTires = winterTires;

        if (key == null) {
            this.key = new Key();
        } else {
            this.key = key;
        }
    }

    public void changeTires(int month) {
        if (month > 12 || month < 1) {
            throw new IllegalArgumentException("?????????? ???????????? ???????? ?? ???????????????? ???? 1 ???? 12");
        }
        this.winterTires = month != 6 && month != 7 && month != 8;
    }

    private boolean isBodyTypeCorrect(String bodyType) {
        boolean flag = false;
        if (bodyType == null || bodyType.isEmpty() || bodyType.isBlank()) {
            return flag;
        }
        for (String type : CAR_BODY_TYPES) {
            if (type.equals(bodyType)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    private boolean isRegistationNumberCorrect(String registrationNumber) {
        boolean flag = false;
        if (registrationNumber.length() != 6 || registrationNumber == null || registrationNumber.isEmpty() || registrationNumber.isBlank()) {
            return flag;
        }
        if (Character.isLetter(registrationNumber.charAt(0)) &&
                Character.isDigit(registrationNumber.charAt(1)) &&
                Character.isDigit(registrationNumber.charAt(2)) &&
                Character.isDigit(registrationNumber.charAt(3)) &&
                Character.isLetter(registrationNumber.charAt(4)) &&
                Character.isLetter(registrationNumber.charAt(5))) {
            flag = true;
        }
        return flag;
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

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        if (gearbox == null || gearbox.isEmpty() || gearbox.isBlank()) {
            this.gearbox = "Manual";
        } else {
            if (gearbox.equalsIgnoreCase("Manual") || gearbox.equalsIgnoreCase("Automatic")) {
                this.gearbox = gearbox;
            } else {
                throw new IllegalArgumentException("?????????????? ?????????????? ?????????? ???????? ????????????: \"Manual\" ?????? \"Automatic\"");
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
        if (isRegistationNumberCorrect(registrationNumber)) {
            this.registrationNumber = registrationNumber;
        }
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public boolean isWinterTires() {
        return winterTires;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Engine Volume: " + engineVolume + "??\n" +
                "Gearbox: " + gearbox + "\n" +
                "Body Type: " + bodyType + "\n" +
                "Registration Number: " + registrationNumber + "\n" +
                "Number of seats: " + numberOfSeats + "\n" +
                "Tires: " + (isWinterTires() ? "winter" : "summer") + "\n" +
                "Key: " + key + "\n";
    }
}
