package model.menu.coffee;

import model.menu.Menu;

public abstract class Coffee extends Menu{
    public Coffee(String name, int makingTime){
        super(name, makingTime);
    }
}