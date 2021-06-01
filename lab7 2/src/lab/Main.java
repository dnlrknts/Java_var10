package lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        List<Mobile> mobiles = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            mobiles.add(Mobile.Factory.getRandom());
        for (Mobile m: mobiles){
            Mobile.Information inf =m.getInf();
            System.out.println(inf);
            inf.playRingtone();
        }
    }
}
