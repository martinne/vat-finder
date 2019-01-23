import java.util.Date;

/**
 * POJO represents one period of VATS of the country
 */
public class Period {
    private Date effective_from;
    private Rates rates;

    public Date getEffective_from() {
        return effective_from;
    }

    public void setEffective_from(Date effective_from) {
        this.effective_from = effective_from;
    }

    public Rates getRates() {
        return rates;
    }

    public void setRates(Rates rates) {
        this.rates = rates;
    }
}
