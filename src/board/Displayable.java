package board;

import java.io.*;
import java.util.*;
import cards.*;

public  interface Displayable
{
  public abstract void add (Card card);
  public abstract int size();
  public abstract Card getElementAt(int n);
  public abstract Card removeElement(int n);
}
