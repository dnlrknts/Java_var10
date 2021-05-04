package lab;

public class Mobile
{
    private Information inf;
    public Mobile(String manufacturer,String model, String ringtone)
    {
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

    public class Information
    {
        private String model;
        private String manufacturer;
        private String ringtone;

        public Information(String model, String manufacturer, String ringtone)
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
