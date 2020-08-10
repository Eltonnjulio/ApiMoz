/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.co.apiMoz.repository;


import java.util.List;
import java.util.Optional;
import mz.co.apiMoz.model.Provincia;
import mz.co.apiMoz.model.Regiao;


/**
 *
 * @author Elton Julio
 */
public interface RegiaoRepository{
  
   int count();
   
    List<Regiao> findAll();

    Optional<Regiao>findById(int id);

    Optional<Regiao> findByProvincia(int id);
}
