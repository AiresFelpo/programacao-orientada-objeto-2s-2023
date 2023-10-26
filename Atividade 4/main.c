#include <stdio.h>
#include <stdlib.h>
#include "bubble_sort.h"

int main(int argc, char *argv[]) {
    if (argc < 2) {
        printf("Uso: %s <lista de números>\n", argv[0]);
        return 1;
    }

    int size = argc - 1;
    int *numbers = (int *)malloc(size * sizeof(int));

    for (int i = 1; i < argc; i++) {
        numbers[i - 1] = atoi(argv[i]);
    }

    bubbleSort(numbers, size);

    printf("Saída: ");
    for (int i = 0; i < size; i++) {
        printf("%d ", numbers[i]);
    }
    printf("\n");

    free(numbers);

    return 0;
}
