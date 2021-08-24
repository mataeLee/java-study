package model;

import action.service.Kiosk;
import model.menu.Menu;
import model.menu.coffee.Coffee;
import model.employment.Employee;
import model.employment.Manager;
import model.order.Order;

import java.util.*;

public class Cafe {
    public static final Cafe getInstance(){ return new Cafe(); }

    private final String name = "Mathew";
    private List<Manager> managers;
    private List<Employee> employees;
    private Kiosk kiosk;
    private Set<Menu> menus;
    private List<User> users;
    private Queue<Order> orders;
    private boolean takingOrder;

    private Cafe(){
        kiosk = new Kiosk(this);
        managers = new ArrayList<>();
        employees = new ArrayList<>();
        menus = new HashSet<>();
        users = new ArrayList<>();
        orders = new LinkedList<>();
    }

    public void open(){
        kiosk.start();
    }

    // staff
    public boolean hasManager(){
        for(Manager m : managers){
            if(!m.isWorking()) return true;
        }
        return false;
    }

    public boolean hasBarista(){
        for(Employee e : employees){
            if(!e.isWorking()) return true;
        }
        return false;
    }

    public Employee assignStaff() {
        for(Manager m : managers){
            if(!m.isWorking()) return m;
        }
        for(Employee e : employees){
            if(!e.isWorking()) return e;
        }
        return null;
    }

    public void hireEmployee(Employee e) {
        e.setCafe(this);
        employees.add(e);
        e.start();
    }

    public void hireManager(Manager m) {
        m.setCafe(this);
        managers.add(m);
        m.start();
    }

    // menu
    public boolean conatainsMenu(String menu){
        if(menus.contains(menu)) return true;
        return false;
    }

    public void addCoffeeMenu(Coffee coffee) {
        menus.add(coffee);
    }

    public Set<Menu> getMenuBoard() {
        return menus;
    }

    // user
    public void enterUser(User user) {
        users.add(user);
    }

    public void getOutUser(User user) {
        if(users.contains(user))
            users.remove(users.indexOf(user));
    }

    public boolean hasUser() {
        return (users.size() > 0)? true : false;
    }

    public synchronized User pollUser() {
        if(users.size() > 0) {
            User user = users.get(0);
            users.remove(0);
            return user;
        }
        return null;
    }

    // order
    public void addOrder(Order order){
        orders.add(order);
    }

    public synchronized Order pollOrder(){
        if(orders.size() > 0)
            return orders.poll();
        return null;
    }
    public boolean hasOrder(){
        if(orders.size() > 0) return true;
        return false;
    }

    public String getName() {
        return name;
    }

    public synchronized boolean isTakingOrder() {
        return takingOrder;
    }

    public synchronized void startTakingOrder(){
        takingOrder = true;
    }
    public synchronized void finishTakingOrder(){
        takingOrder = false;
    }
}