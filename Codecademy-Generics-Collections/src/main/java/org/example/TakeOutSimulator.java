package org.example;

import java.util.Scanner;

public class TakeOutSimulator {
    private Customer customer;
    private FoodMenu menu;
    private Scanner input;

    public TakeOutSimulator(Customer customer, FoodMenu menu, Scanner input) {
        this.customer = customer;
        this.menu = menu;
        this.input = input;
    }

    private <T> Object getResponse(String userInputPrompt, UserInputRetriever<T> userInputRetriever) {
        input = new Scanner(System.in);
        System.out.println(userInputPrompt);

        if (input.hasNextInt()) {
            try {
                return userInputRetriever.produceOutput(input.nextInt());
            } catch (IllegalArgumentException e) {
                System.out.println(input.nextInt() + " is not a valid input. Try Again!\n");
            }
        }

        System.out.println("Input needs to be an `int` type.\n");
        return null;
    }
}
