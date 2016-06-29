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
public class Product extends Model_Abstract {

    public int tax_class_is;
    public String name;
    public String sku;
    public String type_id;
    public String image;
    public String media_allery_entries;
    public double price;
    public boolean visibility;
    public int status;
    public  List<Product> cache;

    protected String table = "retail_products";
    protected String defaultAttributesToSelect = "id,name,sku,type_id, image,price,tax_class_is,visibility,status";

    public Product() {
    }

    public float getTaxRate(){
        try {
            return (float) new Country().load(this.tax_class_is).getData("amount");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0f;
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
        return Product.class; //To change body of generated methods, choose Tools | Templates.
    }

    public List getCache() {
        return cache;
    }
    
}
