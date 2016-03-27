package checkouit;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PurchaseList
{
  private Map<Product, Integer> products = new HashMap<>();

  public void add(Product product)
  {
    if(!products.containsKey(product))
    {
      products.put(product, 0);
    }
    products.put(product, products.get(product)+1);   
  }

  public Set<Entry<Product, Integer>> entrySet()
  {    
    return products.entrySet();
  }
}
