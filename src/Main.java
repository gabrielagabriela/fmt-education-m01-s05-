import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Jogador> melhoresJogadores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        Jogador melhorJogador = criarNovoJogador(scanner, melhoresJogadores);

        Jogo jogo = new Jogo(melhorJogador);

        jogo.jogar();

        atualizarMelhoresJogadores(jogo, melhorJogador, melhoresJogadores);

        System.out.println("Melhores jogadores após o jogo:");
        exibirListaMelhoresJogadores(melhoresJogadores);
    }

    public static Jogador criarNovoJogador(Scanner scanner, List<Jogador> melhoresJogadores) {
        System.out.println("Informe o nome do jogador:");
        String nome = scanner.nextLine();

        while (nomeJaExiste(melhoresJogadores, nome)) {
            System.out.println("Este nome já está em uso. Por favor, escolha outro nome:");
            nome = scanner.nextLine();
        }

        System.out.println("Informe a idade do jogador:");
        int idade = Integer.parseInt(scanner.nextLine());
        System.out.println("Informe a pontuação inicial do jogador:");
        int pontuacao = Integer.parseInt(scanner.nextLine());
        System.out.println("Informe o número de tentativas do jogador:");
        int numeroTentativas = Integer.parseInt(scanner.nextLine());

        Jogador novoJogador = new Jogador(nome, idade, pontuacao, numeroTentativas);

        incluirJogadorLista(melhoresJogadores, novoJogador);

        return novoJogador;
    }

    public static void atualizarMelhoresJogadores(Jogo jogo, Jogador melhorJogador, List<Jogador> melhoresJogadores) {
        // Verificar se o jogador melhorou sua pontuação durante o jogo
        if (jogo.getMelhorJogador().getPontuacao() < melhorJogador.getPontuacao()) {
            jogo.setMelhorJogador(melhorJogador);
        }
    }

    public static void incluirJogadorLista(List<Jogador> melhoresJogadores, Jogador jogador) {
        if (melhoresJogadores.isEmpty()) {
            melhoresJogadores.add(jogador);
            return;
        }

        int i;
        for (i = 0; i < melhoresJogadores.size(); i++) {
            if (jogador.getPontuacao() > melhoresJogadores.get(i).getPontuacao()) {
                break;
            }
        }
        melhoresJogadores.add(i, jogador);
    }

    public static void exibirListaMelhoresJogadores(List<Jogador> melhoresJogadores) {
        int quantidadeExibida = Math.min(10, melhoresJogadores.size());

        for (int i = 0; i < quantidadeExibida; i++) {
            Jogador jogador = melhoresJogadores.get(i);
            System.out.println(jogador.formatarNomeEPosicao(i + 1));
        }
    }

    public static boolean nomeJaExiste(List<Jogador> jogadores, String nome) {
        for (Jogador jogador : jogadores) {
            if (jogador.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }
}
