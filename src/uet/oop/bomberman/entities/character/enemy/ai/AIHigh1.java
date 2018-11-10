package uet.oop.bomberman.entities.character.enemy.ai;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.entities.character.enemy.Enemy;

public class AIHigh1 extends AI {
    private AIMedium1 aiMedium1;
    private AIEvade aiEvade;

    public AIHigh1(Bomber bomber, Enemy e, Board b) {
        aiMedium1 = new AIMedium1(bomber, e);
        aiEvade = new AIEvade(bomber, e, b);
    }

    @Override
    public int calculateDirection() {
        int directionEvade = aiEvade.calculateDirection();
        if (directionEvade != -1) return directionEvade;
//        System.out.println(directionEvade);
        return aiMedium1.calculateDirection();
    }
}
