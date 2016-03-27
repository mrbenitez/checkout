package checkouit;

public class PriceWithDiscount implements PricingRule
{
  private Price basePrice;
  private Price discountPrice;
  private Integer numberProductToDiscount;
  
  public PriceWithDiscount(Price basePrice,Price discountPrice,Integer numberProductDiscount)
  {
   this.basePrice=basePrice;
   this.discountPrice=discountPrice;
   this.numberProductToDiscount=numberProductDiscount;
  }
  
  @Override
  public Price calculator(Integer numberProduct)
  {    
    Integer groupProductWithDiscount = numberProduct / numberProductToDiscount;
    
    Price productWihtDiscountPrice= discountPrice.multiply(groupProductWithDiscount);
    Price productWithoutDiscountPrice=basePrice.multiply(calculateNumberProductWithoutDiscount(numberProduct, groupProductWithDiscount));        
    return productWihtDiscountPrice.add(productWithoutDiscountPrice); 
  }

  private int calculateNumberProductWithoutDiscount(Integer numberProduct, Integer groupProductWithDiscount)
  {
    return numberProduct - (groupProductWithDiscount*numberProductToDiscount);
  } 
}
