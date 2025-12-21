package com.example.still.hepler;
import java.security.SecureRandom;

public class RandomIdGenerator {

    private static final String CHARS =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 24;

    public static String generate() {
        int length = (int) (Math.random() * (MAX_LENGTH - MIN_LENGTH + 1)) + MIN_LENGTH;

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * CHARS.length());
            sb.append(CHARS.charAt(index));
        }
        return sb.toString();
    }

}


//private static final String CHARS =
//        "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//private static final SecureRandom RANDOM = new SecureRandom();
//
//private static final int MIN_LENGTH = 1;
//private static final int MAX_LENGTH = 24;
//
//public static String generate() {
//    int length = RANDOM.nextInt(MAX_LENGTH - MIN_LENGTH + 1) + MIN_LENGTH;
//
//    StringBuilder sb = new StringBuilder(length);
//    for (int i = 0; i < length; i++) {
//        sb.append(CHARS.charAt(RANDOM.nextInt(CHARS.length())));
//    }
//    return sb.toString();
//}
