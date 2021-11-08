import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    FiniteAutomaton fa;
    Scanner scanner = new Scanner(System.in);

    public Menu(FiniteAutomaton fa) {
        this.fa = fa;
    }

    public void show(){
        boolean run = true;
        while(run){
            printMenu();
            int command = getCommand();
            switch (command){
                case 0:{
                    System.out.println("Exiting...");
                    run = false;
                    break;
                }
                case 1:{
                    printAutomaton();
                    break;
                }
                case 2:{
                    printStates();
                    break;
                }
                case 3:{
                    printAlphabet();
                    break;
                }
                case 4:{
                    printFinalStates();
                    break;
                }
                case 5:{
                    printInitialState();
                    break;
                }
                case 6:{
                    printTransitions();
                    break;
                }
                case 7:{
                    checkSequence();
                    break;
                }
                default:{
                    System.out.println("Wrong command!\n");
                }
            }
        }
    }

    private void checkSequence() {
        System.out.print("Enter a sequence: ");
        String sequence = scanner.nextLine();
        System.out.println();
        String[] sequenceChars = sequence.split("");
        boolean isValid = true;

        for(String sChar : sequenceChars){
            if(!fa.getAlphabet().contains(sChar)){
                isValid = false;
                System.out.println("'" + sChar + "' is not part of the alphabet!");
            }
        }

        if(isValid){
            boolean isAccepted = this.fa.isAccepted(sequenceChars);
            System.out.print("Sequence '" + sequence + "' is");
            if(isAccepted){
                System.out.print(" accepted");
            }
            else{
                System.out.print(" not accepted");
            }
            System.out.println();
        }
    }

    private void printTransitions() {
        ArrayList<Transition> transitions = fa.getTransitions();

        System.out.println("Transitions:");
        for(Transition transition : transitions){
            System.out.println("\t" + transition);
        }
    }

    private void printInitialState() {
        System.out.println("Initial state: " + fa.getInitialState());
    }

    private void printFinalStates() {
        ArrayList<String> states = fa.getFinalStates();

        System.out.println("Final states:");
        for(String state : states){
            System.out.println("\t" + state);
        }
    }

    private void printAlphabet() {
        ArrayList<String> alphabet = fa.getAlphabet();

        System.out.println("Alphabet:");
        for(String letter:alphabet){
            System.out.println("\t" + letter);
        }
    }

    private void printStates() {
        ArrayList<String> states = fa.getStates();

        System.out.println("States:");
        for(String state : states){
            System.out.println("\t" + state);
        }

    }

    private void printAutomaton() {
        ArrayList<String> states = fa.getStates();
        ArrayList<String> alphabet = fa.getAlphabet();
        ArrayList<String> finalStates = fa.getFinalStates();
        ArrayList<Transition> transitions = fa.getTransitions();


        System.out.println("Finite automaton: (Q,A,S,F,T)");
        System.out.println();


        boolean notFirst = false;
        System.out.print("Q = { ");
        for(String state : states){
            if(notFirst){
                System.out.print(",");
            }
            System.out.print(state);
            notFirst = true;
        }
        System.out.print(" }\n");

        notFirst = false;
        System.out.print("A = { ");
        for(String letter : alphabet){
            if(notFirst){
                System.out.print(",");
            }
            System.out.print(letter);
            notFirst = true;
        }
        System.out.print(" }\n");



        notFirst = false;
        System.out.print("F = { ");
        for(String state : finalStates){
            if(notFirst){
                System.out.print(",");
            }
            System.out.print(state);
            notFirst = true;
        }
        System.out.print(" }\n");

        System.out.println("S = " + fa.getInitialState());


        System.out.print("T = {");
        for(Transition transition : transitions){
            System.out.print("\n\t");
            System.out.print(transition);
        }
        System.out.println("\n\t}\n");

        System.out.println();
    }

    private int getCommand() {
        System.out.print("Enter a command: ");


        int command = -1;
        try{
            command = Integer.parseInt(scanner.nextLine());
        }
        catch(NumberFormatException e){

        }
        System.out.println();
        return command;
    }

    private void printMenu() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n**************Menu****************\n");
        builder.append("1) Print Automaton\n");
        builder.append("2) Print states\n");
        builder.append("3) Print alphabet\n");
        builder.append("4) Print final states\n");
        builder.append("5) Print initial state\n");
        builder.append("6) Print transitions\n");
        builder.append("7) Check sequence\n");
        builder.append("\n");
        builder.append("0) Exit\n");
        builder.append("**********************************\n");

        System.out.println(builder.toString());
        System.out.println();
    }
}
