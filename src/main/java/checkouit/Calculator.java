package checkouit;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Calculator
{
  private Map<Product, PricingRule> pricingRules = new HashMap<>();
  
  
  public Price totalPrice(Map<Product, Integer> items)
  {
    Price price = new Price(BigDecimal.ZERO);
    for (Entry<Product, Integer> item : items.entrySet())
    {
     Product product=item.getKey();
     PricingRule rule = pricingRules.get(product);     
     price = price.add(calculator(item.getValue(), rule));     
    }
    return price;
  }

  private Price calculator( Integer numberProduct, PricingRule rule)
  {
    return rule.calculator(numberProduct);
  }
  
  public void registryRule(Product product ,PricingRule rule)
  {
    pricingRules.put(product, rule);
  }  
}
