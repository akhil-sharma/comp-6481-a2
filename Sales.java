import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * The Sales class.
 * An instance of this class represents a single sale.
 * All the attributes of this class are accessible through
 * getters and setters.
 * This class does not have the default constructor.
 */
public class Sales implements Comparable<Sales>{
    private String country;
    private String itemType;
    private char orderPriority;
    private Date orderDate; //Date fields will be in dd/mm/yyyy format.
    private long orderID;
    private Date shipDate; //Date fields will be in dd/mm/yyyy format.
    private int unitsSold;
    private float unitPrice;
    private float unitCost;
    private double revenue;
    private double totalCost;
    private double totalProfit;

    /**
     * The parameterized constructor for the Sales class.
     * 
     * @param country String representing the country associated with the order.
     * @param itemType String represent the type of the item.
     * @param orderPriority Char representing the priority of the order.
     * @param orderDate Date representing the date of the order.
     * @param orderID Long representing the id of the order.
     * @param shipDate Date representing the shipping date of the order.
     * @param unitsSold Integer representing the number of units sold.
     * @param unitPrice float representing the price of a unit.
     * @param unitCost float representing the cost of the unit.
     * @param revenue double representing the total revenue.
     * @param totalCost double representing the total cost.
     * @param totalProfit double representing the total profit.
     */
    public Sales(String country, String itemType, char orderPriority, Date orderDate, long orderID, Date shipDate, int unitsSold, float unitPrice, float unitCost, double revenue, double totalCost, double totalProfit) {
        this.country = country;
        this.itemType = itemType;
        this.orderPriority = orderPriority;
        this.orderDate = orderDate;
        this.orderID = orderID;
        this.shipDate = shipDate;
        this.unitsSold = unitsSold;
        this.unitPrice = unitPrice;
        this.unitCost = unitCost;
        this.revenue = revenue;
        this.totalCost = totalCost;
        this.totalProfit = totalProfit;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getItemType() {
        return this.itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public char getOrderPriority() {
        return this.orderPriority;
    }

    public void setOrderPriority(char orderPriority) {
        this.orderPriority = orderPriority;
    }

    public Date getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public long getOrderID() {
        return this.orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public Date getShipDate() {
        return this.shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public int getUnitsSold() {
        return this.unitsSold;
    }

    public void setUnitsSold(int unitsSold) {
        this.unitsSold = unitsSold;
    }

    public float getUnitPrice() {
        return this.unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public float getUnitCost() {
        return this.unitCost;
    }

    public void setUnitCost(float unitCost) {
        this.unitCost = unitCost;
    }

    public double getRevenue() {
        return this.revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public double getTotalCost() {
        return this.totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getTotalProfit() {
        return this.totalProfit;
    }

    public void setTotalProfit(double totalProfit) {
        this.totalProfit = totalProfit;
    }

    public Sales country(String country) {
        setCountry(country);
        return this;
    }

    public Sales itemType(String itemType) {
        setItemType(itemType);
        return this;
    }

    public Sales orderPriority(char orderPriority) {
        setOrderPriority(orderPriority);
        return this;
    }

    public Sales orderDate(Date orderDate) {
        setOrderDate(orderDate);
        return this;
    }

    public Sales orderID(long orderID) {
        setOrderID(orderID);
        return this;
    }

    public Sales shipDate(Date shipDate) {
        setShipDate(shipDate);
        return this;
    }

    public Sales unitsSold(int unitsSold) {
        setUnitsSold(unitsSold);
        return this;
    }

    public Sales unitPrice(float unitPrice) {
        setUnitPrice(unitPrice);
        return this;
    }

    public Sales unitCost(float unitCost) {
        setUnitCost(unitCost);
        return this;
    }

    public Sales revenue(double revenue) {
        setRevenue(revenue);
        return this;
    }

    public Sales totalCost(double totalCost) {
        setTotalCost(totalCost);
        return this;
    }

    public Sales totalProfit(double totalProfit) {
        setTotalProfit(totalProfit);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Sales)) {
            return false;
        }
        Sales sales = (Sales) o;
        return Objects.equals(country, sales.country) && Objects.equals(itemType, sales.itemType) && orderPriority == sales.orderPriority && Objects.equals(orderDate, sales.orderDate) && orderID == sales.orderID && Objects.equals(shipDate, sales.shipDate) && unitsSold == sales.unitsSold && unitPrice == sales.unitPrice && unitCost == sales.unitCost && revenue == sales.revenue && totalCost == sales.totalCost && totalProfit == sales.totalProfit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, itemType, orderPriority, orderDate, orderID, shipDate, unitsSold, unitPrice, unitCost, revenue, totalCost, totalProfit);
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
            return (
                getCountry() + "\t" +
                getItemType() + "\t" +
                getOrderPriority() + "\t" +
                formatter.format(getOrderDate()) + "\t" +
                getOrderID() + "\t" +
                formatter.format(getShipDate()) + "\t" +
                getUnitsSold() + "\t" +
                getUnitPrice() + "\t" +
                getUnitCost() + "\t" +
                getRevenue() + "\t" +
                getTotalCost() + "\t" +
                getTotalProfit());
    }

    /**
     * Overriding the compareTo method.
     * Useful when sorting the salesArr.
     * @param o
     * @return
     */
    @Override
    public int compareTo(Sales o) {
        if (this.getOrderID() > o.getOrderID()){
            return 1;
        } else if (this.getOrderID() < o.getOrderID()){
            return -1;
        }
        return 0;
    }
}