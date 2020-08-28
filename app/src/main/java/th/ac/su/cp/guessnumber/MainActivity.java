package th.ac.su.cp.guessnumber;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random r = new Random();
        answer = r.nextInt(100);
        Log.i("MainActivity","ค่าของ answer ที่สุ่มได้คือ "+ answer);

        Button guessButton = findViewById(R.id.guess_button);
        //guessButton.setText("Hello");
        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText numberEditText = findViewById(R.id.number_edit_text);
                String numText = numberEditText.getText().toString();
                int num = Integer.parseInt(numText);

                String msg = checkAnswer(num);

                Toast t = Toast.makeText(MainActivity.this, msg,Toast.LENGTH_LONG);
                t.show();

            }
        });
    }

    String checkAnswer(int guess){
        String msg;

        if(guess == answer){
            msg = "ถูกต้องครับ";
        }
        else if (guess > answer){
            msg = "ผิดครับ, มากเกินไป";
        }
        else{
            msg = "ผิดครับ, น้อยเกินไป";
        }
        return msg;
    }
}