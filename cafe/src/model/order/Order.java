package model.order;

import model.menu.Menu;

import java.util.List;

public class Order {
    private String username;
    private List<Menu> menus;
    private List<Integer> counts;

    public Order(String username, List<Menu> menus, List<Integer> counts) {
        this.username = username;
        this.menus = menus;
        this.counts = counts;
    }

    public List<Menu> getOrder() {
        return menus;
    }

    public List<Integer> getCounts() {
        return counts;
    }


    public String getUsername(){
        return username;
    }
}