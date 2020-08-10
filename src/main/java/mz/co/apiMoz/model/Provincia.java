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

public class Provincia {


private int id;
private String nome;


private int regiao_id;



    public Provincia() {
    }

    public Provincia(int id, String nome, int regiao_id) {
        this.id = id;
        this.nome = nome;
        this.regiao_id = regiao_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getRegiao_id() {
        return regiao_id;
    }

    public void setRegiao_id(int regiao_id) {
        this.regiao_id = regiao_id;
    }

  

}
