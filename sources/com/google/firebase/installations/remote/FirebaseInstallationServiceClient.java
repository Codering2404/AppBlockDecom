package com.google.firebase.installations.remote;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.TrafficStats;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.heartbeatinfo.HeartBeatController;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.TokenResult;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class FirebaseInstallationServiceClient {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Pattern f89312d = Pattern.compile("[0-9]+s");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Charset f89313e = Charset.forName(Utf8Charset.NAME);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f89314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Provider f89315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RequestLimiter f89316c = new RequestLimiter();

    public FirebaseInstallationServiceClient(Context context, Provider provider) {
        this.f89314a = context;
        this.f89315b = provider;
    }

    private static String a(String str, String str2, String str3) {
        String str4;
        if (TextUtils.isEmpty(str)) {
            str4 = "";
        } else {
            str4 = ", " + str;
        }
        return String.format("Firebase options used while communicating with Firebase server APIs: %s, %s%s", str2, str3, str4);
    }

    private static JSONObject b(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("fid", str);
            jSONObject.put("appId", str2);
            jSONObject.put("authVersion", "FIS_v2");
            jSONObject.put("sdkVersion", "a:19.0.1");
            return jSONObject;
        } catch (JSONException e3) {
            throw new IllegalStateException(e3);
        }
    }

    private static JSONObject c() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sdkVersion", "a:19.0.1");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("installation", jSONObject);
            return jSONObject2;
        } catch (JSONException e3) {
            throw new IllegalStateException(e3);
        }
    }

    private String f() {
        try {
            Context context = this.f89314a;
            byte[] bArrA = AndroidUtilsLight.a(context, context.getPackageName());
            if (bArrA != null) {
                return Hex.c(bArrA, false);
            }
            Log.e("ContentValues", "Could not get fingerprint hash for package: " + this.f89314a.getPackageName());
            return null;
        } catch (PackageManager.NameNotFoundException e3) {
            Log.e("ContentValues", "No such package: " + this.f89314a.getPackageName(), e3);
            return null;
        }
    }

    private URL g(String str) throws FirebaseInstallationsException {
        try {
            return new URL(String.format("https://%s/%s/%s", "firebaseinstallations.googleapis.com", "v1", str));
        } catch (MalformedURLException e3) {
            throw new FirebaseInstallationsException(e3.getMessage(), FirebaseInstallationsException.Status.UNAVAILABLE);
        }
    }

    private static byte[] h(JSONObject jSONObject) {
        return jSONObject.toString().getBytes(Utf8Charset.NAME);
    }

    private static boolean i(int i3) {
        return i3 >= 200 && i3 < 300;
    }

    private static void j() {
        Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
    }

    private static void k(HttpURLConnection httpURLConnection, String str, String str2, String str3) {
        String strO = o(httpURLConnection);
        if (TextUtils.isEmpty(strO)) {
            return;
        }
        Log.w("Firebase-Installations", strO);
        Log.w("Firebase-Installations", a(str, str2, str3));
    }

    private HttpURLConnection l(URL url, String str) throws FirebaseInstallationsException {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(ColorExtractionConstants.MAX_PIXEL_SAMPLES);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setReadTimeout(ColorExtractionConstants.MAX_PIXEL_SAMPLES);
            httpURLConnection.addRequestProperty("Content-Type", "application/json");
            httpURLConnection.addRequestProperty("Accept", "application/json");
            httpURLConnection.addRequestProperty(GraphRequest.CONTENT_ENCODING_HEADER, "gzip");
            httpURLConnection.addRequestProperty("Cache-Control", "no-cache");
            httpURLConnection.addRequestProperty("X-Android-Package", this.f89314a.getPackageName());
            HeartBeatController heartBeatController = (HeartBeatController) this.f89315b.get();
            if (heartBeatController != null) {
                try {
                    httpURLConnection.addRequestProperty("x-firebase-client", (String) Tasks.await(heartBeatController.a()));
                } catch (InterruptedException e3) {
                    Thread.currentThread().interrupt();
                    Log.w("ContentValues", "Failed to get heartbeats header", e3);
                } catch (ExecutionException e4) {
                    Log.w("ContentValues", "Failed to get heartbeats header", e4);
                }
            }
            httpURLConnection.addRequestProperty("X-Android-Cert", f());
            httpURLConnection.addRequestProperty("x-goog-api-key", str);
            return httpURLConnection;
        } catch (IOException unused) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
        }
    }

    static long m(String str) {
        Preconditions.b(f89312d.matcher(str).matches(), "Invalid Expiration Timestamp.");
        if (str == null || str.length() == 0) {
            return 0L;
        }
        return Long.parseLong(str.substring(0, str.length() - 1));
    }

    private InstallationResponse n(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, f89313e));
        TokenResult.Builder builderA = TokenResult.a();
        InstallationResponse.Builder builderA2 = InstallationResponse.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if (strNextName.equals("name")) {
                builderA2.f(jsonReader.nextString());
            } else if (strNextName.equals("fid")) {
                builderA2.c(jsonReader.nextString());
            } else if (strNextName.equals("refreshToken")) {
                builderA2.d(jsonReader.nextString());
            } else if (strNextName.equals("authToken")) {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName2 = jsonReader.nextName();
                    if (strNextName2.equals(AccessToken.TOKEN_KEY)) {
                        builderA.c(jsonReader.nextString());
                    } else if (strNextName2.equals("expiresIn")) {
                        builderA.d(m(jsonReader.nextString()));
                    } else {
                        jsonReader.skipValue();
                    }
                }
                builderA2.b(builderA.a());
                jsonReader.endObject();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        return builderA2.e(InstallationResponse.ResponseCode.OK).a();
    }

    private static String o(HttpURLConnection httpURLConnection) {
        StringBuilder sb;
        InputStream errorStream = httpURLConnection.getErrorStream();
        if (errorStream == null) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream, f89313e));
        try {
            try {
                sb = new StringBuilder();
            } catch (IOException unused) {
            }
        } catch (IOException unused2) {
            bufferedReader.close();
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (IOException unused3) {
            }
            throw th;
        }
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            sb.append(line);
            sb.append('\n');
            return null;
        }
        String str = String.format("Error when communicating with the Firebase Installations server API. HTTP response: [%d %s: %s]", Integer.valueOf(httpURLConnection.getResponseCode()), httpURLConnection.getResponseMessage(), sb);
        try {
            bufferedReader.close();
        } catch (IOException unused4) {
        }
        return str;
    }

    private TokenResult p(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, f89313e));
        TokenResult.Builder builderA = TokenResult.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if (strNextName.equals(AccessToken.TOKEN_KEY)) {
                builderA.c(jsonReader.nextString());
            } else if (strNextName.equals("expiresIn")) {
                builderA.d(m(jsonReader.nextString()));
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        return builderA.b(TokenResult.ResponseCode.OK).a();
    }

    private void q(HttpURLConnection httpURLConnection, String str, String str2) throws IOException {
        s(httpURLConnection, h(b(str, str2)));
    }

    private void r(HttpURLConnection httpURLConnection) throws IOException {
        s(httpURLConnection, h(c()));
    }

    private static void s(URLConnection uRLConnection, byte[] bArr) throws IOException {
        OutputStream outputStream = uRLConnection.getOutputStream();
        if (outputStream == null) {
            throw new IOException("Cannot send request to FIS servers. No OutputStream available.");
        }
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        try {
            gZIPOutputStream.write(bArr);
        } finally {
            try {
                gZIPOutputStream.close();
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public InstallationResponse d(String str, String str2, String str3, String str4, String str5) {
        int responseCode;
        InstallationResponse installationResponseN;
        if (!this.f89316c.b()) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
        }
        URL urlG = g(String.format("projects/%s/installations", str3));
        for (int i3 = 0; i3 <= 1; i3++) {
            TrafficStats.setThreadStatsTag(32769);
            HttpURLConnection httpURLConnectionL = l(urlG, str);
            try {
                try {
                    httpURLConnectionL.setRequestMethod("POST");
                    httpURLConnectionL.setDoOutput(true);
                    if (str5 != null) {
                        httpURLConnectionL.addRequestProperty("x-goog-fis-android-iid-migration-auth", str5);
                    }
                    q(httpURLConnectionL, str2, str4);
                    responseCode = httpURLConnectionL.getResponseCode();
                    this.f89316c.f(responseCode);
                } catch (IOException | AssertionError unused) {
                }
                if (i(responseCode)) {
                    installationResponseN = n(httpURLConnectionL);
                } else {
                    k(httpURLConnectionL, str4, str, str3);
                    if (responseCode == 429) {
                        throw new FirebaseInstallationsException("Firebase servers have received too many requests from this client in a short period of time. Please try again later.", FirebaseInstallationsException.Status.TOO_MANY_REQUESTS);
                    }
                    if (responseCode < 500 || responseCode >= 600) {
                        j();
                        installationResponseN = InstallationResponse.a().e(InstallationResponse.ResponseCode.BAD_CONFIG).a();
                    }
                    httpURLConnectionL.disconnect();
                    TrafficStats.clearThreadStatsTag();
                }
                httpURLConnectionL.disconnect();
                TrafficStats.clearThreadStatsTag();
                return installationResponseN;
            } catch (Throwable th) {
                httpURLConnectionL.disconnect();
                TrafficStats.clearThreadStatsTag();
                throw th;
            }
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
    }

    public TokenResult e(String str, String str2, String str3, String str4) {
        int responseCode;
        TokenResult tokenResultP;
        if (!this.f89316c.b()) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
        }
        URL urlG = g(String.format("projects/%s/installations/%s/authTokens:generate", str3, str2));
        for (int i3 = 0; i3 <= 1; i3++) {
            TrafficStats.setThreadStatsTag(32771);
            HttpURLConnection httpURLConnectionL = l(urlG, str);
            try {
                try {
                    httpURLConnectionL.setRequestMethod("POST");
                    httpURLConnectionL.addRequestProperty("Authorization", "FIS_v2 " + str4);
                    httpURLConnectionL.setDoOutput(true);
                    r(httpURLConnectionL);
                    responseCode = httpURLConnectionL.getResponseCode();
                    this.f89316c.f(responseCode);
                } finally {
                    httpURLConnectionL.disconnect();
                    TrafficStats.clearThreadStatsTag();
                }
            } catch (IOException | AssertionError unused) {
            }
            if (i(responseCode)) {
                tokenResultP = p(httpURLConnectionL);
            } else {
                k(httpURLConnectionL, null, str, str3);
                if (responseCode == 401 || responseCode == 404) {
                    tokenResultP = TokenResult.a().b(TokenResult.ResponseCode.AUTH_ERROR).a();
                } else {
                    if (responseCode == 429) {
                        throw new FirebaseInstallationsException("Firebase servers have received too many requests from this client in a short period of time. Please try again later.", FirebaseInstallationsException.Status.TOO_MANY_REQUESTS);
                    }
                    if (responseCode < 500 || responseCode >= 600) {
                        j();
                        tokenResultP = TokenResult.a().b(TokenResult.ResponseCode.BAD_CONFIG).a();
                    }
                }
            }
            return tokenResultP;
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
    }
}
