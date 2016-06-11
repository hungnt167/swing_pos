/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.models;

import pos.Evn;
import static org.jooq.impl.DSL.*;
import org.jooq.*;
import org.jooq.impl.*;
/**
 *
 * @author hungnt
 */
public abstract class Model {
    protected String table;
    protected DSLContext query = null;

    public Model() {
    }
    protected DSLContext query(){
        if(this.query == null){
            return DSL.using(Evn.getInstance(), SQLDialect.MYSQL);
        }
        return this.query;
    }
    protected Result<Record> getCollection(){
        return this.query().fetch(this.table);
    }
    
}
