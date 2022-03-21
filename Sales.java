import java.util.Date;
import java.util.Objects;

public class Sales{
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

    public Sales() {
    }

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
        return "{" +
            " country='" + getCountry() + "'" +
            ", itemType='" + getItemType() + "'" +
            ", orderPriority='" + getOrderPriority() + "'" +
            ", orderDate='" + getOrderDate() + "'" +
            ", orderID='" + getOrderID() + "'" +
            ", shipDate='" + getShipDate() + "'" +
            ", unitsSold='" + getUnitsSold() + "'" +
            ", unitPrice='" + getUnitPrice() + "'" +
            ", unitCost='" + getUnitCost() + "'" +
            ", revenue='" + getRevenue() + "'" +
            ", totalCost='" + getTotalCost() + "'" +
            ", totalProfit='" + getTotalProfit() + "'" +
            "}";
    }
}