package lab;

import java.util.Random;

public class Mobile
{

    private final Information inf;
    private Mobile(String manufacturer,String model, String ringtone)
    {
        //Анонимный внутренний класс
        inf = new Information(manufacturer, model,ringtone)
        {
            @Override
            public void playRingtone()
            {
                System.out.println(manufacturer+" play ");
                super.playRingtone();
            }
        };
    }

    public Information getInf()
    {
        return inf;
    }

    //Статические вложенные классы
    public static class Factory
    {
        private static final Mobile[] mobiles = new Mobile[]{
                new Mobile("Samsung","S21","Bip-Bip"),
                new Mobile("Apple","12","Bup-Bup"),
                new Mobile("Xiaomi","Note11","Bam-Bam")};
        private static final Random rd = new Random();
        public static Mobile getRandom()
        {
            return mobiles[rd.nextInt(3)];
        }
    }

    //Вложенные внутренние классы
    public class Information
    {
        private String model;
        private String manufacturer;
        private String ringtone;

        public Information(String manufacturer, String model, String ringtone)
        {
            this.model = model;
            this.manufacturer = manufacturer;
            this.ringtone = ringtone;
        }

        public String getModel()
        {
            return model;
        }

        public String getManufacturer()
        {
            return manufacturer;
        }

        public String getRingtone()
        {
            return ringtone;
        }

        public void playRingtone()
        {
            System.out.println(ringtone);
        }

        @Override
        public String toString()
        {
            return "Information{" +
                    "model='" + model + '\'' +
                    ", manufacturer='" + manufacturer + '\'' +
                    ", ringtone='" + ringtone + '\'' +
                    '}';
        }
    }
}
