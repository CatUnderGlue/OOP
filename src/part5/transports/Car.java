package part5.transports;

import part5.drivers.BDriver;

public class Car extends Transport<BDriver> {
    public enum bodyTypes {
        SEDAN("Седан"),
        HATCHBACK("Хетчбек  "),
        COUPE("Купе"),
        CUV("Универсал"),
        SUV("Внедорожник"),
        CROSSOVER("Кроссовер"),
        PICKUP("Пикап"),
        VAN("Фургон"),
        MINIVAN("Минивэн");

        final String translate;

        bodyTypes(String translate) {
            this.translate = translate;
        }

        @Override
        public String toString() {
            return translate;
        }

    }

    private bodyTypes bodyType;

    public Car(String brand, String model, double engineVolume, BDriver driver) {
        super(brand, model, engineVolume, driver);
    }

    @Override
    public void printType() {
        if (bodyType == null) {
            System.out.println("Данных по т/с недостаточно");
        } else {
            System.out.println(bodyType);
        }
    }

    public bodyTypes getBodyType() {
        return bodyType;
    }

    public void setBodyType(bodyTypes bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public void startMoving() {
        System.out.printf("Автомобиль марки %s начал движение\n", getBrand());
    }

    @Override
    public void stopMoving() {
        System.out.printf("Автомобиль марки %s закончил движение\n", getBrand());
    }

    @Override
    public void pitStop() {
        System.out.printf("Водитель: %s из автомобиля %s %s остановился на пит-стоп\n", getDriver().getFullname(), getBrand(), getModel());
    }

    @Override
    public double bestLapTime() {
        return LAP_DISTANCE / maxSpeed();
    }

    @Override
    public double maxSpeed() {
        return getEngineVolume() * 10; // Допустим объём двигателя будет показателем скорости :D
    }
}
