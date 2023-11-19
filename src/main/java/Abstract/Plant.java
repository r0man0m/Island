package Abstract;

import GameObjects.GameField;


public abstract class Plant extends Living {

    public void grow(GameField gameField){
        if(this.getWeight() < this.getMaxWeight()){
            this.setWeight(this.getWeight() + this.getWeight() / 5);
            if(this.getWeight() > this.getMaxWeight()){
                this.setWeight(this.getMaxWeight());
            }
        }
        gameField.setGrowMap(this.getName(), this.getId());
        System.out.println(this + " grow ");
    }

    @Override
    public void play(GameField gameField) {
        grow(gameField);
    }

}
