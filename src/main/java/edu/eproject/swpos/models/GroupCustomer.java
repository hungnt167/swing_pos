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
public class GroupCustomer extends Model_Abstract {

    public String customer_group_code;
    public  List<GroupCustomer> cache;

    protected String table = "retail_customer_groups";
    protected String defaultAttributesToSelect = "id,customer_group_code";

    public GroupCustomer() {
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
        return GroupCustomer.class; //To change body of generated methods, choose Tools | Templates.
    }

    public List getCache() {
        return cache;
    }
    
}
