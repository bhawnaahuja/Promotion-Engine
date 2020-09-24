package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PromotionEngineApplication {

	/*
	 * This code is based on the assumption at a time only one promotion can be
	 * applied.
	 * The user has to enter the no of items and then add items in the cart.
	 */
	private static final List<Promotion> promotionsList = new ArrayList<>();
	static {
		Map<String, Integer> promotionCountMap = new HashMap<String, Integer>();
		promotionCountMap.put("A", 3);
		Promotion P1 = new Promotion(1, 130L, promotionCountMap);
		promotionCountMap = new HashMap<String, Integer>();
		promotionCountMap.put("B", 2);
		
		Promotion P2 = new Promotion(2, 45L, promotionCountMap);
		
		promotionsList.add(P1);
		promotionsList.add(P2);
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number of  items to be ordered");
		int itemCount = sc.nextInt();
		List<Item> items = new ArrayList<Item>();
		for (int i = 0; i < itemCount; i++) {
			System.out.println("Enter Item Name ");
			String name = sc.next();
			Item item = new Item(name);
			items.add(item);

		}
		System.out.println("Choose Promotion code - >1,2 ");
		int promoId = sc.nextInt();

		System.out.println(getTotalPrice(items, promoId));
		sc.close();
	

	}

	public static Long getTotalPrice(List<Item> items, int promoId) {
		Promotion appliedpromo = promotionsList.stream().filter(x -> x.getPromoId() == promoId).findFirst()
				.orElse(null);

		Map<String, Long> itemMap = items.stream().collect(Collectors.groupingBy(Item::getName, Collectors.counting()));

		Long decimalPrice = 0L;
		for (Entry<String, Long> entry : itemMap.entrySet()) {
			Integer promoCount = appliedpromo.getInnerMap().get(entry.getKey());
			if (promoCount != null) {

				Long quotient = entry.getValue() / promoCount;
				Long remainder = entry.getValue() % promoCount;
				decimalPrice = decimalPrice + quotient * appliedpromo.getPromoPrice()
						+ remainder * getPriceByType(entry.getKey());
			} else {
				decimalPrice = decimalPrice + entry.getValue() * getPriceByType(entry.getKey());
			}

		}
		return decimalPrice;
	}

	static Integer getPriceByType(String name) {
		switch (name) {
		case "A":
			return 50;

		case "B":
			return 30;

		case "C":
			return 20;

		case "D":
			return 15;

		}
		return 0;
	}

}