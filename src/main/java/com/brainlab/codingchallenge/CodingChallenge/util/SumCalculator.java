package com.brainlab.codingchallenge.CodingChallenge.util;

import com.brainlab.codingchallenge.CodingChallenge.exceptions.InconvertibleToNumberException;

import java.math.BigInteger;
import java.util.List;

public class SumCalculator {
    private ParseStringHandler parseStringHandler;
    private List<String> list;
    private int[][] baset10Matrix;
    private Integer[] base10SumArray;

    public BigInteger calculateFinalSum(String stringToParse) throws InconvertibleToNumberException {
        parseStringHandler = new ParseStringHandler();
        this.calculateList(stringToParse);
        this.initializeMatrix();
        this.fillBase10SumArray();
        return calculateSum();
    }


    public void calculateList(String stringToParse) throws InconvertibleToNumberException {
        list = parseStringHandler.stringToNumbersArray(stringToParse);

    }

    /**
     * fill the matrix from a list of strings that have same length. the column index in the matrix present the base 10 position of the number
     */
    public void initializeMatrix() {
        if (list != null) {
            if (!list.isEmpty()) {
                int numbersLength = list.get(0).length();
                if (list.get(0).charAt(0) == '+' || list.get(0).charAt(0) == '-')
                    numbersLength--;
                baset10Matrix = new int[list.size()][numbersLength];
                for (int i = 0; i < list.size(); i++) {
                    String numberAsString = list.get(i);
                    for (int j = 0; j < numbersLength; j++) {

                        switch (list.get(i).charAt(0)) {
                            case '-':
                                baset10Matrix[i][j] = Character.getNumericValue(numberAsString.charAt(j + 1)) * (-1);
                                break;
                            case '+':
                                baset10Matrix[i][j] = Character.getNumericValue(numberAsString.charAt(j + 1));
                                break;
                            default:
                                baset10Matrix[i][j] = Character.getNumericValue(numberAsString.charAt(j));
                                break;
                        }
                    }
                }

            }
        }
    }

    public void fillBase10SumArray() {
        if (baset10Matrix != null) {
            int sumCol;
            int cols = baset10Matrix.length;
            int rows = baset10Matrix[0].length;
            base10SumArray = new Integer[rows];
            for (int i = 0; i < rows; i++) {
                sumCol = 0;

                for (int j = 0; j < cols; j++) {
                    sumCol += baset10Matrix[j][i];
                }
                base10SumArray[i] = Integer.valueOf(sumCol);

            }
        } else {
            base10SumArray = null;
        }

    }

    /**
     * iterates base10SumArray and calculates the final sum
     *
     * @return sum
     */
    public BigInteger calculateSum() {

        if (base10SumArray != null) {
            BigInteger sum= BigInteger.valueOf(0);
            for (int i = base10SumArray.length - 1; i >= 0; i--) {
                int currentcolumsum = ((int) (base10SumArray[i] * Math.pow(10,base10SumArray.length-1 - i)));
                sum=sum.add(BigInteger.valueOf(currentcolumsum));
            }
            return sum;
        } else {
            return null;
        }
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

    public int[][] getBaset10Matrix() {
        return baset10Matrix;
    }

    public void setBaset10Matrix(int[][] baset10Matrix) {
        this.baset10Matrix = baset10Matrix;
    }

    public Integer[] getBase10SumArray() {
        return base10SumArray;
    }

    public void setBase10SumArray(Integer[] base10SumArray) {
        this.base10SumArray = base10SumArray;
    }
}
