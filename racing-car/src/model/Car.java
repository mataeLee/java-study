package model;

import standard.Standard;

public class Car implements Comparable<Car>{
    private final String name;
    private int position;
    private String positionShape;

    public Car(String name) {
        this.name = name;
        this.position = Standard.CAR_BASE_POSITION;
        positionShape = Standard.CAR_BASE_POSITION_SHAPE;
    }

//    public int getPosition(){
//        return position;
//    }
//
//    public String getName() {
//        return name;
//    }

    public void behavior(){
        int val = (int)(Math.random() * Standard.CAR_MOVE_RANDOM_RANGE);
        this.position += (val > Standard.MOVE_STANDARD)? Standard.CAR_MOVE_VAL : Standard.CAR_STOP_VAL;
        this.positionShape += (val > Standard.MOVE_STANDARD)? Standard.CAR_MOVE_POSITION_SHAPE : Standard.CAR_STOP_POSITION_SHAPE;
    }

    public void showPosition(){
        System.out.println(this.name + Standard.COLON + positionShape);
    }

    @Override
    public int compareTo(Car o) {
        if(this.position > o.position) return 1;
        else if(this.position == o.position) return 0;
        else return -1;
    }
}