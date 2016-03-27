package checkouit;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CheckoutTest
{
  private static final Integer NUMBER_PRODUCT_A_TO_DISCOUNT = 3;
  private static final Price DISCOUNT_PRICE_A = new Price(130.0);  
  private static final Integer NUMBER_PRODUCT_B_TO_DISCOUNT = 2;
  private static final Price DISCOUNT_PRICE_B = new Price(45.0);  
  private static final Price PRICE_A = new Price(50.0);
  private static final Price PRICE_B = new Price(30.0);
  private static final Price PRICE_C = new Price(20.0);
  private static final Price PRICE_D = new Price(15.0);
  private static final Product PRODUCT_A = new Product("A");
  private static final Product PRODUCT_B = new Product("B");
  private static final Product PRODUCT_C = new Product("C");
  private static final Product PRODUCT_D = new Product("D");
  
  private Calculator calculator =new Calculator();
  private Checkout checkout; 
  @Before
  public void setUp()
  {
    calculator.registryRule(PRODUCT_A, new PriceWithDiscount(PRICE_A,DISCOUNT_PRICE_A,NUMBER_PRODUCT_A_TO_DISCOUNT));    
    calculator.registryRule(PRODUCT_B, new PriceWithDiscount(PRICE_B,DISCOUNT_PRICE_B,NUMBER_PRODUCT_B_TO_DISCOUNT));
    calculator.registryRule(PRODUCT_C, new PriceWithoutDiscount(PRICE_C));  
    calculator.registryRule(PRODUCT_D, new PriceWithoutDiscount(PRICE_D));  
    checkout= new Checkout(calculator);
  }
  
  @Test
  public void whenScanProductAThenReturnPriceA()
  { 
    checkout.scan(PRODUCT_A);
    
    Price totalExpected= PRICE_A ;
    assertThat(checkout.total(), equalTo(totalExpected));
  }  
  
  @Test
  public void whenScanProductAandBThenReturnPriceAMoreB()
  {  
    checkout.scan(PRODUCT_A);
    checkout.scan(PRODUCT_B);
    
    Price totalExpected= new Price(80.0) ;
    assertThat(checkout.total(), equalTo(totalExpected));
  }
  
  @Test
  public void whenScanProductBandBThenReturnPriceBWihtDiscount()
  {    
    checkout.scan(PRODUCT_B);
    checkout.scan(PRODUCT_B);
    
    Price totalExpected= DISCOUNT_PRICE_B ;
    assertThat(checkout.total(), equalTo(totalExpected));
  }
    
  @Test
  public void whenScanProductABCABADBThenReturnPriceTotal()
  {    
    checkout.scan(PRODUCT_A);
    checkout.scan(PRODUCT_B);
    checkout.scan(PRODUCT_C);
    checkout.scan(PRODUCT_A);
    checkout.scan(PRODUCT_B);
    checkout.scan(PRODUCT_A);
    checkout.scan(PRODUCT_D);
    checkout.scan(PRODUCT_B);
    
    Price totalExpected= new Price(240.0);
    assertThat(checkout.total(), equalTo(totalExpected));
  }  
}
