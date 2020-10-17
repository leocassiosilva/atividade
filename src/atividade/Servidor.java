package atividade;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leocassio
 */
public class Servidor {
    public static void main(String[] args) {
        try (ServerSocket servidor = new ServerSocket(999)){
            System.out.println("Aguardando conexão"); // Informa que o servidor está aguardando uma conexao 

            while (true) {
                Socket conexao = servidor.accept();  //inica conexao
                Tratamento tratamento = new Tratamento(conexao); //instancia o objeto tratamento  
                Thread thread = new Thread(tratamento); //Instanciar um objeto thread e passa como parametro um objeto tratamento
                thread.start(); //da start na thread
            }
                
                
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
