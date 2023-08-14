package projeto;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int quantidadeLogs = Integer.parseInt(scan.nextLine());

        Map<String, Integer> eventosPorServico = new HashMap<>();
        preencherEventosPorServico(scan, quantidadeLogs, eventosPorServico);

        String maiorServico = encontrarMaiorServico(eventosPorServico);
        String menorServico = encontrarMenorServico(eventosPorServico);

        imprimirResultados(eventosPorServico, maiorServico, menorServico);
    }

    private static void preencherEventosPorServico(Scanner scanner, int quantidadeLogs, Map<String, Integer> eventosPorServico) {
        for (int i = 0; i < quantidadeLogs; i++) {
            String[] linha = scanner.nextLine().split(",", 3);
            String nomeServico = linha[1];
            eventosPorServico.put(nomeServico, eventosPorServico.getOrDefault(nomeServico, 0) + 1);
        }
    }

    private static String encontrarMaiorServico(Map<String, Integer> eventosPorServico) {
        return Collections.max(eventosPorServico.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private static String encontrarMenorServico(Map<String, Integer> eventosPorServico) {
        return Collections.min(eventosPorServico.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private static void imprimirResultados(Map<String, Integer> eventosPorServico, String maiorServico, String menorServico) {
        System.out.println("Eventos por servico:");
        eventosPorServico.forEach((nomeServico, quantidade) -> {
            System.out.println(nomeServico + ":" + quantidade);
        });

        System.out.println("Maior:" + maiorServico);
        System.out.println("Menor:" + menorServico);
    }

}
