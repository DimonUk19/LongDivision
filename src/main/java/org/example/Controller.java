package org.example;

import java.util.Scanner;

public class Controller {

    private View view;
    private Model model;

    Controller (View view, Model model) {

        this.view = view;
        this.model = model;
    }

    public void processUser() {
        int dividend;
        int divider;
        Scanner scan = new Scanner(System.in);
        view.printlnMessage(view.INPUT_DIVIDEND);
        dividend = inputIntWithScanner(scan);
        view.printlnMessage(view.INPUT_DIVIDER);
        divider = inputIntWithScanner(scan);
        view.printlnMessage(model.divide(dividend,divider));

    }

    // The Utility methods
    int i;
    private int inputIntWithScanner(Scanner scan) {
        int previousInput;
        while(true){
            while(!scan.hasNextInt()) {
                view.printlnMessage(view.WRONG_INPUT);
                scan.next();
            }
            if((previousInput = scan.nextInt()) == 0 & i == 1){
                view.printlnMessage(view.NOT_ZERO);
                continue;
            }
            break;
        }
        i += 1;
        return previousInput;
    }
}
