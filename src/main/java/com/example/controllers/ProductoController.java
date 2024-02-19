/* package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.ProductoDao;
import com.example.entities.Producto;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoDao productoDao;

public ResponseEntity<List<Producto>> getAllProductos(
    @RequestParam(required = false)String name){
        List<Producto> productos = new ArrayList<>();

        if (name == null) {
            productoDao.findAll().forEach(productos::add);
        } else {
            productoDao.findByNameContaining(name).forEach(productos::add);

            if (productos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }

        return new ResponseEntity<>(productos, HttpStatus.OK);
    } 
    
    

}
 */