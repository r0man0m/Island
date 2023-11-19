package Abstract;

import GameObjects.Cell;


public abstract class Plant extends Living {

    public void grow(){
        if(this.getWeight() < this.getMaxWeight()){
            this.setWeight(this.getWeight() + this.getWeight() / 10);
            if(this.getWeight() > this.getMaxWeight()){
                this.setWeight(this.getMaxWeight());
            }
        }
        System.out.println(this + " grow ");
    }

    @Override
    public void play(Cell[][] cells) {
        grow();
    }

    @Override
    public void setIdChild(int idChild) {

    }
}
