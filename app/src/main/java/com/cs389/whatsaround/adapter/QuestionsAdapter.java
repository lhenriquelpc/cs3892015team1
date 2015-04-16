package com.cs389.whatsaround.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cs389.whatsaround.R;
import com.cs389.whatsaround.model.Question;

import java.util.List;



//Android will call its methods when creating the list in the Activity that reference this adapter
public class QuestionsAdapter extends BaseAdapter {


    private List<Question> questions;
    private LayoutInflater inflater;


    public QuestionsAdapter(Context context, List<Question> questions) {

        this.questions = questions;
        this.inflater = LayoutInflater.from(context);

    }


    @Override
    public int getCount() {
        return questions.size();
    }


    @Override
    public Object getItem(int position) {
        return questions.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        //Holds ID of Views for them to be recycled. More details bellow, in the if statement.
        ViewQuestionHolder viewQuestionHolder;


        Question question = questions.get(position);


        //If Android did not pass a View (through convertView) that can be recycled, create (inflate) a new one
        // and associate a Holder as a tag to this view, in order to it can be reused later
        if (view == null) {

            view = inflater.inflate(R.layout.activity_settings_list, parent, false);


            //Create a Holder to hold the Views that are being created in order to allow them to be used later.
            viewQuestionHolder = new ViewQuestionHolder();
            viewQuestionHolder.textImage = (TextView) view.findViewById(R.id.txt_image);
            viewQuestionHolder.textAnswer = (TextView) view.findViewById(R.id.txt_answer);


            //Associate the View received to the holder that has the IDs
            view.setTag(viewQuestionHolder);


        } else {

            //In the case the View passed can be recycled (!= null), take its tag, which is a Holder
            //This avoid calling the methods "inflate" and "findViewById", which are considered heavy
            viewQuestionHolder = (ViewQuestionHolder) view.getTag();
        }


        //Set the texts of the new Views
        viewQuestionHolder.textImage.setText(question.getImage());
        viewQuestionHolder.textAnswer.setText(question.getAnswer());


        return view;
    }


    //It holds the view that was already created for this to be recycled
    private class ViewQuestionHolder {

        public TextView textImage;
        public TextView textAnswer;
    }
}
