package controller;

import model.Car;
import view.OutputView;

import java.util.List;

public class TurnController {
    public static void turn(int n, List<Car> cars){
        for(int i=0; i<n; i++){
            CarController.moveCars(cars);
            OutputView.showPositions(cars);
        }
    }
}
