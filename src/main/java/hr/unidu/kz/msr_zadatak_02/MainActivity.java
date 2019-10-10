package hr.unidu.kz.msr_zadatak_02;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
    private TextView pozdrav;
    private EditText ime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pozdrav = findViewById(R.id.poruka);
        ime = findViewById(R.id.ime);
    }

    public void pozdravi(View view) {
        if (ime.getText().toString().length() < 1) {
            Toast.makeText(this, "Morate unijeti ime prijatelja!", Toast.LENGTH_LONG).show();
            return;
        }
        TimeZone tz = TimeZone.getDefault();
        Calendar sada = new GregorianCalendar(tz);
        int sat = sada.get(sada.HOUR_OF_DAY);
        String poruka;
        if (sat >= 22 || sat < 6)
            poruka = "Laku noć ";
        else if (sat >= 6 && sat < 12)
            poruka = "Dobro jutro ";
        else if (sat >= 12 && sat < 17)
            poruka = "Dobar dan ";
        else
            poruka = "Dobra večer ";
        pozdrav.setText(poruka + ime.getText().toString());

    }

}

