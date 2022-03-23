import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class SalesDatabase {
    public static ArrayList<Sales> salesArr;

    public SalesDatabase(){
        salesArr = new ArrayList<>();
    }

    public void addRecord(Sales sale){
        salesArr.add(sale);
    }

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

    public void sortSales(){
        Collections.sort(salesArr);
    }

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
