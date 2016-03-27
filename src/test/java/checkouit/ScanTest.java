package checkouit;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ScanTest
{
  private static final Integer NUMBER_PRODUCT_B_TO_DISCOUNT = 2;
  private static final Price DISCOUNT_PRICE_B = new Price(45.0);
  private static final Price PRICE_B = new Price(30.0);
  private static final Price PRICE_A = new Price(50.0);
  private static final Product PRODUCT_A = new Product("A");
  private static final Product PRODUCT_B = new Product("B");
  
  private Calculator calculator =new Calculator();
  @Before
  public void setUp()
  {
    calculator.registryRule(PRODUCT_A, new PriceWithoutDiscount(PRICE_A));  
    calculator.registryRule(PRODUCT_B, new PriceWithDiscount(PRICE_B,DISCOUNT_PRICE_B,NUMBER_PRODUCT_B_TO_DISCOUNT));
  }
  
  @Test
  public void whenScanProductAThenReturnPriceA()
  { 
    Checkout checkout = new Checkout(calculator); 
    
    checkout.scan(PRODUCT_A);
    
    Price totalExpected= PRICE_A ;
    assertThat(checkout.total(), equalTo(totalExpected));
  }  
  
  @Test
  public void whenScanProductAandBThenReturnPriceAMoreB()
  {    
    Checkout checkout = new Checkout(calculator);
    checkout.scan(PRODUCT_A);
    checkout.scan(PRODUCT_B);
    
    Price totalExpected= new Price(80.0) ;
    assertThat(checkout.total(), equalTo(totalExpected));
  }
  
  @Test
  public void whenScanProductBandBThenReturnPriceBWihtDiscount()
  {    
    Checkout checkout = new Checkout(calculator);
    checkout.scan(PRODUCT_B);
    checkout.scan(PRODUCT_B);
    
    Price totalExpected= DISCOUNT_PRICE_B ;
    assertThat(checkout.total(), equalTo(totalExpected));
  }
  
}
