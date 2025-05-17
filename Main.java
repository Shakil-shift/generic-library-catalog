import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Catalog<String> catalog = new Catalog<>();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to the Generic Library Catalog!");
        loop: while (true) {
            System.out.println("\nCommands: add | remove | view | exit");
            System.out.print("> ");
            command = scanner.nextLine().trim().toLowerCase();
            try {
                switch (command) {
                    case "add":
                        System.out.print("Enter ID: ");
                        String id = scanner.nextLine().trim();
                        System.out.print("Enter Title: ");
                        String title = scanner.nextLine().trim();
                        System.out.print("Enter Author: ");
                        String author = scanner.nextLine().trim();
                        System.out.print("Enter Extra Info: ");
                        String info = scanner.nextLine().trim();
                        catalog.addItem(new LibraryItem<>(title, author, id, info));
                        System.out.println("Item added.");
                        break;
                    case "remove":
                        System.out.print("Enter ID to remove: ");
                        catalog.removeItem(scanner.nextLine().trim());
                        System.out.println("Item removed.");
                        break;
                    case "view":
                        catalog.listAll();
                        break;
                    case "exit":
                        break loop;
                    default:
                        System.out.println("Unknown command.");
                }
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
        System.out.println("Goodbye!");
    }
}