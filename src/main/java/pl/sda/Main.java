package pl.sda;

import com.squareup.okhttp.OkHttpClient;
import pl.sda.external.client.NbpApiClient;
import pl.sda.external.dao.ExchangeRateDao;
import pl.sda.service.ExchangeRateService;
import pl.sda.view.Menu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExchangeRates");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        OkHttpClient okHttpClient = new OkHttpClient();
        ExchangeRateDao dao = new ExchangeRateDao(entityManager);
        NbpApiClient nbpApiClient = new NbpApiClient(okHttpClient);
        ExchangeRateService exchangeRateService = new ExchangeRateService(dao, nbpApiClient);

        Menu menu = new Menu(exchangeRateService);

        menu.displayMenu();
    }
}
