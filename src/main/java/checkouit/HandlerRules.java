package checkouit;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HandlerRules
{
  private Map<Product, PriceRule> priceRules = new HashMap<>();
    
  public Price calculatorTotalPrice(PurchaseList purchaseList)
  {
    Price price = new Price(BigDecimal.ZERO);
    for (Entry<Product, Integer> item : purchaseList.entrySet())
    {
     Product product=item.getKey();
     PriceRule rule = priceRules.get(product);     
     price = price.add(calculatorPrice(item.getValue(), rule));     
    }
    return price;
  }

  private Price calculatorPrice( Integer numberProduct, PriceRule rule)
  {
    return rule.calculatorPrice(numberProduct);
  }
  
  public void registryRule(Product product ,PriceRule rule)
  {
    priceRules.put(product, rule);
  }  
}
