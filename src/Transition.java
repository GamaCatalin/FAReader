public class Transition {
    private String stateA;
    private String stateB;
    private String path;

    public Transition(String stateA, String stateB, String path) {
        this.stateA = stateA;
        this.stateB = stateB;
        this.path = path;
    }

    public String getStateA() {
        return stateA;
    }

    public String getStateB() {
        return stateB;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return stateA + " -> " + stateB + " : " + path;
    }
}
