import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;


public class TipCalculator {
    public static void main(String[] args) {

        ArrayList<String> items = new ArrayList<String>();
        System.out.print("Hello and welcome! What percentage would you like to tip? (0-100) ");
        Scanner scan = new Scanner(System.in);
        int tipPercentage = scan.nextInt();
        String item;
        System.out.print("How many people are in your group?: ");
        int people = scan.nextInt();
        scan.nextLine();
        double price = 0;
        double subTotal = price;
        System.out.print("Do you have a discount? (y/n): ");
        String discount = scan.nextLine();
        int discountPercentage = 0;
        if (Objects.equals(discount, "y")) {
            System.out.print("What is the discount percentage?: ");
            discountPercentage = scan.nextInt();
        }




        while (price != -1) {
            System.out.print("Please state the price of your purchase (-1 to quit): ");
            price = scan.nextDouble();
            scan.nextLine();
            subTotal += price;
            if (price != -1) {
                System.out.print("Please state the name of your item: ");
                item = scan.nextLine();
                items.add(item);
            }
        }

        subTotal = Math.round(subTotal * 100.0) / 100.0 + 1;
        double subTotalPerPerson = Math.round(subTotal/people * 100.0) / 100.0;
        double total = Math.round(subTotal * (1 + tipPercentage/100.0) * 100.0) / 100.0;
        double totalPerPerson = Math.round(total/people * 100.0) / 100.0;
        double tip = Math.round((total - subTotal) * 100.0) / 100.0;
        double tipPerPerson = Math.round(tip/people * 100.0) / 100.0;

        System.out.println("____________________________________________________________");
        System.out.println("| The group's tip percentage is: " + tipPercentage + "%");
        System.out.println("| The group's total bill before tip is: $" + subTotal);
        System.out.println("| The group's bill before tip per person is: $" + subTotalPerPerson);
        System.out.println("| The tip that the group is paying: $" + tip);
        System.out.println("| The tip that each person is paying: $" + tipPerPerson);
        System.out.println("| The group's total bill after tip is: $" + total);
        System.out.println("| The group's bill per person after tip is: $" + totalPerPerson);
        System.out.println("____________________________________________________________");
        if (discountPercentage > 0) {
            double newTotal = Math.round(total * (1 - discountPercentage/100.0) * 100.0) / 100.0;
            double takenOff = Math.round((total - newTotal) * 100.0) / 100.0;
            System.out.println("| Discount percentage is: " + discountPercentage + "%");
            System.out.println("| Price taken out of total is: $" + takenOff);
            System.out.println("| New total is: $" + newTotal);
            System.out.println("____________________________________________________________");
        }
        System.out.println("The items you ordered are:");
        for (int i= 0; i < items.size(); i++) {
            System.out.println((i+1) + ": " + items.get(i));
        }
        System.out.println("____________________________________________________________");
    }
}
