package checkouit;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PriceWithDiscountTest
{
  private Discount discount = new Discount(new Price(95.6),2);
  private PriceWithDiscount priceWithDiscount=new PriceWithDiscount(new Price(75.6),discount);
  
  @Test
  public void calculatorWhenHaveOnlyProductsNeccesaryToDiscount()
  {  
    Price priceTotal=priceWithDiscount.calculatorPrice(2);
    
    Price totalExpected= new Price(95.6);
    assertThat(priceTotal, equalTo(totalExpected));
  }  
  
  @Test
  public void calculatorWhenHaveOnlyOneProductWithoutDiscount()
  {  
    Price priceTotal=priceWithDiscount.calculatorPrice(1);
    
    Price totalExpected= new Price(75.6);
    assertThat(priceTotal, equalTo(totalExpected));
  } 
  
  @Test
  public void calculatorWhenHaveOnlyThreeProductsTwoWithDiscountAndOneWithoutDiscount()
  {  
    Price priceTotal=priceWithDiscount.calculatorPrice(3);
    
    Price totalExpected= new Price(171.2);
    assertThat(priceTotal, equalTo(totalExpected));
  } 
}
