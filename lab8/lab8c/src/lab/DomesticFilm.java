package lab;

public class DomesticFilm implements Film
{
    String title;
    String description;

    public DomesticFilm(String title, String description)
    {
        this.title = title;
        this.description = description;
    }

    @Override
    public String getTitle()
    {
        return title;
    }

    @Override
    public String getDescription()
    {
        return description;
    }

    @Override
    public void view()
    {
        System.out.println("Фильм " + title + " просмотрен");
    }

    @Override
    public String[] getTags()
    {
        return new String[]{"Отечественный фильм"};
    }
}
