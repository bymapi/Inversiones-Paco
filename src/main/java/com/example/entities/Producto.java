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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "productos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "El nombre no puede ser nulo")
    @NotEmpty(message = "El nombre del producto no puede estar vacío")
    @Size(min = 4, max = 25, message = "El nombre no puede tener menos de 4 caracteres ni más de 25")
    private String name;

    @NotBlank(message = "La descripcion del producto es requerida")
    private String description;

    @Min(value = 0, message = "El precio no puede ser menor que cero")
    private double price;

    @Min(value = 0, message = "El stock no puede ser menor que cero")
    private int stock;

    @ManyToMany(fetch = FetchType.LAZY,
    cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })

    @JoinTable(name = "presentacion_seq",
    joinColumns = {@JoinColumn (name = "producto_id")},
    inverseJoinColumns = {@JoinColumn(name = "presentacion_id")})

    private List<Presentacion> presentaciones;
    

}
