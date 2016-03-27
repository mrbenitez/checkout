package checkouit;

import java.util.HashMap;
import java.util.Map;

public class Checkout
{
  Calculator calculator;
  private Map<Product, Integer> items = new HashMap<>();
  
  public Checkout(Calculator calculator)
  {
    this.calculator=calculator;
  }
  
  public void scan(Product product)
  {
    if(!items.containsKey(product)){
      items.put(product, 0);
    }
    items.put(product, items.get(product)+1);
  }

  public Price total()
  {    
    return calculator.totalPrice(items);
  }
}
