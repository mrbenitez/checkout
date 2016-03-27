package checkouit;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Calculator
{
  private Map<Product, PricingRule> pricingRules = new HashMap<>();
  
  
  public Price totalPrice(Map<Product, Integer> items)
  {
    Double price = 0.0;
    for (Entry<Product, Integer> item : items.entrySet())
    {
     Product product=item.getKey();
     PricingRule rule = pricingRules.get(product);
     
     price = price + rule.calculator(item.getValue());
     
    }
    return new Price(price);
  }
  
  public void registryRule(Product product ,PricingRule rule)
  {
    pricingRules.put(product, rule);
  }  
}