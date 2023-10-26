#include "bubble_sort.h"
#include <string.h>

void bubbleSort(char *array[], int size) {
    int swapped;
    do {
        swapped = 0;
        for (int i = 0; i < size - 1; i++) {
            if (strcmp(array[i], array[i + 1]) > 0) {
                // Troca as palavras se estiverem fora de ordem
                char *temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                swapped = 1;
            }
        }
    } while (swapped);
}
