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
public class Region extends Model_Abstract {

    public int country_id;
    public String code;
    public String name;

    protected String table = "retail_regions";
    protected String defaultAttributesToSelect = "id,country_id,code,name";

    public Region() {
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
        return Region.class; //To change body of generated methods, choose Tools | Templates.
    }
}
