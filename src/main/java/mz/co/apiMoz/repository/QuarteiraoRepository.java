/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.co.apiMoz.repository;


import java.util.List;
import java.util.Optional;
import mz.co.apiMoz.model.Quarteirao;


/**
 *
 * @author Elton Julio
 */
public interface QuarteiraoRepository{
  
     long count();
   
    List<Quarteirao> findAll();
    
    List<Quarteirao> findAll(long id);

    Optional<Quarteirao>findById(long id);

    
}
