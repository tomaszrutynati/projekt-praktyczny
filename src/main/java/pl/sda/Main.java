package pl.sda;

import com.squareup.okhttp.OkHttpClient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import pl.sda.external.client.NbpApiClient;
import pl.sda.external.dao.ExchangeRateDao;
import pl.sda.external.entity.ExchangeRate;
import pl.sda.service.ExchangeRateService;
import pl.sda.view.Menu;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        String hibernateCfgName = args.length > 0 ? args[0] : "hibernate.cfg.xml";

        SessionFactory sessionFactory = buildSessionFactory(hibernateCfgName);

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(new ExchangeRate("EUR", 4.1, LocalDate.now()));

        session.getTransaction().commit();

        OkHttpClient okHttpClient = new OkHttpClient();

        ExchangeRateDao dao = new ExchangeRateDao(sessionFactory);
        NbpApiClient nbpApiClient = new NbpApiClient(okHttpClient);
        ExchangeRateService exchangeRateService = new ExchangeRateService(dao, nbpApiClient);

        Menu menu = new Menu(exchangeRateService);

        menu.displayMenu();
    }

    private static SessionFactory buildSessionFactory(String hibernateCfgName) {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure(hibernateCfgName).build();

        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

        return metadata.getSessionFactoryBuilder().build();
    }
}
