/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.co.apiMoz.jdbcRepository;



import java.util.List;
import java.util.Optional;
import mz.co.apiMoz.model.Bairro;
import mz.co.apiMoz.repository.BairroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public class JdbcBairroRep implements BairroRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public long count() {
       return jdbcTemplate
               .queryForObject("select count(*) from bairros", Long.class); }

    @Override
    public List<Bairro> findAll() {
        return jdbcTemplate.query(
                "select * from bairros",
                (rs, rowNum)
                -> new Bairro(
                        rs.getLong("id"), 
                        rs.getString("nome"),
                        rs.getInt("localidade_id"))
        ); }

    @Override
    public Optional<Bairro> findById(long id) {
          return jdbcTemplate.queryForObject(
                "select * from bairros where id = ?",
                new Object[]{id},
                (rs, rowNum)
                -> Optional.of(new Bairro(
                        rs.getLong("id"), 
                        rs.getString("nome"),
                        rs.getInt("localidade_id")))
        );}

    @Override
    public List<Bairro> findAll(long id) {
        return jdbcTemplate.query(
                "select * from bairros where localidade_id = "+id,
                (rs, rowNum)
                -> new Bairro(
                        rs.getLong("id"), 
                        rs.getString("nome"),
                        rs.getInt("localidade_id"))
        );
    }

   
    
}
