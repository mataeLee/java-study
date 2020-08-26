package view;

import model.Car;
import model.Winner;
import standard.Standard;

import java.util.List;

public class OutputView extends View{
    public static void showInputNamesGuideContent(){
        System.out.println(Standard.INPUT_NAMES_GUIDE_CONTENT);
    }
    public static void showInputTryNumGuideContent(){
        System.out.println(Standard.INPUT_TRY_NUM_GUIDE_CONTENT);
    }
    public static void showPositions(List<Car> cars){
        for(Car car : cars){
            System.out.println(car.getName() + Standard.COLON + car.getPositionShape());
        }
    }
    public static void showWinners(Winner winner){
        System.out.print(Standard.SHOW_WINNER_CONTENT);
        List<Car> cars = winner.getWinners();
        System.out.print(cars.get(0).getName());
        for(int i=1; i<cars.size(); i++){
            System.out.println(Standard.RESULT_OUPUT_SPLITTER_VAL + cars.get(i).getName());
        }
    }
}