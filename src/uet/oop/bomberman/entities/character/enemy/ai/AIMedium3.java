package uet.oop.bomberman.entities.character.enemy.ai;

import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.entities.character.enemy.Enemy;

public class AIMedium3 extends AI {
    private AIMedium1 aiMedium1;

    public AIMedium3(Bomber bomber, Enemy e) {
        aiMedium1 = new AIMedium1(bomber, e);
    }

    @Override
    public int calculateDirection() {
        int random = (int) (Math.random() * 2);
        return aiMedium1.calculateDirection(random);
    }
}
