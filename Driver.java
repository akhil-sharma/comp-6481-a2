import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

    public Driver(){
        this.keyboard = new Scanner(System.in);
        this.streamRegistry = new StreamRegistry();
        this.hs = new HashSet<>();
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
                // read each line.
                if (streamRegistry.isEmpty()){
                    // The files are already loaded.
                }

                // if directory =, check empty.
                // if file, then read it into into a hashset,
                // report duplicates
                // add to the database
                // generate output.
                mainRepl();
                break;

            case 3:
                shutDown();
        }
    }

    /**
     * Just process the log file.
     */
    private void loadStreamRegistry(){
        

    }

    private void ArrayList<Files> parseLogs(){
        FileInputStream fstream = new FileInputStream(LOG_FILE_NAME);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;
        File filePath;

        while ((strLine = br.readLine()) != null){
            strLine = strLine.strip();
            filePath = new File(strLine.split(":")[1]);

            try{
                if (strLine.startsWith("directory")){
                    checkEmptyDirectorty(filePath);
                    // no further processing necessary.
                
                } else if (strLine.startsWith("file")){
                    checkFileExists(filePath);
                    // add the stream to the registry.
                    streamRegistry.register(
                        new Scanner(new FileInputStream(filePath))
                    );
                }
            } catch(InvalidFileException ife){

            } catch (EmptyFolderException efe){

            }
        }
    }

    /**
     * Helper method to check a directory.
     * @param file File object holding the path to the directory.
     */
    private void checkEmptyDirectorty(File file){
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
    private void checkFileExists(File file){
        if (!file.exists()){
            throw new InvalidFileException();
        }
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
