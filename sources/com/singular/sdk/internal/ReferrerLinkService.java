package com.singular.sdk.internal;

import androidx.legacy.content.Werj.QgXempTBEfV;
import com.facebook.GraphRequest;
import com.facebook.stetho.common.Utf8Charset;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.singular.sdk.ShortLinkHandler;
import java.io.BufferedReader;
import java.io.IOException;
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
public class ReferrerLinkService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SingularLog f92638a = SingularLog.f(ReferrerLinkService.class.getSimpleName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f92639b = "https://sdk-api-v1.singular.net/api/v1/shorten_link";

    /* JADX INFO: renamed from: com.singular.sdk.internal.ReferrerLinkService$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f92640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f92641b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ShortLinkHandler f92642c;

        @Override // java.lang.Runnable
        public void run() {
            HttpURLConnection httpURLConnectionC = null;
            try {
                httpURLConnectionC = ReferrerLinkService.c(this.f92640a, this.f92641b);
                httpURLConnectionC.connect();
                int responseCode = httpURLConnectionC.getResponseCode();
                if (responseCode == 200) {
                    StringBuffer stringBuffer = new StringBuffer();
                    InputStream inputStream = httpURLConnectionC.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader((httpURLConnectionC.getContentEncoding() == null || !httpURLConnectionC.getContentEncoding().equals("gzip")) ? new InputStreamReader(inputStream) : new InputStreamReader(new GZIPInputStream(inputStream)));
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        } else {
                            stringBuffer.append(line);
                        }
                    }
                    this.f92642c.onSuccess(new JSONObject(stringBuffer.toString()).getString(QgXempTBEfV.wQwetlCLtcgO));
                } else {
                    this.f92642c.onError("Error sending request: error code - " + responseCode);
                }
            } catch (Throwable th) {
                this.f92642c.onError("Error sending request");
                ReferrerLinkService.f92638a.b("Error in I/O ", th);
            }
            if (httpURLConnectionC != null) {
                httpURLConnectionC.disconnect();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HttpURLConnection c(String str, Map map) throws IOException {
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
        httpsURLConnection.setConnectTimeout(ColorExtractionConstants.MAX_PIXEL_SAMPLES);
        httpsURLConnection.setReadTimeout(ColorExtractionConstants.MAX_PIXEL_SAMPLES);
        httpsURLConnection.setRequestMethod("POST");
        httpsURLConnection.setDoInput(true);
        httpsURLConnection.setUseCaches(false);
        httpsURLConnection.setRequestProperty(GraphRequest.USER_AGENT_HEADER, Constants.f92524c);
        httpsURLConnection.setRequestProperty("Content-Type", "application/json");
        httpsURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        JSONObject jSONObject = new JSONObject(map);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpsURLConnection.getOutputStream(), Utf8Charset.NAME);
        outputStreamWriter.write(jSONObject.toString());
        outputStreamWriter.close();
        return httpsURLConnection;
    }
}
