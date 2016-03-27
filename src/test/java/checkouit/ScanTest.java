package checkouit;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ScanTest
{
  private Product productA = new Product("A");
  private Product productB = new Product("B");
  @Test
  public void whenScanProductAThenReturnPriceA(){
    Calculator calculator =new Calculator();
    calculator.registryRule(productA, new PriceWithoutDiscount(new Price(50.0)));
    
    Checkout checkout = new Checkout(calculator);
    
    checkout.scan(productA);
    
    Price totalExpected= new Price(50.0) ;
    assertThat(checkout.total(), equalTo(totalExpected));
  }  
  
  @Test
  public void whenScanProductAandBThenReturnPriceAMoreB(){
    
    Calculator calculator =new Calculator();
    calculator.registryRule(productA, new PriceWithoutDiscount(new Price(50.0)));
    calculator.registryRule(productB, new PriceWithoutDiscount(new Price(30.0)));
    Checkout checkout = new Checkout(calculator);
    checkout.scan(productA);
    checkout.scan(productB);
    
    Price totalExpected= new Price(80.0) ;
    assertThat(checkout.total(), equalTo(totalExpected));
  }
}
