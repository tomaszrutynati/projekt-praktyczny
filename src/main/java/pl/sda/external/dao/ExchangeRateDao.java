package pl.sda.external.dao;

import pl.sda.external.entity.ExchangeRate;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Optional;

public class ExchangeRateDao {

    private final EntityManager entityManager;

    public ExchangeRateDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<ExchangeRate> findByCurrencyAndDate(String currency, LocalDate localDate) {
        //tu powinno zostac zaimplementowane zapytanie

        return Optional.empty();
    }

    public void save(ExchangeRate rate) {
        //tu powinno zostac zaimplementowany save
    }
}
