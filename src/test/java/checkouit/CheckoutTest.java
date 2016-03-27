package checkouit;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CheckoutTest
{
  private static final Discount DISCOUNT_A = new Discount(new Price(130.0), 3);
  private static final Discount DISCOUNT_B = new Discount(new Price(45.0), 2);
  private static final Price PRICE_A = new Price(50.0);
  private static final Price PRICE_B = new Price(30.0);
  private static final Price PRICE_C = new Price(20.0);
  private static final Price PRICE_D = new Price(15.0);
  private static final Product PRODUCT_A = new Product("A");
  private static final Product PRODUCT_B = new Product("B");
  private static final Product PRODUCT_C = new Product("C");
  private static final Product PRODUCT_D = new Product("D");
  
  private HandlerRules handler =new HandlerRules();
  private Checkout checkout; 
  @Before
  public void setUp()
  {
    handler.registryRule(PRODUCT_A, new PriceWithDiscount(PRICE_A,DISCOUNT_A));    
    handler.registryRule(PRODUCT_B, new PriceWithDiscount(PRICE_B,DISCOUNT_B));
    handler.registryRule(PRODUCT_C, new PriceWithoutDiscount(PRICE_C));  
    handler.registryRule(PRODUCT_D, new PriceWithoutDiscount(PRICE_D));  
    checkout= new Checkout(handler);
  }
  
  @Test
  public void whenScanProductAThenReturnPriceA()
  { 
    checkout.scan(PRODUCT_A);
    
    Price totalExpected= PRICE_A ;
    assertThat(checkout.totalPrice(), equalTo(totalExpected));
  }  
  
  @Test
  public void whenScanProductAandBThenReturnPriceAMoreB()
  {  
    checkout.scan(PRODUCT_A);
    checkout.scan(PRODUCT_B);
    
    Price totalExpected= new Price(80.0) ;
    assertThat(checkout.totalPrice(), equalTo(totalExpected));
  }
  
  @Test
  public void whenScanProductBandBThenReturnPriceBWihtDiscount()
  {    
    checkout.scan(PRODUCT_B);
    checkout.scan(PRODUCT_B);
    
    Price totalExpected= new Price(45.0) ;
    assertThat(checkout.totalPrice(), equalTo(totalExpected));
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
    assertThat(checkout.totalPrice(), equalTo(totalExpected));
  }  
}
