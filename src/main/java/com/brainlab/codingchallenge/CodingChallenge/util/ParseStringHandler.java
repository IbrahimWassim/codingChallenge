package com.brainlab.codingchallenge.CodingChallenge.util;


import com.brainlab.codingchallenge.CodingChallenge.exceptions.InconvertibleToNumberException;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Parses a random string into a list of numeric String having the same length by adding a 0 to the right.
 */
@Component
@Data
public class ParseStringHandler {
    private String stringToParse;
    private List<String> numericInputs;


    public ParseStringHandler() {
    }

    /**
     * coverts a string into  a list of string in number format with equal length.
     *
     * @throws InconvertibleToNumberException in case one of the list's numbers is not a number .
     */
    public List stringToNumbersArray(String stringToParse) throws InconvertibleToNumberException {
        this.stringToParse = stringToParse;
        if (!StringUtils.isEmpty(stringToParse)) {
            stringToParse = stringToParse.replaceAll("\\s+", "");//remove all the spaces and
            stringToParse = stringToParse.replaceAll("\\s*,\\s*", ",");//remove all the spaces and

            numericInputs = Arrays.asList(stringToParse.split("\\s*,\\s*"));

            if (numericInputs.size() > 1) {
                List copyList = new ArrayList<String>();
                int maxNumberLength = 0;
                Iterator itr = numericInputs.iterator();
                while (itr.hasNext()) {
                    String numberAsString = (String) itr.next();
                    //test if the value is entirely numbers (that can start with a minus('-') or plus('+'))
                    if (!StringUtils.isEmpty(numberAsString)) {
                        //do not copy values  equal to 0
                        if (numberAsString.matches("[+-]?[0]+"))
                            numberAsString = "";
                        //test if the value is entirely numbers (that can start with a minus('-') or plus('+'))
                        if (numberAsString.matches("[+-]?[0-9]+")) {
                            if (numberAsString.charAt(0) == '-' || numberAsString.charAt(0) == '+') {
                                maxNumberLength = Math.max(numberAsString.length() - 1, maxNumberLength);
                            } else {
                                maxNumberLength = Math.max(numberAsString.length(), maxNumberLength);
                            }
                            copyList.add(numberAsString);
                        } else {
                            throw new InconvertibleToNumberException();
                        }
                    }
                }
                numericInputs = copyList;

                // add "0" to right of the numbers to make all the list elements with equal length(- and not counted)
                for (int i = 0; i < numericInputs.size(); i++) {
                    numericInputs.set(i, formatString(numericInputs.get(i), maxNumberLength));
                }
            } else {
                if (numericInputs.size() == 0) {
                    numericInputs = Collections.emptyList();
                } else {
                    if (!numericInputs.get(0).matches("[+-]?[0-9]+"))
                        throw new InconvertibleToNumberException();
                }
            }

        } else {
            numericInputs = Collections.emptyList();
        }
        return numericInputs;
    }

    /**
     * Left pad a String with 0 to fit the required Length without counting the sign character.
     *
     * @param stringToFormat
     * @param requiredLength
     * @return
     */
    public String formatString(String stringToFormat, final int requiredLength) {
        int numberOfZerosToAddToTheLeft = 0;
        if (stringToFormat.charAt(0) == '-' || stringToFormat.charAt(0) == '+')
        { numberOfZerosToAddToTheLeft = requiredLength - stringToFormat.length() +1;}else {
            numberOfZerosToAddToTheLeft = requiredLength - stringToFormat.length() ;}
        if (numberOfZerosToAddToTheLeft != 0) {
            String stringToAdd = "";
            for (int i = 0; i < numberOfZerosToAddToTheLeft; i++) {
                stringToAdd += "0";
            }
            if (stringToFormat.charAt(0) == '-')
                return "-" + stringToAdd + stringToFormat.substring(1);

            if (stringToFormat.charAt(0) == '+')
                return "+" + stringToAdd + stringToFormat.substring(1);
            return stringToAdd + stringToFormat;
        } else {
            return stringToFormat;
        }

    }

    public String getStringToParse() {
        return stringToParse;
    }

    public void setStringToParse(String stringToParse) {
        this.stringToParse = stringToParse;
    }

    public List<String> getNumericInputs() {
        return numericInputs;
    }

    public void setNumericInputs(List<String> numericInputs) {
        this.numericInputs = numericInputs;
    }
}
