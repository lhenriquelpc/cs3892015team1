package com.cs389.whatsaround;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.cs389.whatsaround.model.Question;


public class EditQuestionActivity extends ActionBarActivity {

    public static final String LOG_KEY = EditQuestionActivity.class.getName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_edit_question);


        //Get Image and answer from the item clicked on the list
        Question question = (Question) getIntent().getSerializableExtra(SettingsActivity.QUESTION_KEY);


        //If "question" is not null, the an item on the list was clicked and redirected to here.
        //Therefore, take Views on this screen and assign the given Image and Answer (given in the Intent) as their texts
        if (question != null) {

            EditText answerView = (EditText) findViewById(R.id.txt_edit_answer);
            TextView imageView = (TextView) findViewById(R.id.txt_edit_image);

            if (answerView != null) {
                answerView.setText(question.getAnswer());
            } else {
                Log.i(LOG_KEY, "answerView is null.");
            }

            if (imageView != null) {
                imageView.setText(question.getImage());
            } else {
                Log.i(LOG_KEY, "imageView is null.");
            }

        }

        //Otherwise, show the default Layout


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_question, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.mnu_save_question) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
