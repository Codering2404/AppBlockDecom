package com.appsflyer.internal;

import android.graphics.Color;
import android.net.TrafficStats;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import com.appsflyer.AFLogger;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class AFa1sSDK {
    private final AFe1bSDK valueOf;
    private final AFb1ySDK values;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface AFa1zSDK {
        void AFInAppEventType(String str);

        void values(String str, String str2, String str3);
    }

    AFa1sSDK() {
    }

    public final HttpURLConnection values(String str) {
        String strValueOf;
        HttpURLConnection httpURLConnection;
        boolean z2;
        int responseCode;
        AFe1bSDK aFe1bSDK = this.valueOf;
        String str2 = aFe1bSDK.AFLogger;
        String string = AFa1uSDK.valueOf((Map<String, ?>) aFe1bSDK.AFKeystoreWrapper()).toString();
        boolean zAfErrorLogForExcManagerOnly = this.valueOf.afErrorLogForExcManagerOnly();
        boolean level = this.valueOf.getLevel();
        boolean zAFVersionDeclaration = this.valueOf.AFVersionDeclaration();
        boolean zAFInAppEventType = this.valueOf.AFInAppEventType();
        strValueOf = "";
        byte[] bytes = string.getBytes(Charset.defaultCharset());
        HttpURLConnection httpURLConnection2 = null;
        if (zAfErrorLogForExcManagerOnly) {
            return null;
        }
        try {
            URL url = new URL(str2);
            if (zAFVersionDeclaration) {
                this.values.values(url.toString(), string);
                int length = string.getBytes(Charset.defaultCharset()).length;
                StringBuilder sb = new StringBuilder("call = ");
                sb.append(url);
                sb.append("; size = ");
                sb.append(length);
                sb.append(" byte");
                sb.append(length > 1 ? "s" : "");
                sb.append("; body = ");
                sb.append(string);
                AFc1sSDK.values(sb.toString());
            }
            TrafficStats.setThreadStatsTag(82339054);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            try {
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestProperty("Content-Type", zAFInAppEventType ? "application/octet-stream" : "application/json");
                OutputStream outputStream = httpURLConnection.getOutputStream();
                try {
                    if (zAFInAppEventType) {
                        try {
                            try {
                                bytes = (byte[]) ((Class) com.appsflyer.internal.AFa1zSDK.AFKeystoreWrapper((char) (48033 - View.resolveSize(0, 0)), 37 - Color.argb(0, 0, 0, 0), (ViewConfiguration.getScrollBarSize() >> 8) + 37)).getDeclaredMethod("AFInAppEventType", byte[].class).invoke(((Class) com.appsflyer.internal.AFa1zSDK.AFKeystoreWrapper((char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 48033), 37 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), View.MeasureSpec.makeMeasureSpec(0, 0) + 37)).getMethod("values", String.class).invoke(null, str), bytes);
                            } catch (Throwable th) {
                                Throwable cause = th.getCause();
                                if (cause != null) {
                                    throw cause;
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            Throwable cause2 = th2.getCause();
                            if (cause2 != null) {
                                throw cause2;
                            }
                            throw th2;
                        }
                    }
                    outputStream.write(bytes);
                } catch (Exception e3) {
                    AFLogger.afErrorLogForExcManagerOnly("AFCrypto: reflection init failed", e3);
                }
                outputStream.close();
                httpURLConnection.connect();
                responseCode = httpURLConnection.getResponseCode();
                strValueOf = level ? AFa1bSDK.valueOf(httpURLConnection) : "";
                if (zAFVersionDeclaration) {
                    this.values.values(url.toString(), responseCode, strValueOf);
                }
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection2 = httpURLConnection;
                AFLogger.afErrorLog("Error while calling ".concat(String.valueOf(str2)), th);
                httpURLConnection = httpURLConnection2;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        if (responseCode == 200) {
            AFLogger.afInfoLog("Status 200 ok");
            z2 = false;
        } else {
            z2 = true;
        }
        StringBuilder sb2 = new StringBuilder("Connection ");
        sb2.append(z2 ? "error" : "call succeeded");
        sb2.append(": ");
        sb2.append(strValueOf);
        AFLogger.afInfoLog(sb2.toString());
        return httpURLConnection;
    }

    public AFa1sSDK(AFe1bSDK aFe1bSDK, AFb1ySDK aFb1ySDK) {
        this.valueOf = aFe1bSDK;
        this.values = aFb1ySDK;
    }
}
