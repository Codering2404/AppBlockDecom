package com.applovin.impl;

import android.net.Uri;
import android.webkit.WebView;
import com.applovin.impl.ye;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class vm extends yl implements ye.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.applovin.impl.sdk.ad.a f64440h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private AppLovinAdLoadListener f64441i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.applovin.impl.adview.b f64442j;

    public vm(JSONObject jSONObject, JSONObject jSONObject2, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        super("TaskProcessJavaScriptTagAd", jVar);
        this.f64440h = new com.applovin.impl.sdk.ad.a(jSONObject, jSONObject2, jVar);
        this.f64441i = appLovinAdLoadListener;
        jVar.R().a(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.a(this.f65232b, "Rendering AppLovin ad #" + this.f64440h.getAdIdNumber());
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.a70
            @Override // java.lang.Runnable
            public final void run() {
                this.f58217a.e();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        try {
            com.applovin.impl.adview.b bVar = new com.applovin.impl.adview.b(this.f65231a, a());
            this.f64442j = bVar;
            bVar.a(new b(this.f65231a));
            this.f64442j.loadDataWithBaseURL(this.f64440h.h(), this.f64440h.l1(), "text/html", null, "");
        } catch (Throwable th) {
            this.f65231a.R().b(this);
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Failed to initialize WebView", th);
            }
            AppLovinAdLoadListener appLovinAdLoadListener = this.f64441i;
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.failedToReceiveAd(-1);
                this.f64441i = null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class b extends com.applovin.impl.adview.c {
        private b(com.applovin.impl.sdk.j jVar) {
            super(null, jVar);
        }

        private boolean a(String str, sj sjVar) {
            Iterator it = vm.this.f65231a.c(sjVar).iterator();
            while (it.hasNext()) {
                if (((String) it.next()).equalsIgnoreCase(str)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.applovin.impl.adview.c
        protected boolean a(WebView webView, String str) {
            com.applovin.impl.sdk.n nVar = vm.this.f65233c;
            if (com.applovin.impl.sdk.n.a()) {
                vm vmVar = vm.this;
                vmVar.f65233c.d(vmVar.f65232b, "Processing click on ad URL \"" + str + "\"");
            }
            if (str == null || !(webView instanceof com.applovin.impl.adview.b)) {
                return true;
            }
            Uri uri = Uri.parse(str);
            String scheme = uri.getScheme();
            String host = uri.getHost();
            if (!a(scheme, sj.N1)) {
                return true;
            }
            if (a(host, sj.O1)) {
                com.applovin.impl.sdk.n nVar2 = vm.this.f65233c;
                if (com.applovin.impl.sdk.n.a()) {
                    vm vmVar2 = vm.this;
                    vmVar2.f65233c.a(vmVar2.f65232b, "Ad load succeeded");
                }
                if (vm.this.f64441i == null) {
                    return true;
                }
                vm.this.f64441i.adReceived(vm.this.f64440h);
                vm.this.f64441i = null;
                return true;
            }
            if (a(host, sj.P1)) {
                com.applovin.impl.sdk.n nVar3 = vm.this.f65233c;
                if (com.applovin.impl.sdk.n.a()) {
                    vm vmVar3 = vm.this;
                    vmVar3.f65233c.a(vmVar3.f65232b, "Ad load failed");
                }
                if (vm.this.f64441i == null) {
                    return true;
                }
                vm.this.f64441i.failedToReceiveAd(204);
                vm.this.f64441i = null;
                return true;
            }
            com.applovin.impl.sdk.n nVar4 = vm.this.f65233c;
            if (!com.applovin.impl.sdk.n.a()) {
                return true;
            }
            vm vmVar4 = vm.this;
            vmVar4.f65233c.b(vmVar4.f65232b, "Unrecognized webview event");
            return true;
        }
    }

    @Override // com.applovin.impl.ye.a
    public void a(fe feVar) {
        if (feVar.R().equalsIgnoreCase(this.f64440h.I())) {
            this.f65231a.R().b(this);
            AppLovinAdLoadListener appLovinAdLoadListener = this.f64441i;
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.adReceived(this.f64440h);
                this.f64441i = null;
            }
        }
    }
}
