package Abstract;

import GameObjects.Cell;

public abstract class Plant extends Living {
    public void grow(){

    }

    @Override
    public void play(Cell[][] cells) {
        super.play(cells);
        grow();
    }
}
