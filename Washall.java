/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.floydwarshall.AlgoritmoDeWarshall;

class FloydWarshall {

    final static int INF = 9999;

    // Implementing floyd warshall algorithm
    void floydWarshall(int graph[][], int nV) {
        int matrix[][] = new int[nV][nV];
        int i, j, k;

        for (i = 0; i < nV; i++) {
            for (j = 0; j < nV; j++) {
                matrix[i][j] = graph[i][j];
            }
        }

        // Adding vertices individually
        for (k = 0; k < nV; k++) {
            for (i = 0; i < nV; i++) {
                for (j = 0; j < nV; j++) {
                    if (matrix[i][k] + matrix[k][j] < matrix[i][j]) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }
        printMatrix(matrix, nV);
    }

    void printMatrix(int matrix[][], int nV) {
        for (int i = 0; i < nV; ++i) {
            for (int j = 0; j < nV; ++j) {
                if (matrix[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(matrix[i][j] + "  ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int graph[][] = {{0, 4, 8, INF, INF}, {4, 0, 1, 2, INF}, {8, INF, 0, 4, 2}, {INF, 2, 4, 0, 7}, {INF, INF, 2, 7, 0}};
        int nV = graph.length;
        FloydWarshall a = new FloydWarshall();
        a.floydWarshall(graph, nV);
    }
}
