package imp.translator.diana.lang;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.memetix.mst.language.Language;

public class Record extends Activity{

    String from_language;
    Button from = null;

    String to_language;
    Button to = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

         from = (Button)findViewById(R.id.buttonfrom);
                from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popUp1();
            }
        });
        to = (Button)findViewById(R.id.buttonto);
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

    public void popUp1(){
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

        String[] languages = {"Arabic","Bulgarian","Catalan", "Chinese Simplified", "Chinese Traditional", "Czech", "Danish", "Dutch", "English", "Estonian", "Finnish", "French", "German", "Greek", "Haitian Creole", "Hebrew", "Hindi", "Hmong Daw", "Hungarian", "Indonesian", "Italian", "Japanese", "Korean", "Latvian", "Lithuanian", "Norwegian", "Polish", "Portuguese", "Romanian", "Russian", "Slovak", "Slovenian", "Spanish", "Swedish", "Thai", "Turkish", "Ukrainian", "Vietnamese"};

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

    public void popUp2(){
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

        String[] languages = {"Arabic","Bulgarian","Catalan", "Chinese Simplified", "Chinese Traditional", "Czech", "Danish", "Dutch", "English", "Estonian", "Finnish", "French", "German", "Greek", "Haitian Creole", "Hebrew", "Hindi", "Hmong Daw", "Hungarian", "Indonesian", "Italian", "Japanese", "Korean", "Latvian", "Lithuanian", "Norwegian", "Polish", "Portuguese", "Romanian", "Russian", "Slovak", "Slovenian", "Spanish", "Swedish", "Thai", "Turkish", "Ukrainian", "Vietnamese"};

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

    public String translate(String text) throws Exception{

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        // Set the Client ID / Client Secret once per JVM. It is set statically and applies to all services
        Translate.setClientId("VoiceTranslatorApp"); //Change this
        Translate.setClientSecret("7SAtDMAWiEyd+7i4u063kJM174/EN6/9Y58w3HHZWag="); //change

        String translatedText = "";

        if (from_language.equals("Arabic"))
            Translate.execute1(text, Language.ARABIC);
        if (from_language.equals("Bulgarian"))
            Translate.execute1(text, Language.BULGARIAN);
        if (from_language.equals("Catalan"))
            Translate.execute1(text, Language.CATALAN);
        if (from_language.equals("Chinese Simplified"))
            Translate.execute1(text, Language.CHINESE_SIMPLIFIED);
        if (from_language.equals("Chinese Traditional"))
            Translate.execute1(text, Language.CHINESE_TRADITIONAL);
        if (from_language.equals("Czech"))
            Translate.execute1(text, Language.CZECH);
        if (from_language.equals("Danish"))
            Translate.execute1(text, Language.DANISH);
        if (from_language.equals("Dutch"))
            Translate.execute1(text, Language.DUTCH);
        if (from_language.equals("English"))
            Translate.execute1(text, Language.ENGLISH);
        if (from_language.equals("Estonian"))
            Translate.execute1(text, Language.ESTONIAN);
        if (from_language.equals("Finnish"))
            Translate.execute1(text, Language.FINNISH);
        if (from_language.equals("French"))
            Translate.execute1(text, Language.FRENCH);
        if (from_language.equals("German"))
            Translate.execute1(text, Language.GERMAN);
        if (from_language.equals("Greek"))
            Translate.execute1(text, Language.GREEK);
        if (from_language.equals("Haitian Creole"))
            Translate.execute1(text, Language.HAITIAN_CREOLE);
        if (from_language.equals("Hebrew"))
            Translate.execute1(text, Language.HEBREW);
        if (from_language.equals("Hindi"))
            Translate.execute1(text, Language.HINDI);
        if (from_language.equals("Hmong Daw"))
            Translate.execute1(text, Language.HMONG_DAW);
        if (from_language.equals("Hungarian"))
            Translate.execute1(text, Language.HUNGARIAN);
        if (from_language.equals("Indonesian"))
            Translate.execute1(text, Language.INDONESIAN);
        if (from_language.equals("Italian"))
            Translate.execute1(text, Language.ITALIAN);
        if (from_language.equals("Japanese"))
            Translate.execute1(text, Language.JAPANESE);
        if (from_language.equals("Korean"))
            Translate.execute1(text, Language.KOREAN);
        if (from_language.equals("Latvian"))
            Translate.execute1(text, Language.LATVIAN);
        if (from_language.equals("Lithuanian"))
            Translate.execute1(text, Language.LITHUANIAN);
        if (from_language.equals("Norwegian"))
            Translate.execute1(text, Language.NORWEGIAN);
        if (from_language.equals("Polish"))
            Translate.execute1(text, Language.POLISH);
        if (from_language.equals("Portuguese"))
            Translate.execute1(text, Language.PORTUGUESE);
        if (from_language.equals("Romanian"))
            Translate.execute1(text, Language.ROMANIAN);
        if (from_language.equals("Russian"))
            Translate.execute1(text, Language.RUSSIAN);
        if (from_language.equals("Slovak"))
            Translate.execute1(text, Language.SLOVAK);
        if (from_language.equals("Slovenian"))
            Translate.execute1(text, Language.SLOVENIAN);
        if (from_language.equals("Spanish"))
            Translate.execute1(text, Language.SPANISH);
        if (from_language.equals("Swedish"))
            Translate.execute1(text, Language.SWEDISH);
        if (from_language.equals("Thai"))
            Translate.execute1(text, Language.THAI);
        if (from_language.equals("Turkish"))
            Translate.execute1(text, Language.TURKISH);
        if (from_language.equals("Ukrainian"))
            Translate.execute1(text, Language.UKRAINIAN);
        if (from_language.equals("Vienamese"))
            Translate.execute1(text, Language.VIETNAMESE);


        if (to_language.equals("Arabic"))
            translatedText = translatedText = Translate.execute2(text, Language.ARABIC);
        if (to_language.equals("Bulgarian"))
            translatedText = Translate.execute2(text, Language.BULGARIAN);
        if (to_language.equals("Catalan"))
            translatedText = Translate.execute2(text, Language.CATALAN);
        if (to_language.equals("Chinese Simplified"))
            translatedText = Translate.execute2(text, Language.CHINESE_SIMPLIFIED);
        if (to_language.equals("Chinese Traditional"))
            translatedText = Translate.execute2(text, Language.CHINESE_TRADITIONAL);
        if (to_language.equals("Czech"))
            translatedText = Translate.execute2(text, Language.CZECH);
        if (to_language.equals("Danish"))
            translatedText = Translate.execute2(text, Language.DANISH);
        if (to_language.equals("Dutch"))
            translatedText = Translate.execute2(text, Language.DUTCH);
        if (to_language.equals("English"))
            translatedText = Translate.execute2(text, Language.ENGLISH);
        if (to_language.equals("Estonian"))
            translatedText = Translate.execute2(text, Language.ESTONIAN);
        if (to_language.equals("Finnish"))
            translatedText = Translate.execute2(text, Language.FINNISH);
        if (to_language.equals("French"))
            translatedText = Translate.execute2(text, Language.FRENCH);
        if (to_language.equals("German"))
            translatedText = Translate.execute2(text, Language.GERMAN);
        if (to_language.equals("Greek"))
            translatedText = Translate.execute2(text, Language.GREEK);
        if (to_language.equals("Haitian Creole"))
            translatedText = Translate.execute2(text, Language.HAITIAN_CREOLE);
        if (to_language.equals("Hebrew"))
            translatedText = Translate.execute2(text, Language.HEBREW);
        if (to_language.equals("Hindi"))
            translatedText = Translate.execute2(text, Language.HINDI);
        if (to_language.equals("Hmong Daw"))
            translatedText = Translate.execute2(text, Language.HMONG_DAW);
        if (to_language.equals("Hungarian"))
            translatedText = Translate.execute2(text, Language.HUNGARIAN);
        if (to_language.equals("Indonesian"))
            translatedText = Translate.execute2(text, Language.INDONESIAN);
        if (to_language.equals("Italian"))
            translatedText = Translate.execute2(text, Language.ITALIAN);
        if (to_language.equals("Japanese"))
            translatedText = Translate.execute2(text, Language.JAPANESE);
        if (to_language.equals("Korean"))
            translatedText = Translate.execute2(text, Language.KOREAN);
        if (to_language.equals("Latvian"))
            translatedText = Translate.execute2(text, Language.LATVIAN);
        if (to_language.equals("Lithuanian"))
            translatedText = Translate.execute2(text, Language.LITHUANIAN);
        if (to_language.equals("Norwegian"))
            translatedText = Translate.execute2(text, Language.NORWEGIAN);
        if (to_language.equals("Polish"))
            translatedText = Translate.execute2(text, Language.POLISH);
        if (to_language.equals("Portuguese"))
            translatedText = Translate.execute2(text, Language.PORTUGUESE);
        if (to_language.equals("Romanian"))
            translatedText = Translate.execute2(text, Language.ROMANIAN);
        if (to_language.equals("Russian"))
            translatedText = Translate.execute2(text, Language.RUSSIAN);
        if (to_language.equals("Slovak"))
            translatedText = Translate.execute2(text, Language.SLOVAK);
        if (to_language.equals("Slovenian"))
            translatedText = Translate.execute2(text, Language.SLOVENIAN);
        if (to_language.equals("Spanish"))
            translatedText = Translate.execute2(text, Language.SPANISH);
        if (to_language.equals("Swedish"))
            translatedText = Translate.execute2(text, Language.SWEDISH);
        if (to_language.equals("Thai"))
            translatedText = Translate.execute2(text, Language.THAI);
        if (to_language.equals("Turkish"))
            translatedText = Translate.execute2(text, Language.TURKISH);
        if (to_language.equals("Ukrainian"))
            translatedText = Translate.execute2(text, Language.UKRAINIAN);
        if (to_language.equals("Vienamese"))
            Translate.execute2(text, Language.VIETNAMESE);
        return translatedText;
    }

    public void toText(){

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

}