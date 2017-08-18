package id.andaglos.jadwaldosenunila;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton button;
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.activity_main);

        // Makes Progress bar Visible
        getWindow().setFeatureInt( Window.FEATURE_PROGRESS, Window.PROGRESS_VISIBILITY_ON);



        //String url = "http://www.kinerja.com";
         web = (WebView)findViewById(R.id.webViewApp);
        web.getSettings().setJavaScriptEnabled(true);
        web.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress)
            {
                //Make the bar disappear after URL is loaded, and changes string to Loading...
                setTitle("Loading...");
                setProgress(progress * 100); //Make the bar disappear after URL is loaded

                // Return the app name after finish loading
                if(progress == 100)
                    setTitle(R.string.app_name);
            }
        });

        web.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view,String url){
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view,url);

            }

        });

        web.loadUrl("http://aac1945.com/jadwal-dosen/public");
        //web.loadUrl(url)


         button = (FloatingActionButton) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web.reload();

            }
        });
    }

}

