package atividade;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Leocassio
 */
public class Tratamento implements Runnable {

    private Socket conexao; //Crindo um atributo 

    public Tratamento(Socket conexao) {
        this.conexao = conexao;
    }

    @Override
    public void run() {
        try {
            System.out.println("Conexão efetuada " + conexao.getInetAddress().getHostAddress());

            Scanner leitura = new Scanner(conexao.getInputStream());
            PrintStream escrita = new PrintStream(conexao.getOutputStream());
            String mensagem;
            
            String mensagemTratada = "Menu"; //Aqui seria o local do menu 
            escrita.println(mensagemTratada);
            
            while ((mensagem = leitura.nextLine()) != null) {
                System.out.println(mensagem);
            }

            leitura.close();
            conexao.close();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
