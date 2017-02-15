package assignment_2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MaintenanceIntervals {
    private final Map<String, Long> maintenanceIntervals;

    public MaintenanceIntervals() {
        maintenanceIntervals = new HashMap<String, Long>();
        maintenanceIntervals.put("Oil Change", 6000l);
        maintenanceIntervals.put("Tire Rotation", 8000l);
        maintenanceIntervals.put("Tire Condition Check", 5000l);
        maintenanceIntervals.put("Tire Replacement", 41000l);
        maintenanceIntervals.put("Air Filter Replacement", 14000l);
        maintenanceIntervals.put("Spark Plug Replacement", 32000l);
        maintenanceIntervals.put("Timing Belt Replacement", 65000l);
        maintenanceIntervals.put("Cabin Air Filter Replacement", 22000l);
    }

    public Set<String> keySet() {
        return Collections.unmodifiableSet(maintenanceIntervals.keySet());
    }

    public long get(String key) {
        return maintenanceIntervals.get(key).longValue();
    }

    public Map<String, Long> selectMaintenanceDue(long mileage, long within) {
        Map<String, Long> maintenanceDue = new HashMap<String, Long>();

        for (String key : maintenanceIntervals.keySet()) {
            long intervalMileage = maintenanceIntervals.get(key).longValue();
            long milesPast = mileage % intervalMileage;
            long milesUntil = intervalMileage - milesPast;
            if (milesUntil < within) {
                maintenanceDue.put(key, new Long(milesUntil));
            }
        }

        return maintenanceDue;
    }
}
