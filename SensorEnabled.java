public interface SensorEnabled {
    void enableSensor();
    void disableSensor();
    boolean detectMotion();
    
    // Default method to get sensor status
    default String getSensorStatus() {
        return "Sensor status unknown";
    }
    
    // Static method for motion sensitivity validation
    static boolean isValidSensitivity(int level) {
        return level >= 1 && level <= 10;
    }
}
