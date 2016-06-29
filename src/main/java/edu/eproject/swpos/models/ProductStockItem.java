/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eproject.swpos.models;

import java.util.List;

/**
 *
 * @author Nguyen
 */
public class ProductStockItem extends Model_Abstract {

    public int product_id;
    public boolean is_in_stock;
    public int qty;
    public  List<ProductStockItem> cache;

    protected String table = "retail_product_stock_items";
    protected String defaultAttributesToSelect = "id,product_id,is_in_stock,qty";

    public ProductStockItem() {
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
        return ProductStockItem.class; //To change body of generated methods, choose Tools | Templates.
    }

    public List getCache() {
        return cache;
    }
    
}
