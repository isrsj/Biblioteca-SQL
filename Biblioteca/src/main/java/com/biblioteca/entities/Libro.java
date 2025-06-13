
package com.biblioteca.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Libro {
    
    @Id
    @GeneratedValue( strategy=GenerationType.IDENTITY )
    @Column( name="id_libro")
    private Integer id;
    
    @Column( name="titulo", nullable=false)
    private String titulo;
    
    @ManyToOne( fetch=FetchType.LAZY )
    @JoinColumn( name="id_editorial", nullable=false )
    private Editorial editorial;

    public Libro(String titulo, Editorial editorial) {
        this.titulo = titulo;
        this.editorial = editorial;
    }

    public Libro() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }
    
}
