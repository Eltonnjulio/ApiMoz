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
import mz.co.apiMoz.jdbcRepository.JdbcProvinciaRep;
import mz.co.apiMoz.model.Provincia;
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
@RequestMapping(value="/provincias")
@Api(value="API REST Provincias")
@CrossOrigin(origins = "*")
public class ProvinciaResource {
  
    @Autowired
    JdbcProvinciaRep jdbcRep;
    
    @GetMapping("/findAll")
    @ApiOperation(value="Retorna uma lista de todas provincias")
    public List<Provincia> listar(){
    return jdbcRep.findAll();
    }
    
    @GetMapping("/findAll/{id}")
    @ApiOperation(value="Retorna uma lista de todas as provincias de uma região")
    public List<Provincia> listar(@PathVariable(value="id")int id){
    return jdbcRep.findAll(id);
    }
      
    @GetMapping("/findById/{id}")
    @ApiOperation(value="Retorna uma única provincia")
    public Optional<Provincia> listaUma(@PathVariable(value="id") int id){
    return jdbcRep.findById(id);
    }
    
    
    
 
    @GetMapping("/findBydistrito/{id}")
    @ApiOperation(value="Retorna a provincia de um distrito")
    public Optional<Provincia> UmaById(@PathVariable(value="id") int id){
    return jdbcRep.findByDistrito(id);
    } 
   
     
    
}
