// import java.io.File;
// import java.io.FileNotFoundException;
// import java.io.FileOutputStream;
// import java.io.PrintWriter;
// import java.util.InputMismatchException;
// import java.util.Scanner;
import java.util.ArrayList;


public class SalesDatabase {
    private static ArrayList<Sales> salesArr;

    public SalesDatabase(){
        salesArr = new ArrayList<>();
    }

    public void addRecord(Sales sale){
        salesArr.add(sale);
    }

    public void displayFileContents(File fileName){
        FileInputStream fileStream = new FileInputStream(fileName);
        BufferedReader br;
        String line;
        br = new BufferedReader(new InputStreamReader(fileStream, encoding));
        
        while ((line = br.readLine()) != null) {
            sb.append(line + System.lineSeparator());
        }
 
        return sb.toString();
        
    }

    private void binarySaleSearch(long orderID){
        // keep a track of the iterations.
    }

    private void sequentialSaleSearch(long orderID){
        // keep a track of the iterations.
    }

}
