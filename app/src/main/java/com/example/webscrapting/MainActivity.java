package com.example.webscrapting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.btnView);

        button.setOnClickListener(v -> {
            new doIT().execute();
        });

    }

    public class doIT extends AsyncTask<Void, Void, Void> {
        String words;
        @Override
        protected Void doInBackground(Void... params) {
            try {
                Document document = Jsoup.connect("https://dotconnectafrica.com/cyber-security/").get();
                words = document.text();
            } catch (IOException e) {
                e.printStackTrace();
            } return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            textView.setText(words);
        }
    }
}