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
            System.out.println("Aguardando conexão");

            while (true) {
                Socket conexao = servidor.accept();
                Tratamento tratamento = new Tratamento(conexao);
                Thread thread = new Thread(tratamento);
                thread.start();
            }
                
                
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
