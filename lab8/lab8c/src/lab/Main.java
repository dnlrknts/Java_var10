package lab;

import java.util.Arrays;

public class Main {

    public static void main(String[] args)
	{
	Comedy comedy = new Comedy("\"Очень смешной фильм\"","Описание комедии");
	System.out.println("Тэги :");
	System.out.println(Arrays.toString(comedy.getTags()));
	comedy.view();
    }
}
