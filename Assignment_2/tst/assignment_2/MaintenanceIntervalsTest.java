package assignment_2;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Ignore;
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
    @Ignore
    public void testLoop() {
        long maxSize = 0;
        long atMileage = 0;
        Map<String, Long> due = null;
        for (long mileage = 1000l; mileage < 600000l; mileage += 1000l) {
            Map<String, Long> selected = intervals.selectMaintenanceDue(mileage, 2000l);
            if (selected.size() > maxSize) {
                maxSize = selected.size();
                atMileage = mileage;
                due = selected;
            }
        }
        System.out.println(maxSize + " services of found at mileage " + atMileage + ".");
        printMap(atMileage, due);
    }

    @Test
    public void testZero() {
        long mileage = 0l;
        Map<String, Long> expected = new HashMap<String, Long>();
        expected.put(MaintenanceIntervals.CABIN_FILTER, 0l);
        expected.put(MaintenanceIntervals.OIL_CHANGE, 0l);
        expected.put(MaintenanceIntervals.AIR_FILTER, 0l);
        expected.put(MaintenanceIntervals.TIMING_BELT, 0l);
        expected.put(MaintenanceIntervals.TIRE_CONDITION, 0l);
        expected.put(MaintenanceIntervals.TIRE_ROTATION, 0l);
        expected.put(MaintenanceIntervals.TIRE_REPLACEMENT, 0l);
        expected.put(MaintenanceIntervals.SPARK_PLUG, 0l);
        Map<String, Long> actual = intervals.selectMaintenanceDue(mileage, 2000l);
        Assert.assertEquals("testZero", expected, actual);
    }

    @Test
    public void test40000() {
        long mileage = 40000l;
        Map<String, Long> expected = new HashMap<String, Long>();
        expected.put(MaintenanceIntervals.OIL_CHANGE, 2000l);
        expected.put(MaintenanceIntervals.TIRE_CONDITION, 0l);
        expected.put(MaintenanceIntervals.TIRE_ROTATION, 0l);
        expected.put(MaintenanceIntervals.TIRE_REPLACEMENT, 1000l);
        expected.put(MaintenanceIntervals.AIR_FILTER, 2000l);
        Map<String, Long> actual = intervals.selectMaintenanceDue(mileage, 2000l);
        Assert.assertEquals("test40000", expected, actual);

    }

    @Test
    public void test64000() {
        long mileage = 64000l;
        Map<String, Long> expected = new HashMap<String, Long>();
        expected.put(MaintenanceIntervals.OIL_CHANGE, 2000l);
        expected.put(MaintenanceIntervals.TIRE_CONDITION, 1000l);
        expected.put(MaintenanceIntervals.SPARK_PLUG, 0l);
        expected.put(MaintenanceIntervals.TIRE_ROTATION, 0l);
        expected.put(MaintenanceIntervals.CABIN_FILTER, 2000l);
        expected.put(MaintenanceIntervals.TIMING_BELT, 1000l);
        Map<String, Long> actual = intervals.selectMaintenanceDue(mileage, 2000l);
        Assert.assertEquals("test64000", expected, actual);
    }

    @Test
    public void test95000() {
        long mileage = 95000l;
        Map<String, Long> expected = new HashMap<String, Long>();
        expected.put(MaintenanceIntervals.OIL_CHANGE, 1000l);
        expected.put(MaintenanceIntervals.TIRE_CONDITION, 0l);
        expected.put(MaintenanceIntervals.SPARK_PLUG, 1000l);
        expected.put(MaintenanceIntervals.TIRE_ROTATION, 1000l);
        Map<String, Long> actual = intervals.selectMaintenanceDue(mileage, 2000l);
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
        Assert.assertEquals("test209000", expected, actual);
    }

    @Test
    public void test286000() {
        long mileage = 286000l;
        Map<String, Long> expected = new HashMap<String, Long>();
        expected.put(MaintenanceIntervals.OIL_CHANGE, 2000l);
        expected.put(MaintenanceIntervals.CABIN_FILTER, 0l);
        expected.put(MaintenanceIntervals.TIRE_REPLACEMENT, 1000l);
        expected.put(MaintenanceIntervals.TIRE_ROTATION, 2000l);
        expected.put(MaintenanceIntervals.SPARK_PLUG, 2000l);
        Map<String, Long> actual = intervals.selectMaintenanceDue(mileage, 2000l);
        Assert.assertEquals("test286000", expected, actual);
    }

    @Test
    public void testMax() {
        long mileage = Integer.MAX_VALUE + 2000l;
        Map<String, Long> expected = new HashMap<String, Long>();
        expected.put(MaintenanceIntervals.CABIN_FILTER, 353l);
        Map<String, Long> actual = intervals.selectMaintenanceDue(mileage, 2000l);
        Assert.assertEquals("testMax", expected, actual);
    }
}
