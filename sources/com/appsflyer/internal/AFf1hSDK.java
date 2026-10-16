package com.appsflyer.internal;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import com.appsflyer.AFLogger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFf1hSDK extends AFf1jSDK {
    private final AFc1ySDK AFInAppEventType;
    final ProviderInfo AFKeystoreWrapper;

    public AFf1hSDK(ProviderInfo providerInfo, Runnable runnable, AFc1ySDK aFc1ySDK) {
        super("af_referrer", providerInfo.authority, runnable);
        this.AFInAppEventType = aFc1ySDK;
        this.AFKeystoreWrapper = providerInfo;
    }

    public static ContentProviderClient AFKeystoreWrapper(Context context, Uri uri) {
        try {
            return context.getContentResolver().acquireUnstableContentProviderClient(uri);
        } catch (SecurityException e3) {
            AFLogger.afErrorLog("[Preinstall]: Failed to acquire unstable content providerClient due to SecurityException", e3, false);
            return null;
        } catch (Throwable th) {
            AFLogger.afErrorLog("[Preinstall]: Failed to acquire unstable content providerClient due to unexpected throwable", th, false);
            return null;
        }
    }

    @Override // com.appsflyer.internal.AFf1jSDK
    public final void valueOf(final Context context) {
        this.AFInAppEventType.AFInAppEventType().execute(new Runnable() { // from class: com.appsflyer.internal.AFf1hSDK.4
            /* JADX WARN: Removed duplicated region for block: B:25:0x007f  */
            /* JADX WARN: Removed duplicated region for block: B:36:0x00c2  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void run() {
                /*
                    Method dump skipped, instruction units count: 256
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFf1hSDK.AnonymousClass4.run():void");
            }
        });
    }
}
