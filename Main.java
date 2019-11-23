

public  class Main  extends Inventory  {

	public static  void main(String[] args) {

		for (int i = 0; i < args.length; i++) {
			
			String argument = args[i];
			if (argument.equals("create")) {
				
				String itemName = args[i + 1];
				double costPrice = new Double(args[i + 2]);
				double sellPrice = new Double(args[i + 3]);
				create(itemName,costPrice,sellPrice);
			} 
			else if (argument.equals("delete")) {
				String itemName = args[i + 1];
				delete(itemName);

			} 
			else if (argument.equals("updateBuy")) {
				String itemName = args[i + 1];
				int quantity = new Integer(args[i + 2]);
				updateBuy(itemName,quantity);
			}
			else if (argument.equals("updateSell")) {
				String itemName = args[i + 1];
				 int quantity = new Integer(args[i + 2]);
				setItemSold(itemName,quantity);
				
			}
			else if(argument.equals("updateSellPrice")) {
				String itemName = args[i+1];
				double sellPrice = new Double(args[i+2]);
				updateSellPrice(itemName,sellPrice);
				
			}
			else if (argument.equals("report")) {
				report();
			}

		}
		

	}
}
