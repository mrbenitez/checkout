package checkouit;

public class PriceWithoutDiscount implements PricingRule
{
  private Price basePrice;
  
  public PriceWithoutDiscount(Price basePrice)
  {
   this.basePrice=basePrice;
  }
  
  @Override
  public Double calculator(Integer numberProduct)
  {    
    return basePrice.multiply(numberProduct);
  }
 
}
