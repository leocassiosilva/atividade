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
            Socket conexao = new Socket("localhost", 999); // Crinado a conexão
            System.out.println("Conexao efetuada"); //Mansagem para informa que a conexeão foi efetuada
            
            PrintStream saida = new PrintStream(conexao.getOutputStream()); //serve para escrever os dados
           
            Scanner entrada = new Scanner(conexao.getInputStream()); //serve para ler os dados de algum lugar 
            
            Scanner teclado = new Scanner(System.in); //Ler os dados 
                      
            System.out.println(entrada.nextLine()); //recebe os dados vindo do servidor 
            
            
            boolean op = true;
            String mensagem; 
            do {
                mensagem = teclado.nextLine(); // recebe um valor digitado e armazena na variavel mensagem
                saida.println(mensagem); //Envia para o servidor 
                System.out.println(entrada.nextLine()); //apresenta a resposta vinda do servidor
            } while (op);
           
            teclado.close(); // encerra a leitura
            saida.close();// encerra a a saida
            conexao.close();// encerra a conexão com o servidor

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
