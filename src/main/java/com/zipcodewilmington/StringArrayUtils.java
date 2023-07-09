package com.zipcodewilmington;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {

        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {

        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        for (int i = 0; i <= array.length; i++) {
            if (array[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {

        String[] rev = new String[array.length];
        for (int i = array.length - 1, j = 0; i >= 0; i--, j++) {
            rev[j] = array[i].toString();
        }
        return rev;
        //        List<String> list = Arrays.asList(array);
        //        Collections.reverse(list);
        //        String[] rev = list.toArray(array);
        //        return rev;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            if (!array[start].equals(array[end])) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        boolean[] alphabet = new boolean[26];

        for (int i = 0; i < array.length; i++) {
            String str = array[i];
            for (int j = 0; j < str.length(); j++) {
                char letter = Character.toLowerCase(str.charAt(j));
                if (Character.isLetter(letter)) {
                    alphabet[letter - 'a'] = true;
                }
            }
        }
        for (int i = 0; i < alphabet.length; i++) {
            if (!alphabet[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int count = 0;

        for (String used : array) {
            if (used.equals(value)) {
                count++;
            }
        }
        return count;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        ArrayList<String> newArr = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != valueToRemove) {
                newArr.add(array[i]);
            }

        }
        return newArr.toArray(new String[0]);
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        ArrayList<String> newArr = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1 && array[i].equals(array[i + 1])) {
                continue;
            }
            newArr.add(array[i]);
        }
        return newArr.toArray(new String[0]);
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        if (array == null || array.length == 0) {
            return new String[0];
        }
        ArrayList<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        sb.append(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (array[i].equals(array[i - 1])) {
                sb.append(array[i]);
            } else {
                result.add(sb.toString());
                sb = new StringBuilder();
                sb.append(array[i]);
            }
        }
        result.add(sb.toString());
        return result.toArray(new String[result.size()]);
    }
}

