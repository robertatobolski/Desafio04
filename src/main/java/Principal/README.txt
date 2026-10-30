PROJETO RPG - JAVA

1. SOBRE O PROJETO

Este projeto consiste em um jogo de RPG desenvolvido em Java,
no qual o jogador escolhe um personagem e enfrenta uma sequência
de inimigos até chegar ao chefe final, o Demogorgon.
O jogo foi desenvolvido utilizando conceitos de Programação Orientada a Objetos,
como classes, objetos, herança, polimorfismo e interfaces.


2. PERSONAGENS JOGÁVEIS

O jogador pode escolher entre três classes:
- Guerreiro: possui maior quantidade de vida e uma habilidade especial que causa o dobro do dano normal.
- Mago: possui a habilidade de trocar sua vida atual com a do inimigo.
- Arqueiro: possui a habilidade de causar dano sem permitir uma ação do inimigo naquele turno.
Cada personagem possui atributos próprios de vida, ataque e defesa.


3. INIMIGOS

Durante cada partida, o jogador enfrenta de 4 a 6 inimigos,
incluindo obrigatoriamente o Demogorgon como último adversário.
Os inimigos comuns disponíveis são Goblin, Esqueleto, Troll e Zumbi.
As ações dos inimigos são definidas aleatoriamente, com 70% de chance de atacar
e 30% de chance de defender.


4. SISTEMA DE COMBATE

Durante os combates, o jogador pode escolher entre quatro ações:
- Atacar: causa dano ao inimigo.
- Defender: permite reduzir o dano recebido de acordo com o atributo de defesa.
- Usar poção: recupera 20 pontos de vida, desde que o jogador tenha perdido pelo menos 20 pontos.
- Habilidade especial: utiliza a habilidade específica do personagem, com limite de duas utilizações por partida.
Cada personagem começa a partida com três poções de cura.


5. ORGANIZAÇÃO DO PROJETO

O código-fonte está dividido nos seguintes pacotes:
- Personagens: contém a classe Personagem e suas subclasses Guerreiro, Mago e Arqueiro.
- Inimigos: contém a classe Inimigo e os diferentes tipos de adversários.
- Habilidades: contém a interface HabilidadesEspeciais.
- Principal: contém a classe Main, responsável por iniciar e controlar o jogo.


6. REQUISITOS

- Java JDK 17 ou superior.
- Uma IDE compatível com projetos Java, como IntelliJ IDEA.


7. COMO EXECUTAR

1. Abra o projeto na IDE.
2. Localize a classe Main, dentro do pacote Principal.
3. Execute o método main().
4. Siga as instruções apresentadas no console.


8. CONDIÇÃO DE VITÓRIA E DERROTA

O jogador vence ao derrotar todos os inimigos, incluindo o Demogorgon.
Caso a vida do personagem chegue a zero durante um combate, a partida termina em derrota.