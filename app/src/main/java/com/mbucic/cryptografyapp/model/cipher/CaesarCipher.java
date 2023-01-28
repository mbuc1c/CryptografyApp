package com.mbucic.cryptografyapp.model.cipher;

import android.content.Context;
import android.widget.Toast;

public class CaesarCipher implements CipherStrategy {

    /*
    ref: https://www.topcoder.com/thrive/articles/caesar-cipher-in-java-encryption-and-decryption
     */
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    @Override
    public String encrypt(Context context, String input, String key) {
        try {
            input = input.toLowerCase();
            int shiftKey = Integer.parseInt(key);
            StringBuilder cipherText = new StringBuilder();
            for (int ii = 0; ii < input.length(); ii++) {
                int charPosition = ALPHABET.indexOf(input.charAt(ii));
                int keyVal = (shiftKey + charPosition) % 26;
                char replaceVal = ALPHABET.charAt(keyVal);
                cipherText.append(replaceVal);
            }
            return cipherText.toString();
        } catch (NumberFormatException e) {
            Toast.makeText(context, "Enter number as Key!", Toast.LENGTH_SHORT).show();
            return "";
        }

    }

    @Override
    public String decrypt(Context context, String input, String key) {
        try {
            input = input.toLowerCase();
            int shiftKey = Integer.parseInt(key);
            StringBuilder message = new StringBuilder();
            for (int ii = 0; ii < input.length(); ii++) {
                int charPosition = ALPHABET.indexOf(input.charAt(ii));
                int keyVal = (charPosition - shiftKey) % 26;
                if (keyVal < 0) {
                    keyVal = ALPHABET.length() + keyVal;
                }
                char replaceVal = ALPHABET.charAt(keyVal);
                message.append(replaceVal);
            }
            return message.toString();
        } catch (NumberFormatException e) {
            Toast.makeText(context, "Enter number as Key!", Toast.LENGTH_SHORT).show();
            return "";
        }
    }
}
