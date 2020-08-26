package process;

import model.Car;
import standard.Standard;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {
    private static final GameController instance = new GameController();
    public static GameController getInstance(){
        return instance;
    }

    private GameController(){ }

    private void moveCars(List<Car> cars){
        for(Car car: cars) {
            car.behavior();
        }
    }

    private void turn(int n, List<Car> cars){
        for(int i=0; i<n; i++){
            moveCars(cars);
            OutputView.showPositions(cars);
        }
    }

    public void run(){
        OutputView.showInputNamesGuideContent();
        String content = InputView.inputNames();

        List<String> names = analyzer.analyzeContent(content);
        List<Car> cars = CarFactory.createCarsInstance(names);

        OutputView.showInputTryNumGuideContent();
        int n = InputView.inputNumber();
        turn(n, cars);

        RankManager.ranking(cars);

        observer.showWinners(analyzer.decider(cars));
    }
}