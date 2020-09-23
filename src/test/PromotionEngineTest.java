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
		Assert.assertEquals(100L, PromotionEngineApplication.getTotalPrice(items).longValue());
		
		
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
		Assert.assertEquals(370L, PromotionEngineApplication.getTotalPrice(items).longValue());
		
		
	}

	@Test
	public void Scenario3() {
		List<Item> items = new ArrayList<Item>();
		items.add(new Item("A"));
		items.add(new Item("A"));
		items.add(new Item("A"));
		items.add(new Item("B"));
		items.add(new Item("B"));
		items.add(new Item("B"));
		items.add(new Item("B"));
		items.add(new Item("B"));
		items.add(new Item("C"));
		items.add(new Item("D"));
		
		Assert.assertEquals(280L, PromotionEngineApplication.getTotalPrice(items).longValue());
		
		
	}
}
