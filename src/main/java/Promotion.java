package main.java;

import java.util.Map;

public class Promotion {

	private int promoId;
	private Long promoPrice;
	private Map<String, Integer> innerMap;

	public int getPromoId() {
		return promoId;
	}

	public void setPromoId(int promoId) {
		this.promoId = promoId;
	}

	public Long getPromoPrice() {
		return promoPrice;
	}

	public void setPromoPrice(Long promoPrice) {
		this.promoPrice = promoPrice;
	}

	public Map<String, Integer> getInnerMap() {
		return innerMap;
	}

	public void setInnerMap(Map<String, Integer> innerMap) {
		this.innerMap = innerMap;
	}

	public Promotion(int promoId, Long promoPrice, Map<String, Integer> innerMap) {
		super();
		this.promoId = promoId;
		this.promoPrice = promoPrice;
		this.innerMap = innerMap;
	}

}
