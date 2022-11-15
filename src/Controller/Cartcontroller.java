package Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Database.Cartdbcontroller;
import Database.Customerdbcontroller;
import Database.Itemdbcontroller;
import Models.Cart;
import Models.Customer;
import Models.Items;


public class Cartcontroller {
    Scanner scanner=new Scanner(System.in);
    Customerdbcontroller customerdbcontroller=new Customerdbcontroller();
    Cartdbcontroller cartdbcontroller=new Cartdbcontroller();
    Itemdbcontroller itemdbcontroller=new Itemdbcontroller();
    Ordercontroller ordercontroller=new Ordercontroller();
    public void addproducttocart(Customer customer,HashMap<Items, Integer> itemsandquantity){
        int cartid;
        try {
            Cart cart = new Cart();
            double total=0;
            int oldquantity=0;
            cart.setCustomer(customer);
            for(Map.Entry <Items, Integer> entry: itemsandquantity.entrySet()) {
                oldquantity=cartdbcontroller.checkisitalreadyexit(customer,entry.getKey());
                if(oldquantity==0){
                    continue;
                }
                else{
                    cartdbcontroller.deletecartbyitemname(customer,entry.getKey());
                    itemsandquantity.put(entry.getKey(), (oldquantity+entry.getValue()));
                }
            }
            cart.setCart_items(itemsandquantity);
            for(Map.Entry <Items, Integer> entry: itemsandquantity.entrySet()) {

                total=total+(entry.getKey().getPrice()*entry.getValue());
            }
            cart.setCartProductTotal(total);

            cartid = cartdbcontroller.addproducttocartdb(cart);
            if (cartid == 1) {
               System.out.println();
               System.out.println("Items are added to your cart successfully!!!");
               Thread.sleep(1000);
            }
            else{
                System.out.println("Items addition to Cart Failed!!!1");
            }
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
    }
    public void deletecart(Cart cart) throws Exception {
        cartdbcontroller.deletecart(cart);
    }

    public Cart viewCart(Customer customer) throws Exception {
        return cartdbcontroller.viewCart(customer);
    }

    public boolean checkcart(Customer customer) {
        return cartdbcontroller.checkcart(customer);
    }

    }