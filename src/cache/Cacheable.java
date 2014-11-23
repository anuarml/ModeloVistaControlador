/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cache;

/**
 * Interface que representa que un TDA puede ser colocado en la caché.
 * @author Izanami
 */
public interface Cacheable {
    
    /**
     * Método abstracto para recuperar el id de un objeto cacheable.
     * @return
     */
    int getId();
}
