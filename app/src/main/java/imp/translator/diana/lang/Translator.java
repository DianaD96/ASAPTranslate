package imp.translator.diana.lang;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.StrictMode;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.memetix.mst.language.Language;

import java.util.Locale;

public class Translator extends Activity{

    private TextToSpeech tts;
    private Button btnSpeak;

    String from_language="";
    Button from = null;

    String to_language="";
    Button to = null;

    String translatedText;
    String voice;
    TextToSpeech t1;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translator);


        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                        t1.setLanguage(Locale.UK);
                }
            }
        });

        btnSpeak = (Button) findViewById(R.id.buttonSpeak);
        btnSpeak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String toSpeak = voice;
                Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }

        });


        from = (Button) findViewById(R.id.buttonfrom);
        from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popUp1();
            }
        });
        to = (Button) findViewById(R.id.buttonto);
        to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popUp2();
            }
        });

        Button trans = (Button) findViewById(R.id.proceed);
        trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toText();
            }
        });
    }

    public void popUp1() {
        final ListView promptView = new ListView(this);
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setView(promptView);
        // setup a dialog windowc
        alertDialogBuilder.setCancelable(true) // Set cancelable
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create an alert dialog
        final AlertDialog alert = alertDialogBuilder.create();

        String[] languages = {"Arabic", "Bulgarian", "Catalan", "Chinese Simplified", "Chinese Traditional", "Czech", "Danish", "Dutch", "English", "Estonian", "Finnish", "French", "German", "Greek", "Haitian Creole", "Hebrew", "Hindi", "Hmong Daw", "Hungarian", "Indonesian", "Italian", "Japanese", "Korean", "Latvian", "Lithuanian", "Norwegian", "Polish", "Portuguese", "Romanian", "Russian", "Slovak", "Slovenian", "Spanish", "Swedish", "Thai", "Turkish", "Ukrainian", "Vietnamese"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, languages);
        promptView.setAdapter(adapter);

        promptView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                from_language = ((TextView) view).getText().toString();
                Toast.makeText(getBaseContext(), from_language, Toast.LENGTH_LONG).show();
                from.setText(from_language);
                // CLOSE POPUP WINDOW
                alert.cancel();
            }
        });

        alert.show();
    }

    public void popUp2() {
        final ListView promptView = new ListView(this);
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setView(promptView);
        // setup a dialog window
        alertDialogBuilder.setCancelable(true) // Set cancelable
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create an alert dialog
        final AlertDialog alert = alertDialogBuilder.create();

        String[] languages = {"Arabic", "Bulgarian", "Catalan", "Chinese Simplified", "Chinese Traditional", "Czech", "Danish", "Dutch", "English", "Estonian", "Finnish", "French", "German", "Greek", "Haitian Creole", "Hebrew", "Hindi", "Hmong Daw", "Hungarian", "Indonesian", "Italian", "Japanese", "Korean", "Latvian", "Lithuanian", "Norwegian", "Polish", "Portuguese", "Romanian", "Russian", "Slovak", "Slovenian", "Spanish", "Swedish", "Thai", "Turkish", "Ukrainian", "Vietnamese"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, languages);
        promptView.setAdapter(adapter);

        promptView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                to_language = ((TextView) view).getText().toString();
                Toast.makeText(getBaseContext(), to_language, Toast.LENGTH_LONG).show();
                to.setText(to_language);
                // CLOSE POPUP WINDOW
                alert.cancel();
            }
        });

        alert.show();
    }

    public String translate(String text) throws Exception {

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        // Set the Client ID / Client Secret once per JVM. It is set statically and applies to all services
        Translate.setClientId("VoiceTranslatorApp"); //Change this
        Translate.setClientSecret("7SAtDMAWiEyd+7i4u063kJM174/EN6/9Y58w3HHZWag="); //change

        String translatedText = "";

        ImageView imgfrom = (ImageView) findViewById(R.id.imageViewfrom);

        if (from_language.equals("Arabic")) {
            Translate.execute1(text, Language.ARABIC);
            imgfrom.setImageResource(R.drawable.arabic);
        }
        if (from_language.equals("Bulgarian")) {
            Translate.execute1(text, Language.BULGARIAN);
            imgfrom.setImageResource(R.drawable.bulgarian);
        }
        if (from_language.equals("Catalan")) {
            Translate.execute1(text, Language.CATALAN);
            imgfrom.setImageResource(R.drawable.catalan);
        }
        if (from_language.equals("Chinese Simplified")) {
            Translate.execute1(text, Language.CHINESE_SIMPLIFIED);
            imgfrom.setImageResource(R.drawable.china);
        }
        if (from_language.equals("Chinese Traditional")) {
            Translate.execute1(text, Language.CHINESE_TRADITIONAL);
            imgfrom.setImageResource(R.drawable.china);
        }
        if (from_language.equals("Czech")) {
            Translate.execute1(text, Language.CZECH);
            imgfrom.setImageResource(R.drawable.czech);
        }
        if (from_language.equals("Danish")) {
            Translate.execute1(text, Language.DANISH);
            imgfrom.setImageResource(R.drawable.danish);
        }
        if (from_language.equals("Dutch")) {
            Translate.execute1(text, Language.DUTCH);
            imgfrom.setImageResource(R.drawable.dutch);
        }
        if (from_language.equals("English")) {
            Translate.execute1(text, Language.ENGLISH);
            imgfrom.setImageResource(R.drawable.united_kingdom);
        }
        if (from_language.equals("Estonian")) {
            Translate.execute1(text, Language.ESTONIAN);
            imgfrom.setImageResource(R.drawable.estonian);
        }
        if (from_language.equals("Finnish")) {
            Translate.execute1(text, Language.FINNISH);
            imgfrom.setImageResource(R.drawable.finland);
        }
        if (from_language.equals("French")) {
            Translate.execute1(text, Language.FRENCH);
            imgfrom.setImageResource(R.drawable.france);
        }
        if (from_language.equals("German")) {
            Translate.execute1(text, Language.GERMAN);
            imgfrom.setImageResource(R.drawable.germany);
        }
        if (from_language.equals("Greek")) {
            Translate.execute1(text, Language.GREEK);
            imgfrom.setImageResource(R.drawable.greece);
        }
        if (from_language.equals("Haitian Creole")) {
            Translate.execute1(text, Language.HAITIAN_CREOLE);
            imgfrom.setImageResource(R.drawable.haiti);
        }
        if (from_language.equals("Hebrew")) {
            Translate.execute1(text, Language.HEBREW);
            imgfrom.setImageResource(R.drawable.israel);
        }
        if (from_language.equals("Hindi")) {
            Translate.execute1(text, Language.HINDI);
            imgfrom.setImageResource(R.drawable.india);
        }
        if (from_language.equals("Hmong Daw")) {
            Translate.execute1(text, Language.HMONG_DAW);
            imgfrom.setImageResource(R.drawable.china);
        }
        if (from_language.equals("Hungarian")) {
            Translate.execute1(text, Language.HUNGARIAN);
            imgfrom.setImageResource(R.drawable.hungary);
        }
        if (from_language.equals("Indonesian")) {
            Translate.execute1(text, Language.INDONESIAN);
            imgfrom.setImageResource(R.drawable.indonesia_round_icon_256);
        }
        if (from_language.equals("Italian")) {
            Translate.execute1(text, Language.ITALIAN);
            imgfrom.setImageResource(R.drawable.italy);
        }
        if (from_language.equals("Japanese")) {
            Translate.execute1(text, Language.JAPANESE);
            imgfrom.setImageResource(R.drawable.japan);
        }
        if (from_language.equals("Korean")) {
            Translate.execute1(text, Language.KOREAN);
            imgfrom.setImageResource(R.drawable.korea);
        }
        if (from_language.equals("Latvian")) {
            Translate.execute1(text, Language.LATVIAN);
            imgfrom.setImageResource(R.drawable.latvia);
        }
        if (from_language.equals("Lithuanian")) {
            Translate.execute1(text, Language.LITHUANIAN);
            imgfrom.setImageResource(R.drawable.lithuania_round_icon_256);
        }
        if (from_language.equals("Norwegian")) {
            Translate.execute1(text, Language.NORWEGIAN);
            imgfrom.setImageResource(R.drawable.norway);
        }
        if (from_language.equals("Polish")) {
            Translate.execute1(text, Language.POLISH);
            imgfrom.setImageResource(R.drawable.poland_round_icon_256);
        }
        if (from_language.equals("Portuguese")) {
            Translate.execute1(text, Language.PORTUGUESE);
            imgfrom.setImageResource(R.drawable.portugal);
        }
        if (from_language.equals("Romanian")) {
            Translate.execute1(text, Language.ROMANIAN);
            imgfrom.setImageResource(R.drawable.romania);
        }
        if (from_language.equals("Russian")) {
            Translate.execute1(text, Language.RUSSIAN);
            imgfrom.setImageResource(R.drawable.russia);
        }
        if (from_language.equals("Slovak")) {
            Translate.execute1(text, Language.SLOVAK);
            imgfrom.setImageResource(R.drawable.slovakia);
        }
        if (from_language.equals("Slovenian")) {
            Translate.execute1(text, Language.SLOVENIAN);
            imgfrom.setImageResource(R.drawable.slovenia);
        }
        if (from_language.equals("Spanish")) {
            Translate.execute1(text, Language.SPANISH);
            imgfrom.setImageResource(R.drawable.spain);
        }
        if (from_language.equals("Swedish")) {
            Translate.execute1(text, Language.SWEDISH);
            imgfrom.setImageResource(R.drawable.sweden);
        }
        if (from_language.equals("Thai")) {
            Translate.execute1(text, Language.THAI);
            imgfrom.setImageResource(R.drawable.thai);
        }
        if (from_language.equals("Turkish")) {
            Translate.execute1(text, Language.TURKISH);
            imgfrom.setImageResource(R.drawable.turkish);
        }
        if (from_language.equals("Ukrainian")) {
            Translate.execute1(text, Language.UKRAINIAN);
            imgfrom.setImageResource(R.drawable.ukrainian);
        }
        if (from_language.equals("Vienamese")) {
            Translate.execute1(text, Language.VIETNAMESE);
            imgfrom.setImageResource(R.drawable.vietnam);
        }

        ImageView tofrom = (ImageView) findViewById(R.id.imageViewto);

        if (to_language.equals("Arabic")) {
            translatedText = Translate.execute2(text, Language.ARABIC);
            tofrom.setImageResource(R.drawable.arabic);
        }
        if (to_language.equals("Bulgarian")) {
            translatedText = Translate.execute2(text, Language.BULGARIAN);
            tofrom.setImageResource(R.drawable.bulgarian);
        }
        if (to_language.equals("Catalan")) {
            translatedText = Translate.execute2(text, Language.CATALAN);
            tofrom.setImageResource(R.drawable.catalan);
        }
        if (to_language.equals("Chinese Simplified")) {
            translatedText = Translate.execute2(text, Language.CHINESE_SIMPLIFIED);
            tofrom.setImageResource(R.drawable.china);
            t1.setLanguage(Locale.CHINA);
        }
        if (to_language.equals("Chinese Traditional")) {
            translatedText = Translate.execute2(text, Language.CHINESE_TRADITIONAL);
            tofrom.setImageResource(R.drawable.china);
            t1.setLanguage(Locale.CHINA);
        }
        if (to_language.equals("Czech")) {
            translatedText = Translate.execute2(text, Language.CZECH);
            tofrom.setImageResource(R.drawable.czech);
        }
        if (to_language.equals("Danish")) {
            translatedText = Translate.execute2(text, Language.DANISH);
            tofrom.setImageResource(R.drawable.danish);
        }
        if (to_language.equals("Dutch")) {
            translatedText = Translate.execute2(text, Language.DUTCH);
            tofrom.setImageResource(R.drawable.dutch);
        }
        if (to_language.equals("English")) {
            translatedText = Translate.execute2(text, Language.ENGLISH);
            tofrom.setImageResource(R.drawable.united_kingdom);
        }
        if (to_language.equals("Estonian")) {
            translatedText = Translate.execute2(text, Language.ESTONIAN);
            tofrom.setImageResource(R.drawable.estonian);
        }
        if (to_language.equals("Finnish")) {
            translatedText = Translate.execute2(text, Language.FINNISH);
            tofrom.setImageResource(R.drawable.finland);
        }
        if (to_language.equals("French")) {
            translatedText = Translate.execute2(text, Language.FRENCH);
            t1.setLanguage(Locale.CANADA_FRENCH);
            tofrom.setImageResource(R.drawable.france);
        }
        if (to_language.equals("German")) {
            translatedText = Translate.execute2(text, Language.GERMAN);
            tofrom.setImageResource(R.drawable.germany);
            t1.setLanguage(Locale.GERMANY);
        }
        if (to_language.equals("Greek")) {
            translatedText = Translate.execute2(text, Language.GREEK);
            tofrom.setImageResource(R.drawable.greece);
        }
        if (to_language.equals("Haitian Creole")) {
            translatedText = Translate.execute2(text, Language.HAITIAN_CREOLE);
            tofrom.setImageResource(R.drawable.haiti);
        }
        if (to_language.equals("Hebrew")) {
            translatedText = Translate.execute2(text, Language.HEBREW);
            tofrom.setImageResource(R.drawable.israel);
        }
        if (to_language.equals("Hindi")) {
            translatedText = Translate.execute2(text, Language.HINDI);
            tofrom.setImageResource(R.drawable.india);
        }
        if (to_language.equals("Hmong Daw")) {
            translatedText = Translate.execute2(text, Language.HMONG_DAW);
            tofrom.setImageResource(R.drawable.china);
        }
        if (to_language.equals("Hungarian")) {
            translatedText = Translate.execute2(text, Language.HUNGARIAN);
            tofrom.setImageResource(R.drawable.hungary);
        }
        if (to_language.equals("Indonesian")) {
            translatedText = Translate.execute2(text, Language.INDONESIAN);
            tofrom.setImageResource(R.drawable.indonesia_round_icon_256);
        }
        if (to_language.equals("Italian")) {
            translatedText = Translate.execute2(text, Language.ITALIAN);
            tofrom.setImageResource(R.drawable.italy);
            t1.setLanguage(Locale.ITALY);
        }
        if (to_language.equals("Japanese")) {
            translatedText = Translate.execute2(text, Language.JAPANESE);
            tofrom.setImageResource(R.drawable.japan);
            t1.setLanguage(Locale.JAPAN);
        }
        if (to_language.equals("Korean")) {
            translatedText = Translate.execute2(text, Language.KOREAN);
            tofrom.setImageResource(R.drawable.korea);
        }
        if (to_language.equals("Latvian")) {
            translatedText = Translate.execute2(text, Language.LATVIAN);
            tofrom.setImageResource(R.drawable.latvia);
        }
        if (to_language.equals("Lithuanian")) {
            translatedText = Translate.execute2(text, Language.LITHUANIAN);
            tofrom.setImageResource(R.drawable.lithuania_round_icon_256);
        }
        if (to_language.equals("Norwegian")) {
            translatedText = Translate.execute2(text, Language.NORWEGIAN);
            tofrom.setImageResource(R.drawable.norway);
        }
        if (to_language.equals("Polish")) {
            translatedText = Translate.execute2(text, Language.POLISH);
            tofrom.setImageResource(R.drawable.poland_round_icon_256);
        }
        if (to_language.equals("Portuguese")) {
            translatedText = Translate.execute2(text, Language.PORTUGUESE);
            tofrom.setImageResource(R.drawable.portugal);
        }
        if (to_language.equals("Romanian")) {
            translatedText = Translate.execute2(text, Language.ROMANIAN);
            tofrom.setImageResource(R.drawable.romania);
        }
        if (to_language.equals("Russian")) {
            translatedText = Translate.execute2(text, Language.RUSSIAN);
            tofrom.setImageResource(R.drawable.russia);
        }
        if (to_language.equals("Slovak")) {
            translatedText = Translate.execute2(text, Language.SLOVAK);
            tofrom.setImageResource(R.drawable.slovakia);
        }
        if (to_language.equals("Slovenian")) {
            translatedText = Translate.execute2(text, Language.SLOVENIAN);
            tofrom.setImageResource(R.drawable.slovenia);
        }
        if (to_language.equals("Spanish")) {
            translatedText = Translate.execute2(text, Language.SPANISH);
            tofrom.setImageResource(R.drawable.spain);
        }
        if (to_language.equals("Swedish")) {
            translatedText = Translate.execute2(text, Language.SWEDISH);
            tofrom.setImageResource(R.drawable.sweden);
        }
        if (to_language.equals("Thai")) {
            translatedText = Translate.execute2(text, Language.THAI);
            tofrom.setImageResource(R.drawable.thai);
        }
        if (to_language.equals("Turkish")) {
            translatedText = Translate.execute2(text, Language.TURKISH);
            tofrom.setImageResource(R.drawable.turkish);
        }
        if (to_language.equals("Ukrainian")) {
            translatedText = Translate.execute2(text, Language.UKRAINIAN);
            tofrom.setImageResource(R.drawable.ukrainian);
        }
        if (to_language.equals("Vienamese")) {
            translatedText = Translate.execute2(text, Language.VIETNAMESE);
            tofrom.setImageResource(R.drawable.vietnam);
        }
        voice=translatedText;
        return translatedText;
    }

    public void toText() {

        String translatedText = "";
        try {
            String text = ((EditText) findViewById(R.id.toTranslate)).getText().toString();
            translatedText = translate(text);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            translatedText = e.toString();
        }
        ((TextView) findViewById(R.id.translated)).setText(translatedText);
    }

    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }

}