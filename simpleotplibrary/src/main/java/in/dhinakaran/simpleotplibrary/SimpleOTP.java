package in.dhinakaran.simpleotplibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class SimpleOTP extends LinearLayout {

    EditText otp1ET, otp2ET, otp3ET, otp4ET;

    public SimpleOTP(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        inflate(context, R.layout.layout_otp, this);

        int[] sets = {R.attr.otp1, R.attr.otp2, R.attr.otp3, R.attr.otp4};
        TypedArray typedArray = context.obtainStyledAttributes(attrs, sets);
        typedArray.recycle();

        initComponents();

    }

    private void initComponents() {
        otp1ET = findViewById(R.id.otp_1);
        otp2ET = findViewById(R.id.otp_2);
        otp3ET = findViewById(R.id.otp_3);
        otp4ET = findViewById(R.id.otp_4);

        otp1ET.addTextChangedListener(new SimpleOTP.GenericTextWatcher(otp1ET));
        otp2ET.addTextChangedListener(new SimpleOTP.GenericTextWatcher(otp2ET));
        otp3ET.addTextChangedListener(new SimpleOTP.GenericTextWatcher(otp3ET));
        otp4ET.addTextChangedListener(new SimpleOTP.GenericTextWatcher(otp4ET));

        otp2ET.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_DEL) {
                    if (otp2ET.getText().toString().equals("")) {
                        otp1ET.requestFocus();
                    }
                }
                return false;
            }
        });

        otp3ET.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_DEL) {
                    if (otp3ET.getText().toString().equals("")) {
                        otp2ET.requestFocus();
                    }
                }
                return false;
            }
        });

        otp4ET.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_DEL) {
                    if (otp4ET.getText().toString().equals("")) {
                        otp3ET.requestFocus();
                    }
                }
                return false;
            }
        });


    }

    public void setOtp1(CharSequence value) {
        otp1ET.setText(value);
    }

    public void setOtp2(CharSequence value) {
        otp2ET.setText(value);
    }

    public void setOtp3(CharSequence value) {
        otp3ET.setText(value);
    }

    public void setOtp4(CharSequence value) {
        otp4ET.setText(value);
    }

    private CharSequence getOtp1() {
        return otp1ET.getText();
    }

    private CharSequence getOtp2() {
        return otp2ET.getText();
    }

    private CharSequence getOtp3() {
        return otp3ET.getText();
    }

    private CharSequence getOtp4() {
        return otp4ET.getText();
    }

    public String getOtp() {
        String otp = getOtp1().toString() +
                getOtp2().toString() +
                getOtp3().toString() +
                getOtp4().toString();

        return otp;
    }


    public class GenericTextWatcher implements TextWatcher {

        private View view;

        private GenericTextWatcher(View view) {
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {

            String text = s.toString();
            int i = view.getId();
            if (i == R.id.otp_1) {
                if (text.length() == 1) {
                    otp2ET.requestFocus();
                }
            } else if (i == R.id.otp_2) {
                if (text.length() == 1) {
                    otp3ET.requestFocus();
                }
            } else if (i == R.id.otp_3) {
                if (text.length() == 1) {
                    otp4ET.requestFocus();
                }
            } else if (i == R.id.otp_4) {
            }
        }
    }


}