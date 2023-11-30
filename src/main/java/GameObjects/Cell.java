package GameObjects;

import Interfaces.GameObject;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;

public class Cell implements Serializable {
    private  int capacity;
    private BigInteger id;
    private  ArrayBlockingQueue<GameObject> queue;

    public Cell() {
        setCapacity(1000);
        setId(id);
        queue = new ArrayBlockingQueue<>(capacity);
    }

    public Cell(BigInteger id) {
        this.id = id;
        queue = new ArrayBlockingQueue<>(capacity);
    }

    public ArrayBlockingQueue<GameObject> getQueue() {
        return queue;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setQueue(ArrayBlockingQueue<GameObject> queue) {
        this.queue = queue;
    }

    @Override
    public String toString() {
        return "Cell " + id;
    }
}
