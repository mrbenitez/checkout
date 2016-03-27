package checkouit;

public class PriceWithoutDiscount implements PriceRule
{
  private Price basePrice;
  
  public PriceWithoutDiscount(Price basePrice)
  {
   this.basePrice=basePrice;
  }
  
  @Override
  public Price calculatorPrice(Integer numberProduct)
  {    
    return basePrice.multiply(numberProduct);
  } 
}
