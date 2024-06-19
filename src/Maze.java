import java.io.*;
public class Maze {
    private String filename;

    public Maze(String filename) throws IOException{
        this.filename = filename;
        
        FileReader leitorArquivo = new FileReader(filename);
        BufferedReader leitor = new BufferedReader(leitorArquivo);

        String linha;
        
        while ((linha = leitor.readLine()) != null) {
            System.out.println(linha);
        }

        leitor.close();
        System.out.println(linha);
    }
}
