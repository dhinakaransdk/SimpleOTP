package in.dhinakaran.simpleotp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import in.dhinakaran.simpleotplibrary.SimpleOTP;

public class MainActivity extends AppCompatActivity {

    SimpleOTP simpleOTP;
    Button getOtp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleOTP = findViewById(R.id.otp_view);
        getOtp = findViewById(R.id.get_otp);

        getOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), simpleOTP.getOtp(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
