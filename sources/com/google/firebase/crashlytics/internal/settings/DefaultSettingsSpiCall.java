package com.google.firebase.crashlytics.internal.settings;

import android.text.TextUtils;
import com.facebook.GraphRequest;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import com.google.firebase.crashlytics.internal.network.HttpGetRequest;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.network.HttpResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class DefaultSettingsSpiCall implements SettingsSpiCall {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f89048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HttpRequestFactory f89049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Logger f89050c;

    public DefaultSettingsSpiCall(String str, HttpRequestFactory httpRequestFactory) {
        this(str, httpRequestFactory, Logger.f());
    }

    private HttpGetRequest b(HttpGetRequest httpGetRequest, SettingsRequest settingsRequest) {
        c(httpGetRequest, "X-CRASHLYTICS-GOOGLE-APP-ID", settingsRequest.f89080a);
        c(httpGetRequest, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        c(httpGetRequest, "X-CRASHLYTICS-API-CLIENT-VERSION", CrashlyticsCore.o());
        c(httpGetRequest, "Accept", "application/json");
        c(httpGetRequest, "X-CRASHLYTICS-DEVICE-MODEL", settingsRequest.f89081b);
        c(httpGetRequest, "X-CRASHLYTICS-OS-BUILD-VERSION", settingsRequest.f89082c);
        c(httpGetRequest, "X-CRASHLYTICS-OS-DISPLAY-VERSION", settingsRequest.f89083d);
        c(httpGetRequest, "X-CRASHLYTICS-INSTALLATION-ID", settingsRequest.f89084e.a().c());
        return httpGetRequest;
    }

    private void c(HttpGetRequest httpGetRequest, String str, String str2) {
        if (str2 != null) {
            httpGetRequest.d(str, str2);
        }
    }

    private JSONObject e(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e3) {
            this.f89050c.l("Failed to parse settings JSON from " + this.f89048a, e3);
            this.f89050c.k("Settings response " + str);
            return null;
        }
    }

    private Map f(SettingsRequest settingsRequest) {
        HashMap map = new HashMap();
        map.put("build_version", settingsRequest.f89087h);
        map.put("display_version", settingsRequest.f89086g);
        map.put("source", Integer.toString(settingsRequest.f89088i));
        String str = settingsRequest.f89085f;
        if (!TextUtils.isEmpty(str)) {
            map.put("instance", str);
        }
        return map;
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsSpiCall
    public JSONObject a(SettingsRequest settingsRequest, boolean z2) {
        CrashlyticsWorkers.d();
        if (!z2) {
            throw new RuntimeException("An invalid data collection token was used.");
        }
        try {
            Map mapF = f(settingsRequest);
            HttpGetRequest httpGetRequestB = b(d(mapF), settingsRequest);
            this.f89050c.b("Requesting settings from " + this.f89048a);
            this.f89050c.i("Settings query params were: " + mapF);
            return g(httpGetRequestB.c());
        } catch (IOException e3) {
            this.f89050c.e("Settings request failed.", e3);
            return null;
        }
    }

    protected HttpGetRequest d(Map map) {
        return this.f89049b.a(this.f89048a, map).d(GraphRequest.USER_AGENT_HEADER, "Crashlytics Android SDK/" + CrashlyticsCore.o()).d("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    JSONObject g(HttpResponse httpResponse) {
        int iB = httpResponse.b();
        this.f89050c.i("Settings response code was: " + iB);
        if (h(iB)) {
            return e(httpResponse.a());
        }
        this.f89050c.d("Settings request failed; (status: " + iB + ") from " + this.f89048a);
        return null;
    }

    boolean h(int i3) {
        return i3 == 200 || i3 == 201 || i3 == 202 || i3 == 203;
    }

    DefaultSettingsSpiCall(String str, HttpRequestFactory httpRequestFactory, Logger logger) {
        if (str == null) {
            throw new IllegalArgumentException("url must not be null.");
        }
        this.f89050c = logger;
        this.f89049b = httpRequestFactory;
        this.f89048a = str;
    }
}
