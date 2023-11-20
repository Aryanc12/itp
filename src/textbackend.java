import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class textbackend { //do not put consoleui. things in here as we will have to alter some of these in the future in order to make into a
    public static void AddItemToItemstxt(List<String> detailsToAdd) {
        System.out.println(detailsToAdd);
    }

    public static List<String> readItemsFile() {
        try {
            BufferedReader in = new BufferedReader(new FileReader("src/resources/items.txt"));
            String line = in.readLine();
            List<String> lines = new ArrayList<>();
            while (line != null) {                       ///this makes textbackend able to read and output all the lines in the items text file
                lines.add(line);
                line = in.readLine();
            }
            in.close();
            return lines;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> readTransactionsFile() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("src/resources/transactions.txt"));
        String line = in.readLine();
        List<String> lines = new ArrayList<>();
        while (line != null) {                       ///this makes textbackend able to read and output all the lines in the transactions text file
            lines.add(line);
            line = in.readLine();
        }
        in.close();
        return lines;
    }

    public static void appendTextToFile(List<String> properties) { //this needs DESC,QTY,PRICE,

        List<String> allProperties = new ArrayList<>(); //this basically makes an array so we can add things to as strings


        allProperties.add(generateId());    //this is to add an ID to the end of the list but there an empty list so it goes to the start
        //this id will eventually be calculated ;)
        allProperties.addAll(properties);

        double priceNum = Double.parseDouble(properties.get(1));//makes the program able to read the quantity and price as int and not a text
        int quantityNum = Integer.parseInt(properties.get(2));
        double totalPriceNum = quantityNum * priceNum;

        allProperties.add(String.valueOf(totalPriceNum));
        // this adds the integer to the end of the string whilst treating the integer as a string

        try {
            getBufferedWriter(allProperties);
            //these lines replace the default square brackets to nothing and also removes spaces

            updateTransactions(allProperties,"added");

            System.out.println("Text has been successfully appended to the file.");

        } catch (IOException e) {
            // Handle exceptions, e.g., if the file is not found
            e.printStackTrace();
        }
    }

    private static void getBufferedWriter(List<String> allProperties) throws IOException {
        String filePath = "src/resources/items.txt";

        // The text you want to add
        // Create a FileWriter in append mode then
        // Create a BufferedWriter to efficiently write characters to the file
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));
        bufferedWriter.newLine(); // this adds a new line
        // Write the text to the file
        bufferedWriter.write(
                String.valueOf(allProperties)
                        .replace("[", "")
                        .replace("]", "")
                        .replace(" ", ""));
        // Close the BufferedWriter to release resources
        bufferedWriter.close();
}
    private static String generateId() {
        List<String> lines = readItemsFile(); // we will now read the items and store it in a list of strings (copies them)
        int numOfRows = lines.size(); //this finds the size of how many lines there are
        String lastRow = lines.get(numOfRows - 1); // this obtains the string of the last row (which contains the ID we need)
        int latestId = Integer.parseInt(lastRow.substring(0 , 5)); // this gains the latest id number
        int newIdNum = latestId + 1;
        return String.format("%05d",newIdNum); // this adds 0's until the id number reaches 5 digits
    }
    public static void updateTransactions(List<String> properties, String transactionType) { // added, updated or removed
        //other properties are id,description,qtyChanged,amount(£),stockRemaining,
        String filePath = "src/resources/transactions.txt";
        List<String> row = new ArrayList<>();
        switch(transactionType) {
            case "added" -> {
                row.add(properties.get(0)); //ID
                row.add(properties.get(1)); // desc
                row.add(properties.get(2)); // qtychanged
                row.add(properties.get(3));//amount(£)
                row.add(properties.get(2));//stockremaining (which is the same as qtychanged)
                row.add(String.valueOf(java.time.LocalDateTime.now()));

                // The text you want to add
                // Create a FileWriter in append mode
                try {
                    // Create a BufferedWriter to efficiently write characters to the file
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));
                    bufferedWriter.newLine(); // this adds a new line
                    // Write the text to the file
                    bufferedWriter.write(
                            String.valueOf(row)
                                    .replace("[", "")
                                    .replace("]", "")
                                    .replace(" ", ""));
                    bufferedWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            case "updated" -> {
                System.out.println("Updated");
            }
            case "removed" -> {
                System.out.println("Removed");
            }

        }


    }

}
