package Personagens;

import java.util.ArrayList;
import Habilidades.HabilidadesEspeciais;

public class Guerreiro extends Personagem implements HabilidadesEspeciais {
    public Guerreiro(String nome) {
        super(nome, 150, 25, 8, new ArrayList<>());
    }
    @Override
    //Causa o dobro do ataque normal, mas se o inimigo defende, sua defesa é descontada do dano.
    public void usarHabilidadeEspecial(Personagem alvo, boolean inimigoDefendeu) {
        int dano = getAtaque() * 2;

        if (inimigoDefendeu) {
            dano -= alvo.getDefesa();
        }

        if (dano < 0) {
            dano = 0;
        }

        alvo.tomarDano(dano);
    }
}