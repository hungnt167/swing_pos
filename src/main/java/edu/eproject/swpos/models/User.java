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
public class User extends Model_Abstract {

    public String email;
    public String first_name;
    public String last_name;
    public String salt;
    public String password;
    public String image;
    public boolean is_active;
    public boolean is_super_admin;

    protected String table = "retail_users";
    protected String defaultAttributesToSelect = "id,email,first_name,last_name,email";

    public User() {
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
        return User.class; //To change body of generated methods, choose Tools | Templates.
    }
}
