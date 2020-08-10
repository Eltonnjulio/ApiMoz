/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mz.co.apiMoz.model;



/**
 *
 * @author elton
 */

public class Quarteirao {

    
    private long id;
private String nome ;

private long bairro_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Quarteirao() {
    }

    public Quarteirao(long id, String nome, long bairro_id) {
        this.id = id;
        this.nome = nome;
        this.bairro_id = bairro_id;
    }

    public long getBairro_id() {
        return bairro_id;
    }

    public void setBairro_id(long bairro_id) {
        this.bairro_id = bairro_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



}
