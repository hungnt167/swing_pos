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
public class Category extends Model_Abstract {

    public int parent_id;
    public int depth;
    public String name;

    protected String table = "retail_categories";
    protected String defaultAttributesToSelect = "id,parent_id,depth,name";

    public Category() {
    }

     public List<ProductCategory> getProductCategory() {
        return new ProductCategory().getCollection().where(new Where("category_id", this.id, "=")).load();
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
        return Category.class; //To change body of generated methods, choose Tools | Templates.
    }
}
