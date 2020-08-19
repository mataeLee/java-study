package model;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public int getPosition(){
        return position;
    }

    public String getName() {
        return name;
    }

    public void behavior(){
        int val = (int)(Math.random() * 10);
        this.position += (val > Standard.MOVE_STANDARD)? 1 : 0;
    }
}