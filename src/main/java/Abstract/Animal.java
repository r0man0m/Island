package Abstract;


import GameObjects.Cell;

public abstract class Animal extends Living {
   private int maxMove;
   private int maxFood;

   @Override
   public void play() {
      go();
      eat();
      die();
   }

   public  void go(){
      Cell[][] cells = getCells();
   }

   public  void die(){
   }
   public  void reproduce(){

   }
   public abstract void eat();



   public int getMaxMove() {
      return maxMove;
   }

   public void setMaxMove(int maxMove) {
      this.maxMove = maxMove;
   }

   public int getMaxFood() {
      return maxFood;
   }

   public void setMaxFood(int maxFood) {
      this.maxFood = maxFood;
   }

}
