package lab;

import java.util.Arrays;

public class Comedy extends DomesticFilm
{
    public Comedy(String title,String description)
    {
        super(title,description);
    }
    @Override
    public String[] getTags()
    {
        String[] oldTags = super.getTags();
        String[] tags = Arrays.copyOf(oldTags,oldTags.length+1);
        tags[tags.length-1] = "Комедия";
        return tags;
    }
    @Override
    public void view()
    {
        System.out.println("Комедия " + title + " просмотрена");
    }
}
