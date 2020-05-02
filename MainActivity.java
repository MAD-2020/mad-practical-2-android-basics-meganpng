package sg.edu.np.WhackAMole;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.*;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Whack A Mole!";
    TextView resultTextView;
    int score = 0;
    DecimalFormat df = new DecimalFormat("#");
    String strscore = df.format(score);
    Button button4;
    Button button5;
    Button button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "Finished Pre-Initialisation!");
        resultTextView = findViewById(R.id.resultView);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);

    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.v(TAG, "Starting GUI!");

        resultTextView.setText(strscore);

        setNewMole();
        View.OnClickListener onclick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button4:
                        Log.v(TAG, "Button Left Clicked!");
                        if (button4.getText() == "*") {
                            score += 1;
                            strscore = df.format(score);
                            resultTextView.setText(strscore);
                            Log.v(TAG, "Hit, score added!\n");
                            setNewMole();
                        } else {
                            score -= 1;
                            strscore = df.format(score);
                            resultTextView.setText(strscore);
                            System.out.println("Missed, score deducted!");
                            setNewMole();
                        }
                        break;


                    case R.id.button5:
                        Log.v(TAG, "Button Middle Clicked!");

                        if (button5.getText() == "*") {
                            score += 1;
                            strscore = df.format(score);
                            resultTextView.setText(strscore);
                            Log.v(TAG, "Hit, score added!\n");
                            setNewMole();
                        } else {
                            score -= 1;
                            strscore = df.format(score);
                            resultTextView.setText(strscore);
                            Log.v(TAG, "Missed, score deducted!\n");
                            setNewMole();
                        }
                        break;

                    case R.id.button6:
                        Log.v(TAG, "Button Right Clicked!");

                        if (button6.getText() == "*") {
                            score += 1;
                            strscore = df.format(score);
                            resultTextView.setText(strscore);
                            Log.v(TAG, "Hit, score added!\n");
                            setNewMole();
                        } else {
                            score -= 1;
                            strscore = df.format(score);
                            resultTextView.setText(strscore);
                            Log.v(TAG, "Missed, score deducted!\n");
                            setNewMole();
                        }


                }
            }


        };

        button4.setOnClickListener(onclick);
        button5.setOnClickListener(onclick);
        button6.setOnClickListener(onclick);
    }




    public void setNewMole()
    {
        Random ran = new Random();
        int randomLocation = ran.nextInt(3);

        if(randomLocation == 0){
            button4.setText("*");
            button5.setText("O");
            button6.setText("O");
        }
        else if(randomLocation == 1){
            button5.setText("*");
            button4.setText("O");
            button6.setText("O");
        }
        else if(randomLocation == 2){
            button6.setText("*");
            button5.setText("O");
            button4.setText("O");
        }
    }


}
