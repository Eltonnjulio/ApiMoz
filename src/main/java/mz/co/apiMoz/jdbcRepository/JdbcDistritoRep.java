/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.co.apiMoz.jdbcRepository;



import java.util.List;
import java.util.Optional;
import mz.co.apiMoz.model.Distrito;
import mz.co.apiMoz.repository.DistritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public class JdbcDistritoRep implements DistritoRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public long count() {
       return jdbcTemplate
               .queryForObject("select count(*) from distritos", Long.class); }

    @Override
    public List<Distrito> findAll() {
        return jdbcTemplate.query(
                "select * from distritos",
                (rs, rowNum)
                -> new Distrito(
                        rs.getLong("id"), 
                        rs.getString("nome"),
                        rs.getInt("provincia_id"))
        ); }

    @Override
    public Optional<Distrito> findById(long id) {
          return jdbcTemplate.queryForObject(
                "select * from distritos where id = ?",
                new Object[]{id},
                (rs, rowNum)
                -> Optional.of(new Distrito(
                        rs.getLong("id"), 
                        rs.getString("nome"),
                        rs.getInt("provincia_id")))
        );}

    @Override
    public Optional<Distrito> findByPosto(long id) {
      
      return jdbcTemplate.queryForObject(
                "select d.id, d.nome, d.provincia_id from postos p inner join distritos d on p.distrito_id = d.id where p.id = ?",
                new Object[]{id},
                (rs, rowNum)
                -> Optional.of(new Distrito(
                        rs.getLong("id"), 
                        rs.getString("nome"),
                        rs.getInt("provincia_id")
                        
                ))
        );
    }

    @Override
    public List<Distrito> findAll(long id) {
        return jdbcTemplate.query(
                "select * from distritos where provincia_id = "+id,
                (rs, rowNum)
                -> new Distrito(
                        rs.getLong("id"), 
                        rs.getString("nome"),
                        rs.getInt("provincia_id"))
        );
    }
    
}
