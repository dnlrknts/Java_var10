import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        System.out.println("A brood hen has created");
        Puppy puppy = new Puppy("Tim","Breed 1");
        // Print current state of a brood hen
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
}
