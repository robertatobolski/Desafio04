package Habilidades;
import Personagens.Personagem;

// Define um método que deve ser implementado por cada personagem com habilidade especial.
    public interface HabilidadesEspeciais {
    void usarHabilidadeEspecial(Personagem alvo, boolean inimigoDefendeu);
}