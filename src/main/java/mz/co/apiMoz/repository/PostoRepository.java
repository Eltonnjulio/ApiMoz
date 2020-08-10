/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.co.apiMoz.repository;


import java.util.List;
import java.util.Optional;
import mz.co.apiMoz.model.Posto;


/**
 *
 * @author Elton Julio
 */
public interface PostoRepository {
  
   long count();
   
    List<Posto> findAll();
    
    List<Posto> findAll(long id);

    Optional<Posto>findById(long id);

    Optional<Posto> findByLocalidade(long id);
}
