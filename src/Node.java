/**
 * insira a descrição da classe
 * 
 * @author Tomaz Corrêa
 */
import java.util.*;

import javafx.util.Pair;

public class Node {

    private Pair<Integer,Integer> state;
    private Pair<Integer,Integer> parent;
    private String action;

    public Node(Pair<Integer,Integer> state, Pair<Integer,Integer> parent, String action) {
        this.state = state;
        this.parent = parent;
        this.action = action;
    }

    public Pair<Integer, Integer> getState() {
        return state;
    }

    public Pair<Integer, Integer> getParent() {
        return parent;
    }

    public String getAction() {
        return action;
    }

}
