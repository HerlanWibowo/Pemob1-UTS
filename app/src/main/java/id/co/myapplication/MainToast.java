package id.co.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

public class MainToast extends AppCompatActivity {
    private int hitung = 1;
    private TextView showHitung;
    private int fib1 = 1; // Nilai pertama dalam deret Fibonacci
    private int fib2 = 1; // Nilai kedua dalam deret Fibonacci
    private EditText inputCount;
    private boolean maxCountSet = false;
    private int maxCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        showHitung = (TextView) findViewById(R.id.show_count);
        inputCount = (EditText) findViewById(R.id.max_input);
        fib1 = 1;
        fib2 = 1;
        showHitung.setText(Integer.toString(fib1));
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
        showHitung.setText(Integer.toString(1));
    }

    public void countBack(View view) {
        fib1 = 1;
        fib2 = 1;
        maxCount = 0;
        maxCountSet = false;
        inputCount.setText("");
        showHitung.setText(Integer.toString(0));
    }

    public void setMaxCount(View view) {
        String maxCountString = inputCount.getText().toString();
        if (!maxCountString.isEmpty()) {
            int newMaxCount = Integer.parseInt(maxCountString);
            if (newMaxCount >= 0) {
                maxCount = newMaxCount;
            }
        }
    }
    public void countUp(View view) {
        String maxCountString = inputCount.getText().toString();

        if (!maxCountString.isEmpty()) {
            int maxCount = Integer.parseInt(maxCountString);
            int nextFib = fib1 + fib2;

            if (maxCount >= 0) {
                if (fib1 <= maxCount) {
                    if (nextFib <= maxCount) {
                        fib1 = nextFib;
                        int temp = fib1;
                        fib1 = fib2;
                        fib2 = nextFib;
                    } else {
                        fib2 = maxCount;
                    }
                    showHitung.setText(Integer.toString(fib2));
                } else {
                    fib1 = 1;
                    fib2 = 1;
                    showHitung.setText(Integer.toString(0));
                }
            }
        } else {
            int nextFib = fib1 + fib2;
            fib1 = fib2;
            fib2 = nextFib;
            showHitung.setText(Integer.toString(fib1));
        }
    }
}