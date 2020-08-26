package factory;

import model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public static List<Car> createCarsInstance(List<String> names){
        List<Car> cars = new ArrayList<>();
        for(int i=0; i<names.size(); i++){
            cars.add(new Car(names.get(i)));
        }
        return cars;
    }
}
