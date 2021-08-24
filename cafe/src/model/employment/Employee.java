package model.employment;

import action.service.task.ProcessOrder;
import action.service.task.TakeOrder;
import action.service.task.Task;
import model.Cafe;
import model.menu.Menu;
import model.order.Order;
import resource.Guide;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public abstract class Employee extends Thread{
    protected String name;
    protected boolean working;
    protected Cafe cafe;
    protected ExecutorService orderEs;
    protected Future<Order> orderFuture;

    protected Employee(String name) {
        this.name = name;
        orderEs = Executors.newSingleThreadExecutor();
    }

    @Override
    public void run() {
        try {
            while (true){
                if(!isWorking()){
                    orderFuture = orderEs.submit(() -> {
                        Order order = null;
                        while (order == null){
                            order = cafe.pollOrder();
                        }
                        return order;
                    });
                    Order order = orderFuture.get();
                    processOrder(order);
                }
                sleep(300);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void processOrder(Order order){
        Thread thread = new ProcessOrder(this, order);
        startWorking();
        thread.start();
    }

    public void takeOrder() {
        Thread thread = new TakeOrder(this, cafe);
        startWorking();
        thread.start();
    }

    public Menu checkMenu(String choose) {
        for(Menu menu : cafe.getMenuBoard()) {
            if(menu.getName().equals(choose)) return menu;
        }
        return null;
    }

    public void setCafe(Cafe cafe) {
        this.cafe = cafe;
    }

    public boolean isWorking(){
        return working;
    }

    public String greeting(){
        StringBuilder sb = new StringBuilder();
        sb.append(Guide.STAFF).append(this.name).append(Guide.GREETING_REAR);
        return sb.toString();
    }

    public void startWorking(){
        this.working = true;
    }

    public void finishWorking(){
        this.working = false;
    }


    public String getStaffName(){
        return name;
    }
}
