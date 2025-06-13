
package com.biblioteca.main;

import com.biblioteca.entities.Editorial;
import com.biblioteca.panel.PanelEditorial;
import com.biblioteca.panel.PanelLibro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import static jakarta.persistence.Persistence.createEntityManagerFactory;
import java.util.function.Consumer;
import javax.swing.JFrame;

/**
 *
 * @author compi
 */
public class LibraryManager {

    public static void main(String[] args) {
        
        EntityManagerFactory factory = createEntityManagerFactory("biblioteca_unit");

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //PanelEditorial panelEditorial = new PanelEditorial( factory );
        PanelLibro panelLibro = new PanelLibro(factory);
        frame.setSize(260, 320 );
        frame.add(panelLibro);
        frame.setVisible(true);

        /*
        inSession( factory, entityManager -> {
            
            String query = "where id=:parameterId";
            Editorial editorial =
                    entityManager.createQuery(query, Editorial.class)
                            .setParameter("parameterId", 1)
                            .getSingleResult();
            
            System.out.println( "Nombre de la editorial: "+editorial.getNombre() );
            System.out.println( "Id de la editorial: "+editorial.getId() );
            
        });
        */
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
