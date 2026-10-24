import java.util.ArrayList;

public class Main {

        public static void main(String[] args) {
            Guerreiro g = new Guerreiro("Arthur");
            System.out.println("Guerreiro: " + g.getNome());
            System.out.println("Vida: " + g.getVida());
            System.out.println("Ataque: " + g.getAtaque());
            System.out.println("Defesa: " + g.getDefesa());
            System.out.println("Inventário: " + g.getInventario());

            Mago m = new Mago ("Edward");
            System.out.println("Mago: " + m.getNome());
            System.out.println("Vida: " + m.getVida());
            System.out.println("Ataque: " + m.getAtaque());
            System.out.println("Defesa: " + m.getDefesa());
            System.out.println("Inventário: " + m.getInventario());


            Arqueiro a = new Arqueiro("Leonard");
            System.out.println("Arqueiro: " + a.getNome());
            System.out.println("Vida: " + a.getVida());
            System.out.println("Ataque: " + a.getAtaque());
            System.out.println("Defesa: " + a.getDefesa());
            System.out.println("Inventário: " + a.getInventario());

            g.golpeEspecial(m);
        }
    }