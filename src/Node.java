/**
 * insira a descrição da classe
 * 
 * @author Tomaz Corrêa
 */
import java.util.*;

public class Node {

    private String state;
    private String parent;
    private int action;

    public Node(String state, String parent, int action) {
        this.state = state;
        this.parent = parent;
        this.action = action;
    }
}
