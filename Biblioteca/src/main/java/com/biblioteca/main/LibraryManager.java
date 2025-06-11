
package com.biblioteca.main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import static jakarta.persistence.Persistence.createEntityManagerFactory;
import java.util.function.Consumer;

/**
 *
 * @author compi
 */
public class LibraryManager {

    public static void main(String[] args) {
        
        EntityManagerFactory factory = createEntityManagerFactory("persistence_unit_pruebaDB");
        
        inSession( factory, entityManager -> {
            
            
            
        });
        
    }
    
    public static void inSession ( EntityManagerFactory factory, Consumer<EntityManager> work ) {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        
        try {
            transaction.begin();
            work.accept(manager);
            transaction.commit();
        }
        catch ( Exception e ) {
            if ( transaction.isActive() ) transaction.rollback();
            throw e;
        }
        finally {
            manager.close();
        }
        
    } 
}
