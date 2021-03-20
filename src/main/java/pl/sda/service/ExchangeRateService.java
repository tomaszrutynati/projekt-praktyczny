package pl.sda.service;

import pl.sda.external.client.NbpApiClient;
import pl.sda.external.client.NbpTable;
import pl.sda.external.dao.ExchangeRateDao;
import pl.sda.external.entity.ExchangeRate;

import java.time.LocalDate;
import java.util.Optional;

public class ExchangeRateService {
    private final ExchangeRateDao exchangeRateDao;
    private final NbpApiClient nbpApiClient;

    public ExchangeRateService(ExchangeRateDao exchangeRateDao, NbpApiClient nbpApiClient) {
        this.exchangeRateDao = exchangeRateDao;
        this.nbpApiClient = nbpApiClient;
    }

    public Double exchangeMoney(Double amount, String currency) {
        //w tych metodach metodach powinna znalezc sie logika biznesowa aplikacji
        Optional<ExchangeRate> rate =
                exchangeRateDao.findByCurrencyAndDate(currency, LocalDate.now());

        if (rate.isPresent()) {
            return amount * rate.get().getRate();
        }

        NbpTable tableAForDay = nbpApiClient.getTableAForDay(LocalDate.now());
        //zapiszemy dane w bazie
        //odfiltrujemy kurs, ktory nas interesuje i przemonozymy kwote przez kurs
        return amount;
    }
}
