import java.util.Random;
import java.util.Scanner;

public class Jogo {
    private Jogador melhorJogador;
    private int numeroJogadas;

    public Jogo(Jogador melhorJogador) {
        this.melhorJogador = melhorJogador;
        this.numeroJogadas = 0;
    }


    public Jogador getMelhorJogador() {
        return melhorJogador;
    }

    public void setMelhorJogador(Jogador melhorJogador) {
        this.melhorJogador = melhorJogador;
    }

    public void jogar() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Bem-vindo ao jogo Pedra, Papel e Tesoura!");

        while (true) {
            System.out.println("Escolha sua jogada (pedra, papel ou tesoura):");
            String jogadaJogador = scanner.nextLine().toLowerCase();


            String[] jogadasPossiveis = {"pedra", "papel", "tesoura"};
            int indiceJogadaSistema = random.nextInt(3);
            String jogadaSistema = jogadasPossiveis[indiceJogadaSistema];

            System.out.println("O sistema escolheu: " + jogadaSistema);


            String resultado = determinarResultado(jogadaJogador, jogadaSistema);
            System.out.println(resultado);


            this.numeroJogadas++;


            if (resultado.equals("Você ganhou!")) {
                this.melhorJogador.adicionaPontos();
            }

            System.out.println("Deseja jogar novamente? (s/n)");
            String continuar = scanner.nextLine().toLowerCase();
            if (!continuar.equals("s")) {
                break;
            }
        }
    }

    private String determinarResultado(String jogadaJogador, String jogadaSistema) {
        if (jogadaJogador.equals(jogadaSistema)) {
            return "Empate!";
        } else if ((jogadaJogador.equals("pedra") && jogadaSistema.equals("tesoura")) ||
                (jogadaJogador.equals("papel") && jogadaSistema.equals("pedra")) ||
                (jogadaJogador.equals("tesoura") && jogadaSistema.equals("papel"))) {
            return "Você ganhou!";
        } else {
            return "Você perdeu!";
        }
    }
}
