import java.util.Comparator;

/**
 * Compares two countries accoring to their standard rate in an actual period
 */
public class CountryComparator implements Comparator<Country> {
    @Override
    public int compare(Country c1, Country c2) {
        Period periodC1 = Utils.findActualPeriod(c1.getPeriods());
        Period periodC2 = Utils.findActualPeriod(c2.getPeriods());
        return periodC1.getRates().getStandard().compareTo(periodC2.getRates().getStandard());
    }

}

