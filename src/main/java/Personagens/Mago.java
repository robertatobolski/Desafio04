package Personagens;

import java.util.ArrayList;
import Habilidades.HabilidadesEspeciais;

public class Mago extends Personagem implements HabilidadesEspeciais {
    public Mago(String nome) {
        super(nome, 100, 30, 12, new ArrayList<>());
    }
    @Override
    //Troca a vida atual do Mago com a do Inimigo atual, sem limitar a recuperação à vida máxima.
    public void usarHabilidadeEspecial(Personagem alvo, boolean inimigoDefendeu) {
        int vidaMago = getVida();
        int vidaInimigo = alvo.getVida();

        setVida(vidaInimigo);
        alvo.setVida(vidaMago);
    }
}