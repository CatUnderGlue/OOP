package oop.part3;

public abstract class Transport {
    private String brand;
    private String model;
    private final int releaseYear;
    private final String productionCountry;
    private String bodyColor;
    private int maxSpeed;

    public Transport(String brand, String model, int releaseYear, String productionCountry, String bodyColor, int maxSpeed) {
        setBrand(brand);
        setModel(model);
        setBodyColor(bodyColor);
        setMaxSpeed(maxSpeed);

        if (releaseYear <= 0) {
            this.releaseYear = 2000;
        } else {
            this.releaseYear = releaseYear;
        }

        if (productionCountry == null || productionCountry.isEmpty() || productionCountry.isBlank()) {
            this.productionCountry = "default";
        } else {
            this.productionCountry = productionCountry;
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand == null || brand.isEmpty() || brand.isBlank()) {
            this.brand = "default";
        } else {
            this.brand = brand;
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null || model.isEmpty() || model.isBlank()) {
            this.model = "default";
        } else {
            this.model = model;
        }
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getProductionCountry() {
        return productionCountry;
    }

    public String getBodyColor() {
        return bodyColor;
    }

    public void setBodyColor(String bodyColor) {
        if (bodyColor == null || bodyColor.isEmpty() || bodyColor.isBlank()) {
            this.bodyColor = "White";
        } else {
            this.bodyColor = bodyColor;
        }
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        if (maxSpeed <= 0) {
            this.maxSpeed = 60;
        } else {
            this.maxSpeed = maxSpeed;
        }
    }

    @Override
    public String toString() {
        return "Brand: " + getBrand() + "\n" +
                "Model: " + getModel() + "\n" +
                "Color: " + getBodyColor() + "\n" +
                "Year: " + getReleaseYear() + "\n" +
                "Max Speed: " + getMaxSpeed() + "\n" +
                "Country: " + getProductionCountry() + "\n";
    }
}
