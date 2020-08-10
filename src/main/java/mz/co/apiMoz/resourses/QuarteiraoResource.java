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
import mz.co.apiMoz.jdbcRepository.JdbcQuarteiraoRep;
import mz.co.apiMoz.model.Quarteirao;
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
@RequestMapping(value="/quarteiroes")
@Api(value="API REST Quarteirões")
@CrossOrigin(origins = "*")
public class QuarteiraoResource {
  
    @Autowired
    JdbcQuarteiraoRep jdbcRep;
    
    @GetMapping("/findAll")
    @ApiOperation(value="Retorna uma lista de todos quarteirões")
    public List<Quarteirao> listar(){
    return jdbcRep.findAll();
    }
    
    
     @GetMapping("/findAll/{id}")
    @ApiOperation(value="Retorna uma lista de quarteirões de um bairro")
    public List<Quarteirao> listar(@PathVariable(value="id")long id){
    return jdbcRep.findAll(id);
    }
    
      @GetMapping("/findById/{id}")
      @ApiOperation(value="Retorna um único Quarteirão")
    public Optional<Quarteirao> listaUma(@PathVariable(value="id") int id){
    return jdbcRep.findById(id);
    }
   
    
}
