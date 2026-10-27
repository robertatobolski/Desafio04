import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Personagens.Personagem;
import Personagens.Guerreiro;
import Personagens.Mago;
import Personagens.Arqueiro;

import Inimigos.Goblin;
import Inimigos.Esqueleto;
import Inimigos.Troll;
import Inimigos.Zumbi;
import Inimigos.Demogorgon;
import Inimigos.Inimigo;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int quantidadeInimigo = random.nextInt(3, 6);
        List<String> tiposInimigos = new ArrayList<>();
        tiposInimigos.add("Goblin");
        tiposInimigos.add("Esqueleto");
        tiposInimigos.add("Troll");
        tiposInimigos.add("Zumbi");

        Collections.shuffle(tiposInimigos);

        List<String> inimigosPartida = new ArrayList<>();

        if (quantidadeInimigo < 5) {
            for (int i = 0; i < quantidadeInimigo; i++) {
                inimigosPartida.add(tiposInimigos.get(i));
            }
        } else {
            for (int i = 0; i < 4; i++) {
                inimigosPartida.add(tiposInimigos.get(i));
            }
            int posicao = random.nextInt(4);
            String tipoRepetido = tiposInimigos.get(posicao);

            String ultimoTipo = inimigosPartida.get(3);

            while (tipoRepetido.equals(ultimoTipo)) {
                posicao = random.nextInt(4);
                tipoRepetido = tiposInimigos.get(posicao);
            }

            inimigosPartida.add(tipoRepetido);
        }
        inimigosPartida.add("Demogorgon");

        List<Inimigo> inimigosDaPartida = new ArrayList<>();

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

        System.out.println("ESCOLHA SEU PERSONAGEM\n" +
                "1 - Guerreiro (150 de vida, 25 de ataque, 8 de defesa)\n" +
                "2 - Mago (120 de vida, 35 de ataque, 5 de defesa)\n" +
                "3 - Arqueiro (100 de vida, 30 de ataque, 12 de defesa)");

        int personagem = sc.nextInt();

        while (personagem < 1 || personagem > 3) {
            System.out.println("Digite um número válido:");
            personagem = sc.nextInt();
        }

        sc.nextLine();

        System.out.println("Digite o nome do personagem:");
        String nome = sc.nextLine().trim();

        while (nome.isEmpty()) {
            System.out.println("O nome não pode ficar vazio!");
            System.out.println("Digite o nome do personagem:");
            nome = sc.nextLine().trim();
        }

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

        System.out.println("\n=== SEU PERSONAGEM ===");
        System.out.println("Nome: " + jogador.getNome());
        System.out.println("Vida: " + jogador.getVida());
        System.out.println("Ataque: " + jogador.getAtaque());
        System.out.println("Defesa: " + jogador.getDefesa());
        System.out.println("Inventário: " + jogador.getInventario());

        System.out.println("\n=== INIMIGOS DA PARTIDA ===");

        for (int i = 0; i < inimigosDaPartida.size(); i++) {
            Inimigo inimigo = inimigosDaPartida.get(i);

            while (jogador.getVida() > 0 && inimigo.getVida() > 0) {
                exibirStatus(jogador, inimigo, i + 1, inimigosDaPartida.size());
                turnoDoJogador(jogador, inimigo, sc, random);
            }

            if (jogador.getVida() <= 0) {
                System.out.println("Você foi derrotado!");
                break;
            } else {
                System.out.println("Você derrotou o inimigo!");
            }
        }

        if (jogador.getVida() > 0) {
            System.out.println("PARABÉNS! Você derrotou todos os inimigos e venceu a partida!");
        }
    }

    public static void exibirInimigo(Inimigo inimigo) {
        System.out.println("\nTipo: " + inimigo.getTipo());
        System.out.println("Nome: " + inimigo.getNome());
        System.out.println("Vida: " + inimigo.getVida());
        System.out.println("Ataque: " + inimigo.getAtaque());
        System.out.println("Defesa: " + inimigo.getDefesa());
    }



    public static void exibirStatus(Personagem jogador, Inimigo inimigo, int numeroInimigo, int totalInimigos) {
        System.out.println("\n======= STATUS DA BATALHA =======");
        System.out.println("Inimigo " + numeroInimigo + " de " + totalInimigos);

        System.out.println("\n=== SEU PERSONAGEM ===");
        System.out.println("Nome: " + jogador.getNome());
        System.out.println("Vida: " + jogador.getVida() + "/" + jogador.getVidaMaxima());
        System.out.println("Ataque: " + jogador.getAtaque());
        System.out.println("Defesa: " + jogador.getDefesa());

        System.out.println("\n=== INIMIGO ATUAL ===");
        System.out.println("Nome: " + inimigo.getNome());
        System.out.println("Vida: " + inimigo.getVida());
        System.out.println("Ataque: " + inimigo.getAtaque());
        System.out.println("Defesa: " + inimigo.getDefesa());
    }



    public static void turnoDoJogador (Personagem jogador, Inimigo inimigo, Scanner sc, Random random){
        System.out.println("\nEscolha uma ação: ");
        System.out.println("1- Atacar");
        System.out.println("2- Defender");
        System.out.println("3- Usar poção de cura");
        System.out.println("4- Golpe especial");
        int acao = sc.nextInt();

        while (acao < 1 || acao > 4) {
            System.out.println("Digite um número válido:");
            acao = sc.nextInt();
        }

        int acaoInimigo;
        switch (acao){
            case 1:
                acaoInimigo = turnoDoInimigo(inimigo, random);

                if (acaoInimigo == 1) {
                    inimigo.tomarDano(jogador.getAtaque());
                    jogador.tomarDano(inimigo.getAtaque());
                } else {
                    int dano = jogador.getAtaque() - inimigo.getDefesa();

                    if (dano < 0) {
                        dano = 0;
                    }
                    inimigo.tomarDano(dano);
                }
                break;

            case 2:
                acaoInimigo = turnoDoInimigo(inimigo, random);

                if (acaoInimigo == 1) {
                    int dano = inimigo.getAtaque() - jogador.getDefesa();

                    if (dano < 0) {
                        dano = 0;
                    }
                    jogador.tomarDano(dano);
                }
                break;

            case 3:
                if (!jogador.getInventario().contains("Poção de cura")) {
                    System.out.println("Você não tem mais poções");
                } else if (jogador.getVidaMaxima() - jogador.getVida() < 20){
                    System.out.println("Você precisa perder no mínimo 20 de vida para usar este item.");
                } else {
                    jogador.curar(20);
                    jogador.getInventario().remove("Poção de cura");
                    System.out.println("Poção utilizada! Vida atual: " + jogador.getVida());
                }
                break;

            case 4:
                if (jogador.getInventario().contains("Golpe especial")) {
                    jogador.getInventario().remove("Golpe especial");
                    acaoInimigo = turnoDoInimigo(inimigo, random);

                    if (acaoInimigo == 1) {
                        jogador.golpeEspecial(inimigo, false);
                        jogador.tomarDano(inimigo.getAtaque());
                    } else {
                        jogador.golpeEspecial(inimigo, true);
                    }

                } else {
                    System.out.println("Você já usou seu golpe especial nesta partida!");
                }
                break;
        }
    }

    public static int turnoDoInimigo(Inimigo inimigo, Random random) {
        int sorteio = random.nextInt(100);

        if (sorteio < 70) {
            System.out.println(inimigo.getNome() + " escolheu atacar!");
            return 1;
        } else {
            System.out.println(inimigo.getNome() + " escolheu defender!");
            return 2;
        }
    }
}