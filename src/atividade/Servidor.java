package atividade;

import java.io.IOException;
import java.net.ServerSocket;
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
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
