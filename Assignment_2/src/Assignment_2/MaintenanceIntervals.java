package Assignment_2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaintenanceIntervals {
    private final Map<String, Integer> maintenanceIntervals;

    public MaintenanceIntervals() {
        maintenanceIntervals = new HashMap<String, Integer>();
        maintenanceIntervals.put("Oil Change", 6000);
        maintenanceIntervals.put("Tire Rotation", 8000);
        maintenanceIntervals.put("Tire Condition Check", 5000);
        maintenanceIntervals.put("Tire Replacement", 41000);
        maintenanceIntervals.put("Air Filter Replacement", 14000);
        maintenanceIntervals.put("Spark Plug Replacement", 32000);
        maintenanceIntervals.put("Timing Belt Replacement", 65000);
        maintenanceIntervals.put("Cabin Air Filter Replacement", 22000);
    }

    public Set<String> keySet() {
        return new HashSet<String>(maintenanceIntervals.keySet());
    }

    public Integer get(String key) {
        return new Integer(maintenanceIntervals.get(key));
    }
}
