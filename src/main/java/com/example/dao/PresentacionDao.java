package com.example.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entities.Presentacion;

@Repository
public interface PresentacionDao extends JpaRepository<Presentacion,Integer> {

    // Paginacion 
    // 1-Sacar los productos asociados a una presentacion 
    @Query(value = "select p from Presentacion p left join fetch p.productos",
    countQuery = "select count(p) from Presentacion p left join p.productos")

    public Page<Presentacion> findAll(Pageable pageable);

    @Query(value = "select p from Presentacion p left join fetch p.productos")
    public List<Presentacion> findAll(Sort sort);

    // Metodo 3
    @Query(value = "select p from Presentacion p left join fetch p.productos where p.id = :id")
    public Presentacion findById(int id);

}
