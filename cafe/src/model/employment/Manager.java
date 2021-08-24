package model.employment;

import model.order.Order;

public class Manager extends Employee{
    public Manager(String name) {
        super(name);
    }
    @Override
    public void run() {
        try {
            while (true){
                if(!isWorking() && !cafe.hasBarista()){
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
}
