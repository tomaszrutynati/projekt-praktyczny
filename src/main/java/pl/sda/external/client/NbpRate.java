package pl.sda.external.client;

public class NbpRate {
    private String currency;
    private String code;
    private Double mid;

    public NbpRate(String currency, String code, Double mid) {
        this.currency = currency;
        this.code = code;
        this.mid = mid;
    }

    public NbpRate() {
    }

    public String getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }

    public Double getMid() {
        return mid;
    }
}
