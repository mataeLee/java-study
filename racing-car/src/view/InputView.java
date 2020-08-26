package view;

import standard.Standard;

public class InputView extends View{
    public static String inputNames(){
        return scanner.nextLine();
    }

    public static int inputNumber(){
        return scanner.nextInt();
    }
}
