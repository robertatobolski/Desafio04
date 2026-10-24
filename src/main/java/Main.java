import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
            Scanner sc = new Scanner (System.in);

            System.out.println("ESCOLHA SEU PERSONAGEM (Digite o número desejado)\n" +
                    "1 - Guerreiro (150 de vida, 25 de ataque, 12 de defesa)\n" +
                    "2 - Mago (100 de vida, 35 de ataque, 5 de defesa)\n" +
                    "3 - Arqueiro (120 de vida, 30 de ataque, 8 de defesa)");
            int personagem = sc.nextInt();

            while (personagem < 1 || personagem > 3){
                System.out.println("Digite um número válido: ");
                personagem = sc.nextInt();
            }

            sc.nextLine();
            String nome;
            Personagem jogador = null;

            switch (personagem){
                case 1:
                    System.out.println("Digite o nome do Guerreiro: ");
                    nome = sc.nextLine();
                    jogador = new Guerreiro(nome);
                    System.out.println("Guerreiro " + nome + " criado");
                    break;
                case 2:
                    System.out.println("Digite o nome do Mago: ");
                    nome = sc.nextLine();
                    jogador = new Mago(nome);
                    System.out.println("Mago " + nome + " criado");
                    break;
                case 3:
                    System.out.println("Digite o nome do Arqueiro: ");
                    nome = sc.nextLine();
                    jogador = new Arqueiro(nome);
                    System.out.println("Arqueiro " + nome + " criado");
                    break;
            }

            System.out.println("\n=== SEU PERSONAGEM ===");
            System.out.println("Nome: " + jogador.getNome());
            System.out.println("Vida: " + jogador.getVida());
            System.out.println("Ataque: " + jogador.getAtaque());
            System.out.println("Defesa: " + jogador.getDefesa());
            System.out.println("Inventário: " + jogador.getInventario());
        }
    }