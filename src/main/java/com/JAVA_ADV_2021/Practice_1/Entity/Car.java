package com.JAVA_ADV_2021.Practice_1.Entity;


import java.util.Objects;

public class Car {
    private int id;
    private String model;
    private double volume;
    private int power;

    public Car() {
    }

    public Car(int id, String model, double volume, int power) {
        this.id = id;
        this.model = model;
        this.volume = volume;
        this.power = power;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id && Double.compare(car.volume, volume) == 0 && power == car.power && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, volume, power);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", volume=" + volume +
                ", power=" + power +
                '}';
    }
}
