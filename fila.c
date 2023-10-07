#include <stdio.h>
#include <stdlib.h>
#include "fila.h"

Fila *criarFila(int capacidade) {
    Fila *f = (Fila *)malloc(sizeof(Fila));
    f->capacidade = capacidade;
    f->tamanho = 0;
    f->inicio = 0;
    f->fim = -1;
    f->dados = (int *)malloc(capacidade * sizeof(int));
    return f;
}

int filaVazia(Fila *f) {
    return f->tamanho == 0;
}

int filaCheia(Fila *f) {
    return f->tamanho == f->capacidade;
}

void enfileirar(Fila *f, int valor) {
    if (filaCheia(f)) {
        printf("Erro: Fila cheia\n");
        return;
    }
    f->fim = (f->fim + 1) % f->capacidade;
    f->dados[f->fim] = valor;
    f->tamanho++;
}

int desenfileirar(Fila *f) {
    if (filaVazia(f)) {
        printf("Erro: Fila vazia\n");
        return -1;
    }
    int valor = f->dados[f->inicio];
    f->inicio = (f->inicio + 1) % f->capacidade;
    f->tamanho--;
    return valor;
}

void destruirFila(Fila *f) {
    free(f->dados);
    free(f);
}
