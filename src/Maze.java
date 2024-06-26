import java.io.*;
import java.util.*;

import javafx.util.*;

public class Maze {
    private int height;
    private int width;
    private String filename;
    private boolean[][] walls;
    private Pair<Integer, Integer> start;
    private Pair<Integer, Integer> goal;
    private List<int[]> solutionPath;

    public Maze(String filename) throws IOException{
        this.filename = filename;
        
        FileReader leitorArquivo = new FileReader(filename);
        BufferedReader leitor = new BufferedReader(leitorArquivo);

        String linha;
        
        //Ler arquivo do labirinto
        while ((linha = leitor.readLine()) != null) {
            System.out.println(linha);
        }
        leitor.close();

        int cont = 0;

        //validar inicio e fim do labirinto
        for (char c : linha.toCharArray()) {
            if (c == 'A')
                cont++;
            if (cont>1)
                System.out.println("maze must have exactly one start point");
                cont = 0;
                return;
        }
        for (char c : linha.toCharArray()) {
            if (c == 'B')
                cont++;
            if (cont>1)
                System.out.println("maze must have exactly one goal");
                cont = 0;
                return;
        }
        //Determinar altura e largura do labirinto
        String[] content = linha.split("\n");

        height = content.length;
        width = content[0].length();

        //Definir as paredes e caminhos do labirinto
        for (int i = 0; i < height; i++) {
            boolean[] row = new boolean[width];

            for (int j = 0; j < width; j++) {
                //verifica se a posição atual é o inicio e salva seu index num Pair
                if(content[i].toCharArray()[j] == 'A') {
                    start = new Pair<Integer,Integer>(i, j);
                    row[j] = false;
                }
                //verifica se a posição atual é o final e salva seu index num Pair
                else if(content[i].toCharArray()[j] == 'B') {
                    goal = new Pair<Integer,Integer>(i,j);
                    row[j] = false;
                }
                //verifica se a posição atual é um caminho ou uma parede
                else if(content[i].toCharArray()[j] == ' ') {
                    row[j] = false;
                }
                else {
                    row[j] = true;
                }
            }
            walls[i] = row;
        }
    }
    
    //Este método retorna os estados vizinhos de um outro estado determinado
    public Map<String, Pair<Integer, Integer>> neighbors(Node state) {
        int row = state.getState().getKey();
        int col = state.getState().getValue();

        Map<String,Pair<Integer,Integer>> candidates = new HashMap();

        candidates.put("up",new Pair<>(row-1,col));
        candidates.put("down", new Pair<>(row+1,col));
        candidates.put("left", new Pair<>(row,col-1));
        candidates.put("right", new Pair<>(row+1,col+1));

        Map<String,Pair<Integer,Integer>> results = new HashMap();

        for (Map.Entry<String, Pair<Integer, Integer>> entry : candidates.entrySet()) {
            String direction = entry.getKey();

            int r = entry.getValue().getKey();
            int c = entry.getValue().getValue();

            if((r >= 0 && r <= height)&&(c >= 0 && c < width)&&(walls[r][c])){
                results.put(direction, new Pair<>(r,c));
            }
        }
        return results;
    }
    
    private boolean isOnSolutionPath(int row, int col) {
        if (solutionPath == null) {
            return false;
        }

        for (int[] step : solutionPath) {
            if (step[0] == row && step[1] == col) {
                return true;
            }
        }
        return false;
    }
    //este método irá printar o labirinto no terminal
    public void printMaze(List<int[]> solutionPath){
        this.solutionPath = solutionPath;
        for (int i = 0; i < walls.length; i++) {
            for (int j = 0; j < walls[i].length; j++) {
                if(walls[i][j]){
                    System.out.print("█");
                }
                else if (i == start.getValue() && j == start.getKey()) {
                    System.out.print("A");
                }else if (i == goal.getValue() && j == goal.getKey()) {
                    System.out.print("B");
                } else if (solutionPath != null && isOnSolutionPath(i, j)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
