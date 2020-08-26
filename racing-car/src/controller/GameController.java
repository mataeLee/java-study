package controller;

import analyzer.ContentAnalyzer;
import analyzer.RankAnalyzer;
import analyzer.WinnerAnalyzer;
import model.Car;
import view.InputView;
import view.OutputView;

import java.util.List;

public class GameController {
    public void run(){
        OutputView.showInputNamesGuideContent();
        String content = InputView.inputNames();

        List<String> names = ContentAnalyzer.analyzeContent(content);
        List<Car> cars = CarFactory.createCarsInstance(names);

        OutputView.showInputTryNumGuideContent();
        int n = InputView.inputNumber();

        TurnController.turn(n, cars);

        RankAnalyzer.ranking(cars);

        OutputView.showWinners(WinnerAnalyzer.decider(cars));
    }
}