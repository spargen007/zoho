package View;

import java.util.Map;
import java.util.Scanner;

import Controller.Cartcontroller;
import Controller.Customercontroller;
import Controller.Itemcontroller;
import Controller.Ordercontroller;
import Models.Cart;
import Models.Customer;
import Models.Items;

public class Cartview {
    Scanner scanner =new Scanner(System.in);
    Cartcontroller cartcontroller=new Cartcontroller();
    Customercontroller customercontroller=new Customercontroller();
    Itemcontroller itemcontroller=new Itemcontroller();
    Ordercontroller ordercontroller=new Ordercontroller();
    public void viewCart(Customer customer) {
        if (customer.isCustomerloginSession()) {
            try {
                if(cartcontroller.checkcart(customer)){
                Cart cart = cartcontroller.viewCart(customer);
                cart.setCustomer(customercontroller.searchCustomerbycustomerid(customer.getId()));
                if (cart.getCartProductTotal()!= 0) {
                    Items product;
                    int quantity;
                    int cartChoice;
                    System.out.println("");
                    System.out.println("+---------------------------------------------+");
                    System.out.println("|           My Cart: "+cart.getCartId());
                    System.out.println("+---------------------------------------------+");
                    System.out.println("It's a good day to buy the items you saved for later!");
                    Thread.sleep(2000);
                    System.out.println("|  #  Product Name  | Price | Quantitiy  | Amount");
                    for(Map.Entry <Items, Integer> entry: cart.getCart_items().entrySet()) {
                        product=itemcontroller.viewitemsbyname(entry.getKey().getName());
                        quantity=entry.getValue();
                        System.out.println("|  " +product.getId()+ "  " + product.getName()+"          | "+product.getPrice()+"  |    "+quantity+"      | "+product.getPrice()*quantity);
                        Thread.sleep(2000);
                        System.out.println();
                    }
                    System.out.println("Loading.........");
                    System.out.println();
                    Thread.sleep(4000);
                    System.out.println("+------------------------------+");
                    System.out.println("| 1. Confirm order.     |");
                    System.out.println("| 2. Delete Cart.      |");
                    System.out.println("| 3. Back to Dashboard <------ |");
                    System.out.println("+------------------------------+");
                    System.out.print("| Enter Choice:");
                    cartChoice = Integer.parseInt(scanner.nextLine());
                    switch (cartChoice) {
                        case 1:
                        ordercontroller.addorder(cart);
                        Thread.sleep(3000);
                        System.out.println("+------------------------------+");
                        System.out.println("Order Placed Sucessfully...");
                        System.out.println("+------------------------------+");
                        Thread.sleep(2000);
                        cartcontroller.deletecart(cart);
                        break;

                        case 2:
                        cartcontroller.deletecart(cart);
                        break;
                        case 3:
                        break;
                        default:
                            break;
                    }
                }
                 else {
                    Thread.sleep(500);
                    System.out.println("+---------------------------------------------------+");
                    System.out.println("Your cart is empty!");
                    System.out.println("+---------------------------------------------------+");
                    Thread.sleep(1000);
                }
            }
            else{
                System.out.println("+---------------------------------------------------+");
                System.out.println("Your cart is empty!");
                System.out.println("It's a good day to buy the items so quickly fill it!!!!");
                System.out.println("+---------------------------------------------------+");
                Thread.sleep(4000);
            }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
