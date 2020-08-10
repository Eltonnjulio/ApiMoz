/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.co.apiMoz.repository;


import java.util.List;
import java.util.Optional;
import mz.co.apiMoz.model.Distrito;


/**
 *
 * @author Elton Julio
 */
public interface DistritoRepository{
  
     long count();
   
    List<Distrito> findAll();
    
    List<Distrito> findAll(long id);

    Optional<Distrito>findById(long id);

    Optional<Distrito> findByPosto(long id);
    
}
