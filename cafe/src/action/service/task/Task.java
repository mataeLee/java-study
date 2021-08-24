package action.service.task;

import model.employment.Employee;

public class Task extends Thread{
    protected Employee staff;

    public Task(Employee staff) {
        this.staff = staff;
    }
}
