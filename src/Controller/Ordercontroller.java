package Controller;
import java.sql.SQLException;
import java.util.List;
import Database.Orderdbcontroller;
import Database.Ordered_itemsdbcontroller;
import Models.Cart;
import Models.Customer;
import Models.Employee;
import Models.Order;
import Models.Order.OrderStatus;
import Models.Order.PaymentStatus;

public class Ordercontroller {
    Ordered_itemsdbcontroller ordered_itemsdbcontroller=new Ordered_itemsdbcontroller();
    Orderdbcontroller orderdbcontroller=new Orderdbcontroller();
    public void addorder(Cart cart) throws Exception{
        Order order =new Order();
        try{
        order.setCustomer(cart.getCustomer());
        order.setOrdered_items(cart.getCart_items());
        order.setPaymentStatus(PaymentStatus.UNPAID);
        order.setStatus(OrderStatus.PLACED);
        order.setTotal_amount(cart.getCartProductTotal());
        orderdbcontroller.createorder(order);
        String generated_id=orderdbcontroller.lastinsertedid();
        order.setId(generated_id);
        ordered_itemsdbcontroller.createordereditems(order);
       
    }
    catch(Exception e){
        System.out.println(e.getMessage());
    }

    }
public Order viewordereditemsbyorderid(String id) throws ClassNotFoundException, SQLException {
    return ordered_itemsdbcontroller.viewordereditemsbyorderid(id);
}
public List<Order> viewpendingorderslist(Customer customer) {
    return orderdbcontroller.viewpendingorderslist();
}
public Order vieworderbyid(int choice) {
    return orderdbcontroller.vieworderbyid(choice);
}
public List<Order> viewordersfordeliveryList(Customer customer) {
    return orderdbcontroller.viewordersfordeliveryList(customer);
}
public List<Order> viewcompleteddeliveryList(Customer customer) {
    return orderdbcontroller.viewcompleteddeliveryList(customer);
}
public void changepaymentstatus(Order order) throws Exception {
    orderdbcontroller.changepaymentstatus(order);
}
public void changeorderstatus(Order order) throws Exception {
    orderdbcontroller.changeorderstatus(order);
}
public List<Order> viewordersfordeliveryList(Employee employee){
    return orderdbcontroller.viewordersfordeliveryList(employee);
}
public List<Order> viewpendingorderslist(){
    return orderdbcontroller.viewpendingorderslist();
}
public List<Order> viewprocessedorderslist(Customer customerin){
    return orderdbcontroller.viewprocessedorderslist(customerin);
}
public List<Order> viewprocessedorderslist(){
    return orderdbcontroller.viewprocessedorderslist();
}
public List<Order> viewpackedorderslist(Customer customerin){
    return orderdbcontroller.viewpackedorderslist(customerin);
}
public List<Order> viewpackedorderslist(){
    return orderdbcontroller.viewpackedorderslist();
}
public void setprovider(Order order) throws Exception{
     orderdbcontroller.setprovider(order);
}
}

