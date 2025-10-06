abstract class Instrument {
    abstract void play();
    abstract String what();
    abstract void adjust();
}

class Wind extends Instrument {
    public void play() {
        System.out.println("Wind instrument played");
    }
    
    public String what() {
        return "Wind";
    }
    
    public void adjust() {
        System.out.println("Wind instrument tuned properly");
    }
}

class Percussion extends Instrument {
    public void play() {
        System.out.println("Percussion instrument played");
    }
    
    public String what() {
        return "Percussion";
    }
    
    public void adjust() {
        System.out.println("Percussion instrument tuned properly");
    }
}

class Stringed extends Instrument {
    public void play() {
        System.out.println("Stringed instrument played");
    }
    
    public String what() {
        return "Stringed";
    }
    
    public void adjust() {
        System.out.println("Stringed instrument tuned properly");
    }
}

class Woodwind extends Wind {
    public void play() {
        System.out.println("Woodwind instrument played");
    }
    
    public String what() {
        return "Woodwind";
    }
}

class Brass extends Wind {
    public void play() {
        System.out.println("Brass instrument played");
    }
    
    public String what() {
        return "Brass";
    }
}

public class InstrumentDemo {
    public static void main(String[] args) {
        System.out.println("=== Musical Instrument Management ===\n");
        
        Wind wind = new Wind();
        wind.play();
        System.out.println("Instrument name: " + wind.what());
        wind.adjust();
        System.out.println();

        Percussion percussion = new Percussion();
        percussion.play();
        System.out.println("Instrument name: " + percussion.what());
        percussion.adjust();
        System.out.println();

        Stringed stringed = new Stringed();
        stringed.play();
        System.out.println("Instrument name: " + stringed.what());
        stringed.adjust();
        System.out.println();

        Woodwind woodwind = new Woodwind();
        woodwind.play();
        System.out.println("Instrument name: " + woodwind.what());
        woodwind.adjust();
        System.out.println();

        Brass brass = new Brass();
        brass.play();
        System.out.println("Instrument name: " + brass.what());
        brass.adjust();
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Student: 24CE064 HEET MEHTA");
        System.out.println("=".repeat(50));
    }
}
