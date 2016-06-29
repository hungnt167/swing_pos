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
public class Shipping extends Model_Abstract {

    public boolean is_enabled;
    public String code;
    public String name;
    public float price;

    protected String table = "retail_shippings";
    protected String defaultAttributesToSelect = "id,is_enabled,code,name,price";

    public Shipping() {
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
        return Shipping.class; //To change body of generated methods, choose Tools | Templates.
    }
}
