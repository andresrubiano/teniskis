/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenniskiss.dao;

import com.tenniskiss.conexion.Conexion;
import com.tenniskiss.modelo.Rol;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author jhon
 */
@ManagedBean
public class DaoRol extends Rol{
    
    public void login(){
        Conexion conexion=new Conexion();
        String sql="select rol from rol where documento='"+getDocumento()+"' and clave=md5('"+getClave()+"')";
      
        ResultSet r=conexion.consultar(sql);
        
        try {
            if (r.next()) {
                
               FacesContext.getCurrentInstance().getExternalContext().redirect("administrador.xhtml"); 
            }else{
                //mensaje(FacesMessage.SEVERITY_ERROR, "Error", "Usuario o contraseña erroneos");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario o contraseña erroneos"));
            }
        } catch (SQLException ex) {
            
            Logger.getLogger(DaoRol.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
           
            Logger.getLogger(DaoRol.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conexion.cerrarConexion();
    }
    
     public void mensaje(FacesMessage.Severity x, String tituloMsj, String msj) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(x, tituloMsj, msj));
    }
}
