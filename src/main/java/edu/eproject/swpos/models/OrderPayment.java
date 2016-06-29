/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eproject.swpos.models;

import java.util.ArrayList;

/**
 *
 * @author Nguyen
 */
public class OrderPayment extends Model_Abstract {

    public int order_id;
    public int payment_method_id;
    public float amount;
    public String type;

    protected String table = "retail_order_payments";
    protected String defaultAttributesToSelect = "id,order_id,payment_method_id,amount,type";

    public OrderPayment() {
    }

     public Payment getPayment(){
        try {
            return (Payment) new Payment().load(this.payment_method_id);
        } catch (Exception ex) {
            ex.printStackTrace();
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
        return OrderPayment.class; //To change body of generated methods, choose Tools | Templates.
    }
}
