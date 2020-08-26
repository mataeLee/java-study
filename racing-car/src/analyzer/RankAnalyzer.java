package analyzer;

import model.Car;

import java.util.Collections;
import java.util.List;

public class RankAnalyzer {
    public static void ranking(List<Car> cars) {
        Collections.sort(cars, Collections.reverseOrder());
    }
}