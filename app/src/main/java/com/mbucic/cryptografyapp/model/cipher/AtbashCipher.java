package com.mbucic.cryptografyapp.model.cipher;

import android.content.Context;

public class AtbashCipher implements CipherStrategy{

    /*
    ref: https://github.com/tmck-code/Ciphers/blob/master/Atbash.java
     */
    @Override
    public String encrypt(Context context, String input, String key) {
        input = input.toUpperCase();
        StringBuilder decoded = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                int newChar = ('Z' - c) + 'A';
                decoded.append((char) newChar);
            } else {
                decoded.append(c);
            }
        }
        return decoded.toString();
    }

    @Override
    public String decrypt(Context context, String input, String key) {
        input = input.toUpperCase();
        StringBuilder decoded = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                int newChar = ('Z' - c) + 'A';
                decoded.append((char) newChar);
            } else {
                decoded.append(c);
            }
        }
        return decoded.toString();
    }
}
