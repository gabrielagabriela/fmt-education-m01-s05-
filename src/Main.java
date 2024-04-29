import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {


        List<Jogador> melhoresJogadores = new ArrayList<>();

        Jogador jogo01 = new Jogador("Joao", 29, 1,0);

        incluirJogadorLista(melhoresJogadores, jogo01);

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
}
