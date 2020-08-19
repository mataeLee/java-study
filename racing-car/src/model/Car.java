package model;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition(){
        return position;
    }

    public void behavior(){
        int val = (int)Math.random() * 10;
        this.position += (val > Util.MOVE_STANDARD)? 1 : 0;
    }
}