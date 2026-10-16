package com.singular.sdk;

import android.webkit.JavascriptInterface;
import com.singular.sdk.internal.SingularLog;
import cz.mobilesoft.coreblock.view.screen.ohO.MHoiDDglUlPJC;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class SingularJSInterface {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SingularLog f92445b = SingularLog.f("SingularJSInterface");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f92446a;

    @JavascriptInterface
    public boolean event(String str) {
        f92445b.a("event(name=" + str + ")");
        return Singular.b(str);
    }

    @JavascriptInterface
    public void revenue(String str, double d3) throws JSONException {
        f92445b.a("revenue(currency=" + str + ", amount=" + d3 + ")");
        Singular.g(str, d3);
    }

    @JavascriptInterface
    public void setWebViewId(int i3) {
        f92445b.a("setWebViewId(id=" + i3 + ")");
        this.f92446a = i3;
    }

    @JavascriptInterface
    public void unsetCustomUserId() throws JSONException {
        f92445b.a("unsetCustomUserId()");
        Singular.i();
    }

    @JavascriptInterface
    public void setCustomUserId(String str) throws JSONException {
        f92445b.a(MHoiDDglUlPJC.jBs + str + ")");
        Singular.h(str);
    }

    @JavascriptInterface
    public void event(String str, String str2) throws JSONException {
        f92445b.a("event(name=" + str + ", JSONString=" + str2 + ")");
        Singular.d(str, new JSONObject(str2));
    }
}
