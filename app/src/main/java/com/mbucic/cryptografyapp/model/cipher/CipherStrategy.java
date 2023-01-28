package com.mbucic.cryptografyapp.model.cipher;

import android.content.Context;

public interface CipherStrategy {

    String encrypt(Context context, String input, String key);
    String decrypt(Context context, String input, String key);
}
