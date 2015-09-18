package imp.translator.diana.lang;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView switchButton = (CardView)findViewById(R.id.textView);
        switchButton.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Speak.class);
                startActivity(intent);
                overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_top);
            }});
    }

}