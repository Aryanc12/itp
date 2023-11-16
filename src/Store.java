import java.io.IOException;
import java.util.Scanner;

public class Store
{
    static int userInput;
    static boolean sessionActive = true;

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        DisplayMenu();
//        List<String> test = new ArrayList<>();
//        test.add("iPhone");
//        test.add("1000");
//        test.add("10");
//        textbackend.appendTextToFile(test);

        while(sessionActive) {
            MenuInputChoice(input);
        }
        System.out.println("\n\nThanks for using this program...!");
    }

    private static void MenuInputChoice(Scanner input) throws IOException {
        System.out.print("Enter a choice and Press ENTER to continue[1-6]: ");
        try {
            userInput = input.nextInt();
        } catch (Exception e) {
            // consume the invalid input
            input.next();
        }
        switch (userInput) {
            case 1 -> textbackend.appendTextToFile(consoleui.AddItemInput());
            case 2 -> consoleui.UpdateItemQuantity(); //any time you use these put consoleui. becuase that's the file they're in
            case 3 -> consoleui.RemoveItem();
            case 4 -> consoleui.OutputItemList(textbackend.readTransactionsFile());
            case 5 -> consoleui.OutputItemList(textbackend.readItemsFile());
            case 6 -> sessionActive = false;
            default -> System.out.println("Unexpected error occurred, please enter an integer!");
        }
    }

    private static void DisplayMenu() {
        System.out.println("I N V E N T O R Y    M A N A G E M E N T    S Y S T E M");
        System.out.println("--------------------------------------------------------");
        System.out.println("1. ADD NEW ITEM");
        System.out.println("2. UPDATE QUANTITY OF EXISTING ITEM");
        System.out.println("3. REMOVE ITEM");
        System.out.println("4. VIEW DAILY TRANSACTION REPORT");
        System.out.println("5. VIEW ITEMS LIST");
        System.out.println("---------------------------------");
        System.out.println("6. Exit\n");

    }
}