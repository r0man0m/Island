package Interfaces;

import GameObjects.Cell;
import GameObjects.Types;

public interface GameObject extends Runnable{
    public void play(Cell[][] cells);
    public int getMaxQuantity();
    public void setId(int id);
    public int getId();
    public Types getTypes();

}
