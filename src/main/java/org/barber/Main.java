package org.barber;

import java.util.Scanner;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BarberShop shop = new BarberShop(5);
        Random random = new Random();
        int ordCount = 1;
        int vipCount = 1;

        System.out.println("    X         Events                    State of the Shop");
        System.out.println("+---------+--------------+----------------------------------------------+");


        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                int x = random.nextInt(4); // Generate a random number between 0 and 3
                String event = "";
                String state = "";

                switch (x) {
                    case 0:
                        if (shop.hasMainChairClient()) {
                            event = "-- " + shop.getClientInMainChair().getId();
                            shop.clientLeavesMainChair();
                        }
                        break;
                    case 1:
                        Client newVIP = new Client("VIP" + vipCount, true);
                        if (!shop.clientArrives(newVIP)) {
                            event = "+- VIP" + vipCount;
                        } else {
                            event = "++ VIP" + vipCount;
                            vipCount++;
                        }
                        break;
                    case 2:
                    case 3:
                        Client newORD = new Client("ORD" + ordCount, false);
                        if (!shop.clientArrives(newORD)) {
                            event = "+- ORD" + ordCount;
                        } else {
                            event = "++ ORD" + ordCount;
                            ordCount++;
                        }
                        break;
                }

                state = shop.shopState();
                System.out.printf(" %d ---->   ( %s )      [ %s ]\n", x, event, state);
            } else {
                break; // Exit if any other input
            }
        }

        scanner.close();
        System.out.println("Simulation ended.");
    }
}