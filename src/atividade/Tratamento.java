package atividade;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
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

            String mensagem;

            while ((mensagem = leitura.nextLine()) != null) {
                System.out.println(mensagem);
            }

            leitura.close();
            conexao.close();
        } catch (IOException e) {
        }
    }
}
