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

public class Posto {



private long id;
private String nome;

private long distrito_id;


    public Posto() {
    }

    public Posto(long id, String nome, long distrito_id) {
        this.id = id;
        this.nome = nome;
        this.distrito_id = distrito_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getDistrito_id() {
        return distrito_id;
    }

    public void setDistrito_id(long distrito_id) {
        this.distrito_id = distrito_id;
    }

  


}
