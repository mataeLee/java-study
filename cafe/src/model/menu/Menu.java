package model.menu;

public abstract class Menu {
    private String name;
    private int makingTime;

    public Menu(String name, int makingTime) {
        this.name = name;
        this.makingTime = makingTime;
    }

    public String getName(){
        return this.name;
    }

    public int getMakingTime(){
        return this.makingTime;
    }
}
