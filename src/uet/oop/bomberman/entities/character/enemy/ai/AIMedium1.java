package uet.oop.bomberman.entities.character.enemy.ai;

import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.entities.character.enemy.Enemy;

public class AIMedium1 extends AI {
    private Bomber _bomber;
    private Enemy _e;
    private AILow aiLow;

    public AIMedium1(Bomber bomber, Enemy e) {
        _bomber = bomber;
        _e = e;
        aiLow = new AILow();
    }

    @Override
    public int calculateDirection() {
        int random = (int) (Math.random() * 3);
        return calculateDirection(random);
    }

    public int calculateDirection(int random) {
        if (random == 0) {
            int calculateCol = calculateColDirection();
            if (calculateCol != -1) return calculateCol;
            int calculateRow = calculateRowDirection();
            if (calculateRow != -1) return calculateRow;
        }

        if (random == 1) {
            int calculateRow = calculateRowDirection();
            if (calculateRow != -1) return calculateRow;
            int calculateCol = calculateColDirection();
            if (calculateCol != -1) return calculateCol;
        }

        return aiLow.calculateDirection();
    }

    // return 1, 3, -1.
    protected int calculateColDirection() {
        if (_bomber.getXTile() < _e.getXTile()) return 3;
        if (_bomber.getXTile() > _e.getXTile()) return 1;

        return -1;
    }

    // return 0, 2, -1.
    protected int calculateRowDirection() {
        if (_bomber.getYTile() < _e.getYTile()) return 0;
        if (_bomber.getYTile() > _e.getYTile()) return 2;

        return -1;
    }
}
