#ifndef FILA_H
#define FILA_H

typedef struct Fila {
    int *dados;
    int tamanho;
    int capacidade;
    int inicio;
    int fim;
} Fila;

Fila *criarFila(int capacidade);
int filaVazia(Fila *f);
int filaCheia(Fila *f);
void enfileirar(Fila *f, int valor);
int desenfileirar(Fila *f);
void destruirFila(Fila *f);

#endif // FILA_H
