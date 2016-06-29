/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eproject.swpos.app;

import edu.eproject.swpos.models.Address;
import edu.eproject.swpos.models.Customer;
import edu.eproject.swpos.models.Order;
import edu.eproject.swpos.services.Where;
import java.util.List;

/**
 *
 * @author Nguyen
 */
public class App {

    public static void main(String[] args) throws Exception {
        Customer customer = new Customer();
        String[] get = {"email", "telephone", "default_billing"};
        System.out.println("count:" +customer.count());
        List<Customer> list = customer.getCollection()
                .get(get)
                .limit(5)
                .offset(0)
                .where(new Where("id", 28, "="))
                .load();
        for (Customer customerRecord : list) {
            System.out.println(customerRecord.getId() + ": " + customerRecord.getFullName());
            System.out.println("email : " + customerRecord.getData("email"));
//            Address address = customerRecord.getDefaultBillingAddress();
//            System.out.println("street: "+ address.getData("street"));
        }
        String[] strings = {"total_paid"};
        List<Order> orders = new Order().getCollection().get(strings).limit(1).load();
        
        for (Order order : orders) {
            System.out.println("order id: "+order.id);
            System.out.println("customer: "+order.getCustomerName());
            System.out.println("shipment: "+order.getShipment().getData("name"));
            System.out.println("payment: "+order.getOrderPayment().getPayment().getData("display_name"));
            System.out.println("GT: "+order.grand_total);
            System.out.println("TP: "+order.total_paid);
        }
    }
}
