import model.Cafe;
import model.User;
import model.menu.coffee.Americano;
import model.menu.coffee.Coldbrew;
import model.menu.coffee.Latte;
import model.menu.coffee.MalchaLatte;
import model.employment.Barista;
import model.employment.Manager;
import resource.Guide;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        // cafe 세팅
        Cafe cafe = Cafe.getInstance();
//        System.out.println(Guide.SYSTEM+Guide.LOADING_CAFE);
        // 메뉴 세팅
        cafe.addCoffeeMenu(new Coldbrew());
        cafe.addCoffeeMenu(new Americano());
        cafe.addCoffeeMenu(new Latte());
        cafe.addCoffeeMenu(new MalchaLatte());

        Scanner scanner = new Scanner(System.in);
        System.out.println(Guide.SYSTEM+"고용할 매니저 수를 입력해주세요.");
        int managerCnt = Integer.parseInt(scanner.nextLine());

        for(int i=1; i<=managerCnt; i++){
            cafe.hireManager(new Manager("manager"+i));
        }

        System.out.println(Guide.SYSTEM+"고용할 바리스타 수를 입력해주세요.");
        int baristaCnt = Integer.parseInt(scanner.nextLine());
        for(int i=1; i<=baristaCnt; i++){
            cafe.hireEmployee(new Barista("barista"+i));
        }

        // 매장 오픈
        cafe.open();
        System.out.println(Guide.SYSTEM+Guide.CAFE_OPEN);

//        cafe.hireManager(new Manager("Matthew"));
//        cafe.hireEmployee(new Barista("Eric"));
//        cafe.hireEmployee(new Barista("Emma Stone"));
//        cafe.hireEmployee(new Barista("Cruella"));

        // 유저 세팅
//        System.out.println(Guide.SYSTEM+"유저 수를 입력해주세요.");
//        int userCnt = Integer.parseInt(scanner.nextLine());
//        for(int i=0; i<userCnt; i++){
//            User user = new User(i+"", cafe);
//            user.enterCafe();
//        }
    }
}