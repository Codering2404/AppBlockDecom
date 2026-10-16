package com.applovin.sdk;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.applovin.impl.pi;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sj;
import com.applovin.impl.yp;
import com.google.ads.mediation.applovin.AppLovinMediationAdapter;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AppLovinWebViewActivity extends Activity {
    public static final String EVENT_DISMISSED_VIA_BACK_BUTTON = "dismissed_via_back_button";
    public static final String INTENT_EXTRA_KEY_IMMERSIVE_MODE_ON = "immersive_mode_on";
    public static final String INTENT_EXTRA_KEY_LOAD_URL = "load_url";
    public static final String INTENT_EXTRA_KEY_SDK_KEY = "sdk_key";
    public static final String URI_PATH_WEBVIEW_EVENT = "webview_event";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f65623a = new AtomicBoolean();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f65624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WebView f65625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private EventListener f65626d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface EventListener {
        void onReceivedEvent(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends pi {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f65627a;

        a(j jVar) {
            this.f65627a = jVar;
        }

        @Override // com.applovin.impl.pi, android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (AppLovinWebViewActivity.this.f65625c == webView) {
                AppLovinWebViewActivity.this.f65625c.destroy();
                AppLovinWebViewActivity.this.f65625c = null;
                AppLovinWebViewActivity appLovinWebViewActivity = AppLovinWebViewActivity.this;
                final j jVar = this.f65627a;
                appLovinWebViewActivity.runOnUiThread(new Runnable() { // from class: com.applovin.sdk.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f65629a.a(jVar);
                    }
                });
            }
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri uri = Uri.parse(str);
            String scheme = uri.getScheme();
            String host = uri.getHost();
            String path = uri.getPath();
            this.f65627a.I();
            if (n.a()) {
                this.f65627a.I().a("AppLovinWebViewActivity", "Handling url load: " + str);
            }
            if (!"applovin".equalsIgnoreCase(scheme) || !AppLovinMediationAdapter.APPLOVIN_SDK_ERROR_DOMAIN.equalsIgnoreCase(host) || AppLovinWebViewActivity.this.f65626d == null) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            if (!path.endsWith(AppLovinWebViewActivity.URI_PATH_WEBVIEW_EVENT)) {
                return true;
            }
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            String str2 = queryParameterNames.isEmpty() ? "" : (String) queryParameterNames.toArray()[0];
            if (!StringUtils.isValidString(str2)) {
                this.f65627a.I();
                if (!n.a()) {
                    return true;
                }
                this.f65627a.I().b("AppLovinWebViewActivity", "Failed to parse WebView event parameter");
                return true;
            }
            String queryParameter = uri.getQueryParameter(str2);
            this.f65627a.I();
            if (n.a()) {
                this.f65627a.I().a("AppLovinWebViewActivity", "Parsed WebView event parameter name: " + str2 + " and value: " + queryParameter);
            }
            AppLovinWebViewActivity.this.f65626d.onReceivedEvent(queryParameter);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(j jVar) {
            if (!((Boolean) jVar.a(sj.F5)).booleanValue() || !AppLovinWebViewActivity.this.f65623a.compareAndSet(false, true)) {
                AppLovinWebViewActivity.this.finish();
                return;
            }
            AppLovinWebViewActivity.this.a(jVar);
            if (StringUtils.isValidString(AppLovinWebViewActivity.this.f65624b)) {
                AppLovinWebViewActivity.this.f65625c.loadUrl(AppLovinWebViewActivity.this.f65624b);
            }
        }
    }

    public void loadUrl(String str, EventListener eventListener) {
        this.f65626d = eventListener;
        this.f65624b = str;
        this.f65623a.set(false);
        WebView webView = this.f65625c;
        if (webView != null) {
            webView.loadUrl(str);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        EventListener eventListener = this.f65626d;
        if (eventListener != null) {
            eventListener.onReceivedEvent(EVENT_DISMISSED_VIA_BACK_BUTTON);
        }
        super.onBackPressed();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra(INTENT_EXTRA_KEY_SDK_KEY);
        if (TextUtils.isEmpty(stringExtra)) {
            n.h("AppLovinWebViewActivity", "No SDK key specified");
            finish();
            return;
        }
        a(AppLovinSdk.getInstance(stringExtra, new AppLovinSdkSettings(getApplicationContext()), getApplicationContext()).a());
        if (getIntent().getBooleanExtra(INTENT_EXTRA_KEY_IMMERSIVE_MODE_ON, false)) {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        }
        String stringExtra2 = getIntent().getStringExtra(INTENT_EXTRA_KEY_LOAD_URL);
        if (StringUtils.isValidString(stringExtra2)) {
            this.f65624b = stringExtra2;
        }
        if (StringUtils.isValidString(this.f65624b)) {
            this.f65625c.loadUrl(this.f65624b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar) {
        WebView webViewB = yp.b(this, "WebView Activity");
        this.f65625c = webViewB;
        if (webViewB == null) {
            finish();
            return;
        }
        setContentView(webViewB);
        WebSettings settings = this.f65625c.getSettings();
        settings.setSupportMultipleWindows(false);
        settings.setJavaScriptEnabled(true);
        this.f65625c.setVerticalScrollBarEnabled(true);
        this.f65625c.setHorizontalScrollBarEnabled(true);
        this.f65625c.setScrollBarStyle(33554432);
        this.f65625c.setWebViewClient(new a(jVar));
    }
}
