import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class consoleui { // do not put textbackendui. things in here
    public static List<String> AddItemInput() {
        System.out.println("Type item you want to add ");
        List<String> newItemLine = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);//add a scanner to take user input for ,DESC and QTY
        scanner.nextInt();
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
