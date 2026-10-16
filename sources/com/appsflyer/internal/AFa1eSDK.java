package com.appsflyer.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.AFa1hSDK;
import com.appsflyer.internal.AFc1tSDK;
import com.appsflyer.internal.AFd1xSDK.AnonymousClass4;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GoogleApiAvailability;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFa1eSDK implements Runnable {
    static Boolean AFInAppEventParameterName;
    static String values;
    private final Map<String, Object> AFInAppEventType;
    private final AFc1ySDK AFKeystoreWrapper;
    private final AFa1tSDK valueOf;

    public AFa1eSDK() {
    }

    public static AFc1tSDK.AFa1wSDK AFInAppEventParameterName(ContentResolver contentResolver) {
        String string;
        if (!AFInAppEventParameterName() || contentResolver == null || AppsFlyerProperties.getInstance().getString("amazon_aid") != null || !"Amazon".equals(Build.MANUFACTURER)) {
            return null;
        }
        int i3 = Settings.Secure.getInt(contentResolver, "limit_ad_tracking", 2);
        if (i3 == 0) {
            return new AFc1tSDK.AFa1wSDK(Settings.Secure.getString(contentResolver, "advertising_id"), Boolean.FALSE);
        }
        if (i3 == 2) {
            return null;
        }
        try {
            string = Settings.Secure.getString(contentResolver, "advertising_id");
        } catch (Throwable th) {
            AFLogger.afErrorLog("Couldn't fetch Amazon Advertising ID (Ad-Tracking is limited!)", th);
            string = "";
        }
        return new AFc1tSDK.AFa1wSDK(string, Boolean.TRUE);
    }

    public static AFc1tSDK.AFa1wSDK AFInAppEventType(Context context, Map<String, Object> map) {
        int i3;
        boolean z2;
        Throwable th;
        Boolean bool;
        Boolean boolValueOf;
        AdvertisingIdClient.Info advertisingIdInfo;
        String str = null;
        if (!AFInAppEventParameterName()) {
            return null;
        }
        AFLogger.afInfoLog("Trying to fetch GAID..");
        StringBuilder sb = new StringBuilder();
        try {
            i3 = GoogleApiAvailability.q().i(context);
        } catch (Throwable th2) {
            AFLogger.afErrorLogForExcManagerOnly("isGooglePlayServicesAvailable error", th2);
            i3 = -1;
        }
        try {
            advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
        } catch (Throwable th3) {
            z2 = false;
            th = th3;
            bool = null;
        }
        if (advertisingIdInfo == null) {
            sb.append("gpsAdInfo-null |");
            throw new IllegalStateException("GpsAdIndo is null");
        }
        String string = advertisingIdInfo.getId();
        try {
            boolValueOf = Boolean.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled());
            if (string != null) {
                try {
                    if (string.length() == 0) {
                        sb.append("emptyOrNull |");
                    }
                    z2 = true;
                } catch (Throwable th4) {
                    bool = boolValueOf;
                    str = string;
                    th = th4;
                    z2 = true;
                    StringBuilder sb2 = new StringBuilder("Google Play Services is missing ");
                    sb2.append(th.getMessage());
                    AFLogger.afErrorLog(sb2.toString(), th);
                    sb.append(th.getClass().getSimpleName());
                    sb.append(" |");
                    AFLogger.afInfoLog("WARNING: Google Play Services is missing.");
                    if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.ENABLE_GPS_FALLBACK, true)) {
                        try {
                            AFa1hSDK.AFa1xSDK aFa1xSDKAFInAppEventType = AFa1hSDK.AFInAppEventType(context);
                            String str2 = aFa1xSDKAFInAppEventType.values;
                            boolValueOf = Boolean.valueOf(aFa1xSDKAFInAppEventType.AFKeystoreWrapper());
                            if (str2 == null || str2.length() == 0) {
                                sb.append("emptyOrNull (bypass) |");
                            }
                            string = str2;
                        } catch (Throwable th5) {
                            AFLogger.afErrorLog(th5.getMessage(), th5, true, false, false);
                            sb.append(th5.getClass().getSimpleName());
                            sb.append(" |");
                            string = AppsFlyerProperties.getInstance().getString("advertiserId");
                            Boolean boolValueOf2 = Boolean.valueOf(!Boolean.parseBoolean(AppsFlyerProperties.getInstance().getString("advertiserIdEnabled")));
                            if (th5.getLocalizedMessage() != null) {
                                AFLogger.afInfoLog(th5.getLocalizedMessage());
                            } else {
                                AFLogger.afInfoLog(th5.toString());
                            }
                            boolValueOf = boolValueOf2;
                        }
                    } else {
                        string = str;
                        boolValueOf = bool;
                    }
                }
            } else {
                sb.append("emptyOrNull |");
                z2 = true;
            }
        } catch (Throwable th6) {
            bool = null;
            str = string;
            th = th6;
            z2 = false;
        }
        if (context.getClass().getName().equals("android.app.ReceiverRestrictedContext")) {
            string = AppsFlyerProperties.getInstance().getString("advertiserId");
            boolValueOf = Boolean.valueOf(!Boolean.parseBoolean(AppsFlyerProperties.getInstance().getString("advertiserIdEnabled")));
            sb.append("context = android.app.ReceiverRestrictedContext |");
        }
        if (sb.length() > 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(i3);
            sb3.append(": ");
            sb3.append((Object) sb);
            map.put("gaidError", sb3.toString());
        }
        if (string != null && boolValueOf != null) {
            map.put("advertiserId", string);
            map.put("advertiserIdEnabled", String.valueOf(!boolValueOf.booleanValue()));
            AppsFlyerProperties.getInstance().set("advertiserId", string);
            AppsFlyerProperties.getInstance().set("advertiserIdEnabled", String.valueOf(!boolValueOf.booleanValue()));
            map.put("isGaidWithGps", String.valueOf(z2));
        }
        return new AFc1tSDK.AFa1wSDK(string, boolValueOf);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.appsflyer.internal.AFc1tSDK.AFa1wSDK valueOf(android.content.Context r5) {
        /*
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r1 = com.appsflyer.internal.AFa1eSDK.values
            r2 = 1
            if (r1 == 0) goto Lb
            r3 = r2
            goto Lc
        Lb:
            r3 = 0
        Lc:
            r4 = 0
            if (r3 == 0) goto L11
        Lf:
            r5 = r4
            goto L4e
        L11:
            java.lang.Boolean r1 = com.appsflyer.internal.AFa1eSDK.AFInAppEventParameterName
            if (r1 == 0) goto L1b
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L27
        L1b:
            java.lang.Boolean r1 = com.appsflyer.internal.AFa1eSDK.AFInAppEventParameterName
            if (r1 != 0) goto L4c
            java.lang.String r1 = "collectOAID"
            boolean r1 = r0.getBoolean(r1, r2)
            if (r1 == 0) goto L4c
        L27:
            com.appsflyer.oaid.OaidClient r1 = new com.appsflyer.oaid.OaidClient     // Catch: java.lang.Throwable -> L45
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L45
            boolean r5 = r0.isEnableLog()     // Catch: java.lang.Throwable -> L45
            r1.setLogging(r5)     // Catch: java.lang.Throwable -> L45
            com.appsflyer.oaid.OaidClient$Info r5 = r1.fetch()     // Catch: java.lang.Throwable -> L45
            if (r5 == 0) goto L4c
            java.lang.String r0 = r5.getId()     // Catch: java.lang.Throwable -> L45
            java.lang.Boolean r5 = r5.getLat()     // Catch: java.lang.Throwable -> L43
            r1 = r0
            goto L4e
        L43:
            r1 = r0
            goto L46
        L45:
            r1 = r4
        L46:
            java.lang.String r5 = "No OAID library"
            com.appsflyer.AFLogger.afDebugLog(r5)
            goto Lf
        L4c:
            r5 = r4
            r1 = r5
        L4e:
            if (r1 == 0) goto L5c
            com.appsflyer.internal.AFc1tSDK$AFa1wSDK r0 = new com.appsflyer.internal.AFc1tSDK$AFa1wSDK
            r0.<init>(r1, r5)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)
            r0.AFKeystoreWrapper = r5
            return r0
        L5c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1eSDK.valueOf(android.content.Context):com.appsflyer.internal.AFc1tSDK$AFa1wSDK");
    }

    @Override // java.lang.Runnable
    public final void run() {
        AFd1uSDK aFd1fSDK;
        if (this.valueOf.AFInAppEventParameterName()) {
            AFd1hSDK aFd1hSDK = new AFd1hSDK(this.valueOf, this.AFKeystoreWrapper);
            aFd1hSDK.afWarnLog = this.AFInAppEventType;
            aFd1fSDK = aFd1hSDK;
        } else {
            aFd1fSDK = new AFd1fSDK(this.valueOf, this.AFKeystoreWrapper);
        }
        AFd1xSDK aFd1xSDKAFLogger$LogLevel = this.AFKeystoreWrapper.AFLogger$LogLevel();
        aFd1xSDKAFLogger$LogLevel.valueOf.execute(aFd1xSDKAFLogger$LogLevel.new AnonymousClass4(aFd1fSDK));
    }

    public AFa1eSDK(AFc1ySDK aFc1ySDK, AFa1tSDK aFa1tSDK, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(aFc1ySDK, "");
        Intrinsics.checkNotNullParameter(aFa1tSDK, "");
        this.AFKeystoreWrapper = aFc1ySDK;
        this.valueOf = aFa1tSDK;
        this.AFInAppEventType = map;
    }

    private static boolean AFInAppEventParameterName() {
        Boolean bool = AFInAppEventParameterName;
        return bool == null || bool.booleanValue();
    }
}
