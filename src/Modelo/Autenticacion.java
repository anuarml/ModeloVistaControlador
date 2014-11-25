/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;



/**
 *
 * @author lalo
 */
public class Autenticacion {
    //se crea un SecurityManager por default
    DefaultSecurityManager securityManager; 
     
    Subject currentUser; 
    
    /**
     * Constructor que crea un SecurityManager por default
     * y carga un archivo shiro.ini donde se almacenan los usuarios
     */
    public Autenticacion() {
        securityManager = new DefaultSecurityManager();
        //Realm es la configuracion que shiro reconoce, IniRealm es la configuracion
        //del archivo shiro.ini
        securityManager.setRealm(new IniRealm("shiro.ini"));
        SecurityUtils.setSecurityManager(securityManager);
        currentUser = SecurityUtils.getSubject();      
    }
    
    /**
     * 
     * @param user Nombre del usuario que iniciará sesión
     * @param password Password del usuario
     * @return true si se logró iniciar sesión correctamente, false
     * si no se logró cerrar la sesión correctamente.
     */
public boolean IniciarSesion(String user, String password){
    if ( !currentUser.isAuthenticated() ) {    
        UsernamePasswordToken token = new UsernamePasswordToken(user, password);  
        try {

           currentUser.login( token );
            //si no hay excepción 
           //agregar un evento en log de inicio de sesion
           return true;
        } catch ( UnknownAccountException uae ) {
            //username no se encontró en el sistema
            return false;
        } catch ( IncorrectCredentialsException ice ){
            //password incorrecto, intente de nuevo
            return false;
        } catch ( LockedAccountException lae ) {
            //cuenta bloqueada
            return false;
        }

    }
    else{
        System.out.println("Sesion ya iniciada");
        return false;
    }
}

/**
 * 
 * @return true si se cerró correctamente la sesión, false 
 * si no se cerró correctamente la sesión.
 */
public boolean cerrarSesion(){
    if(currentUser.isAuthenticated()){
        currentUser.logout();
        return true;
    }
    else{
        return false;
    }
}
    
/**
 * Metdo que 
 * @param accion Es la accion que se desea ejecutar
 * @return true si el usuario tiene permiso de ejecutar 
 * una acción, false si no lo tiene
 */
    public boolean hasAcces(String accion){
        if(currentUser.isPermitted(accion)){
            return true;
        }
        else{
            return false;
        }
    }
  



}
