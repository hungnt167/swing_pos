/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eproject.swpos.models;

import edu.eproject.swpos.services.Where;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen
 */
public class Order extends Model_Abstract {

    public boolean is_shipped;
    public boolean has_shipment;
    public boolean is_cancelled;
    public String customer_last_name;
    public String customer_first_name;
    public String customer_email;
    public String shipping_address;
    public String billing_address;
    public int customer_id;
    public int user_id;
    public float subtotal;
    public float item_discount_amount;
    public float whole_order_discount_amount;
    public float tax_amount;
    public float refunded_amount;
    public float grand_total;
    public float total_paid;
    public float total_due;
    public float total_change;
    public int shipping_method_id;
    public float shipping_amount;
    public int item_count;
    public String note;

    protected String table = "retail_orders";
    protected String defaultAttributesToSelect = "id,is_shipped,has_shipment,"
            + "shipping_method_id,is_cancelled,"
            + "customer_last_name,customer_first_name,item_count,grand_total,user_id, customer_id";

    public Order() {
    }

    public List<OrderItem> getItems() {
        return new OrderItem().getCollection().where(new Where("order_id", this.id, "=")).load();
    }

    public String getCustomerName() {
        return this.customer_first_name + " " + this.customer_last_name;
    }
    
    public Shipping getShipment() {
        try {
            return  (Shipping) new Shipping().load(this.shipping_method_id);
        } catch (Exception ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public OrderPayment getOrderPayment() {
        try {
            return (OrderPayment) new OrderPayment().getCollection().where(new Where("order_id", this.id, "=")).load().get(0);
        } catch (Exception ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getDefaultAttributesToSelect() {
        return this.defaultAttributesToSelect; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTable() {
        return this.table; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Class getModel() {
        return Order.class; //To change body of generated methods, choose Tools | Templates.
    }
}
