/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cache;

import Modelo.Candidato;
import Modelo.Evento;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.jcs.JCS;
import org.apache.jcs.access.exception.CacheException;

/**
 *
 * @author Anuar
 */
public class MainCache {
    private JCS jcsCache;
    
    public MainCache() {

        try {
            // Se carga el cache usando el archivo de configuracion
            jcsCache = JCS.getInstance("FrameworkCache");
            
        } catch (CacheException ex) {
            Logger.getLogger(MainCache.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void putInCache(Candidato datosCandidato) { 
        
        try {
            //Aqui en el primer datosCandidato va a ir por ejemplo datosCandidato.getId(), o sea el identificador con el cual se va a guardar ese objeto
            jcsCache.put(datosCandidato.getIdCandidato(), datosCandidato);
        } catch (CacheException ex) {
            Logger.getLogger(MainCache.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Aqui en object va a ir el tipo de objeto que se va a guardar    
    public Candidato getProductById(int id) {
          return (Candidato) jcsCache.get(id);
    }
    
}