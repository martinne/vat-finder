import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class TestUtils {

    @Test
    public void findActualPeriod() {

        List<Period> periods = new ArrayList<Period>();

        Period period = new Period();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, -1);
        Date date1 = cal.getTime();
        period.setEffective_from(date1);
        periods.add(period);

        period = new Period();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, -2);
        Date date2 = cal.getTime();
        period.setEffective_from(date2);
        periods.add(period);

        period = new Period();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, -3);
        Date date3 = cal.getTime();
        period.setEffective_from(date3);
        periods.add(period);

        period = new Period();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, 1);
        Date date4 = cal.getTime();
        period.setEffective_from(date4);
        periods.add(period);

        period = new Period();
        Date date5 = new Date();
        period.setEffective_from(date5);
        periods.add(period);

        Period returnedPeriod = Utils.findActualPeriod(periods);

        // verify
        assertEquals(date5, returnedPeriod.getEffective_from());

    }
}
