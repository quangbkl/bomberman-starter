package uet.oop.bomberman.entities.character.enemy.ai;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.entities.character.enemy.Enemy;

public class AIHigh2 extends AI {
    private AIMedium2 aiMedium2;
    private AIEvade aiEvade;

    public AIHigh2(Bomber bomber, Enemy e, Board b) {
        aiMedium2 = new AIMedium2(bomber, e);
        aiEvade = new AIEvade(bomber, e, b);
    }

    @Override
    public int calculateDirection() {
        int directionEvade = aiEvade.calculateDirection();
        if (directionEvade != -1) return directionEvade;
//        System.out.println(directionEvade);
        return aiMedium2.calculateDirection();
    }
}
