package android.luo.stone.geoquiz1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton,mFalseButton,mNextButton;
    private TextView mQuestionTextView;
    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_africa, false),
            new Question(R.string.question_mideast,false),
            new Question(R.string.question_oceans,true),
    };

    private int mCurrentndex = 0;
    private void updateQuestion(){
        int question = mQuestionBank[mCurrentndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentndex].isAnswerTrue();

        int messageResId = 0;

        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
        }else {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT);
                checkAnswer(true);
            }
        });

        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
       updateQuestion();

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentndex = (mCurrentndex + 1)% mQuestionBank.length;
                updateQuestion();
            }
        });


    }
}
