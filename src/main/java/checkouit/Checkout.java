package checkouit;

import java.util.HashMap;
import java.util.Map;

public class Checkout
{
  private HandlerRules handler;
  private PurchaseList purchaseList = new PurchaseList();
  
  public Checkout(HandlerRules handler)
  {
    this.handler=handler;
  }
  
  public void scan(Product product)
  {
    purchaseList.add(product);
  }

  public Price totalPrice()
  {    
    return handler.calculatorTotalPrice(purchaseList);
  }
}
