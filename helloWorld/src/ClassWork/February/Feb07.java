package ClassWork.February;

import ClassWork.February.Entity.Blog.Category;
import ClassWork.February.Entity.Blog.Post;
import ClassWork.February.Entity.Person;
import org.jetbrains.annotations.NotNull;

public class Feb07 implements Runnable
{
    /**
     * Точка старта классной работы
     */
    @Override
    public void run() {
        // linkTypes();
        blog();
    }

    public void blog(){
        Category news = new Category();
        news.name = "News";
        Category article = new Category();
        article.name = "Article";

        Post n1 = new Post();
        n1.name = "First News";
        n1.category = news;
        news.posts.add(n1);

        Post n2 = new Post();
        n2.name = "Second News";
        n2.category = news;
        news.posts.add(n2);

        n1 = n2;
        n2.name = "Change name";
        System.out.println(n1.name);

        System.out.println(
                n1.category.posts.get(0).category.posts.get(1)
        );
    }


    public void linkTypes(){
        Person nykytin = new Person();
        nykytin.setName("Oleksandr");
        System.out.println(nykytin.getName());
        System.out.println(nykytin);

        //catchLinkTypes(nykytin.clone());
        catchName(nykytin.getName());

        System.out.println("After call function: ");

        System.out.println(nykytin.getName());
        System.out.println(nykytin);

    }

    public void catchName(String n){
        n = "Sanya";
        System.out.println(n);
    }

    public void catchLinkTypes(@NotNull Person p) {
        p.setName("Sashko");
        System.out.println(p.getName());
        System.out.println(p);
    }
}
