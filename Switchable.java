public interface Switchable {
    void turnOn();
    void turnOff();
    
    // Default method to get device status
    default String getStatus() {
        return "Device status unknown";
    }
    
    // Static method to validate power state
    static boolean isValidPowerState(boolean state) {
        return true; // Basic validation
    }
}
