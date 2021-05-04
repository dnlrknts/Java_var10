package lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        List<Mobile> mobiles = Arrays.asList(
                new Mobile("Samsung","S21","Bip-Bip"),
                new Mobile("Apple","12","Bup-Bup"),
                new Mobile("Xiaomi","Note11","Bam-Bam"));
        for (Mobile m: mobiles){
            Mobile.Information inf =m.getInf();
            System.out.println(inf);
            inf.playRingtone();
        }
    }
}
