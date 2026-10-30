package Inimigos;

import Personagens.Personagem;
import java.util.List;

// Herda os atributos e métodos de Personagem, acrescentando o atributo específico do tipo de inimigo.
    public class Inimigo extends Personagem {

    protected String tipo;

    public Inimigo(String nome, String tipo, int vida,
                   int ataque, int defesa, List<String> inventario) {
        super(nome, vida, ataque, defesa, inventario);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}