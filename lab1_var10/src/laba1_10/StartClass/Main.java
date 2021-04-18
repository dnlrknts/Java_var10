package laba1_10.StartClass;

import laba1_10.MethodClass.NumberSolver;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NumberSolver.findNumbers(NumberSolver.readInput(scanner));
    }
}
