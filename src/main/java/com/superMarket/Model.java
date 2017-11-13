/*
 * MIT License
 *
 * Copyright (c) 2017. Christos Tsotskas
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.superMarket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Model perspective in Model-View-Control
 */
public class Model {

    /**
     * @param validRequestedItems list of strings that contains the requested items by the user
     */
    private List<String> validRequestedItems;

    /**
     * @param costPerItem hardcoded cost per item
     */
    private HashMap<String, Double > costPerItem;

    /**
     * @param billedItems register of each item with the cumulative cost
     */
    private HashMap<String, Double> billedItems;

    /**
     * Constructor
     *
     * @param validRequestedItems list of strings that contains the request items to be purchased
     */
    public Model(List<String> validRequestedItems){
        this.validRequestedItems = validRequestedItems;

        costPerItem = new HashMap<String, Double>();
        costPerItem.put("SOUP", 0.65);
        costPerItem.put("BREAD", 0.8);
        costPerItem.put("MILK", 1.3);
        costPerItem.put("APPLES", 1.0);

        billedItems = new HashMap<String, Double>();

        calculateCostOfRequestedItems();

    }

    /**
     * Calculate the cost of the requested items
     */
    void calculateCostOfRequestedItems(){

        double currentCostOfSpecificItem = 0.0;

        for (String itemToCharge : validRequestedItems){
            itemToCharge = itemToCharge.toUpperCase();
            currentCostOfSpecificItem = costPerItem.get(itemToCharge);
            if( billedItems.containsKey(itemToCharge) ){
                currentCostOfSpecificItem += costPerItem.get(itemToCharge);
                billedItems.put(itemToCharge, currentCostOfSpecificItem);
            }else {
                billedItems.put(itemToCharge, currentCostOfSpecificItem);
            }

        }

    }

    /**
     * Get the total cost of the order without applying any discount
     *
     * @return total cost of order
     */
    public Double getTotalCostOfRequestedItemsWithoutDiscount(){
        Double totalCost = 0.0;

        for (Map.Entry<String, Double> entry : billedItems.entrySet()){
            totalCost += entry.getValue();
        }

        return totalCost;
    }


}
