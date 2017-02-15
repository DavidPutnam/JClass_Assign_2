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
        for (long mileage = 0; mileage < 300000l; mileage += 1000) {
            Map<String, Long> selected = intervals.selectMaintenanceDue(mileage, 2000l);
            if (selected.size() > 0) {
                System.out.println(selected.size() + " services of found at mileage " + mileage + ".");
            }
        }
    }

    @Test
    public void test95000() {
        long mileage = 95000l;
        Map<String, Long> expected = new HashMap<String, Long>();
        expected.put(MaintenanceIntervals.OIL_CHANGE, 1000l);
        expected.put(MaintenanceIntervals.SPARK_PLUG, 1000l);
        expected.put(MaintenanceIntervals.TIRE_ROTATION, 1000l);
        Map<String, Long> actual = intervals.selectMaintenanceDue(mileage, 2000l);
        printMap(mileage, actual);
        Assert.assertEquals("test95000", expected, actual);
    }

    @Test
    public void test119000() {
        long mileage = 119000l;
        Map<String, Long> expected = new HashMap<String, Long>();
        expected.put(MaintenanceIntervals.OIL_CHANGE, 1000l);
        expected.put(MaintenanceIntervals.TIRE_CONDITION, 1000l);
        expected.put(MaintenanceIntervals.TIRE_ROTATION, 1000l);
        Map<String, Long> actual = intervals.selectMaintenanceDue(mileage, 2000l);
        printMap(mileage, actual);
        Assert.assertEquals("test119000", expected, actual);
    }

    @Test
    public void test159000() {
        long mileage = 159000l;
        Map<String, Long> expected = new HashMap<String, Long>();
        expected.put(MaintenanceIntervals.TIRE_CONDITION, 1000l);
        expected.put(MaintenanceIntervals.SPARK_PLUG, 1000l);
        expected.put(MaintenanceIntervals.TIRE_ROTATION, 1000l);
        Map<String, Long> actual = intervals.selectMaintenanceDue(mileage, 2000l);
        printMap(mileage, actual);
        Assert.assertEquals("test159000", expected, actual);
    }

    @Test
    public void test167000() {
        long mileage = 167000l;
        Map<String, Long> expected = new HashMap<String, Long>();
        expected.put(MaintenanceIntervals.OIL_CHANGE, 1000l);
        expected.put(MaintenanceIntervals.TIRE_ROTATION, 1000l);
        expected.put(MaintenanceIntervals.AIR_FILTER, 1000l);
        Map<String, Long> actual = intervals.selectMaintenanceDue(mileage, 2000l);
        printMap(mileage, actual);
        Assert.assertEquals("test167000", expected, actual);
    }

    @Test
    public void test191000() {
        long mileage = 191000l;
        Map<String, Long> expected = new HashMap<String, Long>();
        expected.put(MaintenanceIntervals.OIL_CHANGE, 1000l);
        expected.put(MaintenanceIntervals.SPARK_PLUG, 1000l);
        expected.put(MaintenanceIntervals.TIRE_ROTATION, 1000l);
        Map<String, Long> actual = intervals.selectMaintenanceDue(mileage, 2000l);
        printMap(mileage, actual);
        Assert.assertEquals("test191000", expected, actual);
    }

    @Test
    public void test209000() {
        long mileage = 209000l;
        Map<String, Long> expected = new HashMap<String, Long>();
        expected.put(MaintenanceIntervals.OIL_CHANGE, 1000l);
        expected.put(MaintenanceIntervals.TIRE_CONDITION, 1000l);
        expected.put(MaintenanceIntervals.AIR_FILTER, 1000l);
        Map<String, Long> actual = intervals.selectMaintenanceDue(mileage, 2000l);
        printMap(mileage, actual);
        Assert.assertEquals("test209000", expected, actual);
    }
}
