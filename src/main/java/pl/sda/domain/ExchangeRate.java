package pl.sda.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "rates")
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String currency;
    private LocalDate rateDate;

    public ExchangeRate(String currency, LocalDate rateDate) {
        this.currency = currency;
        this.rateDate = rateDate;
    }

    public ExchangeRate() {
    }

    public Long getId() {
        return id;
    }

    public String getCurrency() {
        return currency;
    }

    public LocalDate getRateDate() {
        return rateDate;
    }
}
