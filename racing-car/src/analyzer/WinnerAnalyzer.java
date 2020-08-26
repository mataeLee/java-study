package analyzer;

import model.Car;
import model.Winner;
import java.util.List;

public class WinnerAnalyzer {
    public static Winner decider(List<Car> cars){
        Winner winner = new Winner();
        Car max = cars.get(0);
        winner.addWinner(cars.get(0));
        for(int i=1; i<cars.size(); i++){
            Car car = compare(cars.get(i), max);
            winner.addWinner(car);
        }
        return winner;
    }

    private static Car compare(Car car, Car max){
        if(max.compareTo(car) > 0) return null;
        return car;
    }
}
