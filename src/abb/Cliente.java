/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abb;

/**
 *
 * @author Helder
 */
public class Cliente {
    public String nome;
    public String cpf;
    public float id;
    
    //atributos para ABB
    public Cliente esquerda=null,direita=null;

    public Cliente(float id,String nome) {
        this.nome = nome;
        this.id = id;
    }
    
    
}
