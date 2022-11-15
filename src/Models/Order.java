package Models;

import java.util.HashMap;

public class Order {
    public enum OrderStatus{
        PLACED,PROCESSED,PACKED,SHIPPED,DELIVERED
    }
   public enum PaymentStatus{
        PAID,UNPAID,CREDIT
      }
    private Customer customer;
    private String id;
    private OrderStatus status;
    private PaymentStatus paymentStatus;
    private double total_amount;
    private Employee provider;
    private HashMap<Items,Integer> ordered_items=new HashMap<Items,Integer>();
    public Order(String id, OrderStatus status, double total_amount, HashMap<Items, Integer> ordered_items,Customer customer,PaymentStatus paymentStatus) {
        this.id = id;
        this.status = status;
        this.total_amount = total_amount;
        this.ordered_items = ordered_items;
        this.customer=customer;
        this.paymentStatus=paymentStatus;
    }
    public Order() {
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public OrderStatus getStatus() {
        return status;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    public HashMap<Items, Integer> getOrdered_items() {
        return ordered_items;
    }
    public void setOrdered_items(HashMap<Items, Integer> ordered_items) {
        this.ordered_items = ordered_items;
    }
    public double getTotal_amount() {
        return total_amount;
    }
    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    public Employee getProvider() {
        return provider;
    }
    public void setProvider(Employee provider) {
        this.provider = provider;
    }


}
