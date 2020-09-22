/*******************************
* Filename: sort_negative.c
* Author: Maria Halvarsson, mahalv@kth.se
* Date: 2020-09-16
* Updated: 2020-09-17
*
* Compilation: gcc -o sort_negative sort_negative.c
* Execution: ./sort_negative < input.txt
* Dependencies: none
* Data files: sorting-lab/src/tests/test4.txt
*
* This code document is a part of the sorting lab for the course ID1020
* at kth.se. This code solves Assignment 4.
*
* Sorts a sequence of integers from standard input,
* negative integers are sorted to be first in the array.
*********************************/

#include <stdio.h>

/*
* Sorts an array so that all negative values are stored first in the array,
* and all non negative values are stored at the end of the array.
* Note that the elements will not be sorted in any particular order.
*/
void sort (int array[], int length) {
  int i = 0;
  int j = length - 1;

  while (i != j) {
    if (array[i] < 0 && array[j] < 0) { i++; }
    else if (array[i] > -1 && array[j] > -1) { j--; }
    else if (array[i] > -1 && array[j] < 0) {
      int temp = array[i];
      array[i] = array[j];
      array[j] = temp;
    }
    else {
      i++;
      j--;
    }
  }
}

/*
* Prints the array to standard output.
*/
void printArray(int array[], int length) {
  for (int i = 0; i < length; i++) {
    if (i + 1 == length)
      printf("%d\n", array[i]);
    else
      printf("%d, ", array[i]);
  }
}

/*
* Takes integer values from standard input and
* stores them in the assigned array.
*/
void insertInteger(int array[], int size) {
  for (int i = 0; i < size; i++)
    scanf("%d", &array[i]);
}

/*
* This is the main method where the operation starts.
*/
int main() {
  int n;
  printf("Enter array size: \n");
  scanf("%d", &n);
  int array[n];
  printf("Enter %d integers to the array: \n", n);
  insertInteger(array, n);
  sort(array, n);
  printArray(array, n);
  return 0;
}
