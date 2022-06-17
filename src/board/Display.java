package board;
import java.io.*;
import java.util.*;
import cards.*;

public class Display implements Displayable
{
    private ArrayList<Card> displayList;
    // @Overide
    public Display()
    {
       displayList = new ArrayList<Card>();
    }
    @Override
    public void add(Card card)
    {
      displayList.add(card);
    }
    @Override
    public int size()
    {
      return displayList.size();
    }
    @Override
    public Card getElementAt(int position)
    {
      return displayList.get(position);
    }
    @Override
    public Card removeElement(int position)
    {
      return displayList.remove(position);
    }
}
