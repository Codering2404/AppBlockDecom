package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.view.ViewConfiguration;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.AFc1tSDK;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.superwall.sdk.identity.Keys;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFd1bSDK extends AFd1fSDK {
    private static char AppsFlyer2dXConversionCallback = 18211;
    private static int init = 0;
    private static char onAppOpenAttributionNative = 47859;
    private static char onInstallConversionDataLoadedNative = 60750;
    private static char onInstallConversionFailureNative = 19615;
    private static int onResponseNative = 1;
    private final AFb1gSDK AFLogger$LogLevel;
    private final AFc1zSDK afErrorLogForExcManagerOnly;
    private final String afWarnLog;
    private final AFe1rSDK getLevel;

    public AFd1bSDK(String str, AFc1ySDK aFc1ySDK) {
        super(new AFe1qSDK(aFc1ySDK.afWarnLog().values), aFc1ySDK, str);
        this.AFLogger$LogLevel = aFc1ySDK.AFInAppEventParameterName();
        this.afErrorLogForExcManagerOnly = aFc1ySDK.afWarnLog();
        this.afWarnLog = str;
        this.getLevel = aFc1ySDK.AFLogger();
    }

    private void AFLogger$LogLevel() {
        int i3 = onResponseNative + 45;
        init = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        int i4 = i3 % 2;
        ((AFd1fSDK) this).AFVersionDeclaration.valueOf("sentRegisterRequestToAF", true);
        AFLogger.afDebugLog("[register] Successfully registered for Uninstall Tracking");
        int i5 = onResponseNative + 51;
        init = i5 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i5 % 2 != 0) {
            int i6 = 51 / 0;
        }
    }

    @Override // com.appsflyer.internal.AFd1fSDK
    protected final void AFInAppEventParameterName(AFa1tSDK aFa1tSDK) throws JSONException {
        init = (onResponseNative + 103) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        super.AFInAppEventParameterName(aFa1tSDK);
        Context context = this.afErrorLogForExcManagerOnly.values;
        AFa1bSDK aFa1bSDKValues = AFa1bSDK.values();
        if (context == null) {
            throw new IllegalStateException("Context is not provided, can't send register request");
        }
        if (aFa1bSDKValues.AFKeystoreWrapper()) {
            AFLogger.afInfoLog("CustomerUserId not set, Tracking is disabled", true);
            throw new IllegalStateException("CustomerUserId not set, register is not sent");
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            aFa1tSDK.AFInAppEventType("app_version_code", Integer.toString(packageInfo.versionCode));
            aFa1tSDK.AFInAppEventType("app_version_name", packageInfo.versionName);
            aFa1tSDK.AFInAppEventType(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, packageManager.getApplicationLabel(packageInfo.applicationInfo).toString());
            aFa1tSDK.AFInAppEventType("installDate", AFa1bSDK.valueOf(new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US), packageInfo.firstInstallTime));
        } catch (Throwable th) {
            AFLogger.afErrorLog("Exception while collecting application version info.", th);
        }
        this.getLevel.values(aFa1tSDK.AFKeystoreWrapper());
        String strAFInAppEventType = AFa1bSDK.AFInAppEventType();
        if (strAFInAppEventType != null) {
            int i3 = onResponseNative + 13;
            init = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i3 % 2 != 0) {
                aFa1tSDK.AFInAppEventType(Keys.APP_USER_ID, strAFInAppEventType);
                throw null;
            }
            aFa1tSDK.AFInAppEventType(Keys.APP_USER_ID, strAFInAppEventType);
        }
        try {
            aFa1tSDK.AFInAppEventType(DeviceRequestsHelper.DEVICE_INFO_MODEL, Build.MODEL);
            Object[] objArr = new Object[1];
            values("⺭ꆕ没뗓쌵ੀ", (ViewConfiguration.getJumpTapTimeout() >> 16) + 5, objArr);
            aFa1tSDK.AFInAppEventType(((String) objArr[0]).intern(), Build.BRAND);
        } catch (Throwable th2) {
            AFLogger.afErrorLog("Exception while collecting device brand and model.", th2);
        }
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
            int i4 = onResponseNative + 19;
            init = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i4 % 2 != 0) {
                aFa1tSDK.AFInAppEventType(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                int i5 = 68 / 0;
            } else {
                aFa1tSDK.AFInAppEventType(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            }
        }
        AFc1tSDK.AFa1wSDK aFa1wSDKAFInAppEventParameterName = AFa1eSDK.AFInAppEventParameterName(context.getContentResolver());
        if (aFa1wSDKAFInAppEventParameterName != null) {
            aFa1tSDK.AFInAppEventType("amazon_aid", aFa1wSDKAFInAppEventParameterName.AFInAppEventParameterName);
            aFa1tSDK.AFInAppEventType("amazon_aid_limit", String.valueOf(aFa1wSDKAFInAppEventParameterName.AFInAppEventType));
        }
        String string = AppsFlyerProperties.getInstance().getString("advertiserId");
        if (string != null) {
            aFa1tSDK.AFInAppEventType("advertiserId", string);
        }
        aFa1tSDK.AFInAppEventType("devkey", ((AFd1lSDK) this).afRDLog.values);
        aFa1tSDK.AFInAppEventType("uid", AFa1aSDK.valueOf(this.afErrorLogForExcManagerOnly, ((AFd1fSDK) this).AFVersionDeclaration));
        aFa1tSDK.AFInAppEventType("af_gcm_token", this.afWarnLog);
        aFa1tSDK.AFInAppEventType("launch_counter", Integer.toString(((AFd1fSDK) this).AFVersionDeclaration.values("appsFlyerCount", 0)));
        aFa1tSDK.AFInAppEventType("sdk", Integer.toString(Build.VERSION.SDK_INT));
        String strAFKeystoreWrapper = this.AFLogger$LogLevel.AFKeystoreWrapper();
        if (strAFKeystoreWrapper != null) {
            aFa1tSDK.AFInAppEventType(AppsFlyerProperties.CHANNEL, strAFKeystoreWrapper);
            init = (onResponseNative + 15) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
    }

    @Override // com.appsflyer.internal.AFd1fSDK, com.appsflyer.internal.AFd1lSDK
    protected final boolean afRDLog() {
        int i3 = onResponseNative + 117;
        int i4 = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        init = i4;
        boolean z2 = i3 % 2 != 0;
        int i5 = i4 + 121;
        onResponseNative = i5 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i5 % 2 != 0) {
            return z2;
        }
        throw null;
    }

    @Override // com.appsflyer.internal.AFd1lSDK, com.appsflyer.internal.AFd1uSDK
    public final void values() {
        ResponseNetwork responseNetwork;
        int i3 = onResponseNative + 51;
        init = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            super.values();
            responseNetwork = ((AFd1lSDK) this).afDebugLog;
            int i4 = 34 / 0;
            if (responseNetwork == null) {
                return;
            }
        } else {
            super.values();
            responseNetwork = ((AFd1lSDK) this).afDebugLog;
            if (responseNetwork == null) {
                return;
            }
        }
        if (responseNetwork.isSuccessful()) {
            int i5 = init + 9;
            onResponseNative = i5 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i5 % 2 != 0) {
                AFLogger$LogLevel();
            } else {
                AFLogger$LogLevel();
                throw null;
            }
        }
    }

    private static void values(String str, int i3, Object[] objArr) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (AFg1lSDK.AFKeystoreWrapper) {
            try {
                char[] cArr2 = new char[cArr.length];
                AFg1lSDK.AFInAppEventParameterName = 0;
                char[] cArr3 = new char[2];
                while (true) {
                    int i4 = AFg1lSDK.AFInAppEventParameterName;
                    if (i4 < cArr.length) {
                        cArr3[0] = cArr[i4];
                        cArr3[1] = cArr[i4 + 1];
                        int i5 = 58224;
                        for (int i6 = 0; i6 < 16; i6++) {
                            char c3 = cArr3[1];
                            char c4 = cArr3[0];
                            char c5 = (char) (c3 - (((c4 + i5) ^ ((c4 << 4) + onInstallConversionFailureNative)) ^ ((c4 >>> 5) + onInstallConversionDataLoadedNative)));
                            cArr3[1] = c5;
                            cArr3[0] = (char) (c4 - (((c5 >>> 5) + AppsFlyer2dXConversionCallback) ^ ((c5 + i5) ^ ((c5 << 4) + onAppOpenAttributionNative))));
                            i5 -= 40503;
                        }
                        int i7 = AFg1lSDK.AFInAppEventParameterName;
                        cArr2[i7] = cArr3[0];
                        cArr2[i7 + 1] = cArr3[1];
                        AFg1lSDK.AFInAppEventParameterName = i7 + 2;
                    } else {
                        str2 = new String(cArr2, 0, i3);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        objArr[0] = str2;
    }
}
