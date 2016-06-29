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
public class ProductTax extends Model_Abstract {

    public String class_name;
    public boolean is_percent;
    public float amount;
    public  List<ProductTax> cache;

    protected String table = "retail_product_tax_class";
    protected String defaultAttributesToSelect = "id,class_name,is_percent,amount";

    public ProductTax() {
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
        return ProductTax.class; //To change body of generated methods, choose Tools | Templates.
    }

    public List getCache() {
        return cache;
    }
    
}
