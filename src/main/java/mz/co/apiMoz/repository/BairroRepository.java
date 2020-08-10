/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.co.apiMoz.repository;


import java.util.List;
import java.util.Optional;
import mz.co.apiMoz.model.Bairro;


/**
 *
 * @author Elton Julio
 */
public interface BairroRepository{
  
     long count();
   
    List<Bairro> findAll();
    
    List<Bairro> findAll(long id);

    Optional<Bairro>findById(long id);

   
    
}
