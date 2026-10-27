package Personagens;

import java.util.List;
import java.util.ArrayList;

public class Personagem {
    protected String nome;
    protected int vida;
    protected int vidaMaxima;
    protected int ataque;
    protected int defesa;
    protected List<String> inventario = new ArrayList<>();

    public Personagem(String nome, int vida, int ataque, int defesa, List<String> inventario){
        this.nome = nome;
        this.vida = vida;
        this.vidaMaxima = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.inventario = inventario;
        inventario.add("Poção de cura");
        inventario.add("Poção de cura");
        inventario.add("Poção de cura");
        inventario.add("Golpe especial");
        inventario.add("Golpe especial");
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }
    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public int getAtaque() {
        return ataque;
    }
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }
    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public List<String> getInventario() {
        return inventario;
    }
    public void setInventario(List<String> inventario) {
        this.inventario = inventario;
    }

    public void atacar(Personagem alvo){
         int dano = ataque - alvo.getDefesa();
         if (dano<0){
            dano=0;
         }
        alvo.tomarDano(dano);
    }

    public void defender (){
        System.out.println(nome + " escolheu defender!");
    }

    public void tomarDano(int dano) {
        vida -= dano;
        if (vida < 0) {
            vida = 0;
        }
    }

    public void curar(int vidaRecuperada){
        if ((vida + vidaRecuperada) > vidaMaxima){
            vida = vidaMaxima;
        } else {
            vida += vidaRecuperada;
        }
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void golpeEspecial(Personagem alvo, boolean defendendo) {
        int ataqueEspecial = (int) (ataque * 1.5);
        int dano = ataqueEspecial;

        if (defendendo) {
            dano -= alvo.getDefesa();
        }

        if (dano < 0) {
            dano = 0;
        }
        alvo.tomarDano(dano);

        System.out.println(nome + " usou o golpe especial!");
        System.out.println("Causou " + dano + " de dano no " + alvo.getNome());
    }

}