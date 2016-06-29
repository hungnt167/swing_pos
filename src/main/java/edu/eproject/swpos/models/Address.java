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
public class Address extends Model_Abstract {

    public int customer_id;
    public String city;
    public String street;
    public String postcode;
    public String telephone;
    public int country_id;
    public int region_id;
    public  List<Address> cache;

    protected String table = "retail_customer_addresses";
    protected String defaultAttributesToSelect = "id,customer_id,street,city, postcode,telephone";

    public Address() {
    }

    public String getCountry(){
        try {
            return (String) new Country().load(this.country_id).getData("name");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public String getRegion(){
        try {
            return (String) new Region().load(this.region_id).getData("name");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
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
        return Address.class; //To change body of generated methods, choose Tools | Templates.
    }

    public List getCache() {
        return cache;
    }
    
}
