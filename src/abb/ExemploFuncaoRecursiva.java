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
public class ExemploFuncaoRecursiva {

    //1) Faça uma método que imprima seu nome 100x. 
    public void primeiraQuestaoComFor(String nome) {
        for (int i = 0; i < 100; i++) {
            System.out.println(nome);
        }
    }

    public void primeiraQuestaoComWhile(String nome) {
        int i = 0;
        while (i < 100) {
            System.out.println(nome);
            i++;
        }
    }

    public void primeiraQuestaoMetodoRecursivo(String nome, int i) {
        System.out.println(nome + " - " + i);
        if (i < 5) {
            i++;
            primeiraQuestaoMetodoRecursivo(nome, i);
        }
        System.out.println("desempilhamento do valor do i =" + i);
    }

    //2) Faça uma método que retorne o fatorial de um número:
    public int fatorialComFor(int num) {  // num = 4
        int fat = 1; //fat =24
        for (int i = num; i > 1; i++) { //i=4
            fat *= i;
        }
        return fat;
    }

    public int fatorialComRecursividade(int fat, int num) {// num =5
        if (num > 1) { //fat 1
            num--;
           return num *fatorialComRecursividade(fat, num);
        }
        else
            return 1;
    }

    public static void main(String[] args) {
        new ExemploFuncaoRecursiva().primeiraQuestaoMetodoRecursivo("Tiago", 0);
    }
}
