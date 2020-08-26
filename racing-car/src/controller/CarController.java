package controller;

import model.Car;

import java.util.List;

public class CarController {
    public static void moveCars(List<Car> cars){
        for(Car car: cars) {
            car.behavior();
        }
    }
}
