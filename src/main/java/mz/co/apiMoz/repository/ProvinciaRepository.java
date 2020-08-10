/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.co.apiMoz.repository;


import java.util.List;
import java.util.Optional;
import mz.co.apiMoz.model.Provincia;

/**
 *
 * @author Elton Julio
 */
public interface ProvinciaRepository{
  
   int count();
   
    List<Provincia> findAll();
    
    List<Provincia> findAll(int id);

    Optional<Provincia>findById(int id);

    Optional<Provincia> findByDistrito(long id);
}
