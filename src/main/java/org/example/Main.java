package org.example;


public class Main {
    public static void main(String[] args) {

        //Devisor devisor = new Devisor();
        //System.out.println(devisor.makeDivision(-42561,341));

        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view, model);
        controller.processUser();

    }
}