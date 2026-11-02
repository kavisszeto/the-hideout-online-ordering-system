package javafx_individualproject;

/**
 *
 * @author kavisszeto
 */
public class Cafe
{
    
    public final String cofList[] = {"Americano", "Capuccino", "Caramel Latte", "Mocha"};
    public final int cofPrice[] = {100, 120, 130, 140};
    public final String milkList[] = {"Default", "Low-Fat Milk", "Skim Milk", "Soy Milk", "Almond Milk"};
    public final String othList[] = {"Strawberry Smoothie", "Sandwiches", "Carrot Cake"};
    public final int othPrice[] = {130, 150, 210};
    
    private int cofTotal = 0;
    private int cofQty = 0;
    private int othTotal = 0;
    private int[] othQty = new int[othList.length];
    
    public Cafe()
    {
        
    }
    
    public String coffeeInfo(int sizeID, int milkID, boolean tptID, boolean creamID, boolean decafID, int typeID)
    {
        int price = cofPrice[typeID];
        String cofType = cofList[typeID];
        String milk = milkList[milkID];
        
        String tpt = "Hot";
        String size = "Small";
        String cream = "";
        String decaf = "";
        
        String message = "";
        
        if(tptID)
        {
            tpt = "Iced";
        }   

        switch(sizeID)
        {
            
            case 0:
                break;
                
            case 1:
                price += 20;
                size = "Medium";
                break;
                
            case 2:
                price += 30;
                size = "Large";
                break;
                
        }

        message = tpt + " " + cofType + "\n\t" + size + ", " + milk + "\n" + "\t\t\t\t\t\t\t$" + price + "\n";
        
        if(creamID)
        {
            cream = "with Whipped Cream";
            message = tpt + " " + cofType + "\n\t" + size + ", " + milk + "\n\t(" + cream + ")\n" + "\t\t\t\t\t\t\t$" + price + "\n";
        }
        
        if(decafID)
        {
            decaf = "Decaffeinated";
            price += 10;
            message = tpt + " " + cofType + "\n\t" + size + ", " + milk + "\n\t(" + decaf + ")\n" + "\t\t\t\t\t\t\t$" + price + "\n";
        }
        
        if(creamID && decafID)
        {
            message = tpt + " " + cofType + "\n\t" + size + ", " + milk + "\n\t(" + cream + ", " + decaf + ")\n" + "\t\t\t\t\t\t\t$" + price + "\n";          
        }
        
        cofTotal += price;
        cofQty++;

        return message;
        
    }
    
    public void othInfoAdd(int typeID)
    {
        
        int price = 0;
       
        price = othPrice[typeID];
        othQty[typeID]++;
        
        othTotal += price;

    }
    
    public void othInfoRemove(int typeID)
    {
        
        int price = 0;
        
        price = othPrice[typeID];
        
        if(othQty[typeID] > 0)
        {
            
            othQty[typeID]--;
            othTotal -= price;
            
        }

    }
    
    
    public String showCofCart()
    {
        
        String message = "";
        
        if(cofQty != 0)
        {
            message = cofQty + " Coffee(s)" + "\n$" + cofTotal + "\n–––––––––––––––––––––––––\n";
        }

        return message;
        
    }
    
    public String showOthCart(int typeID)
    {
        
        String message = "";

        message = othQty[typeID] + " " + othList[typeID] + "\n$" + othQty[typeID] * othPrice[typeID] + "\n";
        
        return message;
        
    }
    
    public String showOthTotal()
    {
        
        String message = "\t\t\tSubtotal:\n\t\t\t$" + othTotal + "\n";
        return message;
        
    }
    
    public String showTotal()
    {
        
        String total = "Error! No products in the cart.";
        
        if(cofTotal + othTotal != 0)
        {
            total = "\t\t\tTotal:\n\t\t\t$" + (cofTotal + othTotal);
        }
        
        return total;
        
    }
    
    public int getOthQty(int typeID)
    {
        
        return othQty[typeID];
        
    }
    
    public int getTotal()
    {
        
        return cofTotal + othTotal;
        
    }
    
    public void reset()
    {
        
        cofTotal = 0;
        othTotal = 0;
        cofQty = 0;
        
        for(int i = 0; i < othList.length; i++)
        {
            othQty[i] = 0;
        }

    }
}
