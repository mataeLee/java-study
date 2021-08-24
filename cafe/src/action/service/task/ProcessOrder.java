package action.service.task;

import model.employment.Employee;
import model.menu.Menu;
import model.order.Order;
import resource.Guide;

import java.util.List;

public class ProcessOrder extends Task {
    private Order order;
    public ProcessOrder(Employee staff, Order order){
        super(staff);
        this.order = order;
    }
    @Override
    public void run() {
        try {
            List<Menu> menu = order.getOrder();
            List<Integer> counts = order.getCounts();
            int sum = 0;
            StringBuilder sb = new StringBuilder();
            sb.append(Guide.STAFF).append(staff.getStaffName()+"입니다 ").append(order.getUsername()).append(Guide.CALL_USER_FRONT);
            for(int i=0; i<menu.size(); i++){
                sum += menu.get(i).getMakingTime() * counts.get(i);
                sb.append(menu.get(i).getName()).append(Guide.SPACE).append(counts.get(i)).append(Guide.GLASSES_UNIT);
                if(i < menu.size()-1) sb.append(Guide.COMMA);
            }
            sb.append(Guide.CALL_USER_REAR);
            sleep(sum*1000);
            System.out.println(sb.toString());
            staff.finishWorking();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
