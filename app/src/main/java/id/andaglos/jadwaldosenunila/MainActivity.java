package id.andaglos.jadwaldosenunila;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //String url = "http://www.kinerja.com";
         web = (WebView)findViewById(R.id.webViewApp);
        web.getSettings().setJavaScriptEnabled(true);


        web.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view,String url){
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view,url);

            }

        });
        web.loadUrl("http://aac1945.com/jadwal-dosen/public");
        //web.loadUrl(url)


        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web.reload();

            }
        });
    }

}

