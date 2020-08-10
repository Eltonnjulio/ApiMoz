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


public class Bairro {

    
    private long id;
private String nome;


private long localidade_id;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Bairro() {
    }

    public Bairro(long id, String nome, long localidade_id) {
        this.id = id;
        this.nome = nome;
        this.localidade_id = localidade_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getLocalidade_id() {
        return localidade_id;
    }

    public void setLocalidade_id(long localidade_id) {
        this.localidade_id = localidade_id;
    }

  

}
