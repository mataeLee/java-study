package process;

import model.Car;
import java.util.List;

public class Observer {
    public static void check(Car car){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<car.getPosition(); i++)
            sb.append("-");
        System.out.println(car.getName() + " : " + sb.toString());
    }
    public static void result(List<String> res){
        System.out.print("Winner is : " + res.get(0));
        for(int i=1; i<res.size(); i++){
            System.out.print(", " + res.get(i));
        }
    }
}