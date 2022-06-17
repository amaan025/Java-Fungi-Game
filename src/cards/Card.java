
package cards;

public abstract class Card
{
  protected  CardType type;
  protected  String cardName;

  public Card ( CardType ct, String name)
   {
      type = ct;
      cardName = name;
   }

  public CardType getType() { return type; }
  public String getName() { return cardName; }
}
