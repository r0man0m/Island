package Interfaces;

import GameObjects.Cell;
import GameObjects.Coordinate;
import GameObjects.Types;

public interface GameObject extends Runnable{
    public void play(Cell[][] cells);
    public int getMaxQuantity();
    public void setId(int id);
    public int getId();
    public Types getTypes();
    public void setCoordinate(int x, int y);
    public Coordinate getCoordinate();

}
