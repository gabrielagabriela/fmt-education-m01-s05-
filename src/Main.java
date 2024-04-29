import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        List<Jogador> melhoresJogadores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Pedir ao usuário para inserir os dados do jogador
        System.out.println("Informe o nome do jogador:");
        String nome = scanner.nextLine();

        // Validar se o nome já existe na lista de jogadores
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

        // Criar um novo jogador com os dados fornecidos
        Jogador novoJogador = new Jogador(nome, idade, pontuacao, numeroTentativas);

        // Adicionar jogador na lista de melhores jogadores
        incluirJogadorLista(melhoresJogadores, novoJogador);

        // Exibir lista de melhores jogadores
        exibirListaMelhoresJogadores(melhoresJogadores);
    }

    public static void incluirJogadorLista(List<Jogador> melhoresJogadores, Jogador jogador){
        if (melhoresJogadores.isEmpty()) {
            melhoresJogadores.add(jogador);
            return;
        }

        int i;
        for( i = 0; i < melhoresJogadores.size(); i++){
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
