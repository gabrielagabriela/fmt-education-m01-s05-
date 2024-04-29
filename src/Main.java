import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Jogador jogador = null;
        Jogo jogoPedraPapelTesoura = new Jogo(jogador);
        Jogo jogoAdivinhacao = new Jogo(jogador);

        while (true) {
            System.out.println("Bem-vindo ao Jogo!");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Identificar-se pelo nome");
            System.out.println("2 - Criar novo jogador");
            System.out.println("3 - Escolher jogo");
            System.out.println("4 - Encerrar o jogo");

            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("Informe seu nome:");
                    String nomeJogador = scanner.nextLine();
                    jogador = identificarJogador(nomeJogador);
                    break;
                case 2:
                    jogador = criarNovoJogador(scanner);
                    break;
                case 3:
                    escolherJogo(scanner, jogador, jogoPedraPapelTesoura, jogoAdivinhacao);
                    break;
                case 4:
                    System.out.println("Encerrando o jogo...");
                    return;
                default:
                    System.out.println("Opção inválida! Por favor, escolha novamente.");
                    break;
            }
        }
    }

    public static Jogador identificarJogador(String nome) {
        // Lógica para identificar o jogador pelo nome, se já existir
        return new Jogador(nome, 0, 0, 0); // Retornar um novo jogador por enquanto
    }

    public static Jogador criarNovoJogador(Scanner scanner) {
        System.out.println("Informe o nome do novo jogador:");
        String nome = scanner.nextLine();
        // Lógica para criar um novo jogador
        return new Jogador(nome, 0, 0, 0); // Retornar um novo jogador por enquanto
    }

    public static void escolherJogo(Scanner scanner, Jogador jogador, Jogo jogoPedraPapelTesoura, Jogo jogoAdivinhacao) {
        System.out.println("Escolha o jogo:");
        System.out.println("1 - Pedra, Papel e Tesoura");
        System.out.println("2 - Adivinhação de Números");

        int opcaoJogo = Integer.parseInt(scanner.nextLine());

        switch (opcaoJogo) {
            case 1:
                jogoPedraPapelTesoura.setMelhorJogador(jogador);
                jogoPedraPapelTesoura.jogar();
                break;
            case 2:
                jogoAdivinhacao.setMelhorJogador(jogador);
                System.out.println("Informe o número máximo para adivinhar:");
                int numMaximo = Integer.parseInt(scanner.nextLine());
                jogoAdivinhacao.jogar(numMaximo);
                break;
            default:
                System.out.println("Opção inválida! Por favor, escolha novamente.");
                break;
        }
    }
}
