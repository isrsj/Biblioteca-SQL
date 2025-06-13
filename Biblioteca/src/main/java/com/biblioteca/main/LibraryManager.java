
package com.biblioteca.main;

import com.biblioteca.panel.PanelEditorial;
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
        PanelEditorial panelEditorial = new PanelEditorial( factory );
        frame.setSize(260, 320 );
        frame.add(panelEditorial);
        frame.setVisible(true);
        
        //inSession( factory, entityManager -> { 
        //});
        
    }
    
    
}
