package com.brainlab.codingchallenge.CodingChallenge.util;

import com.brainlab.codingchallenge.CodingChallenge.exceptions.InconvertibleToNumberException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * uses ParseStringHandler to parse an input String, converts the obtained  arrayList from parsing into a sum.
 */
public class SumCalculator {
    private ParseStringHandler parseStringHandler;
    private List<String> list;
    private List<Integer> base10SumArray;

    public String calculateFinalSum(String stringToParse) throws InconvertibleToNumberException {
        parseStringHandler = new ParseStringHandler();
        list = parseStringHandler.stringToNumbersArray(stringToParse);
        this.fillBase10Array();
        base10SumArray = calculateSum(base10SumArray);
        return finalSum(base10SumArray);
    }

    /**
     * iterates base10SumArray and makes al the number in base 10 with the same sign by summing the adjacent different signs numbers.
     *
     * @param list of Integers with only one number +/-[0-9]
     * @return list with the final sum numbers that their position indicates the rank.
     */
    public List<Integer> calculateSum(List<Integer> list) {

        if (this.isSameSignforAllValues(list)) {
            return list;
        } else {
            int i = 0;
            boolean sameSign = true;
            while (i < list.size() - 2 && sameSign)
                i++;
            if (i != list.size()) {
                int newSum = list.get(i) * 10 + list.get(i + 1);
                list.set(i, (newSum / 10));
                list.set(i + 1, (newSum % 10));
                return calculateSum(list);

            } else {
                return calculateSum(list);
            }

        }
    }

    /**
     * Return the final sum as a String by displaying it.
     *
     * @param list
     * @return
     */
    private String finalSum(List<Integer> list) {
        String stringToReturn = "";
        int i = 0;
        while (list.get(i) == 0 && i < list.size() - 1)
            i++;
        if (i == list.size())
            return "0";
        else {
            list = list.subList(i, list.size());
        }

        for (Integer integer : list)
            stringToReturn += Math.abs(integer) + "";

        if (list.get(0) < 0)
            return "-" + stringToReturn;
        return stringToReturn;

    }

    /**
     * fills an array list with the base 10 numbers that. the list items are between +/-[0-9] (between -9 and 9)
     */
    public void fillBase10Array() {
        int numbersLength = StringsUtils.startsWithSign(list.get(0)) ? list.get(0).length() - 1 : list.get(0).length();
        base10SumArray = new ArrayList<>(numbersLength);
//        if (list.size() > 1) {

        Integer base10Sum = 0;
        int position;
        for (position = numbersLength - 1; position >= 0; position--) {
            base10Sum /= 10;
            for (int i = 0; i < list.size(); i++) {
                String numberAsString = list.get(i);
                int realPosition = (StringsUtils.startsWithSign(numberAsString)) ? position + 1 : position;
                //ignore to sum zero values
                if (numberAsString.charAt(realPosition) != '0') {
                    int inValue = Character.getNumericValue(numberAsString.charAt(realPosition));
                    if (numberAsString.charAt(0) == '-')
                        inValue *= -1;
                    base10Sum += inValue;
                }
            }

            base10SumArray.add(new Integer(base10Sum % 10));

        }
        while ((base10Sum /= 10) != 0) {
            base10SumArray.add(new Integer(base10Sum % 10));

        }
        Collections.reverse(base10SumArray);
    }

    /**
     * returns true if all the Array list items are with the same sign or not.
     *
     * @param list list to check
     * @return true if  the list's items are with the same sign, false if not
     */
    private boolean isSameSignforAllValues(List<Integer> list) {
        if (list.isEmpty()) {
            //throw  new
            return false;
        } else {
            if (list.size() == 0)
                return true;
            int i = 0;
            boolean sameSign = true;
            while (sameSign && i < list.size() - 2) {
                if ((list.get(i) > 0 && list.get(i) < 0) || (list.get(i) > 0 && list.get(i) < 0)) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public ParseStringHandler getParseStringHandler() {
        return parseStringHandler;
    }

    public void setParseStringHandler(ParseStringHandler parseStringHandler) {
        this.parseStringHandler = parseStringHandler;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
