package pl.sda.external.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "rates")
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String currency;
    private Double rate;
    private LocalDate rateDate;

    public ExchangeRate(String currency, Double rate, LocalDate rateDate) {
        this.currency = currency;
        this.rate = rate;
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

    public Double getRate() {
        return rate;
    }

    public LocalDate getRateDate() {
        return rateDate;
    }
}
