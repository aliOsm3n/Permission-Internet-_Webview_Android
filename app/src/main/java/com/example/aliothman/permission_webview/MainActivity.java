package com.example.aliothman.permission_webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    EditText Urledtx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView)findViewById(R.id.webv);
        webView.setWebViewClient(new MywebView());
       webView.getSettings().setJavaScriptEnabled(true);
       webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        Urledtx = (EditText) findViewById(R.id.Urledtxt);
        webView.loadUrl("https://www.tutorialspoint.com/");
    }
    String Url;
    public void loaddata(String Url){
        this.Url = Url;
        webView.loadUrl(Url);
    }

    public void gobtn(View view) {
        loaddata(Urledtx.getText().toString());
    }


    public void backbtn(View view) {
        webView.goBack();
    }

    public void nextbtn(View view) {
        webView.goForward();
    }

    private  class  MywebView extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String Url) {
            view.loadUrl(Url);
            return true;
        }
    }

}
