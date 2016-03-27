package checkouit;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PriceTest
{
  @Test
  public void multiplyPrice(){
    Price priceTen= new Price(10.0);
      
    Price total= priceTen.multiply(4);
    
    assertThat(total, equalTo(new Price(40.0)));
  }
  
  @Test
  public void addTwoPrice(){
    Price priceTen= new Price(10.0);
    Price priceFour= new Price(4.0);
    
    Price total= priceTen.add(priceFour);
    
    assertThat(total, equalTo(new Price(14.0)));
  }
}
