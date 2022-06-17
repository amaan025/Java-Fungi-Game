package board;
import java.io.*;
import java.util.*;
import cards.*;
public class Board
{
  private static CardPile forestCardsPile;
  private static CardList forest;
  private static ArrayList<Card> decayPile;

  public static void initialisePiles()
  {
    forestCardsPile = new CardPile();
    forest = new CardList();
    decayPile = new ArrayList<Card>();
  }

  public static void setUpCards()
  {
    int i;
    // creating instance of night mushrooms and adding them to forestCardsPile

    HoneyFungus honey_fungus_night = new HoneyFungus(CardType.NIGHTMUSHROOM);
    forestCardsPile.addCard(honey_fungus_night);

    TreeEar tree_ear_night = new TreeEar(CardType.NIGHTMUSHROOM);
    forestCardsPile.addCard(tree_ear_night);

    LawyersWig lawyers_wig_night = new LawyersWig(CardType.NIGHTMUSHROOM);
    forestCardsPile.addCard(lawyers_wig_night);

    Shiitake shiitake_night = new Shiitake(CardType.NIGHTMUSHROOM);
    forestCardsPile.addCard(shiitake_night);

    HenOfWoods hen_of_woods_night = new HenOfWoods(CardType.NIGHTMUSHROOM);
    forestCardsPile.addCard(hen_of_woods_night);

    BirchBolete birch_bolete_night = new BirchBolete(CardType.NIGHTMUSHROOM);
    forestCardsPile.addCard(birch_bolete_night);

    Porcini porcini_night = new Porcini(CardType.NIGHTMUSHROOM);
    forestCardsPile.addCard(porcini_night);

    Chanterelle chanterelle_night = new Chanterelle(CardType.NIGHTMUSHROOM);
    forestCardsPile.addCard(chanterelle_night);

    // Not creating instance of Morel because there is no night mushroom

    // creating instance of day mushrooms and adding them to forestCardsPile

    HoneyFungus honey_fungus_day = new HoneyFungus(CardType.DAYMUSHROOM);
    for (i =0; i<=9;i++) { forestCardsPile.addCard(honey_fungus_day); }

    TreeEar tree_ear_day = new TreeEar(CardType.DAYMUSHROOM);
    for (i=0 ; i<=7; i++) { forestCardsPile.addCard(tree_ear_day); }

    LawyersWig lawyers_wig_day = new LawyersWig(CardType.DAYMUSHROOM);
    for(i=0; i<=5;i++) { forestCardsPile.addCard(lawyers_wig_day); }

    Shiitake shiitake_day = new Shiitake(CardType.DAYMUSHROOM);
    HenOfWoods hen_of_woods_day = new HenOfWoods(CardType.DAYMUSHROOM);
    for(i=0; i<=4; i++)
    {
      forestCardsPile.addCard(shiitake_day);
      forestCardsPile.addCard(hen_of_woods_day);
    }

    BirchBolete birch_bolete_day = new BirchBolete(CardType.DAYMUSHROOM);
    Porcini porcini_day = new Porcini(CardType.DAYMUSHROOM);
    Chanterelle chanterelle_day = new Chanterelle(CardType.DAYMUSHROOM);
    for (i=0; i<=3 ; i++)
    {
      forestCardsPile.addCard(birch_bolete_day);
      forestCardsPile.addCard(porcini_day);
      forestCardsPile.addCard(chanterelle_day);
    }

    Morel morel_day = new Morel(CardType.DAYMUSHROOM);
    for (i=0;i<=2;i++) { forestCardsPile.addCard(morel_day); }

    // creating instance of butter, cider, basket and pan and adding them to forestCardsPile

    Butter butter = new Butter();
    Cider cider = new Cider();
    for (i=0;i<=2;i++)
    {
      forestCardsPile.addCard(butter);
      forestCardsPile.addCard(cider);
    }

    Basket basket = new Basket();
    for(i=0;i<=4;i++) { forestCardsPile.addCard(basket); }

    Pan pan = new Pan();
    for(i=0;i<11;i++) { forestCardsPile.addCard(pan); }

    // Stick sticks = new Stick();

  }

  public static CardPile getForestCardsPile()
  {
    return forestCardsPile;
  }

  public static CardList getForest()
  {
    return forest;
  }

  public static ArrayList<Card> getDecayPile()
  {
    return decayPile;
  }

  public static void updateDecayPile()
  {
    Card x;
    if (decayPile.size() == 4)
    {
      decayPile.clear();
      // if(getForest().getElementAt(7) != null)
      // {
      //   decayPile.add(forest.removeCardAt(1));
      // }
      // else
      // {
      //   decayPile.add(forest.removeCardAt(2));
      // }

     }
    // // x = forest.removeCardAt(1);
    // // decayPile.add(x);
    //
    // if(getForest().getElementAt(7) != null)
    // {
    //   decayPile.add(forest.removeCardAt(1));
    // }
    // else
    // {
      decayPile.add(forest.removeCardAt(1));
    // }
  }
}
