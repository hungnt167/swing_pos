/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eproject.swpos.services;

/**
 *
 * @author Nguyen
 */
public class Where {

    public String name;
    public String value;
    public String operator;

    public Where(String name, String value, String operator) {
        this.name = name;
        this.value = value;
        this.operator = operator;
    }
    
    public Where(String name, int value, String operator) {
        this.name = name;
        this.value = value+"";
        this.operator = operator;
    }
}
