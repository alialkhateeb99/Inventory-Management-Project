# Inventory-Management-Project
Inventory Management system that takes in single line command line arguments and perform's its respective operations.

Below is the list of commands used  in the system:
a) create itemName costPrice sellingPrice
Whenever You to add a new item to the store , use the  create command. This command
creates a new item in the inventory with the given cost price and selling price. The prices are rounded off
to two decimal places.

b) delete itemName

If You decides not to sell an item anymore, then he simply issues a delete command. This
command will remove the item from the inventory.

c) updateBuy itemName quantity

Whenever You want to  purchase additional quantity of the mentioned item, then  issue a updateBuy
command. This command should increase the quantity of the mentioned item.

d) updateSell itemName quantity

Whenever You want to sell some item, then he issue a updateSell command. This command should
deduct the quantity of the mentioned item.

e)  updateSellPrice itemName newSellPrice
 In  case you want to change the initial selling price of that item. 
 This command will update the sellingPrice of the specified item.

f) report
Whenever You wants to view the inventory list then issues the report command. This command
should print the current inventory details in the specified format sorted by alphabetical order. Apart from
printing the inventory it also  reports  the profit made since last report generation.

Where profit is calculated by: ∑ (sellingPrice-costPrice) of the sold items multiplied by no. of items sold-
costPrice of the deleted items.
