package guykit.lolquizz;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemQuizActivity extends AppCompatActivity {

    int score = 0;
    int qNumber = 0;
    List<Item> quizItems;
    List<String> questionKeywords;
    boolean correct = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_quiz);
        quizItems = createItemList();
        questionKeywords = createQuestionList();
    }

    public List<Item> createItemList(){

        List<Item> items = items();

        //select items for quiz
        List<Item> quizItems = new ArrayList<Item>();
        Random random = new Random();
        for(int i = 0; i < 10; i++) {
            int num = random.nextInt(items.size());
            quizItems.add(items.get(num));
        }
        return quizItems;
    }

    public List<Item> items(){
        Item voidStaff = new Item("id0", "Void Staff", 2650, 80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 35, "STH");
        Item liandrysTorment = new Item("id1", "Liandry's Torment", 3100, 80, 0, 300, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 15, 0, "STH");
        Item youmuusGhostblade = new Item("id2", "Youmuu's Ghostblade", 3100, 80, 0, 300, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 15, 0, "STH");
        Item blackCleaver = new Item("id3", "Black Cleaver", 3100, 80, 0, 300, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 15, 0, "STH");
        Item randuinsOmen = new Item("id4", "Randuin's Omen", 3100, 80, 0, 300, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 15, 0, "STH");
        Item sunfireCape = new Item("id5", "Sunfire Cape", 3100, 80, 0, 300, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 15, 0, "STH");
        Item spiritVisage = new Item("id6", "Spirit Visage", 3100, 80, 0, 300, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 15, 0, "STH");
        Item bansheesVeil = new Item("id7", "Banshee's Veil", 3100, 80, 0, 300, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 15, 0, "STH");
        Item righteousGlory = new Item("id8", "Righteous Glory", 3100, 80, 0, 300, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 15, 0, "STH");
        Item ohmwrecker = new Item("id9", "Ohmwrecker", 3100, 80, 0, 300, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 15, 0, "STH");
        Item adaptiveHelm = new Item("id10", "Adaptive Helm", 3100, 80, 0, 300, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 15, 0, "STH");

        List<Item> items = new ArrayList<Item>();
        items.add(voidStaff);
        items.add(liandrysTorment);
        items.add(youmuusGhostblade);
        items.add(blackCleaver);
        items.add(randuinsOmen);
        items.add(sunfireCape);
        items.add(spiritVisage);
        items.add(bansheesVeil);
        items.add(righteousGlory);
        items.add(ohmwrecker);
        items.add(adaptiveHelm);

        return items;
    }

    public void nextQuestion(View view){
        qNumber++;

        if(qNumber <= 10) {
            Button b = (Button) findViewById(R.id.button7);
            b.setText("Next question");

            Item currentItem = quizItems.get(qNumber - 1);

            if(qNumber == 10){
                b.setText("Finish quiz");
            }
            List<String> answers = createAnswerList(qNumber, currentItem, items());

            Button b1 = (Button) findViewById(R.id.button9);
            b1.setText(answers.get(0));
            Button b2 = (Button) findViewById(R.id.button10);
            b2.setText(answers.get(1));
            Button b3 = (Button) findViewById(R.id.button11);
            b3.setText(answers.get(2));
            Button b4 = (Button) findViewById(R.id.button12);
            b4.setText(answers.get(3));

            TextView t = (TextView) findViewById(R.id.textView2);
            t.setText("Question " + qNumber + ": What is the " + questionKeywords.get(qNumber-1) + " of this item?");
            String img = currentItem.getId();
            int resID = getResources().getIdentifier(img, "drawable", getPackageName());
            ImageView i = (ImageView) findViewById(R.id.imageView);
            i.setImageResource(resID);

            //add score stuff
            if(correct == true){
                score++;
            }
            correct = false;

        }
        if(qNumber == 11){
            if(correct == true){
                score++;
            }
            Intent intent = new Intent(this, DisplayScoreActivity.class);
            intent.putExtra("score", score);
            startActivity(intent);
        }

    }

    public void checkAns1(View view){
        if(qNumber >= 1) {
            Button b = (Button) findViewById(R.id.button9);
            String answer = b.getText().toString();
            if (answer == quizItems.get(qNumber - 1).getName()) {
                correct = true;
            } else {
                correct = false;
            }
        }
    }

    public void checkAns2(View view){
        if(qNumber >= 1) {
            Button b = (Button) findViewById(R.id.button10);
            String answer = b.getText().toString();
            if (answer == quizItems.get(qNumber - 1).getName()) {
                correct = true;
            } else {
                correct = false;
            }
        }
    }

    public void checkAns3(View view){
        if(qNumber >= 1) {
            Button b = (Button) findViewById(R.id.button11);
            String answer = b.getText().toString();
            if (answer == quizItems.get(qNumber - 1).getName()) {
                correct = true;
            } else {
                correct = false;
            }
        }
    }

    public void checkAns4(View view){
        if(qNumber >= 1) {
            Button b = (Button) findViewById(R.id.button12);
            String answer = b.getText().toString();
            if (answer == quizItems.get(qNumber - 1).getName()) {
                correct = true;
            } else {
                correct = false;
            }
        }
    }



    public List<String> createQuestionList(){
        List<String> questionKeyword = new ArrayList<String>();
        List<String> questionKeys = new ArrayList<String>();
        questionKeyword.add("name");
        //questionKeyword.add("gold cost");
        //questionKeyword.add("AP");
        //questionKeyword.add("AD");
        //questionKeyword.add("HP");
        //questionKeyword.add("mana");
        Random random = new Random();
        for(int i = 0; i < 10; i++) {
            int num = random.nextInt(questionKeyword.size());
            questionKeys.add(questionKeyword.get(num));
        }
        return questionKeys;
    }
    public List<String> createAnswerList(int qNumber, Item item, List<Item> items){
        List<String> answers = new ArrayList<String>();
        Random random = new Random();
        if (questionKeywords.get(qNumber-1) == "name") {
            boolean itemUsed = false;

            int num1 = random.nextInt(items.size());
            if(items.get(num1).getName() == item.getName()){
                itemUsed = true;
            }
            answers.add(items.get(num1).getName());
            items.remove(items.get(num1));

            int num2 = random.nextInt(items.size());
            if(items.get(num2).getName() == item.getName()){
                itemUsed = true;
            }
            answers.add(items.get(num2).getName());
            items.remove(items.get(num2));

            int num3 = random.nextInt(items.size());
            if(items.get(num3).getName() == item.getName()){
                itemUsed = true;
            }
            answers.add(items.get(num3).getName());
            items.remove(items.get(num3));

            int num4 = random.nextInt(items.size());
            if(items.get(num4).getName() == item.getName()){
                itemUsed = true;
            }
            answers.add(items.get(num4).getName());
            items.remove(items.get(num4));

            if(itemUsed == false) {
                int ans = random.nextInt(answers.size());
                answers.set(ans, item.getName());
            }
        } else {
            answers.add("");
            answers.add("");
            answers.add("");
            answers.add("");
        }
        return answers;
    }

}
