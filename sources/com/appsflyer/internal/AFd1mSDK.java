package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFd1mSDK extends AFd1lSDK<String> {
    private final String AFLogger;
    private final AFg1ySDK AFLogger$LogLevel;

    public AFd1mSDK(AFc1ySDK aFc1ySDK, String str, AFg1ySDK aFg1ySDK) {
        super(AFd1tSDK.IMPRESSIONS, new AFd1tSDK[]{AFd1tSDK.RC_CDN}, aFc1ySDK, str);
        this.AFLogger = str;
        this.AFLogger$LogLevel = aFg1ySDK;
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    protected final AFc1qSDK<String> AFInAppEventType(String str) {
        return ((AFd1lSDK) this).afErrorLog.AFKeystoreWrapper(this.AFLogger);
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    protected final AppsFlyerRequestListener AFLogger() {
        return null;
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    protected final boolean afRDLog() {
        return false;
    }

    @Override // com.appsflyer.internal.AFd1lSDK, com.appsflyer.internal.AFd1uSDK
    public final boolean valueOf() {
        return false;
    }

    @Override // com.appsflyer.internal.AFd1lSDK, com.appsflyer.internal.AFd1uSDK
    public final void values() {
        super.values();
        AFc1dSDK<Result> aFc1dSDK = ((AFd1lSDK) this).afDebugLog;
        if (aFc1dSDK != 0) {
            int statusCode = aFc1dSDK.getStatusCode();
            if (statusCode == 200) {
                StringBuilder sb = new StringBuilder("Cross promotion impressions success: ");
                sb.append(this.AFLogger);
                AFLogger.afInfoLog(sb.toString(), false);
                return;
            }
            if (statusCode != 301 && statusCode != 302) {
                StringBuilder sb2 = new StringBuilder("call to ");
                sb2.append(this.AFLogger);
                sb2.append(" failed: ");
                sb2.append(statusCode);
                AFLogger.afInfoLog(sb2.toString());
                return;
            }
            StringBuilder sb3 = new StringBuilder("Cross promotion redirection success: ");
            sb3.append(this.AFLogger);
            AFLogger.afInfoLog(sb3.toString(), false);
            String strAFKeystoreWrapper = aFc1dSDK.AFKeystoreWrapper("Location");
            AFg1ySDK aFg1ySDK = this.AFLogger$LogLevel;
            if (aFg1ySDK == null || strAFKeystoreWrapper == null) {
                return;
            }
            aFg1ySDK.values = strAFKeystoreWrapper;
            Context context = aFg1ySDK.AFInAppEventType.get();
            if (context != null) {
                try {
                    if (aFg1ySDK.values != null) {
                        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(aFg1ySDK.values)).setFlags(268435456));
                    }
                } catch (Exception e3) {
                    AFLogger.afErrorLog("Failed to open cross promotion url, does OS have browser installed?".concat(String.valueOf(e3)), e3);
                }
            }
        }
    }
}
