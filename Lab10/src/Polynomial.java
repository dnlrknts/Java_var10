import java.util.ArrayList;
import java.util.Collections;

public record Polynomial(ArrayList<Integer> coefficients)
{

    public Polynomial multiply(Polynomial p)
    {
        int m = coefficients.size();
        int n = p.coefficients.size();
        ArrayList<Integer> prod = new ArrayList<>(Collections.nCopies(m+n-1, 0));
        for (int i = 0; i < m; i++)
            // Умножение каждого коэффицента первого многочлена на все коэффиценты второго
            for (int j = 0; j < n; j++)
                prod.set(i + j, prod.get(i + j) + coefficients.get(i) * p.coefficients.get(j));
        return new Polynomial(prod);
    }

    @Override
    public String toString()
    {
        int n = coefficients.size();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++)
        {
            str.append(coefficients.get(i));
            if (i != 0)
                str.append("x^").append(i);
            if (i != n - 1)
                str.append(" + ");
        }
        return str.toString();
    }
}
