package src.threadpracticalandpractical6;
public class Camera implements Switchable, SensorEnabled {
    private boolean isOn;
    private boolean sensorEnabled;
    private int sensitivityLevel;
    
    public Camera() {
        this.isOn = false;
        this.sensorEnabled = false;
        this.sensitivityLevel = 5; // Default sensitivity
    }
    
    public void setSensitivity(int level) {
        if (SensorEnabled.isValidSensitivity(level)) {
            this.sensitivityLevel = level;
            System.out.println("Camera sensitivity set to " + level);
        } else {
            System.out.println("Invalid sensitivity level");
        }
    }
    
    @Override
    public void turnOn() {
        if (Switchable.isValidPowerState(true)) {
            this.isOn = true;
            System.out.println("Camera turned on");
        }
    }
    
    @Override
    public void turnOff() {
        if (Switchable.isValidPowerState(false)) {
            this.isOn = false;
            this.sensorEnabled = false;
            System.out.println("Camera turned off");
        }
    }
    
    @Override
    public String getStatus() {
        return isOn ? 
            "Camera is ON (Sensor: " + (sensorEnabled ? "enabled" : "disabled") + ")" : 
            "Camera is OFF";
    }
    
    @Override
    public void enableSensor() {
        if (isOn) {
            this.sensorEnabled = true;
            System.out.println("Motion sensor enabled");
        } else {
            System.out.println("Turn on camera first");
        }
    }
    
    @Override
    public void disableSensor() {
        this.sensorEnabled = false;
        System.out.println("Motion sensor disabled");
    }
    
    @Override
    public boolean detectMotion() {
        if (!isOn || !sensorEnabled) {
            return false;
        }
        // Simulate motion detection
        boolean motionDetected = Math.random() < (sensitivityLevel / 10.0);
        if (motionDetected) {
            System.out.println("Motion detected!");
        }
        return motionDetected;
    }
    
    @Override
    public String getSensorStatus() {
        return "Sensor is " + (sensorEnabled ? "enabled" : "disabled") + 
               " (Sensitivity: " + sensitivityLevel + ")";
    }
}
