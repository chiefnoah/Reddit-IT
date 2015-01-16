package com.chiefnoah.it;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    TextView questionView;

    String questions[] = {
/*0*/            "Did you try turning it off an on again?",
/*1*/            "Do that now.\nDid it fix it?",
/*2*/            "Are you absolutely sure?",
/*3*/            "Is it plugged in?",
/*4*/            "That's your problem. Now you can browse reddit without bothering your coworkers.\nClose app?",
/*5*/            "Looks like you might have a real problem. But still don't contact IT because you will probably look stupid and they will laugh at you behind your back.\nClose app?",
/*6*/            "Please refrain from distracting IT from their daily reddit browsing.\nClose app?"
    };

    int currentIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionView = (TextView) findViewById(R.id.question_text_view);
        questionView.setText(questions[currentIndex]);
    }

    public void noClick(View v) {
        switch(currentIndex) {
            case 0:
                currentIndex = 1;
                updateText();
                break;
            case 1:
                currentIndex = 3;
                updateText();
                break;
            case 2:
                currentIndex = 3;
                updateText();
                break;
            case 3:
                currentIndex = 4;
                updateText();
                break;
            default:
                currentIndex = 0;
                updateText();
        }
    }

    public void yesClick(View v) {
        switch(currentIndex) {
            case 0:
                currentIndex = 3;
                updateText();
                break;
            case 1:
                currentIndex = 6;
                updateText();
                break;
            case 2:
                currentIndex = 5;
                updateText();
                break;
            case 3:
                currentIndex = 2;
                updateText();
                break;
            case 4:
                finish();
                break;
            case 5:
                finish();
                break;
            case 6:
                finish();
                break;
            default:
                currentIndex = 0;
                updateText();
        }
    }

    private void updateText() {
        questionView.setText(questions[currentIndex]);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, About.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
