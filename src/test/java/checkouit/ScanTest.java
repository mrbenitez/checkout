package checkouit;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ScanTest
{
  @Test
  public void whenScanProductAThenReturnPriceA(){
    Checkout checkout = new Checkout();
    Product product = new Product("A");
    checkout.scan(product);
    
    Price totalExpected= new Price(50.0) ;
    assertThat(checkout.total(), equalTo(totalExpected));
  }  
  
  @Test
  public void whenScanProductAandBThenReturnPriceAMoreB(){
    Checkout checkout = new Checkout();
    Product productA = new Product("A");
    checkout.scan(productA);
    Product productB = new Product("B");
    checkout.scan(productB);
    
    Price totalExpected= new Price(80.0) ;
    assertThat(checkout.total(), equalTo(totalExpected));
  }
}
