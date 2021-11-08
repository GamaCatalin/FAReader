import java.io.*;
import java.util.*;

public class FiniteAutomaton {

    private ArrayList<String> states = new ArrayList<>();
    private ArrayList<String> alphabet = new ArrayList<>();
    private ArrayList<String> finalStates = new ArrayList<>();
    private String initialState = "";
//    private Map<String, HashMap<String, String>> transitions = new HashMap<>();
    private ArrayList<Transition> transitions = new ArrayList<>();


    public FiniteAutomaton() {
        this.readAutomaton();
    }

    private void readAutomaton() {
        try(BufferedReader reader = new BufferedReader(new FileReader("fa.in"))) {

            String statesString = reader.readLine();
            Collections.addAll(this.states, statesString.split(" "));

            String alphabetString = reader.readLine();
            Collections.addAll(this.alphabet, alphabetString.split(" "));

            String finalStatesString = reader.readLine();
            Collections.addAll(this.finalStates, finalStatesString.split(" "));


            String initialStateString = reader.readLine();
            this.initialState = initialStateString;



            String transitionString = reader.readLine();
            while(transitionString!=null){
                String[] trans = transitionString.split("-");
                Transition transition = new Transition(trans[0], trans[1], trans[2].strip());

                this.transitions.add(transition);

                transitionString = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<String> getStates() {
        return states;
    }

    public ArrayList<String> getAlphabet() {
        return alphabet;
    }

    public ArrayList<String> getFinalStates() {
        return finalStates;
    }

    public String getInitialState() {
        return initialState;
    }

    public ArrayList<Transition> getTransitions() {
        return transitions;
    }

    public boolean isAccepted(String[] sequence){

        String currentState = this.initialState;

        for(String sChar : sequence){
            boolean foundOne = false;
            for(Transition trans : this.transitions){
                if (trans.getStateA().equals(currentState)){
                    if(trans.getPath().equals(sChar)){
                        currentState = trans.getStateB();
//                        System.out.println("Went from " + trans.getStateA() + " to " + trans.getStateB() + " through " + trans.getPath());
                        foundOne = true;
                        break;
                    }
                }
            }
            if(!foundOne){
                return false;
            }
        }

        if(!this.finalStates.contains(currentState)){
            return false;
        }

        return true;
    }
}
