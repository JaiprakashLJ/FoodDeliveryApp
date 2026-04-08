package com.tap.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Integer, cartItem> items;

    public Cart() {
        this.items = new HashMap<>();
    }
    public Map<Integer, cartItem> getItems() {
        return items;
    }

    public void addItem(cartItem item) {
        int itemId = item.getMenuId();

        if (items.containsKey(itemId)) {
            cartItem existingItem = items.get(itemId);
            existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
        } else {
            items.put(itemId, item);
        }
    }
    
    
    public void UpdateItem(int itemId,int quantity)
    {
    	if(items.containsKey(itemId))
    	{
    		if(quantity<=0)
    		{
    			items.remove(itemId);
    		}
    		else
    		{
    			cartItem cartitem=items.get(itemId);
    			cartitem.setQuantity(quantity);
    		}
    	}
    }
    
    public void removeItem(int itemId)
    {
    	items.remove(itemId);
    }
}