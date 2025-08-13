class Wind {
    void play() {
        System.out.println("Wind instrument played");
    }
    String what() {
        return "Wind";
    }
    void adjust() {
        System.out.println("Instrument tuned properly");
    }
}

class Percussion {
    void play() {
        System.out.println("Percussion instrument played");
    }
    String what() {
        return "Percussion";
    }
    void adjust() {
        System.out.println("Instrument tuned properly");
    }
}

class Stringed {
    void play() {
        System.out.println("Stringed instrument played");
    }
    String what() {
        return "Stringed";
    }
    void adjust() {
        System.out.println("Instrument tuned properly");
    }
}

class Woodwind {
    void play() {
        System.out.println("Woodwind instrument played");
    }
    String what() {
        return "Woodwind";
    }
    void adjust() {
        System.out.println("Instrument tuned properly");
    }
}

class Brass {
    void play() {
        System.out.println("Brass instrument played");
    }
    String what() {
        return "Brass";
    }
    void adjust() {
        System.out.println("Instrument tuned properly");
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
