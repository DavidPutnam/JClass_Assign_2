package assignment_2;

import java.util.Map;

public class ServiceAdvisor {

    public static void main(String[] args) {
        final MaintenanceIntervals intervals = new MaintenanceIntervals();

        long mileage = 43764;
        long tolerance = 2000;
        System.out.println("Interval is from: " + mileage + " to " + (mileage + tolerance) + " miles.");
        Map<String, Long> selected = intervals.selectMaintenanceDue(mileage, tolerance);
        System.out.println("The following services are due within " + tolerance + " miles.");
        for (String key : selected.keySet()) {
            System.out.println("\t" + key + " in " + selected.get(key).toString() + " miles.");
        }
    }
}
