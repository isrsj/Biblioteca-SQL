
package com.biblioteca.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Editorial {
    
    @Id
    @GeneratedValue ( strategy=GenerationType.IDENTITY )
    @Column( name="id_editorial" )
    private Integer id;
    
    @Column( name="nombre", nullable=false, unique=true )
    private String nombre;
    
    @OneToMany( mappedBy="editorial", cascade=CascadeType.ALL )
    private Set<Libro> libros = new HashSet<>();
    
    public Editorial () {}

    public Editorial(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Libro> getLibros() {
        return libros;
    }

    public void setLibros(Set<Libro> libros) {
        this.libros = libros;
    }
    
    public void setLibro( Libro libro ) {
        libros.add(libro);
    }
}
