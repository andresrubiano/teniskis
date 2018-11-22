package com.tenniskiss.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private Connection conexion;
    private Statement statement;

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tenniskiss", "root", "");
            this.statement = this.conexion.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public void cerrarConexion(){
        try {
            this.getStatement().close();
            this.getConexion().close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    public boolean CUD(String sql){
        boolean b=false;
        try {
          this.getStatement().execute(sql);
          b=false;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            b=true;
        }
        return b;
    }
    public ResultSet consultar(String sql) {
        ResultSet r = null;
        try {
            r = this.getStatement().executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

}
