/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.co.apiMoz.jdbcRepository;



import java.util.List;
import java.util.Optional;
import mz.co.apiMoz.model.Provincia;
import mz.co.apiMoz.repository.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public class JdbcProvinciaRep implements ProvinciaRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
       return jdbcTemplate
               .queryForObject("select count(*) from provincias", Integer.class); }

    @Override
    public List<Provincia> findAll() {
        return jdbcTemplate.query(
                "select * from provincias",
                (rs, rowNum)
                -> new Provincia(
                        rs.getInt("id"), 
                        rs.getString("nome"),
                        rs.getInt("regiao_id"))
        ); }

    @Override
    public Optional<Provincia> findById(int id) {
          return jdbcTemplate.queryForObject(
                "select * from provincias where id = ?",
                new Object[]{id},
                (rs, rowNum)
                -> Optional.of(new Provincia(
                        rs.getInt("id"), 
                        rs.getString("nome"),
                        rs.getInt("regiao_id")))
        );}

    @Override
    public Optional<Provincia> findByDistrito(long id) {
      
      return jdbcTemplate.queryForObject(
                "select p.id, p.nome, p.regiao_id from provincias p inner join distritos d on d.provincia_id = p.id where d.id = ?",
                new Object[]{id},
                (rs, rowNum)
                -> Optional.of(new Provincia(
                        rs.getInt("id"), 
                        rs.getString("nome"),
                        rs.getInt("regiao_id")
                        
                ))
        );
    }

    @Override
    public List<Provincia> findAll(int id) {
         return jdbcTemplate.query(
                "select * from provincias where regiao_id = "+id,
                (rs, rowNum)
                -> new Provincia(
                        rs.getInt("id"), 
                        rs.getString("nome"),
                        rs.getInt("regiao_id"))
        );
    }
    
}
