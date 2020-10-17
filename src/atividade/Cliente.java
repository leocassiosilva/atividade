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
public class Cliente {

    public static void main(String[] args) {
        try {
            Socket conexao = new Socket("localhost", 999);
            System.out.println("Conexao efetuada");
            PrintStream saida = new PrintStream(conexao.getOutputStream());
            Scanner entrada = new Scanner(conexao.getInputStream());
            
            Scanner teclado = new Scanner(System.in);
            System.out.println(entrada.nextLine());
            
            boolean op = true;
            String mensagem; 
            do {
                mensagem = teclado.nextLine();
                saida.println(mensagem);
                System.out.println(entrada.nextLine());
                
            } while (op);
           
            teclado.close();
            saida.close();
            conexao.close();

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
