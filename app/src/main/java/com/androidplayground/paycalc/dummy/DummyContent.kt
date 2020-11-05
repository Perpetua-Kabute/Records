package com.androidplayground.paycalc.dummy

import org.junit.runner.RunWith
import java.util.*

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object DummyContent {
    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<DummyItem?>? = ArrayList()

    /**>
     * A map of sample (dummy) items, by ID.
     */
    val ITEM_MAP: MutableMap<String?, DummyItem?>? = HashMap()
    private fun addItem(item: DummyItem?) {
        ITEMS?.add(item)
        ITEM_MAP!![item?.id] = item
    }

    //    private static DummyItem createDummyItem(int position) {
    //        return new DummyItem(String.valueOf(position), "Item " + position, makeDetails(position));
    //    }
    private fun makeDetails(position: Int): String? {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0 until position) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

    /**
     * A dummy item representing a piece of content.
     */
    class DummyItem(val id: String?, //note to me..I changed content to workerName
                    val workerName: String?, //note to me..I changed details to category
                    val category: String?, private val workUnit: Int) {
        private var amount = 0
        override fun toString(): String {
            return workerName!!
        }

        fun getAmount(): String? {
            return amount.toString()
        }

        fun setAmount(amount: Int) {
            this.amount = workUnit * 50
        }
    }

    //private static final int COUNT = 25;
    init {
        for(i in 0 .. 23)
        addItem(DummyItem("1", "John Smith", "Tea picking", (0..10).random()))

    }
}