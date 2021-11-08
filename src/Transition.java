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
    public boolean equals(Object obj) {
        if(obj instanceof Transition){
            Transition trans = (Transition) obj;
            return trans.getStateA().equals(stateA) && trans.getStateB().equals(stateB) && trans.getPath().equals(path);
        }
        return false;
    }

    @Override
    public String toString() {
        return stateA + " -> " + stateB + " : " + path;
    }
}
