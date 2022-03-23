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

    public void displayFileContents(){
        for(Sales sale: SalesDatabase.salesArr){
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
