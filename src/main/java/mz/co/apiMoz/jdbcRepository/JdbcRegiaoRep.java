/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.co.apiMoz.jdbcRepository;



import java.util.List;
import java.util.Optional;
import mz.co.apiMoz.model.Regiao;
import mz.co.apiMoz.repository.RegiaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public class JdbcRegiaoRep implements RegiaoRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
       return jdbcTemplate
               .queryForObject("select count(*) from regioes", Integer.class); }

    @Override
    public List<Regiao> findAll() {
        return jdbcTemplate.query(
                "select * from regioes",
                (rs, rowNum)
                -> new Regiao(
                        rs.getInt("id"), 
                        rs.getString("nome"))
        ); }

    @Override
    public Optional<Regiao> findById(int id) {
          return jdbcTemplate.queryForObject(
                "select * from regioes where id = ?",
                new Object[]{id},
                (rs, rowNum)
                -> Optional.of(new Regiao(
                        rs.getInt("id"),
                        rs.getString("nome")
                        
                ))
        );}

    @Override
    public Optional<Regiao> findByProvincia(int id) {
      
      return jdbcTemplate.queryForObject(
                "select r.id,r.nome from regioes r inner join provincias p on p.regiao_id = r.id where p.id = ?",
                new Object[]{id},
                (rs, rowNum)
                -> Optional.of(new Regiao(
                        rs.getInt("id"),
                        rs.getString("nome")
                        
                ))
        );
    }
    
}
