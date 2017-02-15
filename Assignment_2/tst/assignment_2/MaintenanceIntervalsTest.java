package assignment_2;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class MaintenanceIntervalsTest {
    static MaintenanceIntervals intervals = new MaintenanceIntervals();

    private void printMap(long mileage, Map<String, Long> servicesDue) {
        System.out.println("These services are due at " + mileage + ":");
        if (servicesDue.size() > 0) {
            for (String key : servicesDue.keySet()) {
                System.out.println("\t" + key + " in " + servicesDue.get(key).toString() + " miles.");
            }
        } else {
            System.out.println("\tNone.");
        }
    }

    @Test
    public void testZero() {
        Map<String, Long> expected = new HashMap<String, Long>();
        Map<String, Long> actual = intervals.selectMaintenanceDue(0l, 2000l);
        printMap(0l, actual);
        Assert.assertEquals("testZero", expected, actual);
    }

    @Test
    public void testLoop() {
        int maxFound = 0;
        long atMileage = 0;
        for (long mileage = 0; mileage < 300000l; mileage += 1000) {
            Map<String, Long> selected = intervals.selectMaintenanceDue(mileage, 2000l);
            if (selected.size() > maxFound) {
                maxFound = selected.size();
                atMileage = mileage;
            }
        }
        System.out.println("Maximum services of " + maxFound + " found at mileage " + atMileage + ".");
    }

    @Test
    public void test95000() {
        Map<String, Long> expected = new HashMap<String, Long>();
        expected.put(MaintenanceIntervals.OIL_CHANGE, 1000l);
        expected.put(MaintenanceIntervals.SPARK_PLUG, 1000l);
        expected.put(MaintenanceIntervals.TIRE_ROTATION, 1000l);
        Map<String, Long> actual = intervals.selectMaintenanceDue(95000l, 2000l);
        printMap(95000l, actual);
        Assert.assertEquals("test95000", expected, actual);
    }
}
