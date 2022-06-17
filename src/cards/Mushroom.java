package cards;
public abstract class Mushroom extends EdibleItem
{
  protected int sticksPerMushroom;
  public Mushroom( CardType ct, String name)
 {
   super(ct,name);
 }
public int getSticksPerMushroom() {
   if("honeyfungus".equals(getName())) { sticksPerMushroom = 1 ; }
   else if ("treeear".equals(getName())) { sticksPerMushroom = 2 ; }
   else if ("lawyerswig".equals(getName())) { sticksPerMushroom = 1 ; }
   else if ("shiitake".equals(getName())) { sticksPerMushroom = 2 ; }
   else if ("henofwoods".equals(getName())) { sticksPerMushroom = 1 ; }
   else if ("birchbolete".equals(getName())) { sticksPerMushroom = 2 ; }
   else if ("porcini".equals(getName())) { sticksPerMushroom = 3 ; }
   else if ("chanterelle".equals(getName())) { sticksPerMushroom = 2 ; }
   else if ("morel".equals(getName())) { sticksPerMushroom = 4 ; }

   return sticksPerMushroom;
 }
}
