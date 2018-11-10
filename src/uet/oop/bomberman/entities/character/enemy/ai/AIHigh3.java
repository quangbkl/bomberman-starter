package uet.oop.bomberman.entities.character.enemy.ai;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.entities.character.enemy.Enemy;

public class AIHigh3 extends AI {
    private AIMedium3 aiMedium3;
    private AIEvade aiEvade;

    public AIHigh3(Bomber bomber, Enemy e, Board b) {
        aiMedium3 = new AIMedium3(bomber, e);
        aiEvade = new AIEvade(bomber, e, b);
    }

    @Override
    public int calculateDirection() {
        int directionEvade = aiEvade.calculateDirection();
        if (directionEvade != -1) return directionEvade;
//        System.out.println(directionEvade);
        return aiMedium3.calculateDirection();
    }
}
