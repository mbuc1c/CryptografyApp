package com.mbucic.cryptografyapp.model.cipher;

import android.content.Context;

public class VigenereCipher implements CipherStrategy{

    /*
    ref: https://www.sanfoundry.com/java-program-implement-vigenere-cipher/
     */
    @Override
    public String encrypt(Context context, String input, String key) {
        StringBuilder res = new StringBuilder();
        input = input.toUpperCase();
        key = key.toUpperCase();
        for (int i = 0, j = 0; i < input.length(); i++)
        {
            char c = input.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            res.append((char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A'));
            j = ++j % key.length();
        }
        return res.toString();
    }

    @Override
    public String decrypt(Context context, String input, String key) {
        StringBuilder res = new StringBuilder();
        input = input.toUpperCase();
        key = key.toUpperCase();
        for (int i = 0, j = 0; i < input.length(); i++)
        {
            char c = input.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            res.append((char) ((c - key.charAt(j) + 26) % 26 + 'A'));
            j = ++j % key.length();
        }
        return res.toString();
    }
}
