/***********************************************************
* Filename: main.c
* Author: Maria Halvarsson, mahalv@kth.se
* Date: 2020-08-31
* Updated: 2020-09-07
*
* Compilation: gcc -o main main.c
* Execution test: ./main < test-input.txt
* Execution program: ./main < input.txt
*                    ./main
* Data files: the-fundamentas-lab/task1/test-input.txt
*             the-fundamentas-lab/task1/input.txt
 
* This program has two different implementations of a function that reads
* characters from standard input and prints them in reverse order to
* standard output. The program will run each implementation after each other,
* starting with the recursive implementation and then the iterative.
* The program also has a unit test for each of the functions.
* To run the tests, redirect the input to test-input.txt.
********************************************************/

#include <stdio.h>

void recursive_reverse();
void iterative_reverse();

/*
* Implements a recursive function that reads characters from stdin
* and prints them in reverse order to stdout.
*/
void recursive_reverse() {
  char c;
  if((c = getchar()) != '\n')
    recursive_reverse();
  putchar(c);
  return;
}

/*
* Implements an iterative function that reads a maximum of 20 characters
* from stdin and prints them in reverse order to stdout.
*/
void iterative_reverse() {
  char c[21];
  int i = 0;
  while((c[i] = getchar()) != '\n') {
    i++;
    if (i > 20) {
      printf("You have entered too many characters.\n");
      break;
    }
  }
  while(i >= 0 && i < 21) {
    putchar(c[i]);
    i--;
  }
  return;
}

/*
* This is a basic unit test for the recursive_reverse function.
* The test takes a given input and shows the expected output.
* The expected output can be compared with the actual output.
* To run the test, redirect input to test-input.txt
*/
static void test_recursve() {
  printf("******************TEST*******************\n");
  printf("This is a test function for recursive_reverse.\n");
  printf("Test if input generates the correct output. \n");
  printf("Input:\n123TEST\n");
  printf("Expected output:\nTSET321\n");
  printf("Output: ");
  recursive_reverse();
  printf("\n");
  printf("***************************************\n");
}

/*
* This is a basic unit test for the iterative_reverse function.
* The test takes a given input and shows the expected output.
* The expected output can be compared with the actual output.
* To run the test, redirect input to test-input.txt
*/
static void test_iterative() {
  printf("******************TEST*******************\n");
  printf("This is a test function for iterative_reverse.\n");
  printf("Test if input generates the correct output. \n");
  printf("Input: \n123TEST\n");
  printf("Expected output: \nTSET321\n");
  printf("Output: ");
  iterative_reverse();
  printf("\n");

  printf("Test entering too many characters: \n");
  printf("Expected output: \n");
  printf("You have entered too many characters.\n");
  printf("Output: \n");
  iterative_reverse();
  printf("***************************************\n");
}

/*
* This is the main funcion, all operations start from here.
* The function returns 0 if the program executed with no errors.
*/
int main() {
  printf("Press enter to start.\n");
  char c;
  scanf("%c", &c);

  // the unit test will start if $ is entered,
  // this command should only be used with test-input.txt file.
  if (c == '$') {
    test_recursve();
    test_iterative();
  }
  else if (c == '\n') {
    printf("Enter some text (recursive): ");
    recursive_reverse();
    printf("\n");
    printf("Enter some text, max 20 characters including spaces (iterative): ");
    iterative_reverse();
    printf("\n");
  }
  else
    printf("The operation did not start.\n");
  return 0;
}
