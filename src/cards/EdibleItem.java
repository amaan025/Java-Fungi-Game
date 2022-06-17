package cards;
public abstract class EdibleItem extends Card
{
protected int flavourPoints;
public EdibleItem( CardType ct, String name)
 {
  super(ct,name);
  }
public int getFlavourPoints()
 {
   if("honeyfungus".equals(getName())) { flavourPoints = 1 ; }
   else if ("treeear".equals(getName())) { flavourPoints = 1 ; }
   else if ("lawyerswig".equals(getName())) { flavourPoints = 2 ; }
   else if ("shiitake".equals(getName())) { flavourPoints = 2 ; }
   else if ("henofwoods".equals(getName())) { flavourPoints = 3 ; }
   else if ("birchbolete".equals(getName())) { flavourPoints = 3 ; }
   else if ("porcini".equals(getName())) { flavourPoints = 3 ; }
   else if ("chanterelle".equals(getName())) { flavourPoints = 4 ; }
   else if ("morel".equals(getName())) { flavourPoints = 6 ; }

  return flavourPoints;
  }
}
