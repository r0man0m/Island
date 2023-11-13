package Interfaces;

import GameObjects.Types;

public interface GameObject extends Runnable{
    public void play();
    public int getMaxQuantity();
    public void setId(int id);
    public int getId();
    public Types getTypes();

}
