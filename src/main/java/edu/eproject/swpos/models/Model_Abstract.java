/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eproject.swpos.models;

import edu.eproject.swpos.config.Evn;
import edu.eproject.swpos.services.Storage;
import edu.eproject.swpos.services.Where;
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.sql2o.Connection;
import org.sql2o.Query;

/**
 *
 * @author Nguyen
 */
public class Model_Abstract implements Model {

    protected String table;
    public int id;
    public String created_at;
    public String updated_at;

    protected String defaultAttributesToSelect;
    protected static Model model;
    protected static List<Model> cache;
    protected static String selectPhare = "";
    protected static String joinPhare = "";
    protected static String wherePhare = "";
    protected static String fromPhare = "";
    protected static String limitPhare = "";
    protected static String offsetPhare = "";
    protected static String sortPhare = "";
    protected static String sql;
    protected static Query query;

    public static Storage storage = new Storage();

    public static Storage getStorage() {
        if (storage == null) {
            return new Storage();
        }
        return storage;
    }

    public String getDefaultAttributesToSelect() {
        return defaultAttributesToSelect;
    }

    @Override
    public Model load(int id) {
        return (Model) this.getCollection().where(new Where("id", id, "=")).limit(1).load().get(0);
    }

    @Override
    public Model load(String id) {
        return (Model) this.getCollection().where(new Where("id", id, "=")).limit(1).load().get(0);
    }

    protected Class getModel() {
        return Model.class;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public Connection getConnection() {
        return Evn.getInstance().open();
    }

    @Override
    public Model_Abstract getCollection() {
        this.selectPhare = this.getDefaultAttributesToSelect();
        return this;
    }

    public Model_Abstract get(String[] fields) {
        for (String fieldName : fields) {
            this.selectPhare += "," + fieldName;
        }
        return this;
    }

    public Model_Abstract where(Where where) {
        this.wherePhare += " AND ";
        this.wherePhare += where.name;
        this.wherePhare += " ";
        this.wherePhare += where.operator;
        this.wherePhare += " ";
        this.wherePhare += where.value;
        return this;
    }

    public Model_Abstract orWhere(Where where) {
        this.wherePhare += " OR ";
        this.wherePhare += where.name;
        this.wherePhare += " ";
        this.wherePhare += where.operator;
        this.wherePhare += " ";
        this.wherePhare += where.value;
        return this;
    }

    public Model_Abstract limit(int limit) {
        String size = new Integer(limit).toString();
        this.limitPhare = " LIMIT " + size + " ";
        return this;
    }

    public Model_Abstract offset(int offset) {
        String from = new Integer(offset).toString();
        this.offsetPhare = " OFFSET " + from + " ";
        return this;
    }

    public Model_Abstract sort(String fieldName, String type) {
        this.sortPhare = " ORDERBY " + fieldName + " " + type + " ";
        return this;
    }

    public Model_Abstract join(String table, String foregnKey, String localKey, String type) {
        this.joinPhare = " " + type + " JOIN " + table
                + " ON(" + this.getTable() + "." + localKey + " = " + table + "." + foregnKey + ") ";
        return this;
    }

    public Integer count() {
        String sql = "SELECT count(id) FROM " + this.getTable();
        try (Connection connection = this.getConnection()) {
            return connection.createQuery(sql).executeScalar(Integer.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List load() {
        if (this.getCache() != null) {
            return this.cache;
        }
        try (Connection connection = this.getConnection()) {
            this.sql = "SELECT " + this.selectPhare;
            this.sql += " FROM " + this.getTable() + " WHERE 1 ";
            this.sql += this.joinPhare;
            this.sql += this.wherePhare;
            this.sql += this.limitPhare;
            this.sql += this.offsetPhare;
            this.sql += this.sortPhare;
            System.out.println(this.sql);
            this.query = connection.createQuery(this.sql);
            this.cache = query.executeAndFetch(this.getModel());
//            this.getStorage().add(this.getModel().getSimpleName(), cache);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.cache;
    }

    public List getMysqlCollection() {
        List<Model> collection = new ArrayList<Model>();
        PreparedStatement stmt = null;

        String sql
                = "SELECT * "
                + "FROM " + this.getTable();
//    "WHERE category = ?";
        System.out.println(this.getTable());
        java.sql.Connection connection = Evn.getMysqlInstance();
        try {
            stmt = connection.prepareStatement(sql);
//            stmt.setString(1, "foo");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("sdfdsf");
            }
            rs.close();
            return collection;
        } catch (SQLException se) {
            se.printStackTrace();
            //Handle errors for JDBC. I'll just throw a RuntimeException.
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public int getId() {
        return this.id;
    }

    /**
     *
     * @param lookingForValue
     * @return
     * @throws Exception
     */
    @Override
    public Object getData(String lookingForValue)
            throws Exception {
        Field field = this.getClass().getField(lookingForValue);
        Class clazzType = field.getType();
        if (clazzType.toString().equals("double")) {
            return field.getDouble(this);
        } else if (clazzType.toString().equals("int")) {
            return field.getInt(this);
        }
        return field.get(this);
    }

    public List getCache() {
        return cache;
    }

    public Model_Abstract() {
        table = "";
        id = 0;
        created_at = "";
        updated_at = "";
        defaultAttributesToSelect = "";
        model = null;
        cache = null;
        selectPhare = "";
        joinPhare = "";
        wherePhare = "";
        fromPhare = "";
        limitPhare = "";
        offsetPhare = "";
        sortPhare = "";
        sql = "";
        query = null;
    }
}
