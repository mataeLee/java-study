package action.service.task;

import model.Cafe;
import model.employment.Employee;
import model.employment.Manager;
import model.menu.Menu;
import model.order.Order;
import resource.Guide;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TakeOrder extends Task {
    private Cafe cafe;

    public TakeOrder(Employee staff, Cafe cafe){
        super(staff);
        this.cafe = cafe;
    }

    @Override
    public void run() {
        try {
            System.out.print(staff.greeting());
            Scanner scanner = new Scanner(System.in);
            List<Menu> receipt = new ArrayList<>();
            List<Integer> counts = new ArrayList<>();
            boolean input_error = false;
            while(true) {
                if(!input_error) {
                    System.out.println(Guide.TAKE_ORDER);
                    System.out.println(Guide.STAFF + Guide.SHOW_DRINK_MENU);
                }
                String choose = scanner.nextLine();
                if(choose.equals("")) break;
                Menu menu = staff.checkMenu(choose);
                if(menu == null) {
                    System.out.println(Guide.STAFF+Guide.INPUT_ERROR);
                    input_error = true;
                }
                else {
                    receipt.add(menu);
                    System.out.println(Guide.STAFF+Guide.ORDER_MENU_COUNT);
                    int count = Integer.parseInt(scanner.nextLine());
                    counts.add(count);
                    input_error = false;
                }
            }
            if(receipt.size() > 0) {
                System.out.println(Guide.STAFF+Guide.ORDER_NAME);
                String username = scanner.nextLine();
                Order order = new Order(username, receipt, counts);
                System.out.println(Guide.STAFF+Guide.ORDER_COMPLETE);
                staff.finishWorking();
                sleep(100);
                cafe.addOrder(order);
            }
            else{
                staff.finishWorking();
                System.out.println(Guide.STAFF+Guide.GOODBYE);
            }
            cafe.finishTakingOrder();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
