package src;

interface InputValue {
    int fuelTaken(float fuel);
}

class F95 implements InputValue {
    @Override
    public int fuelTaken(float fuel) {
        return (int) fuel;
    }
    public float value(float fuel) {
        return fuel;
    }
}

class F98 implements InputValue {
    @Override
    public int fuelTaken(float fuel) {
        return (int) fuel;
    }
    public float value(float fuel) {
        return fuel;
    }
}

class Diesel implements InputValue {
    @Override
    public int fuelTaken(float fuel) {
        return (int) fuel;
    }
    public float total(float fuel) {
        return fuel;
    }
}

public class GasMeter {
    public static float totalFuelUsed(float fuel) {
        return fuel;
    }
    public static void main(String[] args) {
        float fuel = 10.0f;
        System.out.println("Total fuel used: " + totalFuelUsed(fuel));
    }
}
}
