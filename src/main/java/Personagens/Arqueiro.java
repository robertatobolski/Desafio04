package Personagens;

import java.util.ArrayList;
import Habilidades.HabilidadesEspeciais;

public class Arqueiro extends Personagem implements HabilidadesEspeciais {
    public Arqueiro(String nome) {
        super(nome, 120, 35, 5, new ArrayList<>());
    }
    @Override
    //Causa dano igual ao seu ataque, ignorando qualquer ação do Inimigo (ataque/defesa) naquele turno.
    public void usarHabilidadeEspecial(Personagem alvo, boolean inimigoDefendeu) {
        alvo.tomarDano(getAtaque());
    }
}