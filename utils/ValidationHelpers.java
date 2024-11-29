package utils;

import exceptions.InvalidUserInputException;

import java.util.List;

public class ValidationHelpers {
    private static final String INVALID_NUM_OF_ARGUMENTS = "Invalid number of arguments. Expected: %d; received: %d.";

    public static void validateStringLength(String value, int minLength, int maxLength, String errorMessage) {
        if (value.length() < minLength || value.length() > maxLength) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void validateArgumentsCount(List<String> list, int expectedNumberOfParameters) {
        if (list.size() != expectedNumberOfParameters) {
            throw new IllegalArgumentException(
                    String.format(INVALID_NUM_OF_ARGUMENTS, expectedNumberOfParameters, list.size())
            );
        }
    }

    public static void validateIntRange(int value, int min, int max, String message) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateOnlyDigits(String stringToValidate, String errorMessage) {
        for (char character : stringToValidate.toCharArray()) {
            if (!Character.isDigit(character)) {
                throw new InvalidUserInputException(errorMessage);
            }
        }
    }

    public static void validateGreaterThanZero(double value) {
        if (value <= 0) {
            throw new InvalidUserInputException();
        }
    }

    public static void validateStringMinLength(String value, int minLength) {
        if (value == null || value.length() < minLength) {
            throw new InvalidUserInputException();
        }
    }
}