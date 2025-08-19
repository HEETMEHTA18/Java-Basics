public class Light implements Switchable, Schedulable {
    private boolean isOn;
    private String scheduledTime;
    
    public Light() {
        this.isOn = false;
        this.scheduledTime = null;
    }
    
    @Override
    public void turnOn() {
        if (Switchable.isValidPowerState(true)) {
            this.isOn = true;
            System.out.println("Light turned on");
        }
    }
    
    @Override
    public void turnOff() {
        if (Switchable.isValidPowerState(false)) {
            this.isOn = false;
            System.out.println("Light turned off");
        }
    }
    
    @Override
    public String getStatus() {
        return isOn ? "Light is ON" : "Light is OFF";
    }
    
    @Override
    public void schedule(String time) {
        if (Schedulable.isValidTimeFormat(time)) {
            this.scheduledTime = time;
            System.out.println("Light scheduled for " + time);
        } else {
            System.out.println("Invalid time format");
        }
    }
    
    @Override
    public void cancelSchedule() {
        this.scheduledTime = null;
        System.out.println("Light schedule cancelled");
    }
    
    @Override
    public boolean isScheduled() {
        return scheduledTime != null;
    }
}
