/*
 * Class: CMSC203 
 * Instructor:Khandan Monshi
 * Description: Thsi is the BevShopDriverApp class with the main method 
 * Due: 05/13/2025
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __Joel Mbah________
*/


import java.util.Scanner;

public class BevShopDriverApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BevShop bevShop = new BevShop();

        // Display shop policies
        System.out.println("The current order in process can have at most " + bevShop.getMaxOrderForAlcohol() + " alcoholic beverages.");
        System.out.println("The minimum age to order alcohol drink is " + bevShop.getMinAgeForAlcohol());

        // Start a new order
        System.out.println("\nStart please a new order:");
        System.out.print("Would you please enter your name: ");
        String name = scanner.nextLine();

        int age = getValidAge(scanner);

        bevShop.startNewOrder(10, Day.MONDAY, name, age);
        System.out.println("Your Total Order for now is 0.0");

        // Alcohol order process
        if (bevShop.isValidAge(age)) {
            System.out.println("Your age is above 20 and you are eligible to order alcohol");

            int alcoholCount = 0;
            while (bevShop.isEligibleForMore()) {
                System.out.print("Would you like to add an alcohol drink? (yes/no): ");
                String choice = scanner.nextLine().trim().toLowerCase();

                if (choice.equals("yes")) {
                    alcoholCount++;
                    bevShop.processAlcoholOrder("Beer", Size.SMALL);
                    System.out.println("The current order of drinks is " + alcoholCount);
                    System.out.println("The Total Price on the Order: $" + bevShop.getCurrentOrder().calcOrderTotal());
                    if (alcoholCount < 3) {
                        System.out.println("Your current alcohol drink order is less than 4");
                    } else {
                        System.out.println("You have reached the maximum alcohol drinks for this order");
                        break;
                    }
                } else if (choice.equals("no")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                }
            }
        } else {
            System.out.println("Your age is not appropriate for alcohol drink!!");
        }

        // Coffee order process
        System.out.print("Would you like to add a COFFEE to your order? (yes/no): ");
        String coffeeChoice = scanner.nextLine().trim().toLowerCase();
        if (coffeeChoice.equals("yes")) {
            bevShop.processCoffeeOrder("Latte", Size.MEDIUM, true, true);
            System.out.println("Total items on your order is " + bevShop.getCurrentOrder().getTotalItems());
            System.out.println("The Total Price on the Order: $" + bevShop.getCurrentOrder().calcOrderTotal());
        }

        // Smoothie order process
        System.out.print("Would you like to add a SMOOTHIE to your order? (yes/no): ");
        String smoothieChoice = scanner.nextLine().trim().toLowerCase();
        if (smoothieChoice.equals("yes")) {
            int numFruits = getValidNumber(scanner, "Enter number of fruits: ");
            boolean protein = getYesNoChoice(scanner, "Add protein? (yes/no): ");
            bevShop.processSmoothieOrder("Tropical Smoothie", Size.LARGE, numFruits, protein);
            System.out.println("The Total Price on the Order: $" + bevShop.getCurrentOrder().calcOrderTotal());
        }

        // Final order summary
        System.out.println("\n#------------------------------------#");
        System.out.println("Final Order Summary:");
        System.out.println(bevShop.getCurrentOrder());
        System.out.println("Total Monthly Sale: $" + bevShop.totalMonthlySale());

        scanner.close();
    }

    // Helper method to get a valid age input
    private static int getValidAge(Scanner scanner) {
        int age;
        while (true) {
            System.out.print("Would you please enter your age: ");
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                scanner.nextLine(); // consume newline
                if (age >= 18) {
                    return age;
                } else {
                    System.out.println("Age must be 18 or older.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid age.");
                scanner.nextLine(); // consume invalid input
            }
        }
    }

    // Helper method to get a valid number input
    private static int getValidNumber(Scanner scanner, String prompt) {
        int number;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                scanner.nextLine(); // consume newline
                if (number > 0) {
                    return number;
                } else {
                    System.out.println("Number must be positive.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // consume invalid input
            }
        }
    }

    // Helper method to get a valid yes/no choice
    private static boolean getYesNoChoice(Scanner scanner, String prompt) {
        String choice;
        while (true) {
            System.out.print(prompt);
            choice = scanner.nextLine().trim().toLowerCase();
            if (choice.equals("yes")) {
                return true;
            } else if (choice.equals("no")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }
    }
}
