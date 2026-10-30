
package Principal;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Personagens.Personagem;
import Personagens.Guerreiro;
import Personagens.Mago;
import Personagens.Arqueiro;
import Habilidades.HabilidadesEspeciais;
import Inimigos.Goblin;
import Inimigos.Esqueleto;
import Inimigos.Troll;
import Inimigos.Zumbi;
import Inimigos.Demogorgon;
import Inimigos.Inimigo;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            iniciarJogo(sc);
        } finally {
            sc.close();
        }
    }

    public static void iniciarJogo(Scanner sc) {

        Random random = new Random();

        // Sorteia a quantidade de inimigos comuns (3 a 5).
        int quantidadeInimigo = random.nextInt(3, 6);

        // Lista os tipos de inimigos disponíveis.
        List<String> tiposInimigos = new ArrayList<>();
        tiposInimigos.add("Goblin");
        tiposInimigos.add("Esqueleto");
        tiposInimigos.add("Troll");
        tiposInimigos.add("Zumbi");

        // Embaralha os tipos para variar os inimigos de cada partida.
        Collections.shuffle(tiposInimigos);

        List<String> inimigosPartida = new ArrayList<>();

        // Se houver menos de 5 inimigos comuns, utiliza os primeiros tipos sorteados.
        if (quantidadeInimigo < 5) {
            for (int i = 0; i < quantidadeInimigo; i++) {
                inimigosPartida.add(tiposInimigos.get(i));
            }
        } else {
            // Se houver 5 inimigos comuns, utiliza os quatro tipos e repete um deles.
            inimigosPartida.addAll(tiposInimigos);

            String repetido = tiposInimigos.get(random.nextInt(4));

            // Evita que dois inimigos iguais fiquem um ao lado do outro.
            while (repetido.equals(inimigosPartida.get(inimigosPartida.size() - 1))) {
                repetido = tiposInimigos.get(random.nextInt(4));
            }

            inimigosPartida.add(repetido);
        }

        // O Demogorgon sempre será o último inimigo.
        inimigosPartida.add("Demogorgon");

        List<Inimigo> inimigosDaPartida = new ArrayList<>();

        // Cria os objetos dos inimigos de acordo com os tipos sorteados.
        for (String tipo : inimigosPartida) {
            switch (tipo) {
                case "Goblin":
                    inimigosDaPartida.add(new Goblin("Goblin"));
                    break;
                case "Esqueleto":
                    inimigosDaPartida.add(new Esqueleto("Esqueleto"));
                    break;
                case "Troll":
                    inimigosDaPartida.add(new Troll("Troll"));
                    break;
                case "Zumbi":
                    inimigosDaPartida.add(new Zumbi("Zumbi"));
                    break;
                case "Demogorgon":
                    inimigosDaPartida.add(new Demogorgon("Demogorgon"));
                    break;
            }
        }

        // Apresenta as opções de personagens.
        System.out.println("Escolha seu personagem:");
        System.out.println("1 - Guerreiro");
        System.out.println("2 - Mago");
        System.out.println("3 - Arqueiro");

        int personagem = lerNumero(sc);

        while (personagem < 1 || personagem > 3) {
            System.out.println("Opção inválida! Escolha entre 1 e 3.");
            personagem = lerNumero(sc);
        }

        System.out.println("Digite o nome do seu personagem:");
        String nome = sc.nextLine().trim();

        while (nome.isEmpty()) {
            System.out.println("O nome não pode ficar vazio. Digite novamente:");
            nome = sc.nextLine().trim();
        }

        // Cria o personagem escolhido pelo jogador.
        Personagem jogador = null;

        switch (personagem) {
            case 1:
                jogador = new Guerreiro(nome);
                break;
            case 2:
                jogador = new Mago(nome);
                break;
            case 3:
                jogador = new Arqueiro(nome);
                break;
        }

        System.out.println("\nPersonagem escolhido!");
        System.out.println("Nome: " + jogador.getNome());
        System.out.println("Vida: " + jogador.getVida());

        // Percorre todos os inimigos da partida.
        for (int i = 0; i < inimigosDaPartida.size(); i++) {

            Inimigo inimigo = inimigosDaPartida.get(i);

            System.out.println("\n================================");
            System.out.println("Inimigo " + (i + 1) + " de " + inimigosDaPartida.size());
            System.out.println("Um " + inimigo.getNome() + " apareceu!");
            System.out.println("================================");

            // Continua o combate enquanto ambos estiverem vivos.
            while (jogador.getVida() > 0 && inimigo.getVida() > 0) {

                exibirStatus(jogador, inimigo, i + 1, inimigosDaPartida.size());

                turnoDoJogador(jogador, inimigo, sc, random);
            }

            // Encerra a partida caso o jogador seja derrotado.
            if (jogador.getVida() <= 0) {
                break;
            }

            System.out.println("\n" + inimigo.getNome() + " foi derrotado!");
        }

        fimDeJogo(jogador);
    }

    // Exibe as informações do jogador e do inimigo atual.
    public static void exibirStatus(Personagem jogador, Inimigo inimigo,
                                    int numeroInimigo, int totalInimigos) {

        System.out.println("\n========== STATUS ==========");
        System.out.println("Inimigo " + numeroInimigo + " de " + totalInimigos);
        System.out.println(jogador.getNome() + " - Vida: " + jogador.getVida());
        System.out.println(inimigo.getNome() + " - Vida: " + inimigo.getVida());
        System.out.println("============================");
    }

    // Controla as ações disponíveis para o jogador durante o combate.
    public static void turnoDoJogador(Personagem jogador, Inimigo inimigo,
                                      Scanner sc, Random random) {

        System.out.println("\nEscolha sua ação:");
        System.out.println("1 - Atacar");
        System.out.println("2 - Defender");
        System.out.println("3 - Usar poção");
        System.out.println("4 - Habilidade especial");

        int acao = lerNumero(sc);

        while (acao < 1 || acao > 4) {
            System.out.println("Opção inválida! Escolha entre 1 e 4.");
            acao = lerNumero(sc);
        }

        // Executa a ação escolhida pelo jogador.
        switch (acao) {
            case 1:
                int ataqueInimigo = turnoDoInimigo(inimigo, random);

                if (ataqueInimigo == 1) {
                    jogador.tomarDano(inimigo.getAtaque());
                    inimigo.tomarDano(jogador.getAtaque());
                } else {
                    int dano = jogador.getAtaque() - inimigo.getDefesa();

                    if (dano < 0) {
                        dano = 0;
                    }

                    inimigo.tomarDano(dano);
                }
                break;

            case 2:
                int defesaInimigo = turnoDoInimigo(inimigo, random);

                if (defesaInimigo == 1) {
                    int dano = inimigo.getAtaque() - jogador.getDefesa();

                    if (dano < 0) {
                        dano = 0;
                    }

                    jogador.tomarDano(dano);
                }
                break;

            case 3:
                if (!jogador.getInventario().contains("Poção de cura")) {
                    System.out.println("Você não possui mais poções!");
                } else if (jogador.getVidaMaxima() - jogador.getVida() < 20) {
                    System.out.println("Você precisa ter perdido pelo menos 20 de vida para usar a poção!");
                } else {
                    jogador.setVida(jogador.getVida() + 20);
                    jogador.getInventario().remove("Poção de cura");

                    System.out.println("Você recuperou 20 pontos de vida!");
                }
                break;

            // Cada personagem pode usar sua habilidade especial duas vezes por partida.
            case 4:
                if (jogador.getUsosHabilidade() <= 0) {
                    System.out.println("Você já utilizou todas as suas habilidades especiais!");
                    break;
                }

                HabilidadesEspeciais habilidade = (HabilidadesEspeciais) jogador;

                // O Arqueiro utiliza sua habilidade sem permitir uma ação do inimigo.
                if (jogador instanceof Arqueiro) {
                    habilidade.usarHabilidadeEspecial(inimigo, false);
                } else {
                    int acaoInimigo = turnoDoInimigo(inimigo, random);

                    habilidade.usarHabilidadeEspecial(inimigo, acaoInimigo == 2);

                    if (acaoInimigo == 1) {
                        int dano = inimigo.getAtaque() - jogador.getDefesa();

                        if (dano < 0) {
                            dano = 0;
                        }

                        jogador.tomarDano(dano);
                    }
                }

                jogador.setUsosHabilidade(jogador.getUsosHabilidade() - 1);

                System.out.println("Habilidade especial utilizada!");
                break;
        }
    }

    // Define a ação do inimigo: atacar(retorna 1) ou defender(retorna 2).
    public static int turnoDoInimigo(Inimigo inimigo, Random random) {

        // Sorteia um número de 0 a 99.
        int sorteio = random.nextInt(100);

        // O inimigo tem 70% de chance de atacar.
        if (sorteio < 70) {
            System.out.println(inimigo.getNome() + " escolheu atacar!");
            return 1;
        } else {
            // O inimigo tem 30% de chance de defender.
            System.out.println(inimigo.getNome() + " escolheu defender!");
            return 2;
        }
    }

    // Lê um número e trata entradas que não sejam numéricas.
    public static int lerNumero(Scanner sc) {

        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite apenas números.");
            }
        }
    }

    // Exibe a mensagem final de vitória ou derrota.
    public static void fimDeJogo(Personagem jogador) {

        if (jogador.getVida() > 0) {
            System.out.println("\nPARABÉNS! Você derrotou todos os inimigos e venceu a partida!");
        } else {
            System.out.println("\nVocê foi derrotado!");
        }
    }
}
