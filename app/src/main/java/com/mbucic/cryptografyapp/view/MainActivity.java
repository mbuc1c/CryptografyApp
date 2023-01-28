package com.mbucic.cryptografyapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mbucic.cryptografyapp.R;
import com.mbucic.cryptografyapp.model.cipher.AtbashCipher;
import com.mbucic.cryptografyapp.model.cipher.CaesarCipher;
import com.mbucic.cryptografyapp.model.cipher.CipherStrategy;
import com.mbucic.cryptografyapp.model.cipher.VigenereCipher;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnExecute) Button btnExecute;
    @BindView(R.id.etInput) EditText etInput;
    @BindView(R.id.etKey) EditText etKey;
    @BindView(R.id.rgCommand) RadioGroup rgCommand;
    @BindView(R.id.rgCipher) RadioGroup rgCipher;
    @BindView(R.id.rbCaesar) RadioButton rbCaesar;
    @BindView(R.id.rbVigenere) RadioButton radioButton1;
    @BindView(R.id.rbAtbash) RadioButton radioButton2;
    @BindView(R.id.rbEncrypt) RadioButton rbEncrypt;
    @BindView(R.id.rbDecrypt) RadioButton rbDecrypt;
    @BindView(R.id.tvCipher) TextView tvCipher;
    boolean encrypt;
    CipherStrategy strategy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        strategy = new CaesarCipher();
    }

    private boolean getEncrypt() {
        if (rbEncrypt.isChecked()) {
            return true;
        }
        return false;
    }

    @OnClick(R.id.rbCaesar)
    void initCaesarStrategy() {
        strategy = new CaesarCipher();
        etKey.setHint("Enter key");
        etKey.setEnabled(true);
    }

    @OnClick(R.id.rbVigenere)
    void initSomeStrategy() {
        strategy = new VigenereCipher();
        etKey.setHint("Enter key");
        etKey.setEnabled(true);
    }

    @OnClick(R.id.rbAtbash)
    void initSomeStrategy1() {
        strategy = new AtbashCipher();
        etKey.setHint("No key needed");
        etKey.setEnabled(false);
    }

    @OnClick(R.id.btnExecute)
    void execute() {
        encrypt = getEncrypt();
        String input = etInput.getText().toString();
        String key = etKey.getText().toString();

        if (encrypt) {
            tvCipher.setText(strategy.encrypt(this, input, key));
        } else {
            tvCipher.setText(strategy.decrypt(this, input, key));
        }
    }
}