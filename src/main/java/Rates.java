/**
 * POJO represents set of VATS rates for the period.
 */

public class Rates {
    private Double standard;
    private Double super_reduced;
    private Double reduced;

    public Double getStandard() {
        return standard;
    }

    public void setStandard(Double standard) {
        this.standard = standard;
    }

    public Double getSuper_reduced() {
        return super_reduced;
    }

    public void setSuper_reduced(Double super_reduced) {
        this.super_reduced = super_reduced;
    }

    public Double getReduced() {
        return reduced;
    }

    public void setReduced(Double reduced) {
        this.reduced = reduced;
    }
}
