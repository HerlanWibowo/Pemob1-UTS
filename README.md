# UTS Pemograman Mobile 1
## Membuat Aplikasi Deret Angka Fibonacci di Android Studio
### Apa itu deret angka fibonacci?
    Deret Fibonacci adalah sebuah pola bilangan yang diperoleh dari penjumlahan dua bilangan sebelumnya di dalam deret tersebut.

### Tampilan UI
    Saya mempunyai 3 button dan 1 edit text :
    - edit text untuk user dapat menginput memberikan maksimal angka fibonacci
    - button max untuk membatasi angka maksimal yg sudah di input pada edit text
    - button count untuk menambah angka fibonacci untuk mencapai nilai maksimalnya
    - button back untuk mereset angka fibonacci dan inputan max menjadi 0
![UI Angka Fibonacci](https://github.com/HerlanWibowo/UTSMobile1/assets/106060694/919109c8-317d-4ff6-8f3e-08ede788199d)

### Source Code UI
#### Button max
```
<Button
        android:id="@+id/button_toast"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginTop="8dp"
        android:layout_marginEnd="200dp"
        android:background="@color/colorPrimary"
        android:onClick="showToast"
        android:text="@string/button_label_max"
        android:textColor="@android:color/white"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        tools:ignore="UsingOnClickInXml" />
```
#### Button Count
```
    <Button
        android:id="@+id/button_count"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginBottom="8dp"
        android:layout_marginEnd="200dp"
        android:layout_marginStart="8dp"
        android:background="@color/colorPrimary"
        android:onClick="countUp"
        android:text="@string/button_label_count"
        android:textColor="@android:color/white"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        tools:ignore="UsingOnClickInXml" />
```
#### Tampilan Angka Fibonacci
```
    <TextView
        android:id="@+id/show_count"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginBottom="8dp"
        android:layout_marginEnd="8dp"
        android:layout_marginStart="8dp"
        android:layout_marginTop="8dp"
        android:background="#FFFF00"
        android:gravity="center_vertical"
        android:text="@string/count_initial_value"
        android:textAlignment="center"
        android:textColor="@color/colorPrimary"
        android:textSize="160sp"
        android:textStyle="bold"
        app:layout_constraintBottom_toTopOf="@+id/button_count"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/button_toast"
        tools:ignore="RtlCompat" />
```
#### Input Max Angka Fibonacci
    <EditText
        android:id="@+id/max_input"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="200dp"
        android:layout_marginTop="8dp"
        android:layout_marginEnd="8dp"
        android:background="@color/design_default_color_primary"
        android:text="@string/text_max"
        android:textColor="@color/white"
        android:textSize="36sp"
        android:inputType="number"
        android:onClick="setMaxCount"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
#### Button Back
```
    <Button
        android:id="@+id/button_back"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginBottom="8dp"
        android:layout_marginEnd="8dp"
        android:layout_marginStart="200dp"
        android:background="@color/colorPrimary"
        android:onClick="countBack"
        android:text="@string/button_label_back"
        android:textColor="@android:color/white"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        tools:ignore="UsingOnClickInXml" />
```
### Source Code Java untuk Fiturnya
```
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
```
#### Fitur Menampilkan Angka Fibonacci
```
public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
        showHitung.setText(Integer.toString(1));
    }
```
Penjelasan

    Membuat Objek Toast:
    Toast adalah suatu fitur di Android yang digunakan untuk menampilkan Angka Fibonacci ditengah layar.
    Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT); membuat pesan dengan durasi singkat. 
    Pesan yang ditampilkan diambil dari resource string yang diidentifikasi oleh R.string.toast_message.

    Menampilkan Toast:
        toast.show(); digunakan untuk menampilkan Toast yang telah dibuat sebelumnya.

    Mengatur Teks pada Elemen Tampilan:
        showHitung.setText(Integer.toString(1)); Menampilkan Angka Fibonacci menjadi "1" pada saat awal.
        Integer.toString(1) digunakan untuk mengonversi angka 1 menjadi string, karena setText membutuhkan parameter berupa string.
#### Fitur Button MAX
```
 public void setMaxCount(View view) {
        String maxCountString = inputCount.getText().toString();
        if (!maxCountString.isEmpty()) {
            int newMaxCount = Integer.parseInt(maxCountString);
            if (newMaxCount >= 0) {
                maxCount = newMaxCount;
            }
        }
    }
```
Penjelasan

    Mengambil Teks dari Elemen Tampilan:
    inputCount.getText().toString(); mengambil teks dari EditText yang telah di input user dan menyimpannya dalam bentuk string.

    Memeriksa String Tidak Kosong:
        if (!maxCountString.isEmpty()) memeriksa apakah EditText tidak kosong. Jika tidak kosong, maka melanjutkan ke langkah berikutnya.

    Mengonversi String ke Integer:
        int newMaxCount = Integer.parseInt(maxCountString); mengonversi string yg telah di input di EditText menjadi integer (bilangan bulat).

    Memeriksa Nilai Integer Baru:
        if (newMaxCount >= 0) memeriksa apakah nilai integer baru tidak kurang dari 0.

    Mengatur Nilai Maksimum (maxCount):
        maxCount = newMaxCount; jika semua kondisi terpenuhi, nilai maksimum (maxCount) diatur menjadi nilai integer baru (newMaxCount).
#### Fitur Button BACK
```
public void countBack(View view) {
        fib1 = 1;
        fib2 = 1;
        maxCount = 0;
        maxCountSet = false;
        inputCount.setText("");
        showHitung.setText(Integer.toString(0));
    }
```
Penjelasan

    fib1 dan fib2 diatur ke 1
        fib1 dan fib2 membuat bilangan yg sudah ditambah menjadi 1.

    maxCount diatur ke 0.
       batas maksimum Angka Fibonacci menjadi 0.

    maxCountSet diatur ke false.
       batas maksimum angka Fibonacci menjadi false atau belum dimasukkan
       
    Teks pada elemen inputCount dikosongkan.
        Mengosongkan EditText atau inputan maksimal untuk angka Fibonacci

    Teks pada elemen showHitung diatur menjadi "0".
       Menampilkan Angka Fibonacci menjadi 0
#### Fitur Button Count
```
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
```
Penjelasan

    Mengambil Nilai Input:
        maxCountString mengambil nilai input dari EditText yang telah di input.

    Memeriksa Input Tidak Kosong:
        Memeriksa apakah EditTExt tidak kosong.

    Mengonversi Input menjadi Integer:
        Mengonversi nilai Inputan maksimalnya menjadi integer.

    Menghitung Fibonacci Berikutnya:
        Menghitung nilai Fibonacci berikutnya (nextFib).

    Memeriksa Kondisi:
        Melakukan beberapa pengecekan kondisi terkait nilai maxCount, fib1, dan nextFib.

    Memperbarui Nilai dan Menampilkan:
        Memperbarui nilai fib1 dan fib2 tergantung pada kondisi.
        Menampilkan nilai terbaru pada elemen tampilan showHitung.
### Ouput 
![Output 1](https://github.com/HerlanWibowo/UTSMobile1/assets/106060694/45f4dc6c-a60d-4778-8a4c-ebf8228fc90e)
![Output 2](https://github.com/HerlanWibowo/UTSMobile1/assets/106060694/93e4ebc7-974e-440b-bbf2-ddc67c3c61ad)
![Output 3](https://github.com/HerlanWibowo/UTSMobile1/assets/106060694/c8b5e4af-09c5-42d5-b620-09fa3fb1fa58)
![Output 4](https://github.com/HerlanWibowo/UTSMobile1/assets/106060694/2047b86d-7eba-4a44-8575-200f99de341f)
![Output 5](https://github.com/HerlanWibowo/UTSMobile1/assets/106060694/60cc367a-41e4-4ecb-ae27-980fe8532ac3)

