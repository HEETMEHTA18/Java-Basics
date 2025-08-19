public class SmartHomeDemo {
    public static void main(String[] args) {
        // Create devices
        Light light = new Light();
        Fan fan = new Fan();
        Thermostat thermostat = new Thermostat();
        Camera camera = new Camera();
        
        // Demonstrate Light functionality
        System.out.println("\n=== Light Demo ===");
        light.turnOn();
        System.out.println(light.getStatus());
        light.schedule("14:30");
        System.out.println("Is light scheduled? " + light.isScheduled());
        light.turnOff();
        
        // Demonstrate Fan functionality
        System.out.println("\n=== Fan Demo ===");
        fan.turnOn();
        fan.setSpeed(3);
        System.out.println(fan.getStatus());
        fan.schedule("18:00");
        fan.turnOff();
        
        // Demonstrate Thermostat functionality
        System.out.println("\n=== Thermostat Demo ===");
        thermostat.turnOn();
        thermostat.setTemperature(24.5);
        System.out.println(thermostat.getStatus());
        thermostat.schedule("22:00");
        thermostat.turnOff();
        
        // Demonstrate Camera functionality
        System.out.println("\n=== Camera Demo ===");
        camera.turnOn();
        camera.setSensitivity(8);
        camera.enableSensor();
        System.out.println(camera.getStatus());
        System.out.println(camera.getSensorStatus());
        camera.detectMotion();
        camera.disableSensor();
        camera.turnOff();
    }
}
