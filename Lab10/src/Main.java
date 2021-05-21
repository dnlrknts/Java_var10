import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args)
    {
        Polynomial p1 = new Polynomial(new ArrayList<>(Arrays.asList(1,2,2)));
        System.out.println("Многочлен 1 : "+p1);
        Polynomial p2 = new Polynomial(new ArrayList<>(Arrays.asList(5,3,2,5,7)));
        System.out.println("Многочлен 2 : "+p2);
        System.out.println("Произведение : "+p1.multiply(p2));
    }
}
