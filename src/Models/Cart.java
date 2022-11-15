package Models;

import java.util.HashMap;

public class Cart {
        private int cartId;
        private Customer customer;
        private Items item;
        private double cartProductTotal;
        private HashMap<Items,Integer>cart_items=new HashMap<Items,Integer>();
        public int getCartId() {
            return cartId;
        }
        public void setCartId(int cartId) {
            this.cartId = cartId;
        }
        public Customer getCustomer() {
            return customer;
        }
        public void setCustomer(Customer customer) {
            this.customer = customer;
        }
        public double getCartProductTotal() {
            return cartProductTotal;
        }
        public void setCartProductTotal(double cartProductTotal) {
            this.cartProductTotal = cartProductTotal;
        }
        public HashMap<Items, Integer> getCart_items() {
            return cart_items;
        }
        public void setCart_items(HashMap<Items, Integer> cart_items) {
            this.cart_items = cart_items;
        }
        public Items getItem() {
            return item;
        }
        public void setItem(Items item) {
            this.item = item;
        }
}
