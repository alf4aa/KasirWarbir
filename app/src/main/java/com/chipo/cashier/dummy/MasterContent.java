package com.chipo.cashier.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class MasterContent {


	public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();


	public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

	static {
		// Add 3 sample items.
		addItem(new DummyItem("1", "DATA USER"));
		addItem(new DummyItem("2", "DATA CATEGORY"));
		addItem(new DummyItem("3", "DATA PRODUCT"));
	}

	private static void addItem(DummyItem item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.id, item);
	}

	public static class DummyItem {
		public String id;
		public String content;

		public DummyItem(String id, String content) {
			this.id = id;
			this.content = content;
		}

		@Override
		public String toString() {
			return content;
		}
	}
}
