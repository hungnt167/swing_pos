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
public class OrderItem extends Model_Abstract {

    public int order_id;
    public int parent_id;
    public int product_id;
    public int parent_product_id;
    public int quantity;
    public String type;
    public String name;
    public String sku;
    public String image;
    public float price;
    public float custom_price;
    public float subtotal;
    public float item_discount_amount;
    public float whole_order_discount_amount;
    public float tax;
    public float tax_amount;
    public float quantity_refunded;
    public float tax_refunded;
    public float discount_refunded;

    protected String table = "retail_order_items";
    protected String defaultAttributesToSelect = "id,parent_id,,order_id,name,price,"
            + "product_id, parent_product_id, quantity, quantity_refunded, type,"
            + "sku,image,custom_price,subtotal,item_discount_amount,"
            + "whole_order_discount_amount, tax, tax_refunded,discount_refunded";

    public OrderItem() {
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
        return OrderItem.class; //To change body of generated methods, choose Tools | Templates.
    }
}
