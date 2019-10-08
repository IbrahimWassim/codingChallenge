package com.brainlab.codingchallenge.CodingChallenge.util;

import org.springframework.util.StringUtils;

import java.util.Arrays;

public class StringsUtils {
    public static String numberLeftPad(String stringToPad, int finalLength, int position, char padChar) {
        if (finalLength < 0 || position < 0) {
            throw new IndexOutOfBoundsException("Cannot pad a negative amount: " + position);
            //Log

        } else {
            if (position > finalLength)
                //            throw new IndexOutOfBoundsException("Cannot pad a negative amount: " + repeat);
                if (StringUtils.isEmpty(stringToPad)) {
                    //exception for empty string Null pointer exception
                }
            char[] chars = new char[finalLength - stringToPad.length()];
            Arrays.fill(chars, padChar);
            String stringToInsert = new String(chars);

            return stringToPad.substring(0, position) + stringToInsert + stringToPad.substring(position);
        }
    }

    public static boolean startsWithSign(String s) {
        if (StringUtils.isEmpty(s))
            return false;
        return s.charAt(0) == '-' || s.charAt(0) == '+';
    }
}
