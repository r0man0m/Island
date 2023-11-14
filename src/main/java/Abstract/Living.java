package Abstract;

import GameObjects.Cell;
import GameObjects.GameEngine;
import GameObjects.Types;
import Interfaces.GameObject;


public abstract class Living implements GameObject {
    private Cell[][]cells;
    private Types types;
    private String name;
    transient
    private int id;
    private int weight;
    private int maxQuantity;

    public Living() {

    }

    @Override
    public void play(Cell[][] cells) {
        this.cells = cells;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells() {
        this.cells = GameEngine.getCells();
    }

    @Override
    public void run() {
        play(cells);
    }

    protected Living(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    public Types getTypes() {
        return types;
    }

    public void setTypes(Types types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return name + " " + id;
    }
}
