package ClassWork.February.Week4.Wednsday01;

import ClassWork.February.Week4.Wednsday01.Models.City;
import ClassWork.February.Week4.Wednsday01.Models.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class ClassWork0103 implements Runnable {
    @Override
    public void run() {
        hibernateConnection();
    }

    private void hibernateConnection() {

        try {
            // Получить конфигурацию
            Configuration config = new Configuration().configure();
            // Разегистрировать сущность
            config.addAnnotatedClass(Country.class);
            config.addAnnotatedClass(City.class);
            // Создать строителя сервиса соединения с базой
            StandardServiceRegistryBuilder builder =
                    new StandardServiceRegistryBuilder()
                            .applySettings(config.getProperties());
            // Получить фабрику ссессии базы данных
            SessionFactory sessionFactory = config.buildSessionFactory(builder.build());

            // Получить сессию работы с базой
            Session session = sessionFactory.openSession();
            // Начать транзакцию
            Transaction tr = session.beginTransaction();
//*-------------------------------------------------------------------------------------------------------------------

            tr.commit();
//*-------------------------------------------------------------------------------------------------------------------


        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }
}
