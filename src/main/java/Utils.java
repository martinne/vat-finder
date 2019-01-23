import java.util.Date;
import java.util.List;

/**
 * Util class for various tasks.
 */
public class Utils {

    /**
     * Finds period valid for current date.
     * @param periods for each country
     * @return period
     */
    protected static Period findActualPeriod (List<Period> periods) {
        Period periodToReturn = null;
        Date currentDate = new Date();
        for (Period period : periods) {
            if ( (currentDate.compareTo(period.getEffective_from()) >=0)
                    && (((periodToReturn != null) && (periodToReturn.getEffective_from().compareTo(period.getEffective_from()) <= 0))
                    || periodToReturn == null)) {
                periodToReturn = period;
            }
        }
        return periodToReturn;
    }
}
