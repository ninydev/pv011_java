package ClassWork.February.Week4.Tuesday28;

import ClassWork.February.Week3.Tuesday23.Models.Tag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ClassWork2802 implements Runnable
{
    @Override
    public void run() {
        hibernateConnection();
    }

    private void hibernateConnection(){

        try {
            // Получить конфигурацию
            Configuration config = new Configuration().configure();
            // Разегистрировать сущность
            config.addAnnotatedClass(Tag.class);
            // Создать строителя сервиса соединения с базой
            StandardServiceRegistryBuilder builder =
                    new StandardServiceRegistryBuilder()
                            .applySettings(config.getProperties());
            // Получить фабрику ссессии базы данных
            SessionFactory sessionFactory = config.buildSessionFactory(builder.build());

            // Получить сессию работы с базой
            Session session = sessionFactory.openSession();

            // Создадим новую сущность
            Tag newTag = new Tag();
            newTag.setName("HelloWorld");

            // Начнем транзакцию
            Transaction tr = session.beginTransaction();
            // Сохраним сущность в сессии
            session.save(newTag);
            // Завершим транзакцию
            tr.commit();

            // SELECT by id
            Tag t = sessionFactory.openSession().get(Tag.class, 12);
            System.out.println(t);

            // SELECT *
            List<Tag> lst = sessionFactory.openSession().createQuery("From Tag").list();
            for (Tag tg: lst
                 ) {
                System.out.println(tg);
            }



        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }
}
