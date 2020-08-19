package process;

import model.Car;

import java.util.ArrayList;
import java.util.List;

public class Observe {
    public static void check(Car car){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<car.getPosition(); i++)
            sb.append("-");
        System.out.println(car.getName() + " : " + sb.toString());
    }
    public static void result(List<Car> cars){
        List<String> winners = new ArrayList<>();
    }
}