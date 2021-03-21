package pl.sda.external.dao;

import org.hibernate.SessionFactory;
import pl.sda.external.entity.ExchangeRate;

import java.time.LocalDate;
import java.util.Optional;

public class ExchangeRateDao {

    private final SessionFactory sessionFactory;

    public ExchangeRateDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Optional<ExchangeRate> findByCurrencyAndDate(String currency, LocalDate localDate) {
        //tu powinno zostac zaimplementowane zapytanie

        return Optional.empty();
    }

    public void save(ExchangeRate rate) {
        //tu powinno zostac zaimplementowany save
    }
}
