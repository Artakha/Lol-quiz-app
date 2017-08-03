package guykit.lolquizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startItemQuiz(View view) {
        Intent intent = new Intent(this, ItemQuizActivity.class);
        startActivity(intent);
    }

    public void startChampionQuiz(View view) {
        Intent intent = new Intent(this, ChampionQuizActivity.class);
        startActivity(intent);
    }

    public void startSkillsQuiz(View view) {
        Intent intent = new Intent(this, SkillsQuizActivity.class);
        startActivity(intent);
    }

    public void startRandomQuiz(View view) {
        Intent intent = new Intent(this, RandomQuizActivity.class);
        startActivity(intent);
    }

    public void exitApp(View view) {
        System.exit(0);
    }
}
