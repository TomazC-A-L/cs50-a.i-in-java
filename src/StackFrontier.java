import java.util.LinkedList;
import java.util.Queue;

public class StackFrontier {
    private Queue<Node> frontier;

    public StackFrontier() {
        frontier = new LinkedList<>();
    }

    public void add (Node state) {
        frontier.add(state);
    }

    public boolean contains_state(Node state) {
        return frontier.contains(state);
    }
    
    public void remove(){
        frontier.poll();
    } 
}
