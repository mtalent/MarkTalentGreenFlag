package com.assignment.marktalentgreenflag;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActivityCreateAccount extends AppCompatActivity {

    TextView tvButtonNext;
    EditText etEmail;
    EditText etCreatePassword;
    EditText etRepeatPassword;
    ImageView ivCheckMark;
    ImageView ivCheckPassword;
    ImageView ivCheckPasswordRepeat;
    TextView tvBadPasswordWarning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create_account);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        tvButtonNext = findViewById(R.id.tv_button_2);
        etEmail = findViewById(R.id.et_email);
        ivCheckMark = findViewById(R.id.iv_check_email);
        ivCheckPassword = findViewById(R.id.iv_check_password);
        ivCheckPasswordRepeat = findViewById(R.id.iv_check_repeat_password);
        etCreatePassword = findViewById(R.id.et_password);
        etRepeatPassword = findViewById(R.id.et_repeat_password);
        tvBadPasswordWarning = findViewById(R.id.tv_label_password_bad);
        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                Pattern ps = Pattern.compile("^\\w+[\\w-\\.]*\\@\\w+((-\\w+)|(\\w*))\\.[a-z]{2,3}$");
                Matcher ms = ps.matcher(etEmail.getText().toString());
                boolean bs = ms.matches();


                if(bs) {
                    ivCheckMark.setVisibility(View.VISIBLE);
                    etEmail.setBackgroundResource(R.drawable.textview_border_green);

                }
                else{
                    ivCheckMark.setVisibility(View.INVISIBLE);
                    etEmail.setBackgroundResource(R.drawable.textview_border);
                };



            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        etCreatePassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {



            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                Pattern ps = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$");
                Matcher ms = ps.matcher(etCreatePassword.getText().toString());
                boolean bs = ms.matches();


                if(bs) {
                    ivCheckPassword.setVisibility(View.VISIBLE);
                    etCreatePassword.setBackgroundResource(R.drawable.textview_border_green);
                    tvBadPasswordWarning.setVisibility(View.GONE);


                }
                else{
                    ivCheckPassword.setVisibility(View.INVISIBLE);
                    etCreatePassword.setBackgroundResource(R.drawable.textview_border);
                    tvBadPasswordWarning.setVisibility(View.VISIBLE);

                };



            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        etRepeatPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                Pattern ps = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$");
                Matcher ms = ps.matcher(etRepeatPassword.getText().toString());
                boolean bs = ms.matches();

                if(bs) {
                    ivCheckPasswordRepeat.setVisibility(View.VISIBLE);
                    etRepeatPassword.setBackgroundResource(R.drawable.textview_border_green);
                    tvBadPasswordWarning.setVisibility(View.GONE);
                    tvButtonNext.setBackgroundResource(R.drawable.gradient_button_backgroundx);
                    tvButtonNext.setEnabled(true);


                }
                else {
                    ivCheckPasswordRepeat.setVisibility(View.INVISIBLE);
                    etRepeatPassword.setBackgroundResource(R.drawable.textview_border);
                    tvBadPasswordWarning.setVisibility(View.VISIBLE);
                    tvButtonNext.setBackgroundResource(R.drawable.textview_border_rectangle_grey_button);
                    tvButtonNext.setEnabled(false);

                }



            }


            @Override
            public void afterTextChanged(Editable editable) {




            }
        });

        tvButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Objects.equals(etCreatePassword.getText().toString(), etRepeatPassword.getText().toString())) {
                    Toast.makeText(ActivityCreateAccount.this, "Account creation successful.", Toast.LENGTH_LONG).show();
                    finish();
                }
                else {
                    tvBadPasswordWarning.setVisibility(View.VISIBLE);
                    etRepeatPassword.requestFocus();
                    etRepeatPassword.setBackgroundResource(R.drawable.textview_border);
                    tvButtonNext.setEnabled(false);
                    etRepeatPassword.setText("");
                    tvButtonNext.setBackgroundResource(R.drawable.textview_border_rectangle_grey_button);
                }



            }
        });









    }
}