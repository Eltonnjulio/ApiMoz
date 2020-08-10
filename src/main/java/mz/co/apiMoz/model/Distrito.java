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

public class Distrito {


private long id;
private String nome;

private int provincia_id;


    public Distrito() {
    }

    public Distrito(long id, String nome, int provincia_id) {
        this.id = id;
        this.nome = nome;
        this.provincia_id = provincia_id;
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

    public int getProvincia_id() {
        return provincia_id;
    }

    public void setProvincia_id(int provincia_id) {
        this.provincia_id = provincia_id;
    }

  


}
