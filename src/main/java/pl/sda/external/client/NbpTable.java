package pl.sda.external.client;

import java.time.LocalDate;
import java.util.List;

public class NbpTable {
    private String table;
    private String no;
    private LocalDate effectiveDate;
    private List<NbpRate> rates;

    public NbpTable(String table, String no, LocalDate effectiveDate, List<NbpRate> rates) {
        this.table = table;
        this.no = no;
        this.effectiveDate = effectiveDate;
        this.rates = rates;
    }

    public NbpTable() {
    }

    public String getTable() {
        return table;
    }

    public String getNo() {
        return no;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public List<NbpRate> getRates() {
        return rates;
    }
}
