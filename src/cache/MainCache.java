/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cache;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.jcs.JCS;
import org.apache.jcs.access.exception.CacheException;
import org.apache.jcs.access.exception.ObjectExistsException;

/**
 * Clase encargada del manejo del caché.
 * @author Anuar
 */
public class MainCache {
    private JCS jcsCache;
    
    /**
     * Constructor por defecto. Inicializa el objeto con una instancia de
     * la cache.
     */
    public MainCache() {

        try {
            // Se carga el cache usando el archivo de configuracion
            jcsCache = JCS.getInstance("FrameworkCache");
            
        } catch (CacheException ex) {
            Logger.getLogger(MainCache.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    /**
     * Método para agregar un objeto a la caché.
     * @param dato el objeto a agregar.
     * @throws ObjectExistsException si el objeto ya se encuentra en la caché.
     * @throws CacheException si ocurre un problema al intentar agregar a la cahé.
     */
    public void putInCache(Cacheable dato)throws ObjectExistsException,CacheException{ 
        //Aqui en el primer datosCandidato va a ir por ejemplo datosCandidato.getId(), o sea el identificador con el cual se va a guardar ese objeto
        jcsCache.putSafe(dato.getId(), dato);
    }
  
    /**
     * Método para retirar un objeto de la caché.
     * @param id el identificador del objeto a retirar.
     * @return el objeto correspondiente al id.
     */
    public Cacheable getById(int id) {
          return (Cacheable) jcsCache.get(id);
    }
    
}
