import java.util.ArrayList;

public class Main {

        public static void main(String[] args) {
            Personagem p1 = new Personagem("Guerreiro", 100, 25, 12, new ArrayList<>());
            Personagem p2 = new Personagem("Goblin", 60, 15, 3, new ArrayList<>());

            p1.atacar(p2);
            System.out.println("Vida do Goblin: " + p2.getVida());

            p2.tomarDano(10);
            System.out.println("Vida do Goblin: " + p2.getVida());

            p2.defender();

            System.out.println("Goblin está vivo? " + p2.estaVivo());
        }
    }