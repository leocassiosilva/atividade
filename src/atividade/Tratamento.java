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

            Scanner leitura = new Scanner(conexao.getInputStream()); //Utilizada para realizar a leitura 

            PrintStream escrita = new PrintStream(conexao.getOutputStream());

            
            boolean op = true;
           /*
            String menu = "1 - Refrigerante; 2 - Sanduiche; 3 - Batata Frita; 0 - Sair;";
            escrita.println(menu);]*/
           String mensagem;
            do {
                String menu = "1 - Refrigerante; 2 - Sanduiche; 3 - Batata Frita; 0 - Sair;";
                escrita.println(menu);
                mensagem = leitura.nextLine();
                System.out.println(mensagem);
                switch (mensagem) {
                    case "1":
                        System.out.println("Refrigerante");
                        break;
                    case "2":
                        System.out.println("Sanduiche");
                        break;
                    case "3":
                        System.out.println("Batata Frita");
                        break;
                    case "0":
                        System.out.println("Você saiu!");
                        break;
                    default:
                        System.out.println("Digite uma opção valida!!");
                }
            } while (op);

            leitura.close();
            conexao.close();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
