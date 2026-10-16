package com.singular.sdk.internal;

import android.content.Context;
import android.os.HandlerThread;
import android.util.Log;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.stetho.server.http.HttpHeaders;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class SingularExceptionReporter extends HandlerThread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f92673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DeviceInfo f92674b;

    /* JADX INFO: renamed from: com.singular.sdk.internal.SingularExceptionReporter$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Boolean f92675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SingularExceptionReporter f92676b;

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f92676b.f92674b = new DeviceInfo(this.f92676b.f92673a, false, this.f92675a, false);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: renamed from: com.singular.sdk.internal.SingularExceptionReporter$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Throwable f92677a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SingularExceptionReporter f92678b;

        @Override // java.lang.Runnable
        public void run() {
            try {
                JSONObject jSONObject = new JSONObject();
                Throwable th = this.f92677a;
                if (th != null) {
                    jSONObject.put("name", th.getClass().getSimpleName());
                    jSONObject.put("message", this.f92677a.getMessage());
                    jSONObject.put("stack_trace", Log.getStackTraceString(this.f92677a));
                    if (this.f92678b.f92674b != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("aifa", this.f92678b.f92674b.f92540b);
                        jSONObject2.put("appName", this.f92678b.f92674b.f92557s);
                        jSONObject2.put("appVersion", this.f92678b.f92674b.f92551m);
                        jSONObject2.put("deviceModel", this.f92678b.f92674b.f92556r);
                        jSONObject2.put("deviceBrand", this.f92678b.f92674b.f92552n);
                        jSONObject2.put("deviceManufacturer", this.f92678b.f92674b.f92555q);
                        jSONObject2.put("osVersion", this.f92678b.f92674b.f92561w);
                        jSONObject2.put("sdkVersion", this.f92678b.f92674b.f92560v);
                        jSONObject2.put("isGooglePlayServicesAvailable", this.f92678b.f92674b.f92545g);
                        jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_PARAM, jSONObject2);
                    }
                } else {
                    jSONObject.put("error", "Throwable is null!");
                }
                this.f92678b.e(jSONObject);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(JSONObject jSONObject) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://exceptions.singular.net/v2/exceptions/android").openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setConnectTimeout(ColorExtractionConstants.MAX_PIXEL_SAMPLES);
            httpURLConnection.setReadTimeout(ColorExtractionConstants.MAX_PIXEL_SAMPLES);
            httpURLConnection.setDoOutput(true);
            byte[] bytes = jSONObject.toString().getBytes();
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_LENGTH, Integer.toString(bytes.length));
            httpURLConnection.getOutputStream().write(bytes);
            httpURLConnection.connect();
            return httpURLConnection.getResponseCode();
        } catch (Throwable unused) {
            return -1;
        }
    }
}
