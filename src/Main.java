public class Main {
    public static void main(String[] args) {
      DishFactory cookSoup= new CookSoup();
      DishFactory cookFish=new CookFish();

      cookFish.makeDish();
      cookSoup.makeDish();

    }
}
