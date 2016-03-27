package checkouit;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ScanTest
{

  @Test
  public void scanProduct(){
    Checkout checkout = new Checkout();
    Product product = new Product("A");
    checkout.scan(product);
    
    Price totalExpected= new Price(0.0) ;
    assertThat(checkout.total(), equalTo(totalExpected));
  }
}
