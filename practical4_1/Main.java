package practical4_1;
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
        System.out.println("Instrument tuned properly");
    }
}

class Percussion extends Instrument {
    public void play() {
        System.out.println("Percussion  played");
    }
    public String what() {
        return "Percussion";
    }
    public void adjust() {
        System.out.println("Instrument  properly");
    }
}

class Stringed extends Instrument {
    public void play() {
        System.out.println("Stringed  played");
    }
    public String what() {
        return "Stringed";
    }
    public void adjust() {
        System.out.println("Instrument  properly");
    }
}

class Woodwind extends Wind {
    public void play() {
        System.out.println("Woodwind  played");
    }
    public String what() {
        return "Woodwind";
    }
}

class Brass extends Wind {
    public void play() {
        System.out.println("Brass  played");
    }
    public String what() {
        return "Brass";
    }
}

public class Main {
    public static void main(String[] args) {
        
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
    }
}
