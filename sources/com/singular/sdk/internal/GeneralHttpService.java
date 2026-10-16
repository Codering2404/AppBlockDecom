package com.singular.sdk.internal;

import android.net.Uri;
import com.facebook.GraphRequest;
import com.facebook.stetho.common.Utf8Charset;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.singular.sdk.internal.GeneralHttpServiceBase;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class GeneralHttpService extends GeneralHttpServiceBase {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SingularLog f92569b;

    /* JADX INFO: renamed from: com.singular.sdk.internal.GeneralHttpService$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f92570a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f92571b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f92572c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ GeneralHttpServiceBase.CompletionHandler f92573d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ GeneralHttpService f92574f;

        @Override // java.lang.Runnable
        public void run() {
            this.f92574f.c(this.f92570a, this.f92571b, this.f92572c, this.f92573d);
        }
    }

    private HttpURLConnection b(String str, Map map) {
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
            httpsURLConnection.setConnectTimeout(ColorExtractionConstants.MAX_PIXEL_SAMPLES);
            httpsURLConnection.setReadTimeout(ColorExtractionConstants.MAX_PIXEL_SAMPLES);
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.setRequestProperty(GraphRequest.USER_AGENT_HEADER, Constants.f92524c);
            httpsURLConnection.setRequestProperty("Content-Type", "application/json");
            httpsURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            try {
                JSONObject jSONObject = map != null ? new JSONObject(map) : new JSONObject();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpsURLConnection.getOutputStream(), Utf8Charset.NAME);
                outputStreamWriter.write(jSONObject.toString());
                outputStreamWriter.close();
                return httpsURLConnection;
            } catch (Throwable th) {
                this.f92569b.d("Error in JSON Serialization ", th);
                this.f92569b.c(Utils.l(th));
                this.f92569b.c("buildRequest: returning null due to error during request construction for URL: " + str);
                return null;
            }
        } catch (Throwable th2) {
            this.f92569b.c(Utils.l(th2));
            this.f92569b.c("buildRequest: returning null due to error during request construction for URL: " + str);
            return null;
        }
    }

    public void c(String str, Map map, Map map2, GeneralHttpServiceBase.CompletionHandler completionHandler) {
        HttpURLConnection httpURLConnectionB;
        String str2 = "?a=" + SingularInstance.u().C().f92416a;
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                str2 = str2 + "&" + Uri.encode((String) entry.getKey()) + "=" + Uri.encode((String) entry.getValue());
            }
        }
        try {
            httpURLConnectionB = b(a() + str + (str2 + "&h=" + Utils.p0(str2, SingularInstance.u().C().f92417b)), map2);
            try {
                if (httpURLConnectionB == null) {
                    completionHandler.w("Error sending request: connection is null");
                    this.f92569b.c("Error sending request: connection is null");
                    if (httpURLConnectionB != null) {
                        return;
                    } else {
                        return;
                    }
                }
                httpURLConnectionB.connect();
                int responseCode = httpURLConnectionB.getResponseCode();
                StringBuffer stringBuffer = new StringBuffer();
                InputStream inputStream = httpURLConnectionB.getInputStream();
                BufferedReader bufferedReader = new BufferedReader((httpURLConnectionB.getContentEncoding() == null || !httpURLConnectionB.getContentEncoding().equals("gzip")) ? new InputStreamReader(inputStream) : new InputStreamReader(new GZIPInputStream(inputStream)));
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        completionHandler.a(stringBuffer.toString(), responseCode);
                        httpURLConnectionB.disconnect();
                        return;
                    }
                    stringBuffer.append(line);
                }
            } catch (Throwable th) {
                th = th;
                try {
                    completionHandler.w("Error sending request: message - " + th.getMessage());
                    this.f92569b.c(Utils.l(th));
                    if (httpURLConnectionB != null) {
                        httpURLConnectionB.disconnect();
                    }
                } finally {
                    if (httpURLConnectionB != null) {
                        httpURLConnectionB.disconnect();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            httpURLConnectionB = null;
        }
    }
}
