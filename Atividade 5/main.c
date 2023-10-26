#include <stdio.h>
#include <stdlib.h>
#include "bubble_sort.h"

int main(int argc, char *argv[]) {
    if (argc != 2) {
        printf("Uso: %s <arquivo_entrada>\n", argv[0]);
        return 1;
    }

    // Abre o arquivo de entrada para leitura
    FILE *inputFile = fopen(argv[1], "r");
    if (inputFile == NULL) {
        perror("Erro ao abrir o arquivo de entrada");
        return 1;
    }

    // Lê as palavras do arquivo de entrada e armazena-as em um array
    char *words[100]; // Suponhamos que o arquivo contenha no máximo 100 palavras
    int count = 0;

    char buffer[100];
    while (fgets(buffer, sizeof(buffer), inputFile) != NULL) {
        // Remove a quebra de linha do final da palavra
        if (buffer[strlen(buffer) - 1] == '\n') {
            buffer[strlen(buffer) - 1] = '\0';
        }

        words[count] = strdup(buffer); // Aloca memória para cada palavra
        count++;
    }

    fclose(inputFile);

    // Ordena as palavras
    bubbleSort(words, count);

    // Cria o nome do arquivo de saída
    char outputFileName[100];
    snprintf(outputFileName, sizeof(outputFileName), "%s_ordenado.txt", argv[1]);

    // Abre o arquivo de saída para escrita
    FILE *outputFile = fopen(outputFileName, "w");
    if (outputFile == NULL) {
        perror("Erro ao abrir o arquivo de saída");
        return 1;
    }

    // Escreve as palavras ordenadas no arquivo de saída
    for (int i = 0; i < count; i++) {
        fprintf(outputFile, "%s\n", words[i]);
        free(words[i]); // Libera a memória alocada para cada palavra
    }

    fclose(outputFile);

    return 0;
}
