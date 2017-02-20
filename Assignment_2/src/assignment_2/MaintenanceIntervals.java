package assignment_2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * The <code>MaintenanceIntervals</code> class encapsulates the services and
 * frequencies they are expected to be performed.
 * 
 * @author dputnam3 "David Putnam"
 * @version 1.0
 *
 */
public class MaintenanceIntervals {
    private final Map<String, Long> maintenanceIntervals;
    public static final String OIL_CHANGE = "Oil Change";
    public static final String TIRE_ROTATION = "Tire Rotation";
    public static final String TIRE_CONDITION = "Tire Condition Check";
    public static final String TIRE_REPLACEMENT = "Tire Replacement";
    public static final String AIR_FILTER = "Air Filter Replacement";
    public static final String SPARK_PLUG = "Spark Plug Replacement";
    public static final String TIMING_BELT = "Timing Belt Replacement";
    public static final String CABIN_FILTER = "Cabin Air Filter Replacement";

    /**
     * The constructor creates an immutable object that can be queried for
     * services.
     */
    public MaintenanceIntervals() {
        maintenanceIntervals = new HashMap<String, Long>();
        maintenanceIntervals.put(OIL_CHANGE, 6000l);
        maintenanceIntervals.put(TIRE_ROTATION, 8000l);
        maintenanceIntervals.put(TIRE_CONDITION, 5000l);
        maintenanceIntervals.put(TIRE_REPLACEMENT, 41000l);
        maintenanceIntervals.put(AIR_FILTER, 14000l);
        maintenanceIntervals.put(SPARK_PLUG, 32000l);
        maintenanceIntervals.put(TIMING_BELT, 65000l);
        maintenanceIntervals.put(CABIN_FILTER, 22000l);
    }

    /**
     * 
     * @return Collections.unmodifiableSet of service names.
     */
    public Set<String> keySet() {
        return Collections.unmodifiableSet(maintenanceIntervals.keySet());
    }

    /**
     * Retrieve the <code>long</code> maintenance interval associated with the
     * service <code>key</code>
     * 
     * @param key
     * @return
     */
    public long get(String key) {
        return maintenanceIntervals.get(key).longValue();
    }

    /**
     * Retrieve Map of services and mileage until they are due for all services
     * that are due from mileage to mileage plus tolerance inclusive.
     * 
     * @param mileage
     *            mileage of the vehicle now
     * @param tolerance
     *            maximum allowed projection for service.
     * @return
     */
    public Map<String, Long> selectMaintenanceDue(long mileage, long tolerance) {
        Map<String, Long> maintenanceDue = new HashMap<String, Long>();

        for (String key : maintenanceIntervals.keySet()) {
            long intervalMileage = maintenanceIntervals.get(key).longValue();
            long milesPast = (mileage + tolerance) % intervalMileage;
            if (milesPast <= tolerance) {
                maintenanceDue.put(key, new Long(tolerance - milesPast));
            }
        }

        return maintenanceDue;
    }
}
