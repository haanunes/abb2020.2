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
public class ABB {

    public Cliente raiz = null;

    public void inserir(Cliente novo) {
        if (raiz == null) {
            raiz = novo;
        } else {
            Cliente aux = raiz;
            do {
                //vou pra direita pq o novo é maior
                System.out.println("tentanto achar posição");
                if (aux.id < novo.id) {
                    if (aux.direita == null) {
                        // não tem filho a direita. Posso adicionar
                        aux.direita = novo;
                        break;
                    } else {
                        // tem filho a direita então tenho que pular
                        // para o próximo nível, procurando a posição nula
                        aux = aux.direita;
                    }
                } //vou pra esquerda pq o novo é menor ou igual
                else {
                    // buscando uma posição a esquerda que não tenho filhos
                    if (aux.esquerda == null) {
                        // não tem filho a esquerda. posso adicionar
                        aux.esquerda = novo;
                        break;
                    } else {
                        // tem filho a esquerda. desco nível de ABB
                        aux = aux.esquerda;
                    }
                }
            } while (aux != null);
        }
    }

    public void imprimirPreOrdem(Cliente aux) {
        System.out.print(aux.id + " - " + aux.nome+" |");
        if (aux.esquerda != null) {
            imprimirPreOrdem(aux.esquerda);
        }
        if (aux.direita != null) {
            imprimirPreOrdem(aux.direita);
        }
    }

    public void imprimirEmOrdem(Cliente aux) {
        if (aux.esquerda != null) {
            imprimirEmOrdem(aux.esquerda);
        }
        System.out.print(aux.id + " - " + aux.nome+" |");
        if (aux.direita != null) {
            imprimirEmOrdem(aux.direita);
        }
    }
    
    public void imprimirPosOrdem(Cliente aux) {
        if (aux.esquerda != null) {
            imprimirPosOrdem(aux.esquerda);
        }
        if (aux.direita != null) {
            imprimirPosOrdem(aux.direita);
        }
        System.out.print(aux.id + " - " + aux.nome+" |");
        
    }
    public static void main(String[] args) {
        ABB abb = new ABB();
        abb.inserir(new Cliente(5, "Ana"));
        abb.inserir(new Cliente(3, "Joana"));
        abb.inserir(new Cliente(6, "Mario"));
        abb.inserir(new Cliente(7, "Lucas"));
        abb.inserir(new Cliente(1, "Maria"));
        abb.inserir(new Cliente(4, "Barbara"));
        abb.inserir(new Cliente((float)5.1, "Barbara"));
        System.out.println("Impressao em ordem");
        abb.imprimirEmOrdem(abb.raiz);
        System.out.println("\n Impressao pre Ordem");
        abb.imprimirPreOrdem(abb.raiz);
        System.out.println("\n Impressao pos Ordem");
        abb.imprimirPosOrdem(abb.raiz);
    }

}
