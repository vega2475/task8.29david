package vsu.cs.vega;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Solution {

    void readMtx() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/vsu/cs/vega/input.txt"));

        ArrayList<String> lines = new ArrayList<>();
        while (br.ready()) {
            lines.add(br.readLine());
        }
        int matrixHeight = lines.size();

        int[][] matrix = new int[matrixHeight][];

        for(int i = 0; i < matrixHeight; ++i) {
            String[] nums = lines.get(i).split("\s*,\s*");
            matrix[i] = new int[nums.length];
            for(int j = 0; j < nums.length; ++j) {
                matrix[i][j] = Integer.parseInt(nums[j]);
            }
        }
        int[][] matrixForOutput = calc(matrix);
        try(PrintWriter out = new PrintWriter(new FileOutputStream("src/vsu/cs/vega/output.txt"))) {
            for (int i = 0; i < matrixHeight; ++i) {
               out.println(Arrays.toString(matrixForOutput[i]).replaceAll("^\\[|]$", ""));
            }
        }
        catch (ArrayIndexOutOfBoundsException ignored){
        }


        //out.println(Arrays.toString(matrixForOutput).replaceAll("^\\[|]$", ""));
    }

    int[][] calc(int[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        boolean[] minRows = null, maxRows = null;
        boolean[] minCols = null, maxCols = null;

        Integer min = null;
        Integer max = null;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (null == min || array[i][j] < min) {
                    minRows = new boolean[rows];
                    minRows[i] = true;
                    minCols = new boolean[cols];
                    minCols[j] = true;
                    min = array[i][j];
                } else if (array[i][j] == min) {
                    minRows[i] = true;
                    minCols[j] = true;
                }

                if (null == max || array[i][j] > max) {
                    maxRows = new boolean[rows];
                    maxRows[i] = true;
                    maxCols = new boolean[cols];
                    maxCols[j] = true;
                    max = array[i][j];
                } else if (array[i][j] == max) {
                    maxRows[i] = true;
                    maxCols[j] = true;
                }
            }
        }
//  uncomment to debug
//    System.out.println("min=" + min + "; max=" + max);
//    System.out.println("minRows=" + Arrays.toString(minRows));
//    System.out.println("maxRows=" + Arrays.toString(maxRows));
//    System.out.println("minCols=" + Arrays.toString(minCols));
//    System.out.println("maxCols=" + Arrays.toString(maxCols));
        int rowsToDelete = 0, colsToDelete = 0;
        for (int i = 0; i < rows; i++) {
            if (minRows[i] || maxRows[i]) {
                rowsToDelete++;
            }
        }
        for (int i = 0; i < cols; i++) {
            if (minCols[i] || maxCols[i]) {
                colsToDelete++;
            }
        }

        if (rows == rowsToDelete || cols == colsToDelete) {
            return new int[1][0];
        }

        int[][] result = new int[rows - rowsToDelete][cols - colsToDelete];

        for (int i = 0, r = 0; i < rows; i++) {
            if (minRows[i] || maxRows[i])
                continue; // пропустить строку, содержащую минимум или максимум
            for (int j = 0, c = 0; j < cols; j++) {
                if (minCols[j] || maxCols[j])
                    continue; // пропустить столбец, содержащий минимум или максимум
                result[r][c++] = array[i][j];
            }
            r++;
        }
        //out.println(Arrays.toString(array).replaceAll("^\\[|]$", ""));

        return result;
    }



}
