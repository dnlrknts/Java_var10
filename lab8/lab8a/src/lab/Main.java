package lab;

@FunctionalInterface
interface Operation
{
    int operate(int a, int b);
}

@FunctionalInterface
interface Calc
{
    int operate(int a, int b, int c);
}

public class Main {

    public static void main(String[] args) {
        Operation min = Math::min;
        Calc calc = (a,b,c)-> min.operate(min.operate(a,b),c);
        System.out.println(calc.operate(3,2,3));
    }
}
