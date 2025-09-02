package src.threadpracticalandpractical6;
public class Thermostat implements Switchable, Schedulable {
    private boolean isOn;
    private String scheduledTime;
    private double temperature;
    
    public Thermostat() {
        this.isOn = false;
        this.scheduledTime = null;
        this.temperature = 22.0; // Default temperature in Celsius
    }
    
    public void setTemperature(double temperature) {
        if (temperature >= 16.0 && temperature <= 30.0) {
            this.temperature = temperature;
            System.out.println("Temperature set to " + temperature + "°C");
        } else {
            System.out.println("Temperature must be between 16°C and 30°C");
        }
    }
    
    @Override
    public void turnOn() {
        if (Switchable.isValidPowerState(true)) {
            this.isOn = true;
            System.out.println("Thermostat turned on");
        }
    }
    
    @Override
    public void turnOff() {
        if (Switchable.isValidPowerState(false)) {
            this.isOn = false;
            System.out.println("Thermostat turned off");
        }
    }
    
    @Override
    public String getStatus() {
        return isOn ? 
            "Thermostat is ON (Set to: " + temperature + "°C)" : 
            "Thermostat is OFF";
    }
    
    @Override
    public void schedule(String time) {
        if (Schedulable.isValidTimeFormat(time)) {
            this.scheduledTime = time;
            System.out.println("Thermostat scheduled for " + time);
        } else {
            System.out.println("Invalid time format");
        }
    }
    
    @Override
    public void cancelSchedule() {
        this.scheduledTime = null;
        System.out.println("Thermostat schedule cancelled");
    }
}
