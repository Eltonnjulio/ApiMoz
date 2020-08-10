/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.co.apiMoz.jdbcRepository;



import java.util.List;
import java.util.Optional;
import mz.co.apiMoz.model.Localidade;
import mz.co.apiMoz.repository.LocalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public class JdbcLocalidadeRep implements LocalidadeRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public long count() {
       return jdbcTemplate
               .queryForObject("select count(*) from localidades", Long.class); }

    @Override
    public List<Localidade> findAll() {
        return jdbcTemplate.query(
                "select * from localidades",
                (rs, rowNum)
                -> new Localidade(
                        rs.getLong("id"), 
                        rs.getString("nome"),
                        rs.getLong("posto_id"))
        ); }

    @Override
    public Optional<Localidade> findById(long id) {
          return jdbcTemplate.queryForObject(
                "select * from localidades where id = ?",
                new Object[]{id},
                (rs, rowNum)
                -> Optional.of(new Localidade(
                        rs.getLong("id"), 
                        rs.getString("nome"),
                        rs.getLong("posto_id")))
        );}

    @Override
    public Optional<Localidade> findByBairro(long id) {
      
      return jdbcTemplate.queryForObject(
                "select l.id, l.nome, l.posto_id from localidades l inner join bairros b on b.localidade_id = l.id where b.id = ?",
                new Object[]{id},
                (rs, rowNum)
                -> Optional.of(new Localidade(
                        rs.getLong("id"), 
                        rs.getString("nome"),
                        rs.getLong("posto_id")
                        
                ))
        );
    }

    @Override
    public List<Localidade> findAll(long id) {
       return jdbcTemplate.query(
                "select * from localidades where posto_id = "+id,
                (rs, rowNum)
                -> new Localidade(
                        rs.getLong("id"), 
                        rs.getString("nome"),
                        rs.getLong("posto_id"))
        );
    }
    
}
