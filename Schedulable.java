public interface Schedulable {
    void schedule(String time);
    void cancelSchedule();
    
    // Default method to check if device is scheduled
    default boolean isScheduled() {
        return false;
    }
    
    // Static method to validate time format
    static boolean isValidTimeFormat(String time) {
        return time != null && time.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]");
    }
}
