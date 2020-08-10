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

public class Localidade {

   
    private long id;
private String nome;


private long posto_id;




    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Localidade() {
    }

    public Localidade(long id, String nome, long posto_id) {
        this.id = id;
        this.nome = nome;
        this.posto_id = posto_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getPosto_id() {
        return posto_id;
    }

    public void setPosto_id(long posto_id) {
        this.posto_id = posto_id;
    }

   


}
