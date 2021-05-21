import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static  int randInt(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    private static int[][] createMatrix(int n)
    {
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                matrix[i][j] = randInt(-n,n);
        return matrix;
    }
    private static void printMatrix(Object[] matrix)
    {
        System.out.println(Arrays.deepToString(matrix).replace("], ", "]\n"));
    }
    private static int[][] processMatrix(int[][] matrix)
    {
        int n = matrix.length;
        Set<Integer> rows = IntStream.range(0,n).boxed().collect(Collectors.toSet());
        Set<Integer> cols = IntStream.range(0,n).boxed().collect(Collectors.toSet());
        int max = Integer.MIN_VALUE;
        // находим максимальное значение
        for (int[] ints : matrix)
            for (int j = 0; j < n; j++)
                if (ints[j] > max)
                    max = ints[j];
        System.out.println("Макс = " +max);
        //выбираем все удаляемые строки и столбцы
        for(int i =0; i < n;i++)
            for (int j = 0; j < n; j++)
                if(matrix[i][j]==max)
                {
                    rows.remove(i);
                    cols.remove(j);
                }
        int[][] result = new int[rows.size()][cols.size()];
        Integer[] rowsAr = rows.toArray(Integer[]::new);
        Integer[] colsAr = cols.toArray(Integer[]::new);
        //строим результирующую матрицу
        for(int i = 0; i < rowsAr.length; i++)
            for (int j = 0; j < colsAr.length; j++)
                result[i][j] = matrix[rowsAr[i]][colsAr[j]];
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размерность матрицы");
        int[][] matrix = createMatrix(scanner.nextInt());
        printMatrix(matrix);
        System.out.println("Ответ: ");
        printMatrix(processMatrix(matrix));
    }
}
