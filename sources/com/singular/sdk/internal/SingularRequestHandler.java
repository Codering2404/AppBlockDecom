package com.singular.sdk.internal;

import com.facebook.AuthenticationToken;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.stetho.common.Utf8Charset;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.singular.sdk.internal.Api;
import cz.mobilesoft.coreblock.view.screen.ohO.MHoiDDglUlPJC;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
class SingularRequestHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SingularLog f92737a = SingularLog.f(SingularRequestHandler.class.getSimpleName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static int f92738b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f92739c = {"e", "global_properties", "referrer_data"};

    private static String a(String str, String str2) {
        if (str == null) {
            f92737a.a("appendHash: queryString is null, returning empty string");
            return "";
        }
        String strP0 = Utils.p0(String.format("?%s", str), str2);
        f92737a.b("hash = %s", strP0);
        if (Utils.U(strP0)) {
            return str;
        }
        return str + "&h=" + strP0;
    }

    static HttpURLConnection b(SingularInstance singularInstance, String str, Map map, long j3) throws ProtocolException {
        Map mapE = e(map);
        String str2 = str + "?" + a(f(singularInstance, map, j3), singularInstance.C().f92417b);
        URL url = new URL(str2);
        HttpURLConnection httpURLConnectionD = url.getProtocol().equalsIgnoreCase("https") ? d(url) : c(url);
        j(httpURLConnectionD);
        k(httpURLConnectionD, mapE, singularInstance.C().f92417b);
        f92737a.b("__API__ %s %s", httpURLConnectionD.getRequestMethod(), str2);
        return httpURLConnectionD;
    }

    public static HttpURLConnection c(URL url) {
        if (url != null) {
            return (HttpURLConnection) url.openConnection();
        }
        f92737a.c("getHttpConnection: URL is null, cannot create HTTP connection");
        return null;
    }

    public static HttpURLConnection d(URL url) {
        if (url != null) {
            return (HttpsURLConnection) url.openConnection();
        }
        f92737a.c("getHttpsConnection: URL is null, cannot create connection");
        return null;
    }

    private static Map e(Map map) {
        HashMap map2 = new HashMap();
        for (String str : f92739c) {
            if (map.containsKey(str)) {
                map2.put(str, map.get(str));
                map.remove(str);
            }
        }
        return map2;
    }

    static boolean g(SingularInstance singularInstance, String str, Map map, long j3, Api.OnApiCallback onApiCallback) throws ProtocolException {
        long jY = Utils.y();
        int i3 = f92738b + 1;
        f92738b = i3;
        SingularLog singularLog = f92737a;
        singularLog.b("---------------------------> /%d", Integer.valueOf(i3));
        singularLog.b("url = %s", str);
        singularLog.b("params = %s", map);
        HttpURLConnection httpURLConnectionB = b(singularInstance, str, map, j3);
        try {
            try {
                boolean zI = i(singularInstance, onApiCallback, jY, i3, httpURLConnectionB);
                if (httpURLConnectionB != null) {
                    httpURLConnectionB.disconnect();
                }
                return zI;
            } catch (IOException e3) {
                throw e3;
            }
        } finally {
        }
    }

    private static String h(HttpURLConnection httpURLConnection) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        InputStream inputStream = httpURLConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader((httpURLConnection.getContentEncoding() == null || !httpURLConnection.getContentEncoding().equals("gzip")) ? new InputStreamReader(inputStream) : new InputStreamReader(new GZIPInputStream(inputStream)));
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return stringBuffer.toString();
            }
            stringBuffer.append(line);
        }
    }

    static boolean i(SingularInstance singularInstance, Api.OnApiCallback onApiCallback, long j3, int i3, HttpURLConnection httpURLConnection) throws IOException {
        httpURLConnection.connect();
        int responseCode = httpURLConnection.getResponseCode();
        String strH = h(httpURLConnection);
        httpURLConnection.disconnect();
        long jY = Utils.y() - j3;
        SingularLog singularLog = f92737a;
        singularLog.b("%d %s", Integer.valueOf(responseCode), strH);
        singularLog.b("<--------------------------- /%d - took %dms", Integer.valueOf(i3), Long.valueOf(jY));
        return onApiCallback.a(singularInstance, responseCode, strH);
    }

    private static void j(HttpURLConnection httpURLConnection) throws ProtocolException {
        httpURLConnection.setConnectTimeout(ColorExtractionConstants.MAX_PIXEL_SAMPLES);
        httpURLConnection.setReadTimeout(ColorExtractionConstants.MAX_PIXEL_SAMPLES);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestProperty(GraphRequest.USER_AGENT_HEADER, Constants.f92524c);
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
    }

    private static void k(HttpURLConnection httpURLConnection, Map map, String str) {
        try {
            if (httpURLConnection == null) {
                f92737a.c("setPayloadForRequest: connection is null, cannot set payload");
                return;
            }
            JSONObject jSONObject = new JSONObject();
            if (map != null && map.size() > 0) {
                String string = new JSONObject(map).toString();
                String strP0 = Utils.p0(string, str);
                jSONObject.put("payload", string);
                jSONObject.put(AuthenticationToken.SIGNATURE_KEY, strP0);
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream(), Utf8Charset.NAME);
            outputStreamWriter.write(jSONObject.toString());
            outputStreamWriter.close();
        } catch (IOException | JSONException e3) {
            f92737a.d("Error in JSON parsing or I/O ", e3);
        }
    }

    private static String f(SingularInstance singularInstance, Map map, long j3) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        if (map == null) {
            map = new HashMap();
        }
        TreeMap treeMap = new TreeMap(map);
        treeMap.put("rt", GraphRequest.FORMAT_JSON);
        treeMap.put("lag", String.valueOf(Utils.e0(j3)));
        treeMap.put("c", NetworkMonitor.c(singularInstance.o()));
        if (NetworkMonitor.f(singularInstance.o())) {
            treeMap.put(MHoiDDglUlPJC.ckNkQDDM, AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
        if ((!treeMap.containsKey("u") || Utils.U((String) treeMap.get("u"))) && !Utils.U(singularInstance.q().f92542d)) {
            treeMap.put("u", singularInstance.q().f92542d);
            treeMap.put("k", "OAID");
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String strEncode = URLEncoder.encode((String) entry.getKey(), Utf8Charset.NAME);
            String str = (String) entry.getValue();
            String strEncode2 = str != null ? URLEncoder.encode(str, Utf8Charset.NAME) : "";
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(strEncode);
            sb.append("=");
            sb.append(strEncode2);
        }
        return sb.toString();
    }
}
