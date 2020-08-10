/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.co.apiMoz.jdbcRepository;



import java.util.List;
import java.util.Optional;
import mz.co.apiMoz.model.Posto;
import mz.co.apiMoz.repository.PostoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public class JdbcPostoRep implements PostoRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public long count() {
       return jdbcTemplate
               .queryForObject("select count(*) from postos", Long.class); }

    @Override
    public List<Posto> findAll() {
        return jdbcTemplate.query(
                "select * from postos",
                (rs, rowNum)
                -> new Posto(
                        rs.getLong("id"), 
                        rs.getString("nome"),
                        rs.getLong("distrito_id"))
        ); }

    @Override
    public Optional<Posto> findById(long id) {
          return jdbcTemplate.queryForObject(
                "select * from postos where id = ?",
                new Object[]{id},
                (rs, rowNum)
                -> Optional.of(new Posto(
                        rs.getLong("id"), 
                        rs.getString("nome"),
                        rs.getLong("distrito_id")))
        );}

    @Override
    public Optional<Posto> findByLocalidade(long id) {
      
      return jdbcTemplate.queryForObject(
                "select p.id, p.nome, p.distrito_id from postos p inner join localidades l on l.posto_id = p.id where l.id = ?",
                new Object[]{id},
                (rs, rowNum)
                -> Optional.of(new Posto(
                        rs.getLong("id"), 
                        rs.getString("nome"),
                        rs.getLong("distrito_id")
                        
                ))
        );
    }

    @Override
    public List<Posto> findAll(long id) {
       return jdbcTemplate.query(
                "select * from postos where distrito_id = "+id,
                (rs, rowNum)
                -> new Posto(
                        rs.getLong("id"), 
                        rs.getString("nome"),
                        rs.getLong("distrito_id"))
        );
    }
    
}
