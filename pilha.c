#include <stdio.h>
#include <stdlib.h>
#include "pilha.h"

Pilha *criarPilha(int capacidade) {
    Pilha *p = (Pilha *)malloc(sizeof(Pilha));
    p->capacidade = capacidade;
    p->topo = -1;
    p->dados = (int *)malloc(capacidade * sizeof(int));
    return p;
}

int pilhaVazia(Pilha *p) {
    return p->topo == -1;
}

int pilhaCheia(Pilha *p) {
    return p->topo == p->capacidade - 1;
}

void empilhar(Pilha *p, int valor) {
    if (pilhaCheia(p)) {
        printf("Erro: Pilha cheia\n");
        return;
    }
    p->dados[++p->topo] = valor;
}

int desempilhar(Pilha *p) {
    if (pilhaVazia(p)) {
        printf("Erro: Pilha vazia\n");
        return -1;
    }
    return p->dados[p->topo--];
}

void destruirPilha(Pilha *p) {
    free(p->dados);
    free(p);
}
