package enums;

public enum Value {
    TWO("2", 2),
    THREE("3",3),
    FOUR("4",5),
    FIVE("5",5),
    SIX("6",6),
    SEVEN("7",7),
    EIGHT("8",8),
    NINE("9",9),
    TEN("10",10),
    JACK("J",10),
    QUEEN("Q",10),
    KING("K",10),
    ACE("A",11);

    private final String label;
    private final int value;

    Value(String label, int value) {
        this.label = label;
        this.value = value;
    }

    @Override
    public String toString() {
        return this.label;
    }

    public int getValue(){
        return value;






























    }
}
