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
        System.out.print(aux.id + " - " + aux.nome + " |");
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
        System.out.print(aux.id + " - " + aux.nome + " |");
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
        System.out.print(aux.id + " - " + aux.nome + " |");

    }

    public Cliente pegarElementoPorId(int id) {
        Cliente aux = raiz;
        do {
            //o numero buscado é maior, se é maior vai pra direita
            if (aux.id < id) {
                if (aux.direita == null) {
                    System.out.println("Não foi encontrado esse cliente.");
                    return null;
                } else {
                    aux = aux.direita;
                }
            } // o numero buscado é menor, se é menor vai pra esquerda
            else if (aux.id > id) {
                if (aux.esquerda == null) {
                    System.out.println("Não foi encontrado esse cliente.");
                    return null;
                } else {
                    aux = aux.esquerda;
                }
            } else {
                //aux.id == id;
                return aux;
            }
        } while (true);

    }

    public void remover(int id) {
        Cliente aux = raiz;
        do {
            //o numero buscado é maior, se é maior vai pra direita
            if (aux.id < id) {
                if (aux.direita == null) {
                    System.out.println("Não foi encontrado esse cliente.");
                    break;
                } else {
                    if (aux.direita.id == id) {
                        //encontrei o pai do cara que queremos remover.
                        // logica para remover
                        // já encontrei o bendito para remover. agora vou verificar quantos filhos
                        // ele tem para escolher a maneira de remover.
                        Cliente clienteRemover = aux.direita;
                        if (clienteRemover.esquerda == null && clienteRemover.direita == null) {
                            // ele não possui filhos
                        } else if ((clienteRemover.direita == null && clienteRemover.esquerda != null)
                                || (clienteRemover.direita != null && clienteRemover.esquerda == null)) {
                            // ele possui 1 filho
                        } else if (clienteRemover.direita != null && clienteRemover.esquerda != null) {
                            // ele tem dois filhos
                        }

                    } else {
                        aux = aux.direita;
                    }
                }
            } // o numero buscado é menor, se é menor vai pra esquerda
            else if (aux.id > id) {
                if (aux.esquerda == null) {
                    System.out.println("Não foi encontrado esse cliente.");
                    break;
                } else {
                    if (aux.esquerda.id == id) {
                        //encontrei o pai do cara que queremos remover.
                        // logica para remover
                        // já encontrei o bendito para remover. agora vou verificar quantos filhos
                        // ele tem para escolher a maneira de remover.
                        Cliente clienteRemover = aux.direita;
                        if (clienteRemover.esquerda == null && clienteRemover.direita == null) {
                            // ele não possui filhos
                        } else if ((clienteRemover.direita == null && clienteRemover.esquerda != null)
                                || (clienteRemover.direita != null && clienteRemover.esquerda == null)) {
                            // ele possui 1 filho
                        } else if (clienteRemover.direita != null && clienteRemover.esquerda != null) {
                            // ele tem dois filhos
                        }
                    } else {
                        aux = aux.esquerda;
                    }
                }
            }

        } while (true);
    }

    private void removerNenhumFilho(int id, Cliente pai) {
        if (pai.esquerda.id == id) {
            pai.esquerda = null;
        } else {
            pai.direita = null;
        }

    }

    private void remover1filho(int id, Cliente pai) {
        //esquerda
        if (pai.esquerda.id == id) {
            Cliente rem = pai.esquerda;
            if (rem.direita != null) {
                //o unico filho do cara a ser removida está a direita
                pai.esquerda = rem.direita;
                rem.direita = null;
            } else {
                //o unico filho do cara a ser removida está a esquerda
                pai.esquerda = rem.esquerda;
                rem.esquerda = null;
            }

        } //direita
        else {
            Cliente rem = pai.direita;
            if (rem.direita != null) {
                //o unico filho do cara a ser removida está a direita
                pai.direita = rem.direita;
                rem.direita = null;
            } else {
                //o unico filho do cara a ser removida está a esquerda
                pai.direita = rem.esquerda;
                rem.esquerda = null;
            }
        }
    }

    private void remover2filho(int id, Cliente paiDoNoParaRemover) {
        if (paiDoNoParaRemover.id > id) {
            Cliente rem = paiDoNoParaRemover.esquerda;
            Cliente paiDoImediatoProximo = acharPaiImidiatoProximo(paiDoNoParaRemover.esquerda);
            Cliente substituto = paiDoImediatoProximo.esquerda;
            paiDoImediatoProximo.esquerda = null;
            paiDoNoParaRemover.esquerda = substituto;
            substituto.esquerda = rem.esquerda;
            substituto.direita = rem.direita;
            rem.direita = null;
            rem.esquerda = null;
        } else {
            Cliente rem = paiDoNoParaRemover.direita;
            Cliente paiDoImediatoProximo = acharPaiImidiatoProximo(paiDoNoParaRemover.direita);
            Cliente substituto = paiDoImediatoProximo.esquerda;
            paiDoImediatoProximo.esquerda = null;
            paiDoNoParaRemover.direita = substituto;
            substituto.esquerda = rem.esquerda;
            substituto.direita = rem.direita;
            rem.direita = null;
            rem.esquerda = null;
        }
    }

    private Cliente acharPaiImidiatoProximo(Cliente aux) {
        aux = aux.direita;
        while (aux.esquerda.esquerda != null) {
            aux = aux.esquerda;
        }
        return aux;
    }

    public static void main(String[] args) {
        ABB abb = new ABB();
        abb.inserir(new Cliente(5, "Ana"));
        abb.inserir(new Cliente(3, "Joana"));
        abb.inserir(new Cliente(6, "Mario"));
        abb.inserir(new Cliente(7, "Lucas"));
        abb.inserir(new Cliente(1, "Maria"));
        abb.inserir(new Cliente(4, "Barbara"));
        abb.inserir(new Cliente((float) 5.1, "Thiago"));
        System.out.println("Impressao em ordem");
        abb.imprimirEmOrdem(abb.raiz);
        System.out.println("\n Impressao pre Ordem");
        abb.imprimirPreOrdem(abb.raiz);
        System.out.println("\n Impressao pos Ordem");
        abb.imprimirPosOrdem(abb.raiz);

        Cliente clienteComOId4 = abb.pegarElementoPorId(4);
        System.out.println("\n\n\n");
        System.out.println(clienteComOId4.nome + " " + clienteComOId4.cpf + " " + clienteComOId4.id);
        System.out.println("FE no 4" + clienteComOId4.esquerda.nome);
    }

}
