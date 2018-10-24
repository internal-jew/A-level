public class Main {
    public static void main(String[] args) {
      DishFactory cookSoup= new CookSoup();
      DishFactory cookFish=new CookFish();

    //  DishBuilder seafoodSoupBuilder=new SeafoodSoupBuilder();
      // DishBuilder marinadeFishBuider=new MarinadeFishBuilder();
      // DirectorOfDishBuilders directorOfDishBuilders=new DirectorOfDishBuilders(seafoodSoupBuilder);


     // directorOfDishBuilders.makeDish();

      cookFish.makeDish();
      //directorOfDishBuilders.changeBuilder(marinadeFishBuider);
      cookSoup.makeDish();




    }
}
