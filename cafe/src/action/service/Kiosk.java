package action.service;

import model.Cafe;
import model.User;
import model.employment.Employee;
import resource.Guide;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Kiosk extends Thread {
    private Cafe cafe;
    private ExecutorService staffEs;
    private Future<Employee> staffFuture;

    public Kiosk(Cafe cafe){
        this.cafe = cafe;
        staffEs = Executors.newSingleThreadExecutor();
    }

    @Override
    public void run(){
        try {
            while (true) {
                staffFuture = staffEs.submit(() -> {
                    Employee staff = null;
                    boolean wait = false;
                    while (staff == null){
                        staff = cafe.assignStaff();
                        if(staff==null && !wait && !cafe.isTakingOrder()){
                            System.out.println(Guide.WATTING);
                            wait = true;
                        }
                    }
                    return staff;
                });
                if(!cafe.isTakingOrder()) {
                    Employee staff = staffFuture.get();
                    cafe.startTakingOrder();
                    staff.takeOrder();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}