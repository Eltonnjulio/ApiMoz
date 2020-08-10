/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.co.apiMoz.resourses;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Optional;
import mz.co.apiMoz.jdbcRepository.JdbcRegiaoRep;
import mz.co.apiMoz.model.Regiao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Elton Julio
 */
@RestController
@RequestMapping(value="/regioes")
@Api(value="API REST Regioes")
@CrossOrigin(origins = "*")
public class RegiaoResource {
  
    @Autowired
    JdbcRegiaoRep jdbcRep;
    
    @GetMapping("/findAll")
    @ApiOperation(value="Retorna a lista de todas regiões")
    public List<Regiao> listarRegioes(){
    return jdbcRep.findAll();
    }
    
      @GetMapping("/findById/{id}")
      @ApiOperation(value="Retorna uma única região")
    public Optional<Regiao> listaRegiao(@PathVariable(value="id") int id){
    return jdbcRep.findById(id);
    }
    

    @GetMapping("/findByProvincia/{id}")
      @ApiOperation(value="Retorna a região de uma provincia")
    public Optional<Regiao> RegiaoByProvincia(@PathVariable(value="id") int id){
    return jdbcRep.findByProvincia(id);
    } 
      
}
