package Abstract;

import GameObjects.GameField;


public abstract class Plant extends Living {

    public void grow(GameField gameField){
        if(this.getWeight() < this.getMaxWeight() && (this.getWeight() != 0)){
            this.setWeight(this.getWeight() + this.getWeight() / 5);
            if(this.getWeight() > this.getMaxWeight()){
                this.setWeight(this.getMaxWeight());
            }
        }else if(this.getWeight() == 0){
            this.setWeight(this.getMaxWeight());
        }
        synchronized (gameField) {
            gameField.setAllGrowQuantity(1);
        }
        System.out.println(this + " grow ");
    }

    @Override
    public void play(GameField gameField) {
        grow(gameField);
    }

}
