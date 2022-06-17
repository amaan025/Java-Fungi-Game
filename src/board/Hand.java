package board;
import java.io.*;
import java.util.*;
import cards.*;

public class Hand implements Displayable
{
    private ArrayList<Card> handList;
    //
    public Hand()
    {
       handList = new ArrayList<Card>();
    }
    @Override
    public void add(Card card)
    {
      handList.add(card);
    }
    @Override
    public int size()
    {
      return handList.size();
    }
    @Override
    public Card getElementAt(int position)
    {
      return handList.get(position);
    }
    @Override
    public Card removeElement(int position)
    {
      return handList.remove(position);
    }
}
