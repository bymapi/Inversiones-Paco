package com.example.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.entities.Producto;

@Repository
public interface ProductoDao extends JpaRepository<Producto,Integer>{

    @Query(value = "select p from Producto p left join fetch p.presentaciones",
    countQuery = "select count(p) from Producto p left join p.presentaciones")
    public Page<Producto> findAll(Pageable pageable);

    // Método que ordena los asistentes sin paginación 

    @Query(value = "select p from Producto p left join fetch p.presentaciones")
    public List<Producto> findAll(Sort sort);

    // Método que recupera el asistente con su presentaciono

    @Query(value = "select p from Producto p left join fetch p.presentaciones where p.id = :id")
    public Producto findById(int id);




}
