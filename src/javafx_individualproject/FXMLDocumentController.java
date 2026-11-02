package javafx_individualproject;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;



/**
 *
 * @author kavisszeto
 */
public class FXMLDocumentController implements Initializable
{
    
    private final String[] sizes = {"Small", "Medium +$20", "Large +$30"};
    private final ArrayList<String> size_list = new ArrayList(Arrays.asList(sizes));
    
    private final String[] milks = {"Default", "Low-Fat Milk", "Skim Milk", "Soy Milk", "Almond Milk"};
    private final ArrayList<String> milk_list = new ArrayList(Arrays.asList(milks));
    
    private final String[] paymtds = {"Visa/Master", "AMEX", "UnionPay", "Apple Pay", "Google Pay", "LINE Pay", "Pay at Store"};
    private final ArrayList<String> paymtd_list = new ArrayList(Arrays.asList(paymtds));

    @FXML
    private ComboBox<String> sizeBox;
    @FXML
    private ComboBox<String> milkBox;
    @FXML
    private ComboBox<String> paymtdBox;
    @FXML
    private RadioButton hot;
    @FXML
    private RadioButton cold;
    @FXML
    private ToggleGroup tptGroup;
    @FXML
    private CheckBox creamCheck;
    @FXML
    private CheckBox decafCheck;
    @FXML
    private TextField nameField;
    @FXML
    private TextField noField;
    @FXML
    private TextArea displayInfo;
    @FXML
    private TextArea displayCart;
    @FXML
    private TextArea displayDetail;
    @FXML
    private Button cof0add;
    @FXML
    private Button cof1add;
    @FXML
    private Button cof2add;
    @FXML
    private Button cof3add;
    @FXML
    private Button oth0add;
    @FXML
    private Button oth0remove;
    @FXML
    private Button oth1add;
    @FXML
    private Button oth1remove;
    @FXML
    private Button oth2add;
    @FXML
    private Button oth2remove;
    @FXML
    private Button confirmBtn;
    @FXML
    private Button clearBtn;
    @FXML
    private Button payBtn;
    
    private Cafe order;

    String[] othList = {"Strawberry Smoothie", "Sandwiches", "Carrot Cake"};
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        
        sizeBox.setValue("Small");
        sizeBox.getItems().addAll(size_list);
        sizeBox.setStyle("-fx-font: 14px \"Copperplate\"; -fx-background-color: beige; -fx-border-color: saddlebrown; -fx-border-width: 2;");
        
        milkBox.setValue("Default");
        milkBox.getItems().addAll(milk_list);
        milkBox.setStyle("-fx-font: 14px \"Copperplate\"; -fx-background-color: beige; -fx-border-color: saddlebrown; -fx-border-width: 2;");
        
        paymtdBox.setValue("Visa/Master");
        paymtdBox.getItems().addAll(paymtd_list);
        paymtdBox.setStyle("-fx-font: 13px \"Copperplate\"; -fx-background-color: beige; -fx-border-color: saddlebrown; -fx-border-width: 2;");

        order = new Cafe();
        
    }    

    @FXML
    private void addCoffee(ActionEvent event)
    {
        
        int size;
        int milk;
        boolean temputure = false;
        boolean cream = false;
        boolean decaf = false;
        int type = 0;

        String sizeChoice = sizeBox.getValue();
        
        if("Medium +$20".equals(sizeChoice))
        {
            size = 1;
        }
        
        else if("Large +$30".equals(sizeChoice))
        {
            size = 2;
        }
        
        else
        {
            size = 0;
        }
 
        if(cold.isSelected())
        {
            temputure = true;
        }
        
        String milkChoice = milkBox.getValue();
        
        if("Low-Fat Milk".equals(milkChoice))
        {
            milk = 1;
        }
        
        else if("Skim Milk".equals(milkChoice))
        {
            milk = 2;
        }
        
        else if("Soy Milk".equals(milkChoice))
        {
            milk = 3;
        }
        
        else if("Almond Milk".equals(milkChoice))
        {
            milk = 4;
        }
        
        else
        {
            milk = 0;
        }
        
        if(creamCheck.isSelected())
        {
            cream = true;
        }
        
        if(decafCheck.isSelected())
        {
            decaf = true;
        }
        
        Button btn = (Button)event.getSource();
        
        switch(btn.getId())
        {
            
            case "cof0add":
                type = 0;
                break;
                
            case "cof1add":
                type = 1;
                break;
                
            case "cof2add":
                type = 2;
                break;
                
            case "cof3add":
                type = 3;
                break;
                
        }
        
        if(type == 0 && milk != 0)
        {
            
            displayDetail.appendText("Error!\nPlease select other avaliable choice.\n");
            displayDetail.appendText("––––––––––––––––––––––––––––––––––––––––––––\n");
            
        }
        else
        {
            
            displayDetail.appendText(order.coffeeInfo(size, milk, temputure, cream, decaf, type));
            displayDetail.appendText("––––––––––––––––––––––––––––––––––––––––––––\n");

            refreshCart();
            
        }

    }
    
    @FXML
    private void addOne(ActionEvent event)
    {
        
        Button btn = (Button)event.getSource();
        
        int type = 0;
        
        switch(btn.getId())
        {
            
            case "oth0add":
                type = 0;
                break;
                
            case "oth1add":
                type = 1;
                break;
                
            case "oth2add":
                type = 2;
                break;
                
        }
        
        order.othInfoAdd(type);
        
        refreshCart();
        
    }

    @FXML
    private void removeOne(ActionEvent event)
    {
        
        Button btn = (Button)event.getSource();
        
        int type = 0;
        
        switch(btn.getId())
        {
            
            case "oth0remove":
                type = 0;
                break;
                
            case "oth1remove":
                type = 1;
                break;
                
            case "oth2remove":
                type = 2;
                break;
                
        }
        
        order.othInfoRemove(type);
        
        refreshCart();
        
    }

    @FXML
    private void confirm(ActionEvent event)
    {
        
        String name = nameField.getText();
        String telNo = noField.getText();
        String payment = paymtdBox.getValue();

        if(order.getTotal() > 1)
        {
            
            if(nameField.getText().trim().equals("") || noField.getText().trim().equals(""))
            {
                
                displayInfo.setText("Error!\nPlease enter your name\nor telephone number.");
                
            }
            
            else
            {
                
                String message = String.format("Name:\n%s\nTelephone. No.:\n%s\nPayment Method:\n%s\n", name, telNo, payment);
                displayInfo.setText(message);

                displayInfo.appendText(order.showTotal());
                
            }
            
        }
        
        else
        {
            
            displayInfo.setText("Error!\nNo products in the cart.");
            
        }

    }

    @FXML
    private void clear(ActionEvent event)
    {
        
        order.reset();
        
        displayDetail.setText("");
        displayCart.setText("");
        displayInfo.setText("");
        nameField.setText("");
        noField.setText("");
        
    }
    
    private void refreshCart()
    {
        
        boolean othExist = false;
        
        displayCart.setText(order.showCofCart());
            
        for(int i = 0; i < othList.length; i++)
        {

            if(order.getOthQty(i) != 0)
            {
                othExist = true;
                displayCart.appendText(order.showOthCart(i));
                
            }

        }
        
        if(othExist)
        {
            displayCart.appendText(order.showOthTotal());
            displayCart.appendText("–––––––––––––––––––––––––\n");
        }
        
        displayCart.appendText(order.showTotal());

        displayInfo.setText("");
            
    }
    
}
