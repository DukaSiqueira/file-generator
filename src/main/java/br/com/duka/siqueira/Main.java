package br.com.duka.siqueira;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        File pasta = new File("generator");
        if (!pasta.exists()) {
            pasta.mkdir();
        }

        File arquivo = new File(pasta, "arquivo.txt");

        try {
            FileWriter writer = new FileWriter(arquivo);
            PrintWriter printWriter = new PrintWriter(writer);
            for (int i = 1; i <= 10; i++) {
                printWriter.printf("9 x %d = %d%n", i, 9 * i);
            }
            printWriter.close();

            BufferedReader reader = new BufferedReader(new FileReader(arquivo));
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
            reader.close();

            if (arquivo.delete()) {
                System.out.println("O arquivo foi excluído com sucesso.");
            } else {
                System.out.println("Falha ao excluir o arquivo.");
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao manipular o arquivo: " + e.getMessage());
        }
    }
}