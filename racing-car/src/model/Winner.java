package model;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private List<Car> winners = new ArrayList<>();

    public void addWinner(Car car){
        if(car != null)
            winners.add(car);
    }

    public List<Car> getWinners(){return winners;}
}
