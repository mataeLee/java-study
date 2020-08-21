package process;

import model.Car;
import standard.Standard;

import java.util.List;

public class Observer {
    private static final Observer instance = new Observer();
    public static final Observer getInstance(){return instance;}
    private Observer(){}

    public void showPositions(List<Car> cars){
        for(Car car : cars){
            car.showPosition();
        }
    }

    public void showWinners(List<Car> winners){
        System.out.print(Standard.SHOW_WINNER_CONTENT);
        winners.get(0).showName();
        for(int i=1; i<winners.size(); i++){
            System.out.print(Standard.RESULT_OUPUT_SPLITTER_VAL);
            winners.get(i).showName();
        }
    }
}
