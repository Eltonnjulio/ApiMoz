/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.co.apiMoz.jdbcRepository;



import java.util.List;
import java.util.Optional;
import mz.co.apiMoz.model.Quarteirao;
import mz.co.apiMoz.repository.QuarteiraoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Elton Julio
 */
@Repository
public class JdbcQuarteiraoRep implements QuarteiraoRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public long count() {
       return jdbcTemplate
               .queryForObject("select count(*) from quarteiroes", Long.class); }

    @Override
    public List<Quarteirao> findAll() {
        return jdbcTemplate.query(
                "select * from quarteiroes",
                (rs, rowNum)
                -> new  Quarteirao(
                        rs.getLong("id"), 
                        rs.getString("nome"),
                        rs.getLong("bairro_id"))
        ); }

    @Override
    public Optional<Quarteirao> findById(long id) {
          return jdbcTemplate.queryForObject(
                "select * from quarteiroes where id = ?",
                new Object[]{id},
                (rs, rowNum)
                -> Optional.of(new Quarteirao(
                        rs.getLong("id"), 
                        rs.getString("nome"),
                        rs.getLong("bairro_id")))
        );}

    @Override
    public List<Quarteirao> findAll(long id) {
         return jdbcTemplate.query(
                "select * from quarteiroes where bairro_id = "+id,
                (rs, rowNum)
                -> new  Quarteirao(
                        rs.getLong("id"), 
                        rs.getString("nome"),
                        rs.getLong("bairro_id"))
        ); 
    }

   
    
}
