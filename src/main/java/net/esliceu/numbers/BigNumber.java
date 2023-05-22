package net.esliceu.numbers;



public class BigNumber implements BigNumberOperator {
    /**
     * Code smells
     *  - long function
     *  - wrong var names
     *  - comments
     *  - duplicated code
     */

    public static final int ADD = 1;
    public static final int SUBTRACT = -1;

    public String bigNumberString;
    private int carry;

    public BigNumber(String bigNumber) {
        bigNumberString = unPad(bigNumber);
    }

    private String unPad(String bigNumber) {
        while ((bigNumber.charAt(0) == '0') && bigNumber.length() > 1) {
            bigNumber = bigNumber.substring(1);
        }
        return bigNumber;
    }


    public boolean equals(BigNumber anotherBigNumber) {
        return this.compareTo(anotherBigNumber) == 0;
    }

    public int compareTo(BigNumber bigNumber2) {
        if (bigNumberString.length() > bigNumber2.bigNumberString.length()) {
            return 1;
        } else if (bigNumberString.length() < bigNumber2.bigNumberString.length()) {
            return -1;
        }

        for (int i = 0; i < bigNumberString.length(); i++) {
            if (bigNumberString.charAt(i) < bigNumber2.bigNumberString.charAt(i)) {
                return -1;
            } else if (bigNumberString.charAt(i) > bigNumber2.bigNumberString.charAt(i)) {
                return 1;
            }
        }

        return 0;

    }

    public String add(BigNumber secondBigNumber) {
        String secondBigNumberString = setBigNumbersToSameSize(secondBigNumber.bigNumberString);
        String result = "";
        carry = 0;
        int first;
        int second;
        for (int i = bigNumberString.length() - 1; i >= 0; i--) {
            first = Character.getNumericValue(bigNumberString.charAt(i));
            second = Character.getNumericValue(secondBigNumberString.charAt(i));

            result = addCharactersAndCalculateCarry(first, second) + result;
        }

        return unPad(result);
    }

    private int addCharactersAndCalculateCarry(int first, int second) {
        int operationResult;
        operationResult = first + (second + carry);
        if (hasCarry(operationResult)) {
            carry = 1;
            operationResult = operationResult - 10;
        }
        return operationResult;
    }


    public String subtract(BigNumber secondBigNumber) {
        return addOrSubtract(setBigNumbersToSameSize(secondBigNumber.bigNumberString), SUBTRACT);
    }

    private String addOrSubtract(String secondBigNumberString, int sign) {
        String result = "";
        carry = 0;
        int operationResult;
        for (int i = bigNumberString.length() - 1; i >= 0; i--) {
            operationResult = addOrSustractUnit(bigNumberString.charAt(i), secondBigNumberString.charAt(i), sign);

            result = operationResult + result;
        }

        return unPad(result);
    }

    private int addOrSustractUnit(char firstUnit, char secondUnit, int sign) {
        int first = Character.getNumericValue(firstUnit);
        int second = Character.getNumericValue(secondUnit);

        int operationResult = first + (sign * (second + carry));
        if (hasCarry(operationResult)) {
            carry = 1;
            operationResult = operationResult - (sign * 10);
        }
        return operationResult;
    }

    private boolean hasCarry(int addition) {
        return (addition > 9) || (addition < 0);
    }

    private String setBigNumbersToSameSize(String secondBigNumberString) {
        int maxLength = Math.max(bigNumberString.length(), secondBigNumberString.length());

        secondBigNumberString = pad(secondBigNumberString, maxLength);
        bigNumberString = pad(bigNumberString, maxLength);

        return secondBigNumberString;
    }

    private String pad(String number, int maxLength) {
        for (int i = number.length(); i < (maxLength); i++) {
            number = "0" + number;
        }
        return number;
    }


}
