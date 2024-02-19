package com.example.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "presentaciones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Presentacion implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;



    @ManyToMany(fetch = FetchType.LAZY,
    cascade = {

        CascadeType.PERSIST,
        CascadeType.MERGE
    },

    mappedBy = "presentaciones" )
    @JsonIgnore
    private List<Producto> productos;

    public Presentacion(String name, String description) {
        this.name = name;
        this.description = description;
      }
    
      // getters and setters
    
      public void addProducto(Producto producto) {
        this.productos.add(producto);
        producto.getPresentaciones().add(this);
      }
      
      public void removeProducto(long productoId) {
        Producto producto = this.productos.stream().filter(t -> t.getId() == productoId).findFirst().orElse(null);
        if (producto != null) {
          this.productos.remove(producto);
          producto.getPresentaciones().remove(this);
        }
      }

    



}
