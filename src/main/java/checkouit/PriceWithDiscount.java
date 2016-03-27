package checkouit;

public class PriceWithDiscount implements PriceRule
{
  private Price basePrice;
  private Discount discount;
  
  public PriceWithDiscount(Price basePrice,Discount discount)
  {
   this.basePrice=basePrice;
   this.discount=discount;
  }
  
  @Override
  public Price calculatorPrice(Integer numberProduct)
  {    
    Integer groupProductWithDiscount = numberProduct / discount.getNumberProductToDiscount();    
    Price productWihtDiscountPrice = calculatePriceToProductWithDiscount(groupProductWithDiscount);
    Price productWithoutDiscountPrice=calculatePriceToProductWithoutDiscount(numberProduct, groupProductWithDiscount);        
    return productWihtDiscountPrice.add(productWithoutDiscountPrice); 
  }  

  private Price calculatePriceToProductWithoutDiscount(Integer numberProduct, Integer groupProductWithDiscount)
  {
    return basePrice.multiply(calculateNumberProductWithoutDiscount(numberProduct, groupProductWithDiscount));
  }
  
  private int calculateNumberProductWithoutDiscount(Integer numberProduct, Integer groupProductWithDiscount)
  {
    return numberProduct - (groupProductWithDiscount*discount.getNumberProductToDiscount());
  } 

  private Price calculatePriceToProductWithDiscount(Integer groupProductWithDiscount)
  {
    return discount.getDiscountPrice().multiply(groupProductWithDiscount);
  }  
}
