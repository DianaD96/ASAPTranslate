package imp.translator.diana.lang;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class Speak extends Activity
{
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        final ListView list = (ListView) findViewById(R.id.list_view);

        list.addHeaderView(new View(this));
        list.addFooterView(new View(this));

        BaseInflaterAdapter<CardItemData> adapter = new BaseInflaterAdapter<CardItemData>(new CardInflater());

        CardItemData data = new CardItemData("Translate");
        adapter.addItem(data, false);
        CardItemData data2 = new CardItemData("Voice to Text");
        adapter.addItem(data2, false);
        CardItemData data4 = new CardItemData("Info");
        adapter.addItem(data4, false);

        list.setAdapter(adapter);

        list.setClickable(true);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView myAdapter, View myView, int position, long mylng) {
                CardItemData selectedFromList = (CardItemData) (myAdapter.getItemAtPosition(position));
                String pos = selectedFromList.getText1();
                switch (pos) {
                    case "Translate":
                        Intent intent = new Intent();
                        intent.setClass(Speak.this, Translator.class);
                        startActivity(intent);
                        break;
                    case "Voice to Text":
                        Intent intent2 = new Intent();
                        intent2.setClass(Speak.this, VoiceToText.class);
                        startActivity(intent2);
                        break;
                    case "Info":
                        Intent intent3 = new Intent();
                        intent3.setClass(Speak.this, Info.class);
                        startActivity(intent3);
                        break;
                }
            }
        });

    }
}
