/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eproject.swpos.models;

import edu.eproject.swpos.services.Where;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Nguyen
 */
public class Customer extends Model_Abstract {

    public int group_id;
    public String first_name;
    public String last_name;
    public String email;
    public String telephone;
    public int gender;
    public int default_billing;
    public int default_shipping;

    public List<Customer> cache;

    protected String table = "retail_customers";
    protected String defaultAttributesToSelect = "id,first_name,last_name";

    public Customer() {
    }

    public String getFullName() {
        return this.first_name + " " + this.last_name;
    }

    public List<Address> getAddresses() {
        return new Address().getCollection().where(new Where("customer_id", this.id, "=")).load();
    }

    public Address getDefaultBillingAddress() {
        try {
            return (Address) new Address().getCollection()
                    .where(new Where("customer_id", this.id, "="))
                    .where(new Where("id", this.default_billing, "="))
                    .limit(1).load()
                    .get(0);
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }

    public Address getDefaultShippingAddress() {
        return (Address) new Address().getCollection()
                .where(new Where("customer_id", this.id, "="))
                .where(new Where("id", this.default_shipping, "="))
                .load().get(0);
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
        return Customer.class; //To change body of generated methods, choose Tools | Templates.
    }

    public List getCache() {
        return cache;
    }

}
