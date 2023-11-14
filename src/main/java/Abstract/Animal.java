package Abstract;


import GameObjects.Cell;

public abstract class Animal extends Living {
   private int maxMove;
   private int maxFood;

   @Override
   public void play(Cell[][] cells) {
      go(cells);
      eat(cells);
      die(cells);
      reproduce(cells);
   }

   public  void go(Cell[][]cells){
      Cell[][] playerCells = cells;
   }

   public  void die(Cell[][] cells){
      Cell[][] playerCells = cells;
   }
   public  void reproduce(Cell[][] cells){
      Cell[][] playerCells = cells;

   }
   public abstract void eat(Cell[][] cells);



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
