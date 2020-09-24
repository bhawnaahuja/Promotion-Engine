package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PromotionEngineApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number of  items to be ordered");
		int itemCount = sc.nextInt();
		List<Item> items = new ArrayList();
		for (int i = 0; i < itemCount; i++) {
			System.out.println("Enter Item Name ");
			String name = sc.next();
			Item item = new Item(name);
			items.add(item);

		}
		System.out.println(getTotalPrice(items));

	}

	public static Long getTotalPrice(List<Item> items) {
		Map<String, Long> itemMap = items.stream().collect(Collectors.groupingBy(Item::getName, Collectors.counting()));

		Long countOfA = itemMap.get("A") != null ? itemMap.get("A") : 0;
		Long countOfB = itemMap.get("B") != null ? itemMap.get("B") : 0;
		Long countOfC = itemMap.get("C") != null ? itemMap.get("C") : 0;
		Long countOfD = itemMap.get("D") != null ? itemMap.get("D") : 0;

		Long totalPriceOfA = countOfA / 3 * 130 + countOfA % 3 * 50;
		Long totalPriceOfB = countOfB / 2 * 45 + countOfB % 2 * 30;
		Long totalPriceOfC = countOfC * 20;
		Long totalPriceOfD = countOfD * 15;
		if (countOfC + countOfD > 1) {
			countOfC--;
			countOfD--;
			return totalPriceOfA + totalPriceOfB + 30 + countOfC * 20 + countOfD * 15;
		} else {
			return totalPriceOfA + totalPriceOfB + totalPriceOfC + totalPriceOfD;
		}

	}

}