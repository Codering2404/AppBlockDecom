package com.google.firebase.crashlytics.internal.network;

import com.facebook.internal.Utility;
import com.facebook.stetho.common.Utf8Charset;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class HttpGetRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f89000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f89001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f89002c = new HashMap();

    public HttpGetRequest(String str, Map map) {
        this.f89000a = str;
        this.f89001b = map;
    }

    private String a(Map map) {
        StringBuilder sb = new StringBuilder();
        Iterator it = map.entrySet().iterator();
        Map.Entry entry = (Map.Entry) it.next();
        sb.append((String) entry.getKey());
        sb.append("=");
        sb.append(entry.getValue() != null ? URLEncoder.encode((String) entry.getValue(), Utf8Charset.NAME) : "");
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            sb.append("&");
            sb.append((String) entry2.getKey());
            sb.append("=");
            sb.append(entry2.getValue() != null ? URLEncoder.encode((String) entry2.getValue(), Utf8Charset.NAME) : "");
        }
        return sb.toString();
    }

    private String b(String str, Map map) {
        String strA = a(map);
        if (strA.isEmpty()) {
            return str;
        }
        if (!str.contains("?")) {
            return str + "?" + strA;
        }
        if (!str.endsWith("&")) {
            strA = "&" + strA;
        }
        return str + strA;
    }

    private String e(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Utf8Charset.NAME));
        char[] cArr = new char[Utility.DEFAULT_STREAM_BUFFER_SIZE];
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i3 = bufferedReader.read(cArr);
            if (i3 == -1) {
                return sb.toString();
            }
            sb.append(cArr, 0, i3);
        }
    }

    public HttpResponse c() throws Throwable {
        HttpsURLConnection httpsURLConnection;
        CrashlyticsWorkers.d();
        InputStream inputStream = null;
        String strE = null;
        inputStream = null;
        try {
            String strB = b(this.f89000a, this.f89001b);
            Logger.f().i("GET Request URL: " + strB);
            httpsURLConnection = (HttpsURLConnection) new URL(strB).openConnection();
            try {
                httpsURLConnection.setReadTimeout(ColorExtractionConstants.MAX_PIXEL_SAMPLES);
                httpsURLConnection.setConnectTimeout(ColorExtractionConstants.MAX_PIXEL_SAMPLES);
                httpsURLConnection.setRequestMethod("GET");
                for (Map.Entry entry : this.f89002c.entrySet()) {
                    httpsURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                httpsURLConnection.connect();
                int responseCode = httpsURLConnection.getResponseCode();
                InputStream inputStream2 = httpsURLConnection.getInputStream();
                if (inputStream2 != null) {
                    try {
                        strE = e(inputStream2);
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        throw th;
                    }
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                httpsURLConnection.disconnect();
                return new HttpResponse(responseCode, strE);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            httpsURLConnection = null;
        }
    }

    public HttpGetRequest d(String str, String str2) {
        this.f89002c.put(str, str2);
        return this;
    }
}
