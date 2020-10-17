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

public class Tratamento implements Runnable { //implementa o Runnable

    private Socket conexao; //Crindo um atributo de conexao 

    public Tratamento(Socket conexao) { //construtor da classe
        this.conexao = conexao;
    }

    @Override
    public void run() {
        try {
            System.out.println("Conexão efetuada " + conexao.getInetAddress().getHostAddress()); //Informar que a conexao foi efetuada

            Scanner leitura = new Scanner(conexao.getInputStream()); //Utilizada para realizar a leitura 

            PrintStream escrita = new PrintStream(conexao.getOutputStream()); //utilizada para escrita

            
            boolean op = true;
            float total = 0;
           
            
           String mensagem;
            do {
                String menu = "1 - Refrigerante; 2 - Sanduiche; 3 - Batata Frita; 0 - Sair;";
                escrita.println(menu); //manda para o cliente 
                mensagem = leitura.nextLine(); //recebe do cliente um numero
                System.out.println(mensagem);
                switch (mensagem) {
                    case "1":
                        System.out.println("Refrigerante");
                        total = (float) (total + 300);
                        break;
                    case "2":
                        System.out.println("Sanduiche");
                        total = (float) (total + 600);
                        break;
                    case "3":
                        System.out.println("Batata Frita");
                        total = (float) (total + 400);
                        break;
                    case "0":
                        System.out.println("Você saiu!");
                        System.out.println(total);
                        escrita.println(total); //manda para o cliente
                        op = false;
                        break;
                    default:
                        System.out.println("Digite uma opção valida!!");
                }
            } while (op);

            leitura.close(); //finaliza
            conexao.close();//finaliza
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
