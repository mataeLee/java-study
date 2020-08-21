package process;

import model.Car;
import standard.Standard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Analyzer {

    public List<String> analyzeContent(String content){
        List<String> names = new ArrayList<>();
        String[] nameArr = content.split(Standard.INPUT_CONTENT_SPLIT_VAL);
        for(int i=0; i<nameArr.length; i++){
            names.add(nameArr[i].trim());
        }
        return names;
    }

    public List<Car> decider(List<Car> cars){
        List<Car> winners = new ArrayList<>();
        Car max = cars.get(0);
        winners.add(cars.get(0));
        for(int i=1; i<cars.size(); i++){
            Car car = compare(cars.get(i), max);
            addWinner(winners, car);
        }
        return winners;
    }

    private Car compare(Car car, Car max){
        if(max.compareTo(car) > 0) return null;
        return car;
    }

    private void addWinner(List<Car> winners, Car car){
        if(car != null) winners.add(car);
    }

    public void ranking(List<Car> cars){
        Collections.sort(cars, Collections.reverseOrder());
    }
}
