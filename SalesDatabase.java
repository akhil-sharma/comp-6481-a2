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

    private void addRecord(Sales sale){
        salesArr.put(sale);
    }

    private void displayFileContents(){
        for(Sales sale: this.salesArr){
            System.out.println(sale);
        }
    }

    private void binarySaleSearch(long orderID){
        // keep a track of the iterations.
    }

    private void sequenctialSaleSearch(long orderID){
        // keep a track of the iterations.
    }

}
