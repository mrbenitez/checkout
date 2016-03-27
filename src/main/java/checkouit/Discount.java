package checkouit;

public class Discount
{
  private Price discountPrice;
  private Integer numberProductToDiscount;
  
  public Discount(Price discountPrice, Integer numberProductToDiscount)
  {
    this.discountPrice = discountPrice;
    this.numberProductToDiscount = numberProductToDiscount;
  }
  
  public Price getDiscountPrice()
  {
    return discountPrice;
  }
  
  public Integer getNumberProductToDiscount()
  {
    return numberProductToDiscount;
  }
}
