/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eproject.swpos.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nguyen
 */
public class Country extends Model_Abstract {

    public String name;

    protected String table = "retail_countries";
    protected String defaultAttributesToSelect = "id,name";
    public List<Country> cache;

    public Country() {
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
        return Country.class; //To change body of generated methods, choose Tools | Templates.
    }
}
