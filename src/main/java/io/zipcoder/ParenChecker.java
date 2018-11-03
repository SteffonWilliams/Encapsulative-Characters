package io.zipcoder;

import java.util.Stack;

public class ParenChecker {

    private Stack stacks = new Stack ();

    public boolean isParenPaired(String phrase) {

        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i) == '(') {
                stacks.push(phrase.charAt(i));

            }
            if (phrase.charAt(i) == ')') {
                if (!stacks.isEmpty()) {
                    if (stacks.firstElement().equals('(')) {
                        stacks.pop();

                    } else {
                        return false;
                    }
                } else {
                    return false;
                }


            }
        }
            if (stacks.size() > 0) {

                return false;
            }

            return true;

        }


     public boolean isAllPaired(String phrase) {

         for (int i = 0; i < phrase.length(); i++) {
             if (phrase.charAt(i) == '(' || phrase.charAt(i) == '{' || phrase.charAt(i) == '[') {
                 stacks.push(phrase.charAt(i));

             }

             if (phrase.charAt(i) == ')' || phrase.charAt(i) == '}' || phrase.charAt(i) == ']') {
                 if (stacks.isEmpty()) {

                     return false;
                 } else {

                     stacks.pop();
                 }

             }

         }

         System.out.println(stacks);


         if (stacks.isEmpty()) {
             return true;

         } else {

             return false;
     }

        }

        public boolean isDoubleQuoteaPaired (String phrase) {
        int counter = 0;
        for (int i = 0; i < phrase.length(); i++) {
            if(phrase.charAt(i) == '"') {
                counter++;
            }
            }
            if (counter % 2 ==0) {
                return true;
            }
            return false;
        }

        public boolean isSingleQuoteAndPair(String phrase) {
            int counter = 0;

            for (int i = 0; i < phrase.length();  i++) {
                if (phrase.charAt(i) == '\'') {
                    counter++;

                }
            }

            if (counter % 2 == 0) {
                return true;
            }
            return false;
        }

    }


