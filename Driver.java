import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {

    private static String BASE_FILE_PATH = "Data";
    private static String LOG_FILE_NAME = "log.txt";

    private Scanner keyboard;
    private StreamRegistry streamRegistry;
    private HashSet<Sales> hs;
    private SalesDatabase salesDb;

    public Driver(){
        this.keyboard = new Scanner(System.in);
        this.streamRegistry = new StreamRegistry();
        this.hs = new HashSet<>();
        this.salesDb = new SalesDatabase();
    }
    
    public void shutDown(){
        shutDown("Good bye!");
    }

    /**
     * A wrapper to close all the open streams, 
     * print a final message and exit.
     * 
     * @param message The String to be printed before exitting. DEFAULT: Good bye!
     */
    public void shutDown(String message){
        keyboard.close();
        streamRegistry.closeAll();
        System.out.println(message);
        System.exit(0);
    }

    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.mainRepl();
    }
    
    /**
     * Display a menu to the user listing all the available operations.
     * Perform the relevant task when the user has selected an option and 
     * redisplay the menu unless the user chose to exit.<br/>
     * The available options are as follows:
     * <ol>
     *  <li>Explore the Data directory and dump the file/directory paths to log.txt</li>
     *  <li>Process the files listed in log.txt, if it exists.</li>
     *  <li>Exit cleanly.</li>
     * </ol>
     */
    public void mainRepl(){
        int choice = displayMenu(keyboard);

        switch (choice){
            case 1:
                walkDirectory();
                mainRepl();
                break;

            case 2:
                // does the log file exist?
                File logFile = new File(LOG_FILE_NAME);
                if (!logFile.exists()){
                    System.out.println("The log file does not exist.");
                    mainRepl();
                    break;
                }

                parseLogs();
                for (Sales sale : hs){
                    this.salesDb.addRecord(sale);
                }
                
                this.salesDb.displayFileContents();

                mainRepl();
                break;

            case 3:
                shutDown();
        }
    }

    /**
     * Just process the log file.
     */
    // private void loadStreamRegistry(){
        

    // }

    private void parseLogs(){
        try {
            FileInputStream fstream = new FileInputStream(LOG_FILE_NAME);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String strLine;
            File filePath;

            while ((strLine = br.readLine()) != null){
                strLine = strLine.strip();
                filePath = new File(strLine.split(":")[1]);

                try{
                    if (strLine.startsWith("directory")){
                        checkEmptyDirectory(filePath);
                        // no further processing necessary.
                    
                    } else if (strLine.startsWith("file")){
                        checkFileExists(filePath);
                        // Process the file.
                        processFile(filePath);
                    }
                } catch(InvalidFileException ife){
                    System.out.println(ife.getMessage());

                } catch (EmptyFolderException efe){
                    System.out.println(efe.getMessage());

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    /**
     * Helper method to check a directory.
     * @param file File object holding the path to the directory.
     */
    private void checkEmptyDirectory(File file) throws InvalidFileException, EmptyFolderException{
        if (!file.exists() || !file.isDirectory()){
            throw new InvalidFileException();
        }

        if (file.list().length == 0){
            throw new EmptyFolderException(file.getName());
        }
    }

    /**
     * Helper method to check if the file path is valid.
     * @param file
     */
    private void checkFileExists(File file) throws InvalidFileException{
        if (!file.exists()){
            throw new InvalidFileException();
        }
    }

    private void processFile(File filePath) throws FileNotFoundException{
        Scanner reader = new Scanner(filePath);
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            Sales sale = getSaleFromText(data);

            if (this.hs.contains(sale)){
                System.out.println("Duplicate record found: ");
                System.out.println(sale);
            } else {
                hs.put(sale);
            }
          }
          reader.close();
    }

    private Sales getSaleFromText(String fileEntry){
        String values[] = fileEntry.split("\t");
        String country = values[0];
        String itemType = values[1];
        char orderPriority = values[2].charAt(0);
        Date orderDate = new Date(values[3]);
        long orderId = Long.parseLong(values[4]);
        Date shipDate = new Date(values[5]);
        int unitsSold = Integer.parseInt(values[6]);
        float unitPrice = Float.parseFloat(values[7]);
        float unitCost = Float.parseFloat(values[8]);
        double revenue =  Double.parseDouble(values[9]);
        double totalCost =  Double.parseDouble(values[10]);
        double totalProfit =  Double.parseDouble(values[11]);

        return new Sales(
            country, 
            itemType, 
            orderPriority, 
            orderDate, 
            orderId, 
            shipDate, 
            unitsSold, 
            unitPrice, 
            unitCost, 
            revenue, 
            totalCost, 
            totalProfit
        );
    }
    
    /**
     * Helper method for setting up the PrintWriter stream and calling the method for 
     * starting the exploration of the directory.
     */
    private void walkDirectory(){
        File base = new File(BASE_FILE_PATH);
        PrintWriter outputStream = null;

        try{
            outputStream = new PrintWriter(new FileOutputStream(LOG_FILE_NAME));
            walkDirectory(base, outputStream, -4);

            System.out.println("\nSuccessfully added details of the file structure to `log.txt`.\n");

        } catch (FileNotFoundException fnfe){
            System.out.println("Problem opening files: " + LOG_FILE_NAME);
        
        } finally {
            if (outputStream != null){
                outputStream.close();
            }
        }
    }

    /**
     * The recursive method to explore a directory. The the files and directories
     * encountered during the execution are added to log.txt.<br/>
     * <b>NOTE</b>: An empty directory is not added to log.txt. 
     * @param file File object wrapping the path of a potential file.
     * @param outputStream PrintWriter stream for writing to log.txt.
     * @param level Integer deciding the length of indentation for the file paths in log.txt 
     */
    private void walkDirectory(File file, PrintWriter outputStream, int level){       

            if (file.isDirectory()){
                File[] files  = file.listFiles();
                
                // if (files.length == 0){
                //     throw new EmptyFolderException("\nCUSTOM_EXCEPTION: Directory " + file.getName() + " is empty. Skipping.");
                // }

                if (!file.getName().equals(BASE_FILE_PATH)){
                    for (int space = 0; space < level; space ++){
                        outputStream.print(" ");
                    }
                    outputStream.println("directory:" + file.getAbsolutePath());
                }
    
                for (File source: files){
                    walkDirectory(source, outputStream, level + 4);
                }
            
            } else {
                for (int space = 0; space < level; space ++){
                    outputStream.print(" ");
                }
                outputStream.println("file:" + file.getAbsolutePath());
            }
    }
    
    private int displayMenu(Scanner keyboard){
        System.out.println("\nWhat would you like to do?");
        System.out.println("\t1. List files.");
        System.out.println("\t2. Process files.");
        System.out.println("\t3. Exit.");
        System.out.print("Please select a valid option [1:3]> ");

        int choice;

        do { // Loop until correct input
            try {
                choice = keyboard.nextInt();
                if (choice >= 1 && choice <= 3) {
                    break;
                } else {
                    System.out.print("Please enter a number between 1 and 3 (both inclusive): ");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Try again: ");
                keyboard.next();
                continue;
            }
        } while (true);
        keyboard.nextLine();
        return choice;
    }
}
