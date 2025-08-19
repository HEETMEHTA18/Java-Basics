public class Fan implements Switchable, Schedulable {
    private boolean isOn;
    private String scheduledTime;
    private int speed;
    
    public Fan() {
        this.isOn = false;
        this.scheduledTime = null;
        this.speed = 0;
    }
    
    public void setSpeed(int speed) {
        if (speed >= 0 && speed <= 5) {
            this.speed = speed;
            System.out.println("Fan speed set to " + speed);
        } else {
            System.out.println("Invalid speed level");
        }
    }
    
    @Override
    public void turnOn() {
        if (Switchable.isValidPowerState(true)) {
            this.isOn = true;
            this.speed = 1;
            System.out.println("Fan turned on");
        }
    }
    
    @Override
    public void turnOff() {
        if (Switchable.isValidPowerState(false)) {
            this.isOn = false;
            this.speed = 0;
            System.out.println("Fan turned off");
        }
    }
    
    @Override
    public String getStatus() {
        return isOn ? "Fan is ON (Speed: " + speed + ")" : "Fan is OFF";
    }
    
    @Override
    public void schedule(String time) {
        if (Schedulable.isValidTimeFormat(time)) {
            this.scheduledTime = time;
            System.out.println("Fan scheduled for " + time);
        } else {
            System.out.println("Invalid time format");
        }
    }
    
    @Override
    public void cancelSchedule() {
        this.scheduledTime = null;
        System.out.println("Fan schedule cancelled");
    }
}
