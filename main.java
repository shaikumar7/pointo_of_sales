import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sales sales = new Sales();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Point of Sale System ---");
            System.out.println("1. View Products");
            System.out.println("2. Buy Product");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sales.displayProducts();
                    break;
                case 2:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    sales.purchaseProduct(id, qty);
                    break;
                case 3:
                    System.out.println("Thank you for using the POS System!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}