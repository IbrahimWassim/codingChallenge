package com.brainlab.codingchallenge.CodingChallenge.util;


import com.brainlab.codingchallenge.CodingChallenge.exceptions.InconvertibleToNumberException;
import com.brainlab.codingchallenge.CodingChallenge.services.impl.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parses a random string into a list of numeric String having the same length by adding a 0 to the right.
 */
@Component
public class ParseStringHandler {
    private static final Logger LOG = LoggerFactory.getLogger(CalculatorService.class);

    private String stringToParse;
    private List<String> numericInputs;
    protected static String COMMA_SEPARATED_NUMBERS_REGEX = "^[+-]?([0-9]+)(,[+-]?([0-9]+))*$";


    public ParseStringHandler() {
    }

    /**
     * coverts a string into  a list of string in number format with equal length.the numbers are extended to the right with 0.
     *
     * @return the list of String that are in number format
     * @throws InconvertibleToNumberException in case one of the list's numbers is not a number .
     */
    public List stringToNumbersArray(String stringToParse) throws InconvertibleToNumberException {
        this.stringToParse = stringToParse;
        if (validateInputString(stringToParse)) {
            if (!StringUtils.isEmpty(stringToParse)) {

                stringToParse = stringToParse.replaceAll("\\s+", "");//remove all the spaces and
                numericInputs = Arrays.asList(stringToParse.split(","));

                if (numericInputs.size() > 1) {
                    int maxNumberLength = 0;
                    List copyList = new ArrayList<String>();
                    Iterator itr = numericInputs.iterator();
                    while (itr.hasNext()) {
                        String numberAsString = (String) itr.next();
                        //ignore values  equal to 0
                        if (!numberAsString.matches("^[+-]?[0]+$")) {
                            if (StringsUtils.startsWithSign(numberAsString)) {
                                maxNumberLength = Math.max(numberAsString.length() - 1, maxNumberLength);
                            } else {
                                maxNumberLength = Math.max(numberAsString.length(), maxNumberLength);
                            }
                            copyList.add(numberAsString);

                        } else {
                            if (copyList.isEmpty()) {
                                copyList.add("0");
                            }
                        }
                    }
                    numericInputs = copyList;

                    // add "0" to right of the numbers to make all the list elements with equal length(- and not counted)
                    if (copyList.size() > 1) {
                        for (int i = 0; i < numericInputs.size(); i++) {
                            numericInputs.set(i, formatString(numericInputs.get(i), maxNumberLength));
                        }
                    }
                }

            } else {
                numericInputs = Collections.emptyList();
            }
            System.out.println(numericInputs);
        } else {
            throw new InconvertibleToNumberException();

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
        if (StringsUtils.startsWithSign(stringToFormat))
            return StringsUtils.numberLeftPad(stringToFormat, requiredLength + 1, 1, '0');
        return StringsUtils.numberLeftPad(stringToFormat, requiredLength, 0, '0');

    }

    public boolean validateInputString(String inputString) throws InconvertibleToNumberException {
        if (!StringUtils.isEmpty(inputString)) {
            inputString = inputString.replaceAll("\\s+", "");//remove all the spaces
            Pattern p = Pattern.compile(COMMA_SEPARATED_NUMBERS_REGEX, Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(inputString);
            return m.matches();
        } else {
            throw new InconvertibleToNumberException();
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
