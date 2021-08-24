package system;

import resource.Guide;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SystemProcess extends Thread{
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        ExecutorService systemEs = Executors.newSingleThreadExecutor();
        Future<String> inputFuture;
        try {
            while (true) {
                System.out.println(Guide.CHOOSE_OPT);
                inputFuture = systemEs.submit(() -> {
                    while (true) {
                        String input = scanner.nextLine();
                        if(input.equals("system")){

                        }
                    }
                });
                String input = inputFuture.get();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
