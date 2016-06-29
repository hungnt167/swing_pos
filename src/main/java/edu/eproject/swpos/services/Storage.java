/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eproject.swpos.services;

import edu.eproject.swpos.models.Address;
import edu.eproject.swpos.models.Country;
import edu.eproject.swpos.models.Customer;
import edu.eproject.swpos.models.Order;
import edu.eproject.swpos.models.Region;
import edu.eproject.swpos.models.Shipping;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen
 */
public class Storage {

    public static List<Order> orderStorage;
    public static List<Shipping> shippingStorage;
    public static List<Customer> customerStorage;
    public static List<Address> addressStorage;
    public static List<Country> countryStorage;
    public static List<Region> regionStorage;

    public void add(String modelName, List list) {
        try {
            this.get(modelName).addAll(list);
        } catch (Exception ex) {
            Logger.getLogger(Storage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public static List<Customer> getCustomerStorage() {
        return customerStorage;
    }

    public static List<Address> getAddressStorage() {
        return addressStorage;
    }

    public static List<Country> getCountryStorage() {
        return countryStorage;
    }

    public static List<Region> getRegionStorage() {
        return regionStorage;
    }

    public static List<Order> getOrderStorage() {
        return orderStorage;
    }

    public static List<Shipping> getShippingStorage() {
        return shippingStorage;
    }
    
    
    public List get(String modelName)
            throws Exception {
        Field field = this.getClass().getField(modelName.toLowerCase()+"Storage");
        Class clazzType = field.getType();
        return (List) field.get(this);
    }

    public Storage() {
        orderStorage = new ArrayList<Order>();
        shippingStorage = new ArrayList<Shipping>();
        customerStorage = new ArrayList<Customer>();
        addressStorage = new ArrayList<Address>();
        countryStorage = new ArrayList<Country>();
        regionStorage = new ArrayList<Region>();
    }
    
    
}
