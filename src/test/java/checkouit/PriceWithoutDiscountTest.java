package checkouit;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PriceWithoutDiscountTest
{
  @Test
  public void calculator()
  {    
    PriceWithoutDiscount priceWithoutDiscount=new PriceWithoutDiscount(new Price(75.6));
    
    Price priceTotal=priceWithoutDiscount.calculatorPrice(10);
    
    Price totalExpected= new Price(756.0);
    assertThat(priceTotal, equalTo(totalExpected));
  }  
}
