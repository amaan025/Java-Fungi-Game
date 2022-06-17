package board;
import java.io.*;
import java.util.*;
import cards.*;
public class CardList{
  private ArrayList<Card> cList;

  public CardList()
  {
    cList = new ArrayList<Card>();
  }

  public void add(Card card)
  {
    cList.add(card);
  }

  public int size()
  {
    return cList.size();
  }

  public Card getElementAt(int position )
  {
    return cList.get(position);
  }

  public Card removeCardAt( int position )
  {
    return cList.remove(8 - position);
  }
}
