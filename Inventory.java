
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class Inventory  {
	
	private	String itemName;
	private double costPrice;
	private double sellPrice;
	private int quantity=0;
	private  int NoItemSold = 0;
	private static double COST_PRICE_DELETED= 0;
	private static double NET_PROFIT = 0;
	public static ArrayList<Inventory> list = new ArrayList<Inventory>();
	
	static NumberFormat formatter = new DecimalFormat("#0.00");     

	
	public static  Inventory create(String ITEM_NAME,double COST_PRICE,double SELL_PRICE) {
		Inventory obj = new Inventory();
		obj.setItemName(ITEM_NAME);
		obj.setCostPrice(COST_PRICE);
		obj.setSellPrice(SELL_PRICE);
		list.add(obj);
		return obj;
		
	}
	public static void delete(String itemName) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getItemName().equals(itemName)){
				COST_PRICE_DELETED +=list.get(i).getValue();
				list.remove(i);
			}
				
		}
	}
	public static void updateBuy(String itemName,int QTY) {
		for(int i=0;i<list.size();i++)
			if(list.get(i).getItemName().equals(itemName)) {
				list.get(i).setQuantity(list.get(i).getQuantity()+QTY);
			}

	}
	public static void updateSell(String itemName,int QTY) {
		
		for(int i=0;i<list.size();i++)
			if(list.get(i).getItemName().equals(itemName)) {
				list.get(i).setQuantity(list.get(i).getQuantity()-QTY);

			}	
		
	}
	public static void updateSellPrice(String itemName,double sellPrice) {
		for(int i=0;i<list.size();i++)
			if(list.get(i).getItemName().equals(itemName)) {
				list.get(i).setSellPrice(sellPrice);

			}
	}
	public int getItemSold() {
		return this.NoItemSold;
	}
	public  static void setItemSold(String itemName,int x) {
		for(int i=0;i<list.size();i++)
			if(list.get(i).getItemName().equals(itemName)) {
				list.get(i).NoItemSold +=x;
				list.get(i).setQuantity(list.get(i).getQuantity()-x);
			}
	}
	
	public static void report() {
		
		Collections.sort(list,new Comparator<Inventory>() {

			public int compare(Inventory o1, Inventory o2) {

				return o1.getItemName().compareToIgnoreCase(o2.getItemName());
			}
			
		});
		
		printing();
		for(Inventory x : list) {
			System.out.println(x.getItemName() +"\t\t" +x.getCostPrice() + "\t\t" + x.getSellPrice() + "\t\t"  + x.getQuantity() +"\t\t"  +  x.getValue());
		}
		
		System.out.println("-----------------------------------------------------------------------------------------------"
				+ "\nTotal Value: \t\t\t\t\t\t\t\t\t" +formatter.format(getTotalValue()));
		System.out.println("Profit since previous report\t\t\t\t\t\t\t"+formatter.format(getProfit())+"\n\n");

	}
	
	public static double getProfit() {
		
		double net_profit = 0;
		double SUM_COST_SELL = 0;
		int SUM_ITEMS = 0;
		for(Inventory x : list) {
			SUM_COST_SELL = x.getSellPrice() - x.getCostPrice();
			SUM_ITEMS = x.getItemSold();
			net_profit += SUM_COST_SELL * SUM_ITEMS;
		}
		net_profit -= COST_PRICE_DELETED;
		NET_PROFIT += net_profit;
		return net_profit;
	}
	public static double getTotalValue() {
		
		double total_inventory = 0;
		for(Inventory x : list) {
			total_inventory += x.getValue();
		}
		return total_inventory;
	}
	
	public void setItemName(String x) {
		this.itemName = x;
	}
	public String getItemName() {
		return this.itemName;
	}
	public void setCostPrice(double x) {
		this.costPrice = x;
	}
	public double getCostPrice(){
		return costPrice;
	}
	public void setSellPrice(double x) {
		this.sellPrice = x;
	}
	public double getSellPrice() {
		return sellPrice;
	}
	public void setQuantity(int x) {
		this.quantity = x ;
	}
	public int getQuantity(){
		return quantity;
	}
	public double getValue() {
		
		return this.getCostPrice() * this.getQuantity();
		
	}
	
	 
	public static void printing() {
		System.out.println("\t\t\t\tINVENTORY REPORT\n");
		System.out.println("Item name\t Bought at\t Sold at\t AvailableQty\t Value ");
		System.out.println("----------\t ----------\t---------\t------------\t--------");
		
	}
	
}
	
