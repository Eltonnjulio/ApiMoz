/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.co.apiMoz.repository;


import java.util.List;
import java.util.Optional;
import mz.co.apiMoz.model.Localidade;


/**
 *
 * @author Elton Julio
 */
public interface LocalidadeRepository{
  
     long count();
   
    List<Localidade> findAll();
    
    List<Localidade> findAll(long id);

    Optional<Localidade>findById(long id);

    Optional<Localidade> findByBairro(long id);
}
