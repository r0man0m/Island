package Abstract;

import GameObjects.Cell;
import GameObjects.GameEngine;
import Interfaces.GameObject;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

public abstract class Predator extends Animal {
    @Override
    public void eat(Cell[][]cells) {
        /*int x = getCoordinate().getX();
        int y = getCoordinate().getY();
        Cell[][] playerCells = cells;
        ArrayBlockingQueue<GameObject> queues = playerCells[y][x].getQueue();
        GameObject victim = (GameObject) queues.stream().limit(1).
                filter(c->c.getClass().getAnnotations().equals(Herbivorous.class.getAnnotations()));
        if(victim != null){

        }*/
    }
}
