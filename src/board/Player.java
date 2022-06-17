package board;
import java.io.*;
import java.util.*;
import cards.*;
import cards.Mushroom;


public class Player extends Board
{
  private  Hand h;
  private  Display d;
  private  int score;
  private  int handlimit;
  private  int sticks;

  public Player()
  {

    score = 0;
    handlimit = 8;
    sticks = 0;
    h = new Hand();
    d = new Display();
    d.add(new Pan());


  }

  public int getScore()
  {
    return score;
  }

  public int getHandLimit()
  {
    return handlimit;
  }

  public int getStickNumber()
  {
    return sticks;
  }

  public void addSticks(int sticks_add)
  {
    sticks += sticks_add;
    Stick stk;
    for(int i = 0;i < sticks_add;i++)
		{
			stk = new Stick();
			d.add(stk);
		}
  }

  public void removeSticks(int sticks_remove)
  {
    int y = 0;
    sticks -= sticks_remove;
    for (int i=0 ; i<d.size();i++)
    {
      if(d.getElementAt(i).getType().equals(CardType.STICK))
      {
        d.removeElement(i);
        sticks_remove = sticks_remove - 1;
        y++;
        if (y == sticks_remove){break;}
      }
    }
  }

  public Hand getHand()
  {
    return h;
  }

  public Display getDisplay()
  {
    return d;
  }

  public void addCardtoHand(Card card)
  {
    if(card.getType().equals(CardType.BASKET)){ addCardtoDisplay(card);}
    else{h.add(card); }
  }

  public void addCardtoDisplay(Card card)
  {
    d.add(card);
    if (card.getType() == CardType.BASKET)
		{
			handlimit += 2;
		}
		else if (card.getType() == CardType.STICK)
		{
			sticks++;
		}
  }

  public boolean takeCardFromTheForest(int position)
  {
    Card card;
    if(getForest().getElementAt(1).getType().equals(CardType.BASKET) && getForest().getElementAt(2).getType().equals(CardType.BASKET) && getForest().getElementAt(3).getType().equals(CardType.BASKET) && getForest().getElementAt(4).getType().equals(CardType.BASKET) && getForest().getElementAt(5).getType().equals(CardType.BASKET) && getForest().getElementAt(6).getType().equals(CardType.BASKET) && getForest().getElementAt(7).getType().equals(CardType.BASKET) && getForest().getElementAt(0).getType().equals(CardType.BASKET) && (sticks == 5)){
            if(position == 3){
                for(int i =0; i<d.size(); i++){
                    d.removeElement(0);
                }
                d.add(new Stick());
                d.add(new Stick());
                d.add(new Stick());
                handlimit = 10;
                return true;
            }if(position == 4){
                for(int i =0; i<d.size(); i++){
                    d.removeElement(0);
                }
                d.add(new Stick());
                d.add(new Stick());
                handlimit = 10;
                return true;
            }if(position == 6){
                for(int i =0; i<d.size(); i++){
                    d.removeElement(0);
                }

                handlimit = 10;
                return true;

            }if(position == 7){
                for(int i =0; i<d.size(); i++){
                    d.removeElement(0);
                }
                d.removeElement(0);
                handlimit = 10;
                return true;
            }
        }

    if(0< (handlimit- h.size()))
    {

        if( position==2 || position==1)
        {
          card = Board.getForest().removeCardAt(position);
          if(card.getType().equals(CardType.BASKET) || card.getType().equals(CardType.STICK))
          {
            addCardtoDisplay(card);
          }
          else
          {
            h.add(card);
            // Board.getForest().removeCardAt(position);
          }
          return true;
        }
        else if (position>=3 && position <=8)
        {
            if ( (position - 2) <= sticks)
            {
              card = Board.getForest().removeCardAt(position);
                if(card.getType()==(CardType.BASKET) || card.getType()==(CardType.STICK))
              {

                addCardtoDisplay(card);
                removeSticks(position - 2);
                // Board.getForest().removeCardAt(position);
                // return true;
              }
              else
              {

                h.add(card);
                removeSticks(position - 2);
                // Board.getForest().removeCardAt(position);
                // return true;
              }
              return true;
              }
            else{ return false; }
        }
    }

     return false;

  }
  public boolean takeFromDecay()
  {
    int i,c=0;
    for ( i = 0; i < getDecayPile().size(); i++)
    {
        if (getDecayPile().get(i).getType().equals(CardType.BASKET) )
        {
          c++;
        }
    }
    if ((h.size() + getDecayPile().size()) - c <= handlimit + (c*2) )
    {
    //  handlimit = handlimit + 2;
      for ( i = 0; i < getDecayPile().size(); i++)
      {
        if (getDecayPile().get(i).getType().equals(CardType.BASKET) || getDecayPile().get(i).getType().equals(CardType.STICK))
        {
          addCardtoDisplay(getDecayPile().get(i));
        }
        else
        {
          addCardtoHand(getDecayPile().get(i));
        }
      }
      return true;
    }
    return false;
  }

  public boolean cookMushrooms(ArrayList<Card> cm)
  {
    int i,j;
    int b=0; int c = 0;int m=0; int flvp=0; int day =0;int night =0;int k=0;
    String nm="";
    boolean p = false;
    boolean pd = false;
    boolean mushroom_identical = false;

    // Counting the number of butter and cider in arraylist

    for(i = 0; i<cm.size(); i++)
    {
      if(cm.get(i).getType().equals(CardType.BUTTER))
      {
        b = b+1;
      }
      if(cm.get(i).getType().equals(CardType.CIDER))
      {
        c = c+1;
      }
    }

    // Checking there is a pan in display or in the array list


    for(i = 0; i<cm.size(); i++)
    {
      if(cm.get(i).getType().equals(CardType.PAN))
      {
        p=true;
      }
    }
    if(p == false)
    {
      for(i = 0; i<d.size(); i++)
      {
        if(d.getElementAt(i).getType().equals(CardType.PAN))
        {
          pd = true;
          break;
        }
      }
      if(pd == false) { return false;}
    }

    // Checking for non edible items

    for(i = 0; i<cm.size(); i++)
    {
      if(cm.get(i).getType().equals(CardType.STICK) || cm.get(i).getType().equals(CardType.BASKET))
      {
        return false;
      }
    }
    // removing cider butter and PAN
    for( i =0; i<cm.size(); i++){
      if(cm.get(i).getType().equals(CardType.BUTTER)){
        cm.remove(i);
      }
    }
    for( i =0; i<cm.size(); i++){
      if(cm.get(i).getType().equals(CardType.CIDER)){
        cm.remove(i);
      }
    }
    for( i =0; i<cm.size(); i++){
      if(cm.get(i).getType().equals(CardType.PAN)){
        cm.remove(i);
      }
    }





    // Checking if the mushrooms are identical or Not

    for(i = 0; i<cm.size(); i++)
    {
      for(j=i+1;j<cm.size();j++)
      {
        if(cm.get(i).getName() == cm.get(j).getName())
        {
          mushroom_identical = true;
           //nm = cm.get(i).getName();
        }
        else{ return false;}
      }
    }

    // checking number of mushrooms in if loop of pan ans identical Mushrooms

    if( (p == true || pd == true))
    {
      if(mushroom_identical == true)
      {
        nm = cm.get(0).getName();
        for(i = 0; i<cm.size(); i++)
        {
          if(cm.get(i).getType().equals(CardType.DAYMUSHROOM)) { day = day+1; }
          if(cm.get(i).getType().equals(CardType.NIGHTMUSHROOM)) { night = night+1;}

        }
        m = day+(night*2);
        if (m >=3 )
        {
          if(m >= 5*c + 4*b)
          {
            // calculating score
                if((nm).equals("honeyfungus")){
                flvp = 1*m; score = score + flvp + (5*c) + (3*b);
              }if((nm).equals("treeear")){
                flvp = 1*m; score = score + flvp + (5*c) + (3*b);
              }if((nm).equals("lawyerswig")){
                flvp = 2*m; score = score + flvp + (5*c) + (3*b);
              }if((nm).equals("shiitake")){
                flvp = 2*m; score = score + flvp + (5*c) + (3*b);
              }if((nm).equals("henOfwoods")){
                flvp = 3*m; score = score + flvp + (5*c) + (3*b);
              }if((nm).equals("birchbolete")){
                flvp = 3*m; score = score + flvp + (5*c) + (3*b);
              }if((nm).equals("porcini")){
                flvp = 3*m; score = score + flvp + (5*c) + (3*b);
              }if((nm).equals("chanterelle")){
                flvp = 4*m; score = score + flvp + (5*c) + (3*b);
              }if((nm).equals("morel")){
                flvp = 6*m; score = score + flvp + (5*c) + (3*b);
              }
              // System.out.println(nm);
            // score = score + flvp + (5*c) + (3*b);
            // // System.out.println("Basket" +b);
            // // System.out.println("Cider" + c);
            // // System.out.println("flvp" + flvp);
            // // System.out.println("score" + score);
            // System.out.print("mushroom" + m);
          }else{return false;}

        }else{return false;}


    // removing elements from hand and display

    if(p == true)
    {
      for(i=0; i<h.size();i++){
        if(h.getElementAt(i).getType().equals(CardType.PAN)) { h.removeElement(i);  break;}
      }
    }else{
      for(i = 0; i<d.size(); i++ )
      {
        if(d.getElementAt(i).getType().equals(CardType.PAN)) { d.removeElement(i);  break;}
      }
    }
    k=0;
    for(i =0; i<h.size();i++)
    {
      if(h.getElementAt(i).getName().equals(nm) && h.getElementAt(i).getType().equals(CardType.DAYMUSHROOM) ){
        h.removeElement(i);
        k=k+1;
        if (k==day){
          break;
        }
      }
    }
    k=0;
    for(i =0; i<h.size();i++)
    {
      if(h.getElementAt(i).getName().equals(nm) && h.getElementAt(i).getType().equals(CardType.NIGHTMUSHROOM) ){
        h.removeElement(i);
        k=k+1;
        if (k==night){
          break;
        }
      }
    }
    k=0;
    for(i =0; i<h.size();i++)
    {
      if(h.getElementAt(i).getName().equals(CardType.CIDER) ){
        h.removeElement(i);
        k=k+1;
        if (k==c){
          break;
        }
      }
    }
    k=0;
    for(i =0; i<h.size();i++)
    {
      if(h.getElementAt(i).getName().equals(CardType.BUTTER) ){
        h.removeElement(i);
        k=k+1;
        if (k==b){
          break;
        }
      }
    }return true;
  }
  return false;
}



return false;

































  }

  public boolean sellMushrooms(String name, int number)
  {
    int day_count=0;int night_count=0; int spm = 0; int x=0;
    int t;
    int i; int day_score=0;int total_sticks=0;
    name = name.replaceAll("[^A-Za-z]+", "").toLowerCase();
    name = name.replaceAll(" ","");
    String mush[] = {"HoneyFungus","TreeEar","LawyersWig","Shiitake","HenOfWoods","BirchBolete","Porcini","Chanterelle","Morel"};
    String mush_name;
    String mushArray[] = {"honeyfungus","treeear","lawyerswig","shiitake","henofwoods","birchbolete","porcini","chanterelle","morel"};
    for (i=0;i < mushArray.length;i++)
    {
      if (name == mushArray[i])
      {
        x = i;
         break;
       }
      else if ( i==8 && name != mushArray[i]){ return false;}
    }

    mush_name = mushArray[x];
    //System.out.println(mush_name);
    //if(n)
    for(i=0;i<h.size();i++)
    {
      if(h.getElementAt(i).getName().equals(mush_name) && h.getElementAt(i).getType().equals(CardType.DAYMUSHROOM)) { day_count++; }
      if(h.getElementAt(i).getType().equals(CardType.NIGHTMUSHROOM) && h.getElementAt(i).getName().equals(mush_name)) { night_count++;}
    }
    t = day_count + (night_count*2);
    if(t < number){return false;}
    // for (i=0;i<h.size();i++)
    // {
    //   if(h.getElementAt(i).getName().equals(mush_name))
    //   {
    //     day_sticks = ((Mushroom)h.getElementAt(i)).getSticksPerMushroom();
    //     night_sticks = 2 * ((Mushroom)h.getElementAt(i)).getSticksPerMushroom();
    //     break;
    //   }
    // }
    int k=0;int l=0;
    if((day_count == 0 ||day_count==1) && night_count == 0) {return false;}
    if(number >= 2)
    {
      if(night_count == 0)
      {
        if((mush_name).equals("honeyfungus")){
        spm = 1*number;
      }if((mush_name).equals("treeear")){
        spm = 2*number;
      }if((mush_name).equals("lawyerswig")){
        spm = 1*number;
      }if((mush_name).equals("shiitake")){
        spm = 2*number;
      }if((mush_name).equals("henofwoods")){
        spm = 1*number;
      }if((mush_name).equals("birchbolete")){
        spm = 2*number;
      }if((mush_name).equals("porcini")){
        spm = 3*number;
      }if((mush_name).equals("chanterelle")){
        spm = 2*number;
      }if((mush_name).equals("morel")){
        spm = 4*number;
      }
        // total_sticks = number * day_sticks;
        addSticks(spm);

        for(i=0;i<h.size();i++)
        {

          if(h.getElementAt(i).getType().equals(CardType.DAYMUSHROOM) && h.getElementAt(i).getName().equals(mush_name))
          {
            h.removeElement(i);
            k=k+1;

          if(k == number){ break;}}
        }
        for(i=0;i<h.size();i++)
        {

          if(h.getElementAt(i).getType().equals(CardType.DAYMUSHROOM) && h.getElementAt(i).getName().equals(mush_name) && k!=number)
          {
            h.removeElement(i);
            k=k+1;

          if(k == number){ break;}}
        }

        return true;
      }
      if(night_count == 1)
      {
        if((mush_name).equals("honeyfungus")){
        spm = (1*2)+((number-2)*1);
      }if((mush_name).equals("treeear")){
        spm = (2*2)+((number-2)*2);
      }if((mush_name).equals("lawyerswig")){
        spm = (1*2)+((number-2)*1);
      }if((mush_name).equals("shiitake")){
        spm = (2*2)+((number-2)*2);
      }if((mush_name).equals("henofwoods")){
        spm = (1*2)+((number-2)*1);
      }if((mush_name).equals("birchbolete")){
        spm =  (2*2)+((number-2)*2);
      }if((mush_name).equals("porcini")){
        spm = (3*2)+((number-2)*3);

      }if((mush_name).equals("chanterelle")){
        spm = (2*2)+((number-2)*2);
      }if((mush_name).equals("morel")){ return false;  }
      // if(h.size()<handlimit)
      // System.out.print(spm + " ");
      // {
      //
        addSticks(spm);
      // }
        for(i=0;i<h.size();i++)
        {
          if(h.getElementAt(i).getType().equals(CardType.NIGHTMUSHROOM) && h.getElementAt(i).getName().equals(mush_name)) {h.removeElement(i); number = number - 2;}
          if(h.getElementAt(i).getType().equals(CardType.DAYMUSHROOM) && h.getElementAt(i).getName().equals(mush_name))
          {
            h.removeElement(i);
            l = l + 1;
          }
          if( l == (number) ) { break; }
        }


      return true;
    }

    }
  return false;
 }

  public boolean putPanDown()
  {
    int i;
    for (i = 0 ; i < h.size() ; i++ )
    {
      if (h.getElementAt(i).getType().equals(CardType.PAN))
      {
        addCardtoDisplay(h.removeElement(i));
        return true;
      }
    }
    return false;
  }
}
