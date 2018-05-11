package com.srllimited.srl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.srllimited.srl.constants.Constants;
import com.srllimited.srl.database.DatabaseHelper;
import com.srllimited.srl.util.Util;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class HealthSurvey_activity extends MenuBaseActivity {
    WebView webviewsurvey;
    ProgressBar progessbar;
    String url = "";
    DatabaseHelper db;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_health_survey_activity);
        super.addContentView(R.layout.activity_health_survey_activity);
        webviewsurvey = (WebView) findViewById(R.id.webviewsurvey);
        url = getIntent().getExtras().getString("url");
        db = new DatabaseHelper(this);
        progessbar = (ProgressBar) findViewById(R.id.progessbar);
        header_loc_name.setText("");
        header_loc_name.setVisibility(View.GONE);
        headerlayout.setEnabled(false);
        clearCache(HealthSurvey_activity.this, 0);
        webviewsurvey.clearCache(true);
        webviewsurvey.clearHistory();
        CookieSyncManager cookieSyncMngr = CookieSyncManager.createInstance(HealthSurvey_activity.this);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeAllCookie();
        /*webviewsurvey.getSettings().setJavaScriptEnabled(true);
        webviewsurvey.getSettings().setLoadWithOverviewMode(true);
        webviewsurvey.getSettings().setUseWideViewPort(true);

        webviewsurvey.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);*/
        WebSettings webSettings = webviewsurvey.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheEnabled(false);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setDomStorageEnabled(true);
        Util.loadSSLCertificates(HealthSurvey_activity.this);
        webviewsurvey.loadUrl("about:blank");
        webviewsurvey.reload();
        webviewsurvey.loadUrl(url);
        webviewsurvey.setWebViewClient(new HelloWebViewClient());
        navBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HealthSurvey_activity.this, Dashboard.class);
                startActivity(intent);

                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(HealthSurvey_activity.this, Dashboard.class);
        startActivity(intent);

        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        String updatredurl = webviewsurvey.getUrl();
        //Toast.makeText(HealthSurvey_activity.this,updatredurl,Toast.LENGTH_LONG).show();
    }

    //helper method for clearCache() , recursive
//returns number of deleted files
    static int clearCacheFolder(final File dir, final int numDays) {

        int deletedFiles = 0;
        if (dir != null && dir.isDirectory()) {
            try {
                for (File child : dir.listFiles()) {

                    //first delete subdirectories recursively
                    if (child.isDirectory()) {
                        deletedFiles += clearCacheFolder(child, numDays);
                    }

                    //then delete the files and subdirectories in this dir
                    //only empty directories can be deleted, so subdirs have been done first
                    if (child.lastModified() < new Date().getTime() - numDays * DateUtils.DAY_IN_MILLIS) {
                        if (child.delete()) {
                            deletedFiles++;
                        }
                    }
                }
            } catch (Exception e) {
                Log.e("TAG", String.format("Failed to clean the cache, error %s", e.getMessage()));
            }
        }
        return deletedFiles;
    }

    public static void clearCache(final Context context, final int numDays) {
        Log.i("TAG", String.format("Starting cache prune, deleting files older than %d days", numDays));
        int numDeletedFiles = clearCacheFolder(context.getCacheDir(), numDays);
        Log.i("TAG", String.format("Cache pruning completed, %d files deleted", numDeletedFiles));
    }

    private class HelloWebViewClient extends WebViewClient  {
        boolean loadingFinished = true;
        boolean redirect = false;

        int count =0;
        int bynowcount =0;
        int timerCount =0;
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
        }

      /*  @TargetApi(Build.VERSION_CODES.N)
        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest request)
        {
            final Uri uri = request.getUrl();

            webView.getUrl();
            if (!loadingFinished) {
                redirect = true;
            }
            //  https://srlcare.srl.in/smartselect?preserve_city=Mumbai&clear_cache=true
            loadingFinished = false;
            webView.loadUrl(url);
           // progessbar.setVisibility(View.GONE);//need to comment
            timerClass();
            ////////////////onLoadResource code /////////////////////////
            if (uri.toString().contains("&label=recommended"*//*"http://uatcustomerportal.srlworld"*//*)) {
                //Toast.makeText(HealthSurvey_activity.this,""+status,Toast.LENGTH_LONG).show();
                if (bynowcount == 0) {
                    bynowcount = bynowcount + 1;
                    Constants.issrlRecommondation = true;
                    Constants.isPackage = false;
                    Constants.isrecomm_comefrommenu = false;
                    Util.killBook();
                    Intent intent = new Intent(HealthSurvey_activity.this, BookATestActivity.class);
                    intent.putExtra("pkg_category", "recommended");//recommended
                    startActivity(intent);
                    db.deleteBookATest();
                    finish();
                    Log.v("SRL URL", "" + url);
                }
            } else if (url.toString().contains("&label=advanced")) {
                if (bynowcount == 0) {
                    bynowcount = bynowcount + 1;
                    Constants.issrlRecommondation = true;
                    Constants.isPackage = false;
                    Constants.isrecomm_comefrommenu = false;
                    Util.killBook();
                    Intent intent = new Intent(HealthSurvey_activity.this, BookATestActivity.class);
                    intent.putExtra("pkg_category", "advanced");//recommended
                    startActivity(intent);
                    db.deleteBookATest();
                    finish();
                    Log.v("SRL URL", "" + url);
                }

            }
            return false;
        }
*/
        @SuppressWarnings("deprecation")
        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String url) {
            if (!loadingFinished) {
                redirect = true;
            }//about:blank
            webView.getUrl();
            https://srlcare.srl.in/smartselect
          //  https://srlcare.srl.in/smartselect?preserve_city=Mumbai&clear_cache=true
            loadingFinished = false;
            webView.loadUrl(url);
           // progessbar.setVisibility(View.GONE);//need to comment
            if(progessbar.getVisibility()==View.VISIBLE){

                if(timerCount ==0) {
                    timerCount =timerCount+1;
                    timerClass();
                }
            }

            ////////////////onLoadResource code /////////////////////////
            if (url.contains("&label=recommended"/*"http://uatcustomerportal.srlworld"*/)) {
                //Toast.makeText(HealthSurvey_activity.this,""+status,Toast.LENGTH_LONG).show();
                if (bynowcount == 0) {
                    bynowcount = bynowcount + 1;
                    Constants.issrlRecommondation = true;
                    Constants.isPackage = false;
                    Constants.isrecomm_comefrommenu = false;
                    Util.killBook();
                    Intent intent = new Intent(HealthSurvey_activity.this, BookATestActivity.class);
                    intent.putExtra("pkg_category", "recommended");//recommended
                    startActivity(intent);
                    db.deleteBookATest();
                    finish();
                    Log.v("SRL URL", "" + url);
                }
            } else if (url.contains("&label=advanced")) {
                if (bynowcount == 0) {
                    bynowcount = bynowcount + 1;
                    Constants.issrlRecommondation = true;
                    Constants.isPackage = false;
                    Constants.isrecomm_comefrommenu = false;
                    Util.killBook();
                    Intent intent = new Intent(HealthSurvey_activity.this, BookATestActivity.class);
                    intent.putExtra("pkg_category", "advanced");//recommended
                    startActivity(intent);
                    db.deleteBookATest();
                    finish();
                    Log.v("SRL URL", "" + url);
                }

            }
          /*  webView.evaluateJavascript("javascript:getSmartSelectStatus();", new ValueCallback<String>() {
                @Override
                public void onReceiveValue(String s) {

                    // Do what you want with the return value
                    String status = s.replaceAll("^\"|\"$", "");
                   *//* if(count==0) {
                        if (status.equalsIgnoreCase("complete")) {
                            //Toast.makeText(HealthSurvey_activity.this,""+status,Toast.LENGTH_LONG).show();
                            count =count+1;
                            Constants.issrlRecommondation = true;
                            Constants.isPackage = false;
                            Constants.isrecomm_comefrommenu = false;
                            Util.killBook();
                            Intent intent = new Intent(HealthSurvey_activity.this, BookATestActivity.class);
                            startActivity(intent);
                            db.deleteBookATest();
                            finish();
                        }
                    }*//*
                    if(status.equalsIgnoreCase("started"))
                    {
                        progessbar.setVisibility(View.GONE);
                    }


                }
            });*/

            /////////////////////////////////////////

            return true;
        }

       /* @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
            // http://uatcustomerportal.srlworld.com/?TestCode=CMP75%2C4836H%2C4866H%2CB%2FC%2CCMP96&Uhid=SHRAF2510882&cityname=Mumbai
            //http://uatcustomerportal.srlworld.com/?TestCode=CMP75%2C4836H%2C4866H%2CB%2FC%2CCMP96&Uhid=SHRAF2510882&cityname=Mumbai&label=recommended

           // https://portal.srlworld.com/BookTest/InitiateTest?Uhid=SHRAF2510882&cityname=Mumbai&TestCode=CMP81A%2C3250%2C3020&label=recommended

            if (url.contains("&label=recommended"*//*"http://uatcustomerportal.srlworld"*//*)) {
                //Toast.makeText(HealthSurvey_activity.this,""+status,Toast.LENGTH_LONG).show();
                if (bynowcount == 0) {
                    bynowcount = bynowcount + 1;
                    Constants.issrlRecommondation = true;
                    Constants.isPackage = false;
                    Constants.isrecomm_comefrommenu = false;
                    Util.killBook();
                    Intent intent = new Intent(HealthSurvey_activity.this, BookATestActivity.class);
                    intent.putExtra("pkg_category", "recommended");//recommended
                    startActivity(intent);
                    db.deleteBookATest();
                    finish();
                    Log.v("SRL URL", "" + url);
                }
            } else if (url.contains("&label=advanced")) {
                if (bynowcount == 0) {
                    bynowcount = bynowcount + 1;
                    Constants.issrlRecommondation = true;
                    Constants.isPackage = false;
                    Constants.isrecomm_comefrommenu = false;
                    Util.killBook();
                    Intent intent = new Intent(HealthSurvey_activity.this, BookATestActivity.class);
                    intent.putExtra("pkg_category", "advanced");//recommended
                    startActivity(intent);
                    db.deleteBookATest();
                    finish();
                    Log.v("SRL URL", "" + url);
                }

        }
            view.evaluateJavascript("javascript:getSmartSelectStatus();", new ValueCallback<String>() {
                @Override
                public void onReceiveValue(String s) {

                    // Do what you want with the return value
                    String status = s.replaceAll("^\"|\"$", "");
                   *//* if(count==0) {
                        if (status.equalsIgnoreCase("complete")) {
                            //Toast.makeText(HealthSurvey_activity.this,""+status,Toast.LENGTH_LONG).show();
                            count =count+1;
                            Constants.issrlRecommondation = true;
                            Constants.isPackage = false;
                            Constants.isrecomm_comefrommenu = false;
                            Util.killBook();
                            Intent intent = new Intent(HealthSurvey_activity.this, BookATestActivity.class);
                            startActivity(intent);
                            db.deleteBookATest();
                            finish();
                        }
                    }*//*
                    if(status.equalsIgnoreCase("started"))
                    {
                        progessbar.setVisibility(View.GONE);
                    }


                }
            });


           *//* view.evaluateJavascript("javascript:recommendation_category_selected();", new ValueCallback<String>() {
                @Override
                public void onReceiveValue(String s) {

                    // Do what you want with the return value
                    String status = s.replaceAll("^\"|\"$", "");

                        if (status.equalsIgnoreCase("recommended")) {
                            //Toast.makeText(HealthSurvey_activity.this,""+status,Toast.LENGTH_LONG).show();
                            count =count+1;
                            Constants.issrlRecommondation = true;
                            Constants.isPackage = false;
                            Constants.isrecomm_comefrommenu = false;
                            Util.killBook();
                            Intent intent = new Intent(HealthSurvey_activity.this, BookATestActivity.class);
                            intent.putExtra("pkg_category","recommended");
                            startActivity(intent);
                            db.deleteBookATest();
                            finish();
                        }
                    else if (status.equalsIgnoreCase("advanced")) {
                        //Toast.makeText(HealthSurvey_activity.this,""+status,Toast.LENGTH_LONG).show();
                        count =count+1;
                        Constants.issrlRecommondation = true;
                        Constants.isPackage = false;
                        Constants.isrecomm_comefrommenu = false;
                        Util.killBook();
                        Intent intent = new Intent(HealthSurvey_activity.this, BookATestActivity.class);
                            intent.putExtra("pkg_category","advanced");
                        startActivity(intent);
                        db.deleteBookATest();
                        finish();
                    }

                    if(status.equalsIgnoreCase("started"))
                    {
                        progessbar.setVisibility(View.GONE);
                    }


                }
            });*//*
        }*/

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub

            super.onPageFinished(view, url);
            if(!redirect){
                loadingFinished = true;
            }

            if(loadingFinished && !redirect){
                //HIDE LOADING IT HAS FINISHED
                //progessbar.setVisibility(View.GONE);
            } else{
                redirect = false;
            }
            /*webviewsurvey.clearCache(true);
            webviewsurvey.clearHistory();
            webviewsurvey.destroy();*/


            //clearCache(HealthSurvey_activity.this,0);
            //view.clearCache(true);
        }

       /* @Override
        public void onPageCommitVisible(WebView view, String url) {
            super.onPageCommitVisible(view, url);

        }*/

        @SuppressLint("NewApi")
        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {

            SslCertificate serverCertificate = error.getCertificate();
            Bundle serverBundle = SslCertificate.saveState(serverCertificate);
            for (SslCertificate appCertificate : Util.certificates) {
                if (TextUtils.equals(serverCertificate.toString(), appCertificate.toString())) { // First fast check
                    Bundle appBundle = SslCertificate.saveState(appCertificate);
                    Set<String> keySet = appBundle.keySet();
                    boolean matches = true;
                    for (String key : keySet) {
                        Object serverObj = serverBundle.get(key);
                        Object appObj = appBundle.get(key);
                        if (serverObj instanceof byte[] && appObj instanceof byte[]) {     // key "x509-certificate"
                            if (!Arrays.equals((byte[]) serverObj, (byte[]) appObj)) {
                                matches = false;
                                break;
                            }
                        } else if ((serverObj != null) && !serverObj.equals(appObj)) {
                            matches = false;
                            break;
                        }
                    }
                    if (matches) {
                        handler.proceed();
                        return;
                    }
                }
            }

            handler.cancel();
            String message = "SSL Error " + error.getPrimaryError();
            Log.w("HealthSurveySecond", message);

            //handler.proceed(); // Ignore SSL certificate errors
        }



    }

    public void timerClass(){
        Timer buttonTimer = new Timer();

        buttonTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        progessbar.setVisibility(View.GONE);
                    }
                });
            }
        }, 16000);
    }

}
