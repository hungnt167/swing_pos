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
public class Payment extends Model_Abstract {

    public boolean is_active;
    public boolean is_cash;
    public String code;
    public String display_name;

    protected String table = "retail_payments";
    protected String defaultAttributesToSelect = "id,is_active,is_cash,code,display_name";

    public Payment() {
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
        return Payment.class; //To change body of generated methods, choose Tools | Templates.
    }
}
