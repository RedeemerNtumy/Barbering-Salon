package org.barber;

import java.util.Scanner;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BarberShop shop = new BarberShop(5); // Initialize the barber shop with 5 waiting chairs
        Random random = new Random();
        int ordCount = 1;
        int vipCount = 1;

        // Print header for the console output
        System.out.println(" x | Events | State of the Shop");
        System.out.println("---+--------+--------------------------------");

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.isEmpty() || input.charAt(0) != ' ') {
                break; // End simulation if input is not space
            }

            int x = random.nextInt(4); // Generate a random number between 0 and 3
            String event = "";
            String state = "";

            if (x == 0 && shop.hasMainChairClient()) {
                event = "-- " + shop.getClientInMainChair().getId();
                shop.clientLeavesMainChair();
            } else if (x == 1) {
                Client newVIP = new Client("VIP" + vipCount++, true);
                event = "++ " + newVIP.getId();
                shop.clientArrives(newVIP);
            } else if (x == 2 || x == 3) {
                Client newORD = new Client("ORD" + ordCount++, false);
                event = "++ " + newORD.getId();
                shop.clientArrives(newORD);
            }

            state = shop.shopState();
            System.out.printf("%d ---> ( %s ) [ %s ]\n", x, event, state);
        }

        System.out.println("Simulation ended.");
        scanner.close();
    }
}