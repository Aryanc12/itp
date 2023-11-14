import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class textbackend { //do not put consoleui. things in here as we will have to alter some of these in the future in order to make into a
    public static void AddItemToItemstxt(String[] detailsToAdd) {

    }

    public static List<String> readItemsFile() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("src/resources/items.txt"));
        String line = in.readLine();
        List<String> lines = new ArrayList<>();
        while (line != null)
        {                       ///this makes textbackend able to read and output all the lines in the items text file
            lines.add(line);
            line = in.readLine();
        }
        in.close();
        return lines;
    }
    public static List<String> readTransactionsFile() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("src/resources/transactions.txt"));
        String line = in.readLine();
        List<String> lines = new ArrayList<>();
        while (line != null)
        {                       ///this makes textbackend able to read and output all the lines in the transactions text file
            lines.add(line);
            line = in.readLine();
        }
        in.close();
        return lines;
    }
        public static void appendTextToFile(List<String> properties) { //this needs DESC,QTY,PRICE,

        List<String> allProperties = new ArrayList<>(); //this basically makes an array so we can add things to as strings

        allProperties.add("00001");    //this is to add an ID to the end of the list but there an empty list so it goes to the start
            //this id will eventually be calculated ;)
            allProperties.addAll(properties);

            int quantityNum = Integer.parseInt(properties.get(1));
            int priceNum = Integer.parseInt(properties.get(2));//this makes the program able to read the quantity and price as an integer number and not a text
            int totalPriceNum = quantityNum * priceNum;

            allProperties.add(String.valueOf(totalPriceNum)); // this adds the integer to the end of the string whilst treating the integer as a string

        try {
                String filePath = "src/resources/items.txt";

                // The text you want to add
                // Create a FileWriter in append mode
                FileWriter fileWriter = new FileWriter(filePath, true);

                // Create a BufferedWriter to efficiently write characters to the file
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                // Write the text to the file
                bufferedWriter.write(String.valueOf(allProperties));

                // Close the BufferedWriter to release resources
                bufferedWriter.close();

                System.out.println("Text has been successfully appended to the file.");

            } catch (IOException e) {
                // Handle exceptions, e.g., if the file is not found
                e.printStackTrace();
            }
        }
    }

