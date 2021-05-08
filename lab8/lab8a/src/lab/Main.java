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
        Operation max = Math::max;
        Calc calc = (a,b,c)-> max.operate(max.operate(a,b),c);
        System.out.println(calc.operate(3,2,8));
    }
}
