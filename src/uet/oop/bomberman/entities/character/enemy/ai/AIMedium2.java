package uet.oop.bomberman.entities.character.enemy.ai;

import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.entities.character.enemy.Enemy;

public class AIMedium2 extends AI {
    private AIMedium aiMedium;

    public AIMedium2(Bomber bomber, Enemy e) {
        aiMedium = new AIMedium(bomber, e);
    }

    @Override
    public int calculateDirection() {
        int random = (int) (Math.random() * 2);
        return aiMedium.calculateDirection(random);
    }
}
