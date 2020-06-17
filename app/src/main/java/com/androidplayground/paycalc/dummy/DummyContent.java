package com.androidplayground.paycalc.dummy;

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
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    //private static final int COUNT = 25;

    static {
        // Add some sample items.
        addItem(new DummyItem("1", "John Smith", "Tea picking", 10));
        addItem(new DummyItem("1", "John Smith", "Tea picking", 10));
        addItem(new DummyItem("1", "John Smith", "Tea picking", 10));
    }

    private static void addItem(DummyItem item) {

        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

//    private static DummyItem createDummyItem(int position) {
//        return new DummyItem(String.valueOf(position), "Item " + position, makeDetails(position));
//    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        //note to me..I changed content to workerName
        public final String workerName;
        //note to me..I changed details to category
        public final String category;
        private int amount;
        private int workUnit;


        public DummyItem(String id, String workerName, String category, int workUnit) {
            this.id = id;
            this.workerName = workerName;
            this.category = category;
            this.workUnit = workUnit;
        }



        @Override
        public String toString() {
            return workerName;
        }

        public String getAmount(){
            return String.valueOf(amount);
        }

        public void setAmount(int amount){
            this.amount = workUnit * 50;
        }
    }
}
