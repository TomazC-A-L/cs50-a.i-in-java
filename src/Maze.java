import java.io.*;
public class Maze {
    private String filename;
    private int height;
    private int width;
    private Node start;
    private Node goal;


    public Maze(String filename) throws IOException{
        this.filename = filename;
        
        FileReader leitorArquivo = new FileReader(filename);
        BufferedReader leitor = new BufferedReader(leitorArquivo);

        String linha;
        
        //Read file and set height and width of maze
        while ((linha = leitor.readLine()) != null) {
            System.out.println(linha);
        }
        leitor.close();

        int cont = 0;

        for (char c : linha.toCharArray()) {
            if (c == 'A')
                cont++;
            if (cont>1)
                System.out.println("maze must have exactly one start point");
                cont = 0;
                return;
        }
        //validate start and goal
        for (char c : linha.toCharArray()) {
            if (c == 'B')
                cont++;
            if (cont>1)
                System.out.println("maze must have exactly one goal");
                cont = 0;
                return;
        }
        //Determine height and width of maze
        String[] content = linha.split("\n");

        height = content.length;
        width = content[0].length();

        //Keep track of walls

        for (int i = 0; i < height; i++) {

        }
    }
}
