package com.facebook.ads.internal.dynamicloading;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DexLoadErrorReporter {
    private static final String LOGGING_URL = "https://www.facebook.com/adnw_logging/";
    public static final double SAMPLING = 0.1d;
    private static final AtomicBoolean sAlreadyReported = new AtomicBoolean();

    /* JADX INFO: Access modifiers changed from: private */
    public static void addEnvFields(Context context, JSONObject jSONObject, String str) throws JSONException, PackageManager.NameNotFoundException {
        String packageName = context.getPackageName();
        jSONObject.put("APPBUILD", context.getPackageManager().getPackageInfo(packageName, 0).versionCode);
        jSONObject.put("APPNAME", context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(packageName, 0)));
        jSONObject.put("APPVERS", context.getPackageManager().getPackageInfo(packageName, 0).versionName);
        jSONObject.put("OSVERS", Build.VERSION.RELEASE);
        jSONObject.put("SDK", "android");
        jSONObject.put("SESSION_ID", str);
        jSONObject.put("MODEL", Build.MODEL);
        jSONObject.put("BUNDLE", packageName);
        jSONObject.put("SDK_VERSION", BuildConfigApi.getVersionName(context));
        jSONObject.put("OS", "Android");
    }

    public static void reportDexLoadingIssue(final Context context, final String str, double d3) {
        AtomicBoolean atomicBoolean = sAlreadyReported;
        if (atomicBoolean.get() || Math.random() >= d3) {
            return;
        }
        atomicBoolean.set(true);
        new Thread() { // from class: com.facebook.ads.internal.dynamicloading.DexLoadErrorReporter.1
            /* JADX WARN: Can't wrap try/catch for region: R(12:0|2|(9:83|3|77|4|5|75|6|65|7)|(5:69|8|(1:10)(1:85)|22|45)|13|81|14|67|18|22|45|(1:(0))) */
            /* JADX WARN: Code restructure failed: missing block: B:16:0x0142, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:17:0x0143, code lost:
            
                android.util.Log.e(com.facebook.ads.AudienceNetworkAds.TAG, "Can't close connection.", r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:20:0x014a, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:21:0x014b, code lost:
            
                android.util.Log.e(com.facebook.ads.AudienceNetworkAds.TAG, "Can't close connection.", r0);
             */
            /* JADX WARN: Removed duplicated region for block: B:61:0x016b A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:73:0x0175 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Thread, java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instruction units count: 413
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.dynamicloading.DexLoadErrorReporter.AnonymousClass1.run():void");
            }
        }.start();
    }
}
