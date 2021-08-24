package model.employment;

import action.service.task.ProcessOrder;
import model.Cafe;
import model.order.Order;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Barista extends Employee {
    public Barista(String name) {
        super(name);
    }
}