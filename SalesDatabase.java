import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * This class holds all the sales and 
 * performs any necessary operation on these
 * sales.
 * 
 * The main method was moved to a separate Driver class
 * to reduce the file size.
 */
public class SalesDatabase {
    public static ArrayList<Sales> salesArr;

    /**
     * The public default constructor.
     * It simply initialized the salesArr
     * ArrayList<Sales>.
     */
    public SalesDatabase(){
        salesArr = new ArrayList<>();
    }

    /**
     * Add the given sale to the salesArr.
     * @param sale
     */
    public void addRecord(Sales sale){
        salesArr.add(sale);
    }

    /**
     * Display the contents of the given File object.
     * @param file File object representing the path of the given file.
     */
    public void displayFileContents(File file){
        System.out.println("\n\nFile contents:\n\n");
        BufferedReader objReader = null;
        try {
            String strCurrentLine;
            objReader = new BufferedReader(new FileReader(file));
            
            while ((strCurrentLine = objReader.readLine()) != null) {
                System.out.println(strCurrentLine);
            }
      
        } catch (IOException e) {
            e.printStackTrace();
        
        } finally {
            try {
                if (objReader != null){
                    objReader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }   
    }

    /**
     * Sort the salesArr using the built-in
     * Collections.sort().
     * 
     * This is useful when running binarySaleSearch method.
     */
    public void sortSales(){
        Collections.sort(salesArr);
    }

    /**
     * Clear all the data in the salesArr.
     */
    public void resetSales(){
        SalesDatabase.salesArr.clear();
    }

    /**
     * Look for an order with the given orderID in the salesArr using
     * the binary search algorithm.
     * If the sale is found, print it's contents, 
     * the number of iterations needed to find it and return.
     * Else accept defeat and print `Record not found!`
     * 
     * @param orderID long representing the orderID of the sale to be found.
     */
    public void binarySaleSearch(long orderID){
        int i = 0;
        int low = 0;
        int high = salesArr.size() - 1;
        while (high >= low){
            i += 1;
            int mid = low + (high - low) / 2;
            if (salesArr.get(mid).getOrderID() == orderID){
                System.out.println("\nSale record found!");
                System.out.println(salesArr.get(mid));
                System.out.println("Total iterations: " + i);
                System.out.println();
                return;
            }

            else if (salesArr.get(mid).getOrderID() < orderID){
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        System.out.println("Record not found!");
        System.out.println("Total iterations: " + i);

    }

    /**
     * Look for an order with the given orderID in the salesArr using
     * the sequential search algorithm (Linear search.).
     * If the sale is found, print it's contents, 
     * the number of iterations needed to find it and return.
     * Else accept defeat and print `Record not found!`
     * 
     * @param orderID long representing the orderID of the sale to be found.
     */
    public void sequentialSaleSearch(long orderID){
        // keep a track of the iterations.
        Iterator<Sales> itr = salesArr.iterator();
        int i = 0;
        Sales current;
        while(itr.hasNext()){
            i += 1;
            current = itr.next();
            if (current.getOrderID() == orderID){
                System.out.println("\nSale record found!");
                System.out.println(current);
                System.out.println("Total iterations: " + i);
                System.out.println();
                return;
            }
        }

        System.out.println("Record not found!");
        System.out.println("Total iterations: " + i);
    }

}
