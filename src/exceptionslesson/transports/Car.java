package exceptionslesson.transports;

import exceptionslesson.drivers.BDriver;
import exceptionslesson.exceptions.CantFindLicense;
import exceptionslesson.exceptions.WrongLicense;

public class Car extends Transport<BDriver> {
    public enum BTypes {
        SEDAN("Седан"),
        HATCHBACK("Хетчбек"),
        COUPE("Купе"),
        CUV("Универсал"),
        SUV("Внедорожник"),
        CROSSOVER("Кроссовер"),
        PICKUP("Пикап"),
        VAN("Фургон"),
        MINIVAN("Минивэн");

        private final String translate;

        BTypes(String translate) {
            this.translate = translate;
        }

        @Override
        public String toString() {
            return translate;
        }

    }
    private BTypes bodyType;

    public Car(String brand, String model, double engineVolume, BDriver driver, BTypes bodyType) {
        super(brand, model, engineVolume, driver);
        this.bodyType = bodyType;
    }

    @Override
    public void passDiagnostic() {
        try {
            if (!getDriver().isHasDriveLicense()){
                throw new CantFindLicense("У водителя отсутствуют водительские права!");
            } else if (getDriver().getClass() != BDriver.class){
                throw new WrongLicense("Некорректный тип прав водителя!");
            } else {
                System.out.printf("Диагностика легкового автомобиля - %s %s успешно пройдена\n", getBrand(), getModel());
            }
        } catch (CantFindLicense | WrongLicense e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void printType() {
        if (bodyType == null) {
            System.out.println("Данных по т/с недостаточно");
        } else {
            System.out.println("Легковой автомобиль: " + bodyType);
        }
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

    public BTypes getBodyType() {
        return bodyType;
    }

    public void setBodyType(BTypes bodyType) {
        this.bodyType = bodyType;
    }
}
