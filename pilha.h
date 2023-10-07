#ifndef PILHA_H
#define PILHA_H

typedef struct Pilha {
    int *dados;
    int topo;
    int capacidade;
} Pilha;

Pilha *criarPilha(int capacidade);
int pilhaVazia(Pilha *p);
int pilhaCheia(Pilha *p);
void empilhar(Pilha *p, int valor);
int desempilhar(Pilha *p);
void destruirPilha(Pilha *p);

#endif // PILHA_H
