package process;

import model.Car;
import standard.Standard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {
    private static final Game instance = new Game();
    public static Game getInstance(){
        return instance;
    }

    private Scanner scanner;
    private List<Car> cars;
    private Analyzer analyzer;
    private Observer observer;

    private Game(){
        scanner = new Scanner(System.in);
        cars = new ArrayList<>();
        analyzer = new Analyzer();
        observer = Observer.getInstance();
    }

    private void createCarsInstance(List<Car> cars, List<String> names){
        for(int i=0; i<names.size(); i++){
            cars.add(new Car(names.get(i)));
        }
    }

    private void moveCars(List<Car> cars){
        for(Car car: cars) {
            car.behavior();
        }
    }

    private void turn(int n, List<Car> cars){
        for(int i=0; i<n; i++){
            moveCars(cars);
            observer.showPositions(cars);
        }
    }

    private String inputNames(){
        System.out.println(Standard.INPUT_NAMES_GUIDE_CONTENT);
        return scanner.nextLine();
    }

    private int inputNumber(){
        System.out.println(Standard.INPUT_NUM_GUIDE_CONTENT);
        return scanner.nextInt();
    }

    public void run(){
        String content = inputNames();

        List<String> names = analyzer.analyzeContent(content);
        createCarsInstance(cars, names);

        int n = inputNumber();
        turn(n, cars);

        analyzer.ranking(cars);

        observer.showWinners(analyzer.decider(cars));
    }
}