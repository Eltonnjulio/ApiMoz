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
import mz.co.apiMoz.jdbcRepository.JdbcDistritoRep;
import mz.co.apiMoz.model.Distrito;
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
@RequestMapping(value="/distritos")
@Api(value="API REST distritos")
@CrossOrigin(origins = "*")
public class DistritoResource {
  
    @Autowired
    JdbcDistritoRep jdbcRep;
    
    @GetMapping("/findAll")
    @ApiOperation(value="Retorna uma lista de todos os distritos")
    public List<Distrito> listar(){
    return jdbcRep.findAll();
    }
    
    @GetMapping("/findAll/{id}")
    @ApiOperation(value="Retorna uma lista de todos os distritos de uma provincia")
    public List<Distrito> listar(@PathVariable(value="id") int id){
    return jdbcRep.findAll(id);
    }
    
      @GetMapping("/findById/{id}")
      @ApiOperation(value="Retorna um único Distrito")
    public Optional<Distrito> listaUma(@PathVariable(value="id") int id){
    return jdbcRep.findById(id);
    }
    
    
 
    @GetMapping("/findByPosto/{id}")
      @ApiOperation(value="Retorna o distrito de um posto administrativo")
    public Optional<Distrito> UmaById(@PathVariable(value="id") long id){
    return jdbcRep.findByPosto(id);
    } 
   
     
    
}
