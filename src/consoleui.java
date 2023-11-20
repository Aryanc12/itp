import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class consoleui { // do not put textbackendui. things in here
    public static List<String> AddItemInput() {
        List<String> newItemLine = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);//add a scanner to take user input for ,DESC and QTY

        System.out.println("Type item you want to add ");
        newItemLine.add(scanner.nextLine());

        System.out.println("Enter price of unit");
        while  (!scanner.hasNextDouble()) {
            System.out.println("That is not a valid price number, please re-enter"); //this is to ensure that the input is in the format required
            scanner.next(); // kill the invalid input
        }
        newItemLine.add(String.valueOf(scanner.nextDouble()));

        System.out.println("Type Quantity of item ");
        while (!scanner.hasNextInt()) {
                System.out.println("That is not a valid quantity number, please re-enter");
                scanner.next(); // kill the invalid input
        }
        newItemLine.add(String.valueOf(scanner.nextInt()));

        return newItemLine;
    }
    public static void OutputItemList(List<String> itemList) {
        System.out.println("This is the item list");
        itemList.forEach(System.out::println); // this prints out the listed items underneath each other
    }
    public static void UpdateItemQuantity() {
        System.out.println("Item quantity updated\n");






    }

    public static void RemoveItem() {
        System.out.println("Item Removed\n");
    }

    public static void ViewDailyTransactionReport() {
        System.out.println("Report printed\n");
    }
}
