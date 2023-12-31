package Abstract;

import GameObjects.*;
import Interfaces.GameObject;

import java.math.BigInteger;
import java.util.HashMap;


public abstract class Living implements GameObject {
    private GameField gameField;
    private Coordinate coordinate;
    private Types types;
    private String name;
    private String avatar;
    transient
    private volatile BigInteger id;
    private int weight;
    private int maxWeight;
    private int maxQuantity;
    private HashMap<Types, Integer> propertyMap;


    @Override
    public void setProperty(HashMap<Types, Integer> propertyMap) {
        this.propertyMap = propertyMap;
    }

    @Override
    public int getProperty(Types types) {
        return propertyMap.get(types);
    }

    public Living() {
        coordinate = new Coordinate();
    }


    @Override
    public void play(GameField gameField) throws CloneNotSupportedException, InterruptedException {

    }

    @Override
    public Boolean call() {
        try {
            play(gameField);
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public Living(BigInteger id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getId() {return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public void setMaxWeight(int weight) {
        maxWeight = weight;
    }

    public int getMaxWeight() {
        return maxWeight;
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
    public void setCoordinate(int x, int y) {
        coordinate.setCoordinate(x, y);
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public GameField getGameField() {
        return gameField;
    }

    public void setGameField(GameField gameField) {
        this.gameField = gameField;
    }

    /* @Override
        public String toString() {
            return "[" + name + " " + id + " (X=" + coordinate.getX() + " Y=" + coordinate.getY() + " weight " + weight + ")" + "]" + " ";
        }
    */
    @Override
    public String toString() {
        return "[" + avatar + " " + id +"]";
    }
}
