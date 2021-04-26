import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    private static void loop() throws IllegalStateException, NoSuchElementException
    {
        // исключения могут генерируются в scanner и ловятся в методе main
        System.out.println("A brood hen has created");
        Puppy puppy = new Puppy("Tim","Breed 1");
        System.out.println(puppy);

        System.out.println("A: say");
        System.out.println("B: jump");
        System.out.println("C: run");
        System.out.println("D: bite");
        System.out.println("Q: Quit");

        String choice = "";
        Scanner scan = new Scanner(System.in);
        while (!choice.equals("Q")) {
            System.out.println("Select something: ");

            choice = scan.nextLine();
            switch (choice) {
                case "A" -> puppy.say();
                case "B" -> puppy.jump();
                case "C" -> puppy.run();
                case "D" -> puppy.bite();
            }
        }
        System.out.println("See you soon!");

        // Testing
        // Equal
        Puppy puppy2 = new Puppy("Tim","Breed 1");
        if (puppy2.equals(puppy)){
            System.out.println("puppy and puppy2 are equal");
        }

        //Hash code
        System.out.println("Hash code of an {Tim,Breed 1} is: " + puppy.hashCode());

        //To string
        System.out.println("Information about the puppy: " + puppy2);

    }
    private static int divByZero() throws ArithmeticException
    {
        int i = 1;
        int j = 0;
        return i/j;
    }
    private static void outOfMemory() throws OutOfMemoryError
    {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(1);
        while (true)
        {
            l.addAll(l);
        }
    }
    public static void main(String[] args)
    {
        try
        {
            loop();
        }
        catch (IllegalStateException | NoSuchElementException e)
        {
            e.printStackTrace();
        }
        try
        {
            System.out.println(divByZero());
        }
        catch (ArithmeticException e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            new Animal(null);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            outOfMemory();
        }
        catch (OutOfMemoryError e)
        {
            System.out.println(e.getMessage());
        }
    }
}
