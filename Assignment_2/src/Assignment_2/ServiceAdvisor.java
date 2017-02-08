package Assignment_2;

public class ServiceAdvisor {

    public static void main(String[] args) {
        final MaintenanceIntervals intervals = new MaintenanceIntervals();

        // System.out.println(intervals.keySet());
        // System.out.println("Values:");
        // for (String key : intervals.keySet()) {
        // System.out.println("key: " + key + ", value: " +
        // intervals.get(key).toString());
        // }
        long milage = 42764;
        System.out.println("Interval is from: " + milage + " to " + (milage + 2000) + " miles.");
        for (String key : intervals.keySet()) {
            long intervalMileage = intervals.get(key).longValue();
            long milesUntil = milage % intervalMileage;

            System.out.println(" " + milesUntil + ", key: " + key + ", value: " + intervals.get(key).toString());
        }

    }
}
