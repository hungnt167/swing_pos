/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eproject.swpos.models;

import edu.eproject.swpos.services.Where;
import java.util.List;

/**
 *
 * @author Nguyen
 */
public interface Model {

    public int getId();
    public Model getCollection();
    public Model load(int id);
    public Model load(String id);
    public Model where(Where where);
    public Model orWhere(Where where);
    public Object getData(String lookingForValue) throws Exception;
}
