package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import main.java.Item;
import main.java.PromotionEngineApplication;

public class PromotionEngineTest {
	
	@Test
	public void Scenario1() {
		List<Item> items = new ArrayList<Item>();
		items.add(new Item("A"));
		items.add(new Item("B"));
		items.add(new Item("C"));
		Assert.assertEquals(100L, PromotionEngineApplication.getTotalPrice(items,1).longValue());
		
		
	}
	
	@Test
	public void Scenario2() {
		List<Item> items = new ArrayList<Item>();
		items.add(new Item("A"));
		items.add(new Item("A"));
		items.add(new Item("A"));
		items.add(new Item("A"));
		items.add(new Item("A"));
		items.add(new Item("B"));
		items.add(new Item("B"));
		items.add(new Item("B"));
		items.add(new Item("B"));
		items.add(new Item("B"));
		items.add(new Item("C"));
		Assert.assertEquals(390L, PromotionEngineApplication.getTotalPrice(items,2).longValue());
		
		
	}

	
		
		
	
}
