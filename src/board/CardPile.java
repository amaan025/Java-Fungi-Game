package board;
import java.io.*;
import java.util.*;
import cards.*;
public class CardPile {
  private Stack<Card> cPile;
  public CardPile()
  {
    cPile = new Stack<Card>();
  }

  public void addCard(Card card)
  {
    cPile.push(card);
  }

  public Card drawCard()
  {
    return cPile.pop();
  }

  public void shufflePile()
  {
    Collections.shuffle(cPile);
  }

  public int pileSize()
  {
    return cPile.size();
  }

  public boolean isEmpty()
  {
    return cPile.empty();
  }
}
