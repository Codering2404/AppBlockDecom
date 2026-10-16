package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import androidx.core.content.pm.PackageInfoCompat;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ConfigFetchHttpClient {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Pattern f89732h = Pattern.compile("^[^:]+:([0-9]+):(android|ios|web):([0-9a-f]+)");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f89733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f89734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f89735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f89736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f89737e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f89738f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f89739g;

    public ConfigFetchHttpClient(Context context, String str, String str2, String str3, long j3, long j4) {
        this.f89733a = context;
        this.f89734b = str;
        this.f89735c = str2;
        this.f89736d = f(str);
        this.f89737e = str3;
        this.f89738f = j3;
        this.f89739g = j4;
    }

    private boolean a(JSONObject jSONObject) {
        try {
            return !jSONObject.get(ServerProtocol.DIALOG_PARAM_STATE).equals("NO_CHANGE");
        } catch (JSONException unused) {
            return true;
        }
    }

    private String b(long j3) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(Long.valueOf(j3));
    }

    private JSONObject c(String str, String str2, Map map, Long l3, Map map2) throws FirebaseRemoteConfigClientException {
        HashMap map3 = new HashMap();
        if (str == null) {
            throw new FirebaseRemoteConfigClientException("Fetch failed: Firebase installation id is null.");
        }
        map3.put("appInstanceId", str);
        map3.put("appInstanceIdToken", str2);
        map3.put("appId", this.f89734b);
        Locale locale = this.f89733a.getResources().getConfiguration().locale;
        map3.put("countryCode", locale.getCountry());
        int i3 = Build.VERSION.SDK_INT;
        map3.put("languageCode", locale.toLanguageTag());
        map3.put("platformVersion", Integer.toString(i3));
        map3.put("timeZone", TimeZone.getDefault().getID());
        try {
            PackageInfo packageInfo = this.f89733a.getPackageManager().getPackageInfo(this.f89733a.getPackageName(), 0);
            if (packageInfo != null) {
                map3.put("appVersion", packageInfo.versionName);
                map3.put("appBuild", Long.toString(PackageInfoCompat.a(packageInfo)));
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        map3.put("packageName", this.f89733a.getPackageName());
        map3.put("sdkVersion", "23.0.1");
        map3.put("analyticsUserProperties", new JSONObject(map));
        if (!map2.isEmpty()) {
            map3.put("customSignals", new JSONObject(map2));
            Log.d("FirebaseRemoteConfig", "Keys of custom signals during fetch: " + map2.keySet());
        }
        if (l3 != null) {
            map3.put("firstOpenTime", b(l3.longValue()));
        }
        return new JSONObject(map3);
    }

    private static ConfigContainer e(JSONObject jSONObject, Date date) throws FirebaseRemoteConfigClientException {
        JSONObject jSONObject2;
        JSONArray jSONArray;
        JSONObject jSONObject3;
        try {
            ConfigContainer.Builder builderE = ConfigContainer.l().e(date);
            JSONArray jSONArray2 = null;
            try {
                jSONObject2 = jSONObject.getJSONObject("entries");
            } catch (JSONException unused) {
                jSONObject2 = null;
            }
            if (jSONObject2 != null) {
                builderE = builderE.c(jSONObject2);
            }
            try {
                jSONArray = jSONObject.getJSONArray("experimentDescriptions");
            } catch (JSONException unused2) {
                jSONArray = null;
            }
            if (jSONArray != null) {
                builderE = builderE.d(jSONArray);
            }
            try {
                jSONObject3 = jSONObject.getJSONObject("personalizationMetadata");
            } catch (JSONException unused3) {
                jSONObject3 = null;
            }
            if (jSONObject3 != null) {
                builderE = builderE.f(jSONObject3);
            }
            String string = jSONObject.has("templateVersion") ? jSONObject.getString("templateVersion") : null;
            if (string != null) {
                builderE.h(Long.parseLong(string));
            }
            try {
                jSONArray2 = jSONObject.getJSONArray("rolloutMetadata");
            } catch (JSONException unused4) {
            }
            if (jSONArray2 != null) {
                builderE = builderE.g(jSONArray2);
            }
            return builderE.a();
        } catch (JSONException e3) {
            throw new FirebaseRemoteConfigClientException("Fetch failed: fetch response could not be parsed.", e3);
        }
    }

    private static String f(String str) {
        Matcher matcher = f89732h.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }

    private JSONObject g(URLConnection uRLConnection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(uRLConnection.getInputStream(), "utf-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i3 = bufferedReader.read();
            if (i3 == -1) {
                return new JSONObject(sb.toString());
            }
            sb.append((char) i3);
        }
    }

    private String h(String str, String str2) {
        return String.format("https://firebaseremoteconfig.googleapis.com/v1/projects/%s/namespaces/%s:fetch", str, str2);
    }

    private String i() {
        try {
            Context context = this.f89733a;
            byte[] bArrA = AndroidUtilsLight.a(context, context.getPackageName());
            if (bArrA != null) {
                return Hex.c(bArrA, false);
            }
            Log.e("FirebaseRemoteConfig", "Could not get fingerprint hash for package: " + this.f89733a.getPackageName());
            return null;
        } catch (PackageManager.NameNotFoundException e3) {
            Log.e("FirebaseRemoteConfig", "No such package: " + this.f89733a.getPackageName(), e3);
            return null;
        }
    }

    private void j(HttpURLConnection httpURLConnection, String str) {
        httpURLConnection.setRequestProperty("X-Goog-Api-Key", this.f89735c);
        httpURLConnection.setRequestProperty("X-Android-Package", this.f89733a.getPackageName());
        httpURLConnection.setRequestProperty("X-Android-Cert", i());
        httpURLConnection.setRequestProperty("X-Google-GFE-Can-Retry", "yes");
        httpURLConnection.setRequestProperty("X-Goog-Firebase-Installations-Auth", str);
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept", "application/json");
    }

    private void k(HttpURLConnection httpURLConnection, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
    }

    private void l(HttpURLConnection httpURLConnection, byte[] bArr) throws IOException {
        httpURLConnection.setFixedLengthStreamingMode(bArr.length);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
        bufferedOutputStream.write(bArr);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    private void m(HttpURLConnection httpURLConnection, String str, String str2, Map map) {
        httpURLConnection.setDoOutput(true);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        httpURLConnection.setConnectTimeout((int) timeUnit.toMillis(this.f89738f));
        httpURLConnection.setReadTimeout((int) timeUnit.toMillis(this.f89739g));
        httpURLConnection.setRequestProperty("If-None-Match", str);
        j(httpURLConnection, str2);
        k(httpURLConnection, map);
    }

    HttpURLConnection d() throws FirebaseRemoteConfigException {
        try {
            return (HttpURLConnection) new URL(h(this.f89736d, this.f89737e)).openConnection();
        } catch (IOException e3) {
            throw new FirebaseRemoteConfigException(e3.getMessage());
        }
    }

    ConfigFetchHandler.FetchResponse fetch(HttpURLConnection httpURLConnection, String str, String str2, Map<String, String> map, String str3, Map<String, String> map2, Long l3, Date date, Map<String, String> map3) throws FirebaseRemoteConfigException {
        m(httpURLConnection, str3, str2, map2);
        try {
            try {
                l(httpURLConnection, c(str, str2, map, l3, map3).toString().getBytes("utf-8"));
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 200) {
                    throw new FirebaseRemoteConfigServerException(responseCode, httpURLConnection.getResponseMessage());
                }
                String headerField = httpURLConnection.getHeaderField("ETag");
                JSONObject jSONObjectG = g(httpURLConnection);
                httpURLConnection.disconnect();
                try {
                    httpURLConnection.getInputStream().close();
                } catch (IOException unused) {
                }
                ConfigContainer configContainerE = e(jSONObjectG, date);
                return !a(jSONObjectG) ? ConfigFetchHandler.FetchResponse.a(date, configContainerE) : ConfigFetchHandler.FetchResponse.b(configContainerE, headerField);
            } finally {
            }
        } catch (IOException | JSONException e3) {
            throw new FirebaseRemoteConfigClientException("The client had an error while calling the backend!", e3);
        }
    }
}
