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
import mz.co.apiMoz.jdbcRepository.JdbcPostoRep;
import mz.co.apiMoz.model.Posto;
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
@RequestMapping(value="/postos")
@Api(value="API REST postos")
@CrossOrigin(origins = "*")
public class PostoResource {
  
    @Autowired
    JdbcPostoRep jdbcRep;
    
    @GetMapping("/findAll")
    @ApiOperation(value="Retorna uma lista de postos")
    public List<Posto> listar(){
    return jdbcRep.findAll();
    }
    
    
    @GetMapping("/findAll/{id}")
    @ApiOperation(value="Retorna uma lista de postos de um distrito")
    public List<Posto> listar(@PathVariable(value="id") long id){
    return jdbcRep.findAll(id);
    }
    
      @GetMapping("/findById/{id}")
      @ApiOperation(value="Retorna um único posto")
    public Optional<Posto> listaUma(@PathVariable(value="id") long id){
    return jdbcRep.findById(id);
    }
    
    
    
 
    @GetMapping("/findByLocalidade/{id}")
      @ApiOperation(value="Retorna o posto de uma localidade")
    public Optional<Posto> UmaById(@PathVariable(value="id") long id){
    return jdbcRep.findByLocalidade(id);
    } 
   
     
    
}
