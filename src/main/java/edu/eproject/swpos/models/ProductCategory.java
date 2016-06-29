/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eproject.swpos.models;

import edu.eproject.swpos.services.Where;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nguyen
 */
public class ProductCategory extends Model_Abstract {

    public int product_id;
    public int category_id;

    protected String table = "retail_product_category";
    protected String defaultAttributesToSelect = "id,product_id,category_id";
    public List<ProductCategory> cache;

    public ProductCategory() {
    }

     public Product getProduct() {
        return (Product) new Product().load(this.product_id);
    }
     
     public Category getCategory() {
        return  (Category) new Category().load(this.category_id);
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
        return ProductCategory.class; //To change body of generated methods, choose Tools | Templates.
    }
}
