package checkouit;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ScanTest
{

  @Test
  public void scanProduct(){
    Checkout checkout = new Checkout();
    checkout.scan("A");
    
    Integer totalExpected=0;
    assertThat(checkout.total(), equalTo(totalExpected));
  }
}
