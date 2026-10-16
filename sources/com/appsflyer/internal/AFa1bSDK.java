package com.appsflyer.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.applovin.impl.privacy.consentFlow.as.KLAQHFCRAUejH;
import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFInAppEventType;
import com.appsflyer.AFLogger;
import com.appsflyer.AFVersionDeclaration;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerInAppPurchaseValidatorListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.PurchaseHandler;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.deeplink.DeepLinkListener;
import com.appsflyer.deeplink.DeepLinkResult;
import com.appsflyer.internal.AFa1sSDK;
import com.appsflyer.internal.AFb1iSDK;
import com.appsflyer.internal.AFd1gSDK;
import com.appsflyer.internal.AFd1xSDK.AnonymousClass4;
import com.appsflyer.internal.AFf1jSDK;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import com.appsflyer.internal.platform_extension.PluginInfo;
import com.facebook.FacebookSdk;
import com.facebook.LegacyTokenHelper;
import com.facebook.applinks.AppLinkData;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.GoogleApiAvailability;
import com.revenuecat.purchases.common.responses.CustomerInfoResponseJsonKeys;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.HttpURLConnection;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFa1bSDK extends AppsFlyerLib {
    static AppsFlyerInAppPurchaseValidatorListener AFInAppEventParameterName = null;
    public static final String AFInAppEventType;
    private static AFa1bSDK afErrorLog = null;
    private static int onAppOpenAttribution = 1;
    private static int onAttributionFailureNative;
    private static int onConversionDataFail;
    private static char[] onConversionDataSuccess;
    private static boolean onDeepLinking;
    private static boolean onResponseNative;
    static final String valueOf;
    public static final String values;
    private String AFVersionDeclaration;
    private SharedPreferences AppsFlyer2dXConversionCallback;
    public AFa1fSDK afDebugLog;
    private boolean afErrorLogForExcManagerOnly;
    String afRDLog;
    private Map<Long, String> getLevel;
    private Map<String, Object> init;
    private Application onAppOpenAttributionNative;
    private final AFc1xSDK onDeepLinkingNative;
    private String onInstallConversionFailureNative;
    private AFb1hSDK onResponseErrorNative;
    public volatile AppsFlyerConversionListener AFKeystoreWrapper = null;
    private long AFLogger = -1;
    private long afInfoLog = -1;
    private long afWarnLog = TimeUnit.SECONDS.toMillis(5);
    private boolean AFLogger$LogLevel = false;
    private boolean onInstallConversionDataLoadedNative = false;

    /* JADX INFO: renamed from: com.appsflyer.internal.AFa1bSDK$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] AFInAppEventType;

        static {
            int[] iArr = new int[AppsFlyerProperties.EmailsCryptType.values().length];
            AFInAppEventType = iArr;
            try {
                iArr[AppsFlyerProperties.EmailsCryptType.SHA256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                AFInAppEventType[AppsFlyerProperties.EmailsCryptType.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AFa1wSDK implements Runnable {
        private final AFa1tSDK values;

        /* synthetic */ AFa1wSDK(AFa1bSDK aFa1bSDK, AFa1tSDK aFa1tSDK, byte b3) {
            this(aFa1tSDK);
        }

        @Override // java.lang.Runnable
        public final void run() throws UnsupportedEncodingException {
            AFa1bSDK.AFInAppEventType(AFa1bSDK.this, this.values);
        }

        private AFa1wSDK(AFa1tSDK aFa1tSDK) {
            this.values = aFa1tSDK;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AFa1ySDK implements AFd1vSDK {
        private AFa1ySDK() {
        }

        @Override // com.appsflyer.internal.AFd1vSDK
        public final void AFInAppEventType(AFd1uSDK<?> aFd1uSDK) {
            if (aFd1uSDK instanceof AFd1hSDK) {
                AFa1bSDK.this.valueOf().afErrorLog().AFInAppEventParameterName(((AFd1fSDK) aFd1uSDK).AFLogger.afInfoLog);
            }
        }

        @Override // com.appsflyer.internal.AFd1vSDK
        public final void AFKeystoreWrapper(AFd1uSDK<?> aFd1uSDK, AFc1bSDK aFc1bSDK) {
            JSONObject jSONObjectAFKeystoreWrapper;
            AFb1pSDK aFb1pSDKAFInAppEventType;
            if (!(aFd1uSDK instanceof AFd1fSDK)) {
                if (!(aFd1uSDK instanceof AFe1lSDK) || aFc1bSDK == AFc1bSDK.SUCCESS) {
                    return;
                }
                AFe1nSDK aFe1nSDK = new AFe1nSDK(AFa1bSDK.this.valueOf());
                AFd1xSDK aFd1xSDKAFLogger$LogLevel = AFa1bSDK.this.valueOf().AFLogger$LogLevel();
                aFd1xSDKAFLogger$LogLevel.valueOf.execute(aFd1xSDKAFLogger$LogLevel.new AnonymousClass4(aFe1nSDK));
                return;
            }
            AFd1fSDK aFd1fSDK = (AFd1fSDK) aFd1uSDK;
            boolean z2 = aFd1uSDK instanceof AFd1hSDK;
            if (z2 && valueOf()) {
                AFd1hSDK aFd1hSDK = (AFd1hSDK) aFd1uSDK;
                if (aFd1hSDK.AFKeystoreWrapper == AFc1bSDK.SUCCESS || aFd1hSDK.AFInAppEventType == 1) {
                    AFe1lSDK aFe1lSDK = new AFe1lSDK(aFd1hSDK, AFa1bSDK.this.valueOf().AFKeystoreWrapper());
                    AFd1xSDK aFd1xSDKAFLogger$LogLevel2 = AFa1bSDK.this.valueOf().AFLogger$LogLevel();
                    aFd1xSDKAFLogger$LogLevel2.valueOf.execute(aFd1xSDKAFLogger$LogLevel2.new AnonymousClass4(aFe1lSDK));
                }
            }
            if (aFc1bSDK == AFc1bSDK.SUCCESS) {
                AFa1bSDK aFa1bSDK = AFa1bSDK.this;
                aFa1bSDK.AFKeystoreWrapper(AFa1bSDK.AFKeystoreWrapper(aFa1bSDK)).values("sentSuccessfully", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                if (!(aFd1uSDK instanceof AFd1bSDK) && (aFb1pSDKAFInAppEventType = new AFe1sSDK(AFa1bSDK.AFKeystoreWrapper(AFa1bSDK.this)).AFInAppEventType()) != null && aFb1pSDKAFInAppEventType.AFInAppEventParameterName()) {
                    String str = aFb1pSDKAFInAppEventType.AFInAppEventType;
                    AFLogger.afDebugLog("Resending Uninstall token to AF servers: ".concat(String.valueOf(str)));
                    AFe1sSDK.AFKeystoreWrapper(str);
                }
                ResponseNetwork responseNetwork = ((AFd1lSDK) aFd1fSDK).afDebugLog;
                if (responseNetwork != null && (jSONObjectAFKeystoreWrapper = AFb1uSDK.AFKeystoreWrapper((String) responseNetwork.getBody())) != null) {
                    AFa1bSDK.valueOf(AFa1bSDK.this, jSONObjectAFKeystoreWrapper.optBoolean("send_background", false));
                }
                if (z2) {
                    AFa1bSDK.values(AFa1bSDK.this, System.currentTimeMillis());
                }
            }
        }

        @Override // com.appsflyer.internal.AFd1vSDK
        public final void valueOf(AFd1uSDK<?> aFd1uSDK) {
        }

        /* synthetic */ AFa1ySDK(AFa1bSDK aFa1bSDK, byte b3) {
            this();
        }

        private boolean valueOf() {
            return AFa1bSDK.this.AFKeystoreWrapper != null;
        }
    }

    static {
        AFInAppEventParameterName();
        valueOf = "265";
        AFInAppEventType = "6.12";
        StringBuilder sb = new StringBuilder();
        sb.append("6.12");
        sb.append("/androidevent?buildnumber=6.12.3&app_id=");
        values = sb.toString();
        AFInAppEventParameterName = null;
        afErrorLog = new AFa1bSDK();
        int i3 = onAppOpenAttribution + 81;
        onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            throw null;
        }
    }

    public AFa1bSDK() {
        AFVersionDeclaration.init();
        this.onDeepLinkingNative = new AFc1xSDK();
        AFd1xSDK aFd1xSDKAFLogger$LogLevel = valueOf().AFLogger$LogLevel();
        aFd1xSDKAFLogger$LogLevel.AFKeystoreWrapper.add(new AFa1ySDK(this, (byte) 0));
    }

    static void AFInAppEventParameterName() {
        onResponseNative = true;
        onConversionDataSuccess = new char[]{389, 394, 387, 408, 397, 401, 393, 407, 404};
        onDeepLinking = true;
        onAttributionFailureNative = 292;
    }

    static /* synthetic */ void AFInAppEventType(AFa1bSDK aFa1bSDK, AFa1tSDK aFa1tSDK) throws UnsupportedEncodingException {
        int i3 = onAppOpenAttribution + 87;
        onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        int i4 = i3 % 2;
        aFa1bSDK.valueOf(aFa1tSDK);
        if (i4 != 0) {
            throw null;
        }
        onAppOpenAttribution = (onConversionDataFail + 87) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    static /* synthetic */ Application AFKeystoreWrapper(AFa1bSDK aFa1bSDK) {
        int i3 = onConversionDataFail;
        int i4 = i3 + 5;
        onAppOpenAttribution = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        int i5 = i4 % 2;
        Application application = aFa1bSDK.onAppOpenAttributionNative;
        if (i5 == 0) {
            throw null;
        }
        onAppOpenAttribution = (i3 + 105) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        return application;
    }

    private static void AFLogger(Context context) {
        int i3 = onConversionDataFail + 31;
        onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        try {
            if (i3 % 2 == 0) {
                if ((context.getPackageManager().getPackageInfo(context.getPackageName(), 1).applicationInfo.flags & 32768) == 0) {
                    return;
                }
            } else if ((context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.flags & 32768) == 0) {
                return;
            }
            if (context.getResources().getIdentifier("appsflyer_backup_rules", "xml", context.getPackageName()) == 0) {
                AFLogger.AFKeystoreWrapper("'allowBackup' is set to true; appsflyer_backup_rules.xml not detected.\nAppsFlyer shared preferences should be excluded from auto backup by adding: <exclude domain=\"sharedpref\" path=\"appsflyer-data\"/> to the Application's <full-backup-content> rules");
                onConversionDataFail = (onAppOpenAttribution + 39) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                return;
            }
            int i4 = onAppOpenAttribution + 41;
            onConversionDataFail = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i4 % 2 != 0) {
                AFLogger.afInfoLog("appsflyer_backup_rules.xml detected, using AppsFlyer defined backup rules for AppsFlyer SDK data", false);
            } else {
                AFLogger.afInfoLog("appsflyer_backup_rules.xml detected, using AppsFlyer defined backup rules for AppsFlyer SDK data", true);
            }
        } catch (Exception e3) {
            AFLogger.afErrorLogForExcManagerOnly("checkBackupRules Exception", e3);
            AFLogger.afRDLog("checkBackupRules Exception: ".concat(String.valueOf(e3)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void AFLogger$LogLevel() {
        try {
            AFe1iSDK aFe1iSDK = new AFe1iSDK();
            if (valueOf(aFe1iSDK, AFKeystoreWrapper(this.onAppOpenAttributionNative))) {
                int i3 = onConversionDataFail + 11;
                onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                if (i3 % 2 == 0) {
                    valueOf(aFe1iSDK);
                    throw null;
                }
                valueOf(aFe1iSDK);
            }
            int i4 = onConversionDataFail + 115;
            onAppOpenAttribution = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i4 % 2 == 0) {
                throw null;
            }
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void AFVersionDeclaration() {
        onConversionDataFail = (onAppOpenAttribution + 1) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        values(valueOf().values(), new Runnable() { // from class: com.appsflyer.internal.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f65641a.AFLogger$LogLevel();
            }
        }, 0L, TimeUnit.MILLISECONDS);
        int i3 = onAppOpenAttribution + 57;
        onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            int i4 = 22 / 0;
        }
    }

    private void afDebugLog() {
        AFf1iSDK aFf1iSDKAFVersionDeclaration = valueOf().AFVersionDeclaration();
        AFf1lSDK aFf1lSDKAfInfoLog = afInfoLog();
        Runnable runnableAFKeystoreWrapper = AFKeystoreWrapper(aFf1lSDKAfInfoLog);
        aFf1iSDKAFVersionDeclaration.valueOf(aFf1lSDKAfInfoLog);
        aFf1iSDKAFVersionDeclaration.valueOf(new AFf1gSDK(runnableAFKeystoreWrapper));
        aFf1iSDKAFVersionDeclaration.valueOf(new AFf1oSDK(runnableAFKeystoreWrapper, valueOf()));
        aFf1iSDKAFVersionDeclaration.valueOf(new AFf1kSDK(runnableAFKeystoreWrapper, valueOf()));
        if (!afErrorLog()) {
            int i3 = onAppOpenAttribution + 5;
            onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i3 % 2 != 0) {
                aFf1iSDKAFVersionDeclaration.AFInAppEventParameterName(this.onAppOpenAttributionNative, runnableAFKeystoreWrapper, valueOf());
                throw null;
            }
            aFf1iSDKAFVersionDeclaration.AFInAppEventParameterName(this.onAppOpenAttributionNative, runnableAFKeystoreWrapper, valueOf());
        }
        for (AFf1jSDK aFf1jSDK : aFf1iSDKAFVersionDeclaration.AFKeystoreWrapper()) {
            onConversionDataFail = (onAppOpenAttribution + 37) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            aFf1jSDK.valueOf(this.onAppOpenAttributionNative);
        }
        onAppOpenAttribution = (onConversionDataFail + 107) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    private boolean afErrorLog() {
        onAppOpenAttribution = (onConversionDataFail + 63) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        boolean zAFInAppEventType = valueOf().AFInAppEventParameterName().AFInAppEventType("AF_PREINSTALL_DISABLED");
        int i3 = onAppOpenAttribution + 41;
        onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            return zAFInAppEventType;
        }
        throw null;
    }

    private void afErrorLogForExcManagerOnly() {
        int i3 = onConversionDataFail + 89;
        onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            AFd1nSDK.afRDLog();
            throw null;
        }
        if (AFd1nSDK.afRDLog()) {
            return;
        }
        AFc1ySDK aFc1ySDKValueOf = valueOf();
        AFd1xSDK aFd1xSDKAFLogger$LogLevel = aFc1ySDKValueOf.AFLogger$LogLevel();
        aFd1xSDKAFLogger$LogLevel.valueOf.execute(aFd1xSDKAFLogger$LogLevel.new AnonymousClass4(new AFd1nSDK(aFc1ySDKValueOf)));
        onAppOpenAttribution = (onConversionDataFail + 99) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    private AFf1lSDK afInfoLog() {
        AFf1lSDK aFf1lSDK = new AFf1lSDK(new Runnable() { // from class: com.appsflyer.internal.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f65640a.AFVersionDeclaration();
            }
        }, valueOf().AFInAppEventType());
        onConversionDataFail = (onAppOpenAttribution + 29) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        return aFf1lSDK;
    }

    private boolean afRDLog() {
        if (this.AFLogger <= 0) {
            if (isStopped()) {
                return false;
            }
            int i3 = onAppOpenAttribution + 93;
            onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i3 % 2 == 0) {
                AFLogger.afInfoLog("Sending first launch for this session!");
                return false;
            }
            AFLogger.afInfoLog("Sending first launch for this session!");
            throw null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.AFLogger;
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS Z", locale);
        String strValueOf = valueOf(simpleDateFormat, this.AFLogger);
        String strValueOf2 = valueOf(simpleDateFormat, this.afInfoLog);
        if (jCurrentTimeMillis >= this.afWarnLog || isStopped()) {
            if (isStopped()) {
                return false;
            }
            onAppOpenAttribution = (onConversionDataFail + 121) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            AFLogger.afInfoLog(String.format(locale, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nSending launch (+%s ms)", strValueOf, strValueOf2, Long.valueOf(jCurrentTimeMillis)));
            return false;
        }
        onConversionDataFail = (onAppOpenAttribution + 11) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        AFLogger.afInfoLog(String.format(locale, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nThis launch is blocked: %s ms < %s ms", strValueOf, strValueOf2, Long.valueOf(jCurrentTimeMillis), Long.valueOf(this.afWarnLog)));
        int i4 = onConversionDataFail + 97;
        onAppOpenAttribution = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i4 % 2 != 0) {
            return true;
        }
        throw null;
    }

    private AFf1jSDK[] getLevel() {
        onConversionDataFail = (onAppOpenAttribution + 51) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        AFf1jSDK[] aFf1jSDKArrAFKeystoreWrapper = valueOf().AFVersionDeclaration().AFKeystoreWrapper();
        int i3 = onAppOpenAttribution + 85;
        onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            int i4 = 20 / 0;
        }
        return aFf1jSDKArrAFKeystoreWrapper;
    }

    static /* synthetic */ Map valueOf(AFa1bSDK aFa1bSDK) {
        int i3 = onConversionDataFail + 17;
        int i4 = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        onAppOpenAttribution = i4;
        int i5 = i3 % 2;
        Map<String, Object> map = aFa1bSDK.init;
        if (i5 == 0) {
            throw null;
        }
        int i6 = i4 + 83;
        onConversionDataFail = i6 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i6 % 2 == 0) {
            return map;
        }
        throw null;
    }

    static /* synthetic */ long values(AFa1bSDK aFa1bSDK, long j3) {
        int i3 = onConversionDataFail + 29;
        int i4 = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        onAppOpenAttribution = i4;
        int i5 = i3 % 2;
        aFa1bSDK.afInfoLog = j3;
        if (i5 == 0) {
            throw null;
        }
        onConversionDataFail = (i4 + 27) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        return j3;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void addPushNotificationDeepLinkPath(String... strArr) {
        onConversionDataFail = (onAppOpenAttribution + 43) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        List<String> listAsList = Arrays.asList(strArr);
        List<List<String>> list = valueOf().onInstallConversionDataLoadedNative().AFKeystoreWrapper;
        if (list.contains(listAsList)) {
            return;
        }
        int i3 = onAppOpenAttribution + 97;
        onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        int i4 = i3 % 2;
        list.add(listAsList);
        if (i4 != 0) {
            throw null;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void anonymizeUser(boolean z2) {
        onConversionDataFail = (onAppOpenAttribution + 17) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        valueOf().afErrorLogForExcManagerOnly().AFInAppEventParameterName("anonymizeUser", String.valueOf(z2));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, z2);
        onConversionDataFail = (onAppOpenAttribution + 57) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void appendParametersToDeepLinkingURL(String str, Map<String, String> map) {
        int i3 = onConversionDataFail + 123;
        onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            AFb1sSDK aFb1sSDKOnInstallConversionDataLoadedNative = valueOf().onInstallConversionDataLoadedNative();
            aFb1sSDKOnInstallConversionDataLoadedNative.AFInAppEventParameterName = str;
            aFb1sSDKOnInstallConversionDataLoadedNative.AFInAppEventType = map;
            throw null;
        }
        AFb1sSDK aFb1sSDKOnInstallConversionDataLoadedNative2 = valueOf().onInstallConversionDataLoadedNative();
        aFb1sSDKOnInstallConversionDataLoadedNative2.AFInAppEventParameterName = str;
        aFb1sSDKOnInstallConversionDataLoadedNative2.AFInAppEventType = map;
        int i4 = onConversionDataFail + 29;
        onAppOpenAttribution = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i4 % 2 == 0) {
            int i5 = 7 / 0;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void enableFacebookDeferredApplinks(boolean z2) {
        int i3 = onAppOpenAttribution;
        this.onInstallConversionDataLoadedNative = z2;
        int i4 = i3 + 31;
        onConversionDataFail = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i4 % 2 != 0) {
            throw null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0039, code lost:
    
        if ((r5 % 2) == 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003b, code lost:
    
        r5 = 7 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003d, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003e, code lost:
    
        AFInAppEventType(r5);
        r5 = valueOf().AFInAppEventParameterName();
        r5 = com.appsflyer.internal.AFa1aSDK.valueOf(r5.values, r5.valueOf);
        r0 = com.appsflyer.internal.AFa1bSDK.onConversionDataFail + 93;
        com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution = r0 % com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x005b, code lost:
    
        if ((r0 % 2) != 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005d, code lost:
    
        r0 = 91 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0060, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x001c, code lost:
    
        if (r5 == null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002c, code lost:
    
        if (r5 == null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002e, code lost:
    
        r5 = com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution + 123;
        com.appsflyer.internal.AFa1bSDK.onConversionDataFail = r5 % com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
     */
    @Override // com.appsflyer.AppsFlyerLib
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String getAppsFlyerUID(android.content.Context r5) {
        /*
            r4 = this;
            int r0 = com.appsflyer.internal.AFa1bSDK.onConversionDataFail
            int r0 = r0 + 119
            int r1 = r0 % 128
            com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution = r1
            int r0 = r0 % 2
            java.lang.String r1 = "getAppsFlyerUID"
            r2 = 0
            if (r0 != 0) goto L1f
            com.appsflyer.internal.AFc1ySDK r0 = r4.valueOf()
            com.appsflyer.internal.AFb1ySDK r0 = r0.afErrorLogForExcManagerOnly()
            java.lang.String[] r3 = new java.lang.String[r2]
            r0.AFInAppEventParameterName(r1, r3)
            if (r5 != 0) goto L3e
            goto L2e
        L1f:
            com.appsflyer.internal.AFc1ySDK r0 = r4.valueOf()
            com.appsflyer.internal.AFb1ySDK r0 = r0.afErrorLogForExcManagerOnly()
            java.lang.String[] r3 = new java.lang.String[r2]
            r0.AFInAppEventParameterName(r1, r3)
            if (r5 != 0) goto L3e
        L2e:
            int r5 = com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution
            int r5 = r5 + 123
            int r0 = r5 % 128
            com.appsflyer.internal.AFa1bSDK.onConversionDataFail = r0
            int r5 = r5 % 2
            r0 = 0
            if (r5 == 0) goto L3d
            r5 = 7
            int r5 = r5 / r2
        L3d:
            return r0
        L3e:
            r4.AFInAppEventType(r5)
            com.appsflyer.internal.AFc1ySDK r5 = r4.valueOf()
            com.appsflyer.internal.AFb1gSDK r5 = r5.AFInAppEventParameterName()
            com.appsflyer.internal.AFc1zSDK r0 = r5.values
            com.appsflyer.internal.AFb1fSDK r5 = r5.valueOf
            java.lang.String r5 = com.appsflyer.internal.AFa1aSDK.valueOf(r0, r5)
            int r0 = com.appsflyer.internal.AFa1bSDK.onConversionDataFail
            int r0 = r0 + 93
            int r1 = r0 % 128
            com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L60
            r0 = 91
            int r0 = r0 / r2
        L60:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1bSDK.getAppsFlyerUID(android.content.Context):java.lang.String");
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final String getAttributionId(Context context) {
        try {
            String strValues = new AFa1dSDK(context, valueOf()).values();
            onConversionDataFail = (onAppOpenAttribution + 103) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            return strValues;
        } catch (Throwable th) {
            AFLogger.afErrorLog("Could not collect facebook attribution id. ", th);
            return null;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final String getHostName() {
        onConversionDataFail = (onAppOpenAttribution + 117) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        String strValueOf = valueOf().onAppOpenAttributionNative().valueOf();
        onAppOpenAttribution = (onConversionDataFail + 27) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        return strValueOf;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final String getHostPrefix() {
        onAppOpenAttribution = (onConversionDataFail + 117) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        String strAFInAppEventType = valueOf().onAppOpenAttributionNative().AFInAppEventType();
        onConversionDataFail = (onAppOpenAttribution + 45) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        return strAFInAppEventType;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final String getOutOfStore(Context context) {
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_STORE_FROM_API);
        if (string != null) {
            onAppOpenAttribution = (onConversionDataFail + 89) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            return string;
        }
        String strAFKeystoreWrapper = AFKeystoreWrapper(context, "AF_STORE");
        if (strAFKeystoreWrapper != null) {
            onConversionDataFail = (onAppOpenAttribution + 3) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            return strAFKeystoreWrapper;
        }
        AFLogger.afInfoLog("No out-of-store value set");
        return null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final String getSdkVersion() {
        AFc1ySDK aFc1ySDKValueOf;
        int i3 = onAppOpenAttribution + 41;
        onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            aFc1ySDKValueOf = valueOf();
            aFc1ySDKValueOf.afErrorLogForExcManagerOnly().AFInAppEventParameterName("getSdkVersion", new String[0]);
        } else {
            aFc1ySDKValueOf = valueOf();
            aFc1ySDKValueOf.afErrorLogForExcManagerOnly().AFInAppEventParameterName("getSdkVersion", new String[0]);
        }
        aFc1ySDKValueOf.AFInAppEventParameterName();
        return AFb1gSDK.valueOf();
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final AppsFlyerLib init(String str, AppsFlyerConversionListener appsFlyerConversionListener, Context context) {
        long j3;
        if (this.afErrorLogForExcManagerOnly) {
            onAppOpenAttribution = (onConversionDataFail + 85) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            return this;
        }
        this.afErrorLogForExcManagerOnly = true;
        valueOf().getLevel().values = str;
        AFc1sSDK.AFInAppEventParameterName(str);
        if (context != null) {
            this.onAppOpenAttributionNative = (Application) context.getApplicationContext();
            AFInAppEventType(context);
            valueOf().afErrorLog().values = System.currentTimeMillis();
            valueOf().onResponseErrorNative().AFInAppEventParameterName();
            valueOf().afInfoLog().valueOf(new AFe1zSDK() { // from class: com.appsflyer.internal.e
                @Override // com.appsflyer.internal.AFe1zSDK
                public final void onRemoteConfigUpdateFinished(AFd1dSDK aFd1dSDK) {
                    this.f65639a.AFInAppEventParameterName(aFd1dSDK);
                }
            });
            afDebugLog();
            AFe1pSDK level = this.onDeepLinkingNative.getLevel();
            AFb1gSDK aFb1gSDKAFInAppEventParameterName = valueOf().AFInAppEventParameterName();
            level.AFKeystoreWrapper = System.currentTimeMillis();
            AFe1ySDK aFe1ySDK = level.AFInAppEventParameterName;
            StringBuilder sb = new StringBuilder();
            sb.append(AFa1aSDK.valueOf(aFb1gSDKAFInAppEventParameterName.values, aFb1gSDKAFInAppEventParameterName.valueOf));
            sb.append(level.AFKeystoreWrapper);
            byte[] bArrAFKeystoreWrapper = AFc1rSDK.AFKeystoreWrapper(sb.toString());
            if (bArrAFKeystoreWrapper == null || bArrAFKeystoreWrapper.length <= 0) {
                j3 = -1;
            } else {
                if (bArrAFKeystoreWrapper.length > 8) {
                    bArrAFKeystoreWrapper = Arrays.copyOfRange(bArrAFKeystoreWrapper, 0, 8);
                }
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
                byteBufferAllocate.put(bArrAFKeystoreWrapper);
                byteBufferAllocate.flip();
                j3 = byteBufferAllocate.getLong();
                onAppOpenAttribution = (onConversionDataFail + 87) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            }
            level.AFInAppEventType = aFe1ySDK.values(j3, level.valueOf.values, level);
        } else {
            AFLogger.afWarnLog("context is null, Google Install Referrer will be not initialized");
        }
        valueOf().afErrorLogForExcManagerOnly().AFInAppEventParameterName("init", str, appsFlyerConversionListener == null ? "null" : "conversionDataListener");
        AFLogger.AFInAppEventType(String.format("Initializing AppsFlyer SDK: (v%s.%s)", "6.12.3", valueOf));
        this.AFKeystoreWrapper = appsFlyerConversionListener;
        return this;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final boolean isPreInstalledApp(Context context) {
        try {
            if ((context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 1) != 0) {
                onAppOpenAttribution = (onConversionDataFail + 125) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                return true;
            }
        } catch (PackageManager.NameNotFoundException e3) {
            AFLogger.afErrorLog("Could not check if app is pre installed", e3);
        }
        int i3 = onConversionDataFail + 3;
        onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            int i4 = 2 / 0;
        }
        return false;
    }

    @Override // com.appsflyer.AppsFlyerLib
    @Deprecated
    public final boolean isStopped() {
        boolean zAFKeystoreWrapper;
        int i3 = onConversionDataFail + 73;
        onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            zAFKeystoreWrapper = valueOf().getLevel().AFKeystoreWrapper();
            int i4 = 91 / 0;
        } else {
            zAFKeystoreWrapper = valueOf().getLevel().AFKeystoreWrapper();
        }
        onConversionDataFail = (onAppOpenAttribution + 117) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        return zAFKeystoreWrapper;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void logEvent(Context context, String str, Map<String, Object> map) {
        int i3 = onAppOpenAttribution + 75;
        onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        int i4 = i3 % 2;
        logEvent(context, str, map, null);
        if (i4 != 0) {
            throw null;
        }
        int i5 = onAppOpenAttribution + 49;
        onConversionDataFail = i5 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i5 % 2 != 0) {
            throw null;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void logLocation(Context context, double d3, double d4) {
        valueOf().afErrorLogForExcManagerOnly().AFInAppEventParameterName("logLocation", String.valueOf(d3), String.valueOf(d4));
        HashMap map = new HashMap();
        map.put(AFInAppEventParameterName.LONGITUDE, Double.toString(d4));
        map.put(AFInAppEventParameterName.LATITUDE, Double.toString(d3));
        AFInAppEventType(context, AFInAppEventType.LOCATION_COORDINATES, map);
        onConversionDataFail = (onAppOpenAttribution + 77) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void logSession(Context context) {
        onConversionDataFail = (onAppOpenAttribution + 65) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        valueOf().afErrorLogForExcManagerOnly().AFInAppEventParameterName("logSession", new String[0]);
        valueOf().afErrorLogForExcManagerOnly().valueOf();
        values(context, AFe1fSDK.logSession);
        AFInAppEventType(context, (String) null, (Map<String, Object>) null);
        int i3 = onConversionDataFail + 81;
        onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            throw null;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void onPause(Context context) {
        int i3 = onAppOpenAttribution + 125;
        onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            valueOf().onAttributionFailureNative().AFKeystoreWrapper(context);
        } else {
            valueOf().onAttributionFailureNative().AFKeystoreWrapper(context);
            int i4 = 99 / 0;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    @Deprecated
    public final void performOnAppAttribution(Context context, URI uri) {
        if (uri != null) {
            onAppOpenAttribution = (onConversionDataFail + 35) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (!uri.toString().isEmpty()) {
                if (context != null) {
                    valueOf().onInstallConversionDataLoadedNative().AFInAppEventType(context, new HashMap(), Uri.parse(uri.toString()));
                    return;
                }
                AFb1sSDK aFb1sSDKOnInstallConversionDataLoadedNative = valueOf().onInstallConversionDataLoadedNative();
                StringBuilder sb = new StringBuilder("Context is \"");
                sb.append(context);
                sb.append("\"");
                aFb1sSDKOnInstallConversionDataLoadedNative.valueOf(sb.toString(), DeepLinkResult.Error.NETWORK);
                return;
            }
        }
        AFb1sSDK aFb1sSDKOnInstallConversionDataLoadedNative2 = valueOf().onInstallConversionDataLoadedNative();
        StringBuilder sb2 = new StringBuilder("Link is \"");
        sb2.append(uri);
        sb2.append("\"");
        aFb1sSDKOnInstallConversionDataLoadedNative2.valueOf(sb2.toString(), DeepLinkResult.Error.NETWORK);
        onConversionDataFail = (onAppOpenAttribution + 119) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void performOnDeepLinking(final Intent intent, Context context) {
        if (intent == null) {
            onConversionDataFail = (onAppOpenAttribution + 121) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            valueOf().onInstallConversionDataLoadedNative().valueOf("performOnDeepLinking was called with null intent", DeepLinkResult.Error.DEVELOPER_ERROR);
        } else if (context == null) {
            onAppOpenAttribution = (onConversionDataFail + 79) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            valueOf().onInstallConversionDataLoadedNative().valueOf("performOnDeepLinking was called with null context", DeepLinkResult.Error.DEVELOPER_ERROR);
        } else {
            final Context applicationContext = context.getApplicationContext();
            AFInAppEventType(applicationContext);
            valueOf().AFInAppEventType().execute(new Runnable() { // from class: com.appsflyer.internal.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f65636a.AFInAppEventType(applicationContext, intent);
                }
            });
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void registerConversionListener(Context context, AppsFlyerConversionListener appsFlyerConversionListener) {
        onAppOpenAttribution = (onConversionDataFail + 25) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        valueOf().afErrorLogForExcManagerOnly().AFInAppEventParameterName("registerConversionListener", new String[0]);
        values(appsFlyerConversionListener);
        int i3 = onAppOpenAttribution + 87;
        onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            int i4 = 37 / 0;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void registerValidatorListener(Context context, AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener) {
        onAppOpenAttribution = (onConversionDataFail + 5) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        valueOf().afErrorLogForExcManagerOnly().AFInAppEventParameterName("registerValidatorListener", new String[0]);
        AFLogger.afDebugLog("registerValidatorListener called");
        if (appsFlyerInAppPurchaseValidatorListener != null) {
            AFInAppEventParameterName = appsFlyerInAppPurchaseValidatorListener;
        } else {
            onConversionDataFail = (onAppOpenAttribution + 19) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            AFLogger.afDebugLog("registerValidatorListener null listener");
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void sendAdImpression(Context context, Map<String, Object> map) {
        int iValues = values(AFKeystoreWrapper(context));
        HashMap map2 = new HashMap();
        map2.put("ad_network", map);
        map2.put("adimpression_counter", Integer.valueOf(iValues));
        AFInAppEventParameterName(context, map2, new AFe1gSDK());
        onAppOpenAttribution = (onConversionDataFail + 51) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void sendAdRevenue(Context context, Map<String, Object> map) {
        int iAFInAppEventParameterName = AFInAppEventParameterName(AFKeystoreWrapper(context));
        HashMap map2 = new HashMap();
        map2.put("ad_network", map);
        map2.put("adrevenue_counter", Integer.valueOf(iAFInAppEventParameterName));
        AFInAppEventParameterName(context, map2, new AFe1jSDK());
        int i3 = onConversionDataFail + 75;
        onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            int i4 = 43 / 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003b A[PHI: r4
      0x003b: PHI (r4v3 com.appsflyer.PurchaseHandler) = (r4v2 com.appsflyer.PurchaseHandler), (r4v9 com.appsflyer.PurchaseHandler) binds: [B:8:0x0039, B:5:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.appsflyer.AppsFlyerLib
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void sendInAppPurchaseData(android.content.Context r4, java.util.Map<java.lang.String, java.lang.Object> r5, com.appsflyer.PurchaseHandler.PurchaseValidationCallback r6) {
        /*
            r3 = this;
            int r0 = com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution
            int r0 = r0 + 67
            int r1 = r0 % 128
            com.appsflyer.internal.AFa1bSDK.onConversionDataFail = r1
            int r0 = r0 % 2
            java.lang.String r1 = "purchases"
            if (r0 == 0) goto L26
            r3.AFInAppEventType(r4)
            com.appsflyer.internal.AFc1ySDK r4 = r3.valueOf()
            com.appsflyer.PurchaseHandler r4 = r4.afDebugLog()
            r0 = 0
            java.lang.String[] r0 = new java.lang.String[r0]
            r2 = 1
            r0[r2] = r1
            boolean r0 = r4.AFInAppEventType(r5, r6, r0)
            if (r0 == 0) goto L4e
            goto L3b
        L26:
            r3.AFInAppEventType(r4)
            com.appsflyer.internal.AFc1ySDK r4 = r3.valueOf()
            com.appsflyer.PurchaseHandler r4 = r4.afDebugLog()
            java.lang.String[] r0 = new java.lang.String[]{r1}
            boolean r0 = r4.AFInAppEventType(r5, r6, r0)
            if (r0 == 0) goto L4e
        L3b:
            com.appsflyer.internal.AFd1kSDK r0 = new com.appsflyer.internal.AFd1kSDK
            com.appsflyer.internal.AFc1ySDK r1 = r4.AFInAppEventParameterName
            r0.<init>(r5, r6, r1)
            com.appsflyer.internal.AFd1xSDK r4 = r4.valueOf
            java.util.concurrent.Executor r5 = r4.valueOf
            com.appsflyer.internal.AFd1xSDK$4 r6 = new com.appsflyer.internal.AFd1xSDK$4
            r6.<init>(r0)
            r5.execute(r6)
        L4e:
            int r4 = com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution
            int r4 = r4 + 109
            int r4 = r4 % 128
            com.appsflyer.internal.AFa1bSDK.onConversionDataFail = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1bSDK.sendInAppPurchaseData(android.content.Context, java.util.Map, com.appsflyer.PurchaseHandler$PurchaseValidationCallback):void");
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void sendPurchaseData(Context context, Map<String, Object> map, PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback) {
        onAppOpenAttribution = (onConversionDataFail + 123) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        AFInAppEventType(context);
        PurchaseHandler purchaseHandlerAfDebugLog = valueOf().afDebugLog();
        if (purchaseHandlerAfDebugLog.AFInAppEventType(map, purchaseValidationCallback, CustomerInfoResponseJsonKeys.SUBSCRIPTIONS)) {
            AFd1rSDK aFd1rSDK = new AFd1rSDK(map, purchaseValidationCallback, purchaseHandlerAfDebugLog.AFInAppEventParameterName);
            AFd1xSDK aFd1xSDK = purchaseHandlerAfDebugLog.valueOf;
            aFd1xSDK.valueOf.execute(aFd1xSDK.new AnonymousClass4(aFd1rSDK));
            onAppOpenAttribution = (onConversionDataFail + 79) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        onAppOpenAttribution = (onConversionDataFail + 109) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void sendPushNotificationData(Activity activity) {
        long jLongValue;
        int i3 = onConversionDataFail + 89;
        onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            throw null;
        }
        if (activity != null && activity.getIntent() != null) {
            AFb1ySDK aFb1ySDKAfErrorLogForExcManagerOnly = valueOf().afErrorLogForExcManagerOnly();
            String localClassName = activity.getLocalClassName();
            StringBuilder sb = new StringBuilder("activity_intent_");
            sb.append(activity.getIntent().toString());
            aFb1ySDKAfErrorLogForExcManagerOnly.AFInAppEventParameterName("sendPushNotificationData", localClassName, sb.toString());
        } else if (activity != null) {
            valueOf().afErrorLogForExcManagerOnly().AFInAppEventParameterName("sendPushNotificationData", activity.getLocalClassName(), "activity_intent_null");
        } else {
            valueOf().afErrorLogForExcManagerOnly().AFInAppEventParameterName("sendPushNotificationData", "activity_null");
        }
        String strAFInAppEventType = AFInAppEventType(activity);
        this.AFVersionDeclaration = strAFInAppEventType;
        if (strAFInAppEventType != null) {
            onAppOpenAttribution = (onConversionDataFail + 35) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.getLevel == null) {
                AFLogger.afInfoLog("pushes: initializing pushes history..");
                this.getLevel = new ConcurrentHashMap();
                jLongValue = jCurrentTimeMillis;
            } else {
                try {
                    long j3 = AppsFlyerProperties.getInstance().getLong("pushPayloadMaxAging", 1800000L);
                    jLongValue = jCurrentTimeMillis;
                    for (Long l3 : this.getLevel.keySet()) {
                        try {
                            JSONObject jSONObject = new JSONObject(this.AFVersionDeclaration);
                            JSONObject jSONObject2 = new JSONObject(this.getLevel.get(l3));
                            if (jSONObject.opt("pid").equals(jSONObject2.opt("pid")) && jSONObject.opt("c").equals(jSONObject2.opt("c"))) {
                                StringBuilder sb2 = new StringBuilder("PushNotificationMeasurement: A previous payload with same PID and campaign was already acknowledged! (old: ");
                                sb2.append(jSONObject2);
                                sb2.append(", new: ");
                                sb2.append(jSONObject);
                                sb2.append(")");
                                AFLogger.afInfoLog(sb2.toString());
                                this.AFVersionDeclaration = null;
                                return;
                            }
                            if (jCurrentTimeMillis - l3.longValue() > j3) {
                                onAppOpenAttribution = (onConversionDataFail + 21) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                                this.getLevel.remove(l3);
                                onConversionDataFail = (onAppOpenAttribution + 117) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                            }
                            if (l3.longValue() <= jLongValue) {
                                jLongValue = l3.longValue();
                            }
                        } catch (Throwable th) {
                            th = th;
                            StringBuilder sb3 = new StringBuilder("Error while handling push notification measurement: ");
                            sb3.append(th.getClass().getSimpleName());
                            AFLogger.afErrorLog(sb3.toString(), th);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    jLongValue = jCurrentTimeMillis;
                }
            }
            if (this.getLevel.size() == AppsFlyerProperties.getInstance().getInt("pushPayloadHistorySize", 2)) {
                StringBuilder sb4 = new StringBuilder("pushes: removing oldest overflowing push (oldest push:");
                sb4.append(jLongValue);
                sb4.append(")");
                AFLogger.afInfoLog(sb4.toString());
                this.getLevel.remove(Long.valueOf(jLongValue));
            }
            this.getLevel.put(Long.valueOf(jCurrentTimeMillis), this.AFVersionDeclaration);
            start(activity);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    @Override // com.appsflyer.AppsFlyerLib
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setAdditionalData(java.util.Map<java.lang.String, java.lang.Object> r4) {
        /*
            r3 = this;
            int r0 = com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution
            int r0 = r0 + 25
            int r1 = r0 % 128
            com.appsflyer.internal.AFa1bSDK.onConversionDataFail = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L13
            r0 = 12
            int r0 = r0 / 0
            if (r4 == 0) goto L3a
            goto L15
        L13:
            if (r4 == 0) goto L3a
        L15:
            com.appsflyer.internal.AFc1ySDK r0 = r3.valueOf()
            com.appsflyer.internal.AFb1ySDK r0 = r0.afErrorLogForExcManagerOnly()
            java.lang.String r1 = r4.toString()
            java.lang.String[] r1 = new java.lang.String[]{r1}
            java.lang.String r2 = "setAdditionalData"
            r0.AFInAppEventParameterName(r2, r1)
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>(r4)
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r0 = r0.toString()
            r4.setCustomData(r0)
        L3a:
            int r4 = com.appsflyer.internal.AFa1bSDK.onConversionDataFail
            int r4 = r4 + 67
            int r0 = r4 % 128
            com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution = r0
            int r4 = r4 % 2
            if (r4 == 0) goto L47
            return
        L47:
            r4 = 0
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1bSDK.setAdditionalData(java.util.Map):void");
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setAndroidIdData(String str) {
        int i3 = onAppOpenAttribution + 81;
        onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            AFb1ySDK aFb1ySDKAfErrorLogForExcManagerOnly = valueOf().afErrorLogForExcManagerOnly();
            String[] strArr = new String[1];
            strArr[1] = str;
            aFb1ySDKAfErrorLogForExcManagerOnly.AFInAppEventParameterName("setAndroidIdData", strArr);
        } else {
            valueOf().afErrorLogForExcManagerOnly().AFInAppEventParameterName("setAndroidIdData", str);
        }
        this.afRDLog = str;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setAppId(String str) {
        int i3 = onAppOpenAttribution + 107;
        onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            AFb1ySDK aFb1ySDKAfErrorLogForExcManagerOnly = valueOf().afErrorLogForExcManagerOnly();
            String[] strArr = new String[1];
            strArr[1] = str;
            aFb1ySDKAfErrorLogForExcManagerOnly.AFInAppEventParameterName("setAppId", strArr);
        } else {
            valueOf().afErrorLogForExcManagerOnly().AFInAppEventParameterName("setAppId", str);
        }
        values(AppsFlyerProperties.APP_ID, str);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setAppInviteOneLink(String str) {
        onConversionDataFail = (onAppOpenAttribution + 121) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        valueOf().afErrorLogForExcManagerOnly().AFInAppEventParameterName("setAppInviteOneLink", str);
        AFLogger.afInfoLog("setAppInviteOneLink = ".concat(String.valueOf(str)));
        if (str == null || !str.equals(AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_ID))) {
            AppsFlyerProperties.getInstance().remove(AppsFlyerProperties.ONELINK_DOMAIN);
            AppsFlyerProperties.getInstance().remove(AppsFlyerProperties.ONELINK_VERSION);
            AppsFlyerProperties.getInstance().remove(AppsFlyerProperties.ONELINK_SCHEME);
            onConversionDataFail = (onAppOpenAttribution + 37) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        values(AppsFlyerProperties.ONELINK_ID, str);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setCollectAndroidID(boolean z2) {
        int i3 = onAppOpenAttribution + 115;
        onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            valueOf().afErrorLogForExcManagerOnly().AFInAppEventParameterName("setCollectAndroidID", String.valueOf(z2));
        } else {
            valueOf().afErrorLogForExcManagerOnly().AFInAppEventParameterName("setCollectAndroidID", String.valueOf(z2));
        }
        values(AppsFlyerProperties.COLLECT_ANDROID_ID, Boolean.toString(z2));
        values(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, Boolean.toString(z2));
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setCollectIMEI(boolean z2) {
        onConversionDataFail = (onAppOpenAttribution + 7) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        valueOf().afErrorLogForExcManagerOnly().AFInAppEventParameterName("setCollectIMEI", String.valueOf(z2));
        values(AppsFlyerProperties.COLLECT_IMEI, Boolean.toString(z2));
        values(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, Boolean.toString(z2));
        int i3 = onConversionDataFail + 69;
        onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            throw null;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    @Deprecated
    public final void setCollectOaid(boolean z2) {
        onAppOpenAttribution = (onConversionDataFail + 63) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        valueOf().afErrorLogForExcManagerOnly().AFInAppEventParameterName("setCollectOaid", String.valueOf(z2));
        values(AppsFlyerProperties.COLLECT_OAID, Boolean.toString(z2));
        onConversionDataFail = (onAppOpenAttribution + 39) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setCurrencyCode(String str) {
        int i3 = onAppOpenAttribution + 87;
        onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            AFb1ySDK aFb1ySDKAfErrorLogForExcManagerOnly = valueOf().afErrorLogForExcManagerOnly();
            String[] strArr = new String[0];
            strArr[0] = str;
            aFb1ySDKAfErrorLogForExcManagerOnly.AFInAppEventParameterName("setCurrencyCode", strArr);
        } else {
            valueOf().afErrorLogForExcManagerOnly().AFInAppEventParameterName("setCurrencyCode", str);
        }
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.CURRENCY_CODE, str);
        onAppOpenAttribution = (onConversionDataFail + 105) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
    
        setCustomerUserId(r7);
        r0 = new java.lang.StringBuilder("CustomerUserId set: ");
        r0.append(r7);
        r0.append(" - Initializing AppsFlyer Tacking");
        com.appsflyer.AFLogger.afInfoLog(r0.toString(), true);
        r7 = com.appsflyer.AppsFlyerProperties.getInstance().getReferrer(valueOf().AFKeystoreWrapper());
        values(r8, com.appsflyer.internal.AFe1fSDK.setCustomerIdAndLogSession);
        r0 = valueOf().getLevel().values;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0058, code lost:
    
        if (r7 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x005a, code lost:
    
        r7 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x005c, code lost:
    
        r4 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x005f, code lost:
    
        if ((r8 instanceof android.app.Activity) == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0061, code lost:
    
        ((android.app.Activity) r8).getIntent();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0067, code lost:
    
        AFInAppEventParameterName(r8, null, null, r4, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x006f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0070, code lost:
    
        setCustomerUserId(r7);
        com.appsflyer.AFLogger.afInfoLog("waitForCustomerUserId is false; setting CustomerUserID: ".concat(java.lang.String.valueOf(r7)), true);
        com.appsflyer.internal.AFa1bSDK.onConversionDataFail = (com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution + 71) % com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0088, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0017, code lost:
    
        if (AFKeystoreWrapper() != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001e, code lost:
    
        if (AFKeystoreWrapper() != false) goto L10;
     */
    @Override // com.appsflyer.AppsFlyerLib
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setCustomerIdAndLogSession(java.lang.String r7, android.content.Context r8) {
        /*
            r6 = this;
            if (r8 == 0) goto L88
            int r0 = com.appsflyer.internal.AFa1bSDK.onConversionDataFail
            int r0 = r0 + 77
            int r1 = r0 % 128
            com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution = r1
            int r0 = r0 % 2
            r1 = 1
            if (r0 != 0) goto L1a
            boolean r0 = r6.AFKeystoreWrapper()
            r2 = 72
            int r2 = r2 / 0
            if (r0 == 0) goto L70
            goto L20
        L1a:
            boolean r0 = r6.AFKeystoreWrapper()
            if (r0 == 0) goto L70
        L20:
            r6.setCustomerUserId(r7)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "CustomerUserId set: "
            r0.<init>(r2)
            r0.append(r7)
            java.lang.String r7 = " - Initializing AppsFlyer Tacking"
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            com.appsflyer.AFLogger.afInfoLog(r7, r1)
            com.appsflyer.AppsFlyerProperties r7 = com.appsflyer.AppsFlyerProperties.getInstance()
            com.appsflyer.internal.AFc1ySDK r0 = r6.valueOf()
            com.appsflyer.internal.AFb1fSDK r0 = r0.AFKeystoreWrapper()
            java.lang.String r7 = r7.getReferrer(r0)
            com.appsflyer.internal.AFe1fSDK r0 = com.appsflyer.internal.AFe1fSDK.setCustomerIdAndLogSession
            r6.values(r8, r0)
            com.appsflyer.internal.AFc1ySDK r0 = r6.valueOf()
            com.appsflyer.internal.AFe1pSDK r0 = r0.getLevel()
            java.lang.String r0 = r0.values
            if (r7 != 0) goto L5c
            java.lang.String r7 = ""
        L5c:
            r4 = r7
            boolean r7 = r8 instanceof android.app.Activity
            if (r7 == 0) goto L67
            r7 = r8
            android.app.Activity r7 = (android.app.Activity) r7
            r7.getIntent()
        L67:
            r5 = 0
            r2 = 0
            r3 = 0
            r0 = r6
            r1 = r8
            r0.AFInAppEventParameterName(r1, r2, r3, r4, r5)
            return
        L70:
            r6.setCustomerUserId(r7)
            java.lang.String r8 = "waitForCustomerUserId is false; setting CustomerUserID: "
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r7 = r8.concat(r7)
            com.appsflyer.AFLogger.afInfoLog(r7, r1)
            int r7 = com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution
            int r7 = r7 + 71
            int r7 = r7 % 128
            com.appsflyer.internal.AFa1bSDK.onConversionDataFail = r7
        L88:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1bSDK.setCustomerIdAndLogSession(java.lang.String, android.content.Context):void");
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setCustomerUserId(String str) {
        onAppOpenAttribution = (onConversionDataFail + 11) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        valueOf().afErrorLogForExcManagerOnly().AFInAppEventParameterName("setCustomerUserId", str);
        AFLogger.afInfoLog("setCustomerUserId = ".concat(String.valueOf(str)));
        values(AppsFlyerProperties.APP_USER_ID, str);
        values(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false);
        onAppOpenAttribution = (onConversionDataFail + 55) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setDebugLog(boolean z2) {
        AFLogger.LogLevel logLevel;
        if (z2) {
            logLevel = AFLogger.LogLevel.DEBUG;
        } else {
            logLevel = AFLogger.LogLevel.NONE;
            onConversionDataFail = (onAppOpenAttribution + 1) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        setLogLevel(logLevel);
        onConversionDataFail = (onAppOpenAttribution + 101) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setDisableAdvertisingIdentifiers(boolean z2) {
        boolean z3;
        onConversionDataFail = (onAppOpenAttribution + 27) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        AFLogger.afDebugLog("setDisableAdvertisingIdentifiers: ".concat(String.valueOf(z2)));
        if (z2) {
            z3 = false;
        } else {
            onConversionDataFail = (onAppOpenAttribution + 61) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            z3 = true;
        }
        AFa1eSDK.AFInAppEventParameterName = Boolean.valueOf(z3);
        AppsFlyerProperties.getInstance().remove("advertiserIdEnabled");
        AppsFlyerProperties.getInstance().remove("advertiserId");
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setDisableNetworkData(boolean z2) {
        int i3 = onConversionDataFail + 13;
        onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            AFLogger.afDebugLog("setDisableNetworkData: ".concat(String.valueOf(z2)));
            values(AppsFlyerProperties.DISABLE_NETWORK_DATA, z2);
            int i4 = 69 / 0;
        } else {
            AFLogger.afDebugLog("setDisableNetworkData: ".concat(String.valueOf(z2)));
            values(AppsFlyerProperties.DISABLE_NETWORK_DATA, z2);
        }
        int i5 = onAppOpenAttribution + 31;
        onConversionDataFail = i5 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i5 % 2 != 0) {
            throw null;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setExtension(String str) {
        onConversionDataFail = (onAppOpenAttribution + 33) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        valueOf().afErrorLogForExcManagerOnly().AFInAppEventParameterName("setExtension", str);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EXTENSION, str);
        onAppOpenAttribution = (onConversionDataFail + 39) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setHost(String str, String str2) {
        onAppOpenAttribution = (onConversionDataFail + 25) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (AFb1tSDK.AFInAppEventParameterName(str2)) {
            AFLogger.afWarnLog("hostname was empty or null - call for setHost is skipped");
            return;
        }
        onConversionDataFail = (onAppOpenAttribution + 95) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        AFd1ySDK.AFInAppEventType(new AFc1cSDK(str != null ? str.trim() : "", str2.trim()));
        int i3 = onAppOpenAttribution + 29;
        onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            throw null;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setImeiData(String str) {
        onAppOpenAttribution = (onConversionDataFail + 83) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        valueOf().afErrorLogForExcManagerOnly().AFInAppEventParameterName("setImeiData", str);
        valueOf().getLevel().AFLogger = str;
        onAppOpenAttribution = (onConversionDataFail + 103) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setIsUpdate(boolean z2) {
        onConversionDataFail = (onAppOpenAttribution + 121) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        valueOf().afErrorLogForExcManagerOnly().AFInAppEventParameterName("setIsUpdate", String.valueOf(z2));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.IS_UPDATE, z2);
        onConversionDataFail = (onAppOpenAttribution + 107) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setLogLevel(AFLogger.LogLevel logLevel) {
        boolean z2;
        onConversionDataFail = (onAppOpenAttribution + 45) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (logLevel.getLevel() > AFLogger.LogLevel.NONE.getLevel()) {
            onAppOpenAttribution = (onConversionDataFail + 91) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            z2 = true;
        } else {
            z2 = false;
        }
        valueOf().afErrorLogForExcManagerOnly().AFInAppEventParameterName("log", String.valueOf(z2));
        AppsFlyerProperties.getInstance().set("logLevel", logLevel.getLevel());
        onAppOpenAttribution = (onConversionDataFail + 47) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setMinTimeBetweenSessions(int i3) {
        onConversionDataFail = (onAppOpenAttribution + 13) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        this.afWarnLog = TimeUnit.SECONDS.toMillis(i3);
        int i4 = onConversionDataFail + 23;
        onAppOpenAttribution = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i4 % 2 == 0) {
            int i5 = 14 / 0;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setOaidData(String str) {
        onConversionDataFail = (onAppOpenAttribution + 19) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        valueOf().afErrorLogForExcManagerOnly().AFInAppEventParameterName("setOaidData", str);
        AFa1eSDK.values = str;
        int i3 = onConversionDataFail + 125;
        onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            throw null;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setOneLinkCustomDomain(String... strArr) {
        onConversionDataFail = (onAppOpenAttribution + 69) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        AFLogger.afDebugLog(String.format("setOneLinkCustomDomain %s", Arrays.toString(strArr)));
        valueOf().onInstallConversionDataLoadedNative().afDebugLog = strArr;
        int i3 = onConversionDataFail + 73;
        onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            throw null;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setOutOfStore(String str) {
        if (str == null) {
            AFLogger.AFKeystoreWrapper("Cannot set setOutOfStore with null");
            onConversionDataFail = (onAppOpenAttribution + 121) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            onAppOpenAttribution = (onConversionDataFail + 111) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            String lowerCase = str.toLowerCase(Locale.getDefault());
            AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_STORE_FROM_API, lowerCase);
            AFLogger.afInfoLog("Store API set with value: ".concat(String.valueOf(lowerCase)), true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
    
        if (r4.isEmpty() != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
    
        if (r4.isEmpty() != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0037, code lost:
    
        if (r5 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
    
        r1 = com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution + 95;
        com.appsflyer.internal.AFa1bSDK.onConversionDataFail = r1 % com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0043, code lost:
    
        if ((r1 % 2) != 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0049, code lost:
    
        if (r5.isEmpty() == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004c, code lost:
    
        r1 = new java.lang.StringBuilder("Setting partner data for ");
        r1.append(r4);
        r1.append(": ");
        r1.append(r5);
        com.appsflyer.AFLogger.afDebugLog(r1.toString());
        r1 = new org.json.JSONObject(r5).toString().length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0074, code lost:
    
        if (r1 <= 1000) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0076, code lost:
    
        com.appsflyer.AFLogger.afWarnLog("Partner data 1000 characters limit exceeded");
        r5 = new java.util.HashMap();
        r5.put("error", "limit exceeded: ".concat(java.lang.String.valueOf(r1)));
        r0.values.put(r4, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0094, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0095, code lost:
    
        r0.valueOf.put(r4, r5);
        r0.values.remove(r4);
        r4 = com.appsflyer.internal.AFa1bSDK.onConversionDataFail + 123;
        com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution = r4 % com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a9, code lost:
    
        if ((r4 % 2) != 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ab, code lost:
    
        r4 = 54 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00af, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b0, code lost:
    
        r5.isEmpty();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b4, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00bb, code lost:
    
        if (r0.valueOf.remove(r4) != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bd, code lost:
    
        r4 = "Partner data is missing or `null`";
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c0, code lost:
    
        r4 = "Cleared partner data for ".concat(java.lang.String.valueOf(r4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ca, code lost:
    
        com.appsflyer.AFLogger.afWarnLog(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00cd, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:?, code lost:
    
        return;
     */
    @Override // com.appsflyer.AppsFlyerLib
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setPartnerData(java.lang.String r4, java.util.Map<java.lang.String, java.lang.Object> r5) {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1bSDK.setPartnerData(java.lang.String, java.util.Map):void");
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setPhoneNumber(String str) {
        int i3 = onAppOpenAttribution + 47;
        onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        int i4 = i3 % 2;
        this.onInstallConversionFailureNative = AFc1rSDK.values(str);
        if (i4 != 0) {
            int i5 = 54 / 0;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setPluginInfo(PluginInfo pluginInfo) {
        int i3 = onConversionDataFail + 49;
        onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            Objects.requireNonNull(pluginInfo);
            valueOf().onInstallConversionFailureNative().values(pluginInfo);
        } else {
            Objects.requireNonNull(pluginInfo);
            valueOf().onInstallConversionFailureNative().values(pluginInfo);
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016 A[Catch: JSONException -> 0x0012, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0012, blocks: (B:4:0x000e, B:8:0x0016, B:12:0x002b, B:14:0x002f, B:18:0x0034), top: B:30:0x000e }] */
    @Override // com.appsflyer.AppsFlyerLib
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setPreinstallAttribution(java.lang.String r3, java.lang.String r4, java.lang.String r5) {
        /*
            r2 = this;
            java.lang.String r0 = "setPreinstallAttribution API called"
            com.appsflyer.AFLogger.afDebugLog(r0)
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "pid"
            if (r3 == 0) goto L14
            r0.put(r1, r3)     // Catch: org.json.JSONException -> L12
            goto L14
        L12:
            r3 = move-exception
            goto L38
        L14:
            if (r4 == 0) goto L1b
            java.lang.String r3 = "c"
            r0.put(r3, r4)     // Catch: org.json.JSONException -> L12
        L1b:
            if (r5 == 0) goto L3f
            int r3 = com.appsflyer.internal.AFa1bSDK.onConversionDataFail
            int r3 = r3 + 25
            int r4 = r3 % 128
            com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution = r4
            int r3 = r3 % 2
            java.lang.String r4 = "af_siteid"
            if (r3 != 0) goto L34
            r0.put(r4, r5)     // Catch: org.json.JSONException -> L12
            r3 = 1
            int r3 = r3 / 0
            goto L3f
        L32:
            r3 = move-exception
            throw r3
        L34:
            r0.put(r4, r5)     // Catch: org.json.JSONException -> L12
            goto L3f
        L38:
            java.lang.String r4 = r3.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r4, r3)
        L3f:
            boolean r3 = r0.has(r1)
            if (r3 == 0) goto L5d
            java.lang.String r3 = "preInstallName"
            java.lang.String r4 = r0.toString()
            values(r3, r4)
            int r3 = com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution
            int r3 = r3 + 55
            int r4 = r3 % 128
            com.appsflyer.internal.AFa1bSDK.onConversionDataFail = r4
            int r3 = r3 % 2
            if (r3 != 0) goto L5b
            return
        L5b:
            r3 = 0
            throw r3
        L5d:
            java.lang.String r3 = "Cannot set preinstall attribution data without a media source"
            com.appsflyer.AFLogger.afWarnLog(r3)
            int r3 = com.appsflyer.internal.AFa1bSDK.onConversionDataFail
            int r3 = r3 + 29
            int r3 = r3 % 128
            com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1bSDK.setPreinstallAttribution(java.lang.String, java.lang.String, java.lang.String):void");
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setResolveDeepLinkURLs(String... strArr) {
        onConversionDataFail = (onAppOpenAttribution + 69) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        AFLogger.afDebugLog(String.format("setResolveDeepLinkURLs %s", Arrays.toString(strArr)));
        AFb1sSDK aFb1sSDKOnInstallConversionDataLoadedNative = valueOf().onInstallConversionDataLoadedNative();
        aFb1sSDKOnInstallConversionDataLoadedNative.AFLogger.clear();
        aFb1sSDKOnInstallConversionDataLoadedNative.AFLogger.addAll(Arrays.asList(strArr));
        onAppOpenAttribution = (onConversionDataFail + 15) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    @Override // com.appsflyer.AppsFlyerLib
    @Deprecated
    public final void setSharingFilter(String... strArr) {
        onAppOpenAttribution = (onConversionDataFail + 67) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        setSharingFilterForPartners(strArr);
        int i3 = onConversionDataFail + 121;
        onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            int i4 = 46 / 0;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    @Deprecated
    public final void setSharingFilterForAllPartners() {
        onConversionDataFail = (onAppOpenAttribution + 123) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        setSharingFilterForPartners("all");
        int i3 = onConversionDataFail + 91;
        onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            throw null;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setSharingFilterForPartners(String... strArr) {
        this.afDebugLog = new AFa1fSDK(strArr);
        onAppOpenAttribution = (onConversionDataFail + 123) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setUserEmails(String... strArr) {
        int i3 = onConversionDataFail + 19;
        onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            valueOf().afErrorLogForExcManagerOnly().AFInAppEventParameterName("setUserEmails", strArr);
            setUserEmails(AppsFlyerProperties.EmailsCryptType.NONE, strArr);
        } else {
            valueOf().afErrorLogForExcManagerOnly().AFInAppEventParameterName("setUserEmails", strArr);
            setUserEmails(AppsFlyerProperties.EmailsCryptType.NONE, strArr);
            throw null;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void start(Context context) {
        int i3 = onAppOpenAttribution + 107;
        onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        int i4 = i3 % 2;
        start(context, null);
        if (i4 != 0) {
            throw null;
        }
        onAppOpenAttribution = (onConversionDataFail + 91) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void stop(boolean z2, Context context) {
        AFInAppEventType(context);
        final AFc1ySDK aFc1ySDKValueOf = valueOf();
        aFc1ySDKValueOf.getLevel().afRDLog = z2;
        aFc1ySDKValueOf.AFInAppEventType().submit(new Runnable() { // from class: com.appsflyer.internal.b
            @Override // java.lang.Runnable
            public final void run() {
                AFa1bSDK.AFInAppEventType(aFc1ySDKValueOf);
            }
        });
        if (z2) {
            onConversionDataFail = (onAppOpenAttribution + 25) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            aFc1ySDKValueOf.AFKeystoreWrapper().valueOf("is_stop_tracking_used", true);
            onAppOpenAttribution = (onConversionDataFail + 15) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void subscribeForDeepLink(DeepLinkListener deepLinkListener) {
        onAppOpenAttribution = (onConversionDataFail + 61) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        subscribeForDeepLink(deepLinkListener, TimeUnit.SECONDS.toMillis(3L));
        int i3 = onConversionDataFail + 61;
        onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            throw null;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void unregisterConversionListener() {
        int i3 = onAppOpenAttribution + 27;
        onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            valueOf().afErrorLogForExcManagerOnly().AFInAppEventParameterName("unregisterConversionListener", new String[1]);
        } else {
            valueOf().afErrorLogForExcManagerOnly().AFInAppEventParameterName("unregisterConversionListener", new String[0]);
        }
        this.AFKeystoreWrapper = null;
        onConversionDataFail = (onAppOpenAttribution + 83) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void updateServerUninstallToken(Context context, String str) {
        AFInAppEventType(context);
        AFe1sSDK aFe1sSDK = new AFe1sSDK(context);
        if (str == null || str.trim().isEmpty()) {
            AFLogger.afWarnLog("[register] Firebase Token is either empty or null and was not registered.");
            return;
        }
        AFLogger.afInfoLog("[register] Firebase Refreshed Token = ".concat(str));
        AFb1pSDK aFb1pSDKAFInAppEventType = aFe1sSDK.AFInAppEventType();
        if (aFb1pSDKAFInAppEventType == null || !str.equals(aFb1pSDKAFInAppEventType.AFInAppEventType)) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean z2 = aFb1pSDKAFInAppEventType == null || jCurrentTimeMillis - aFb1pSDKAFInAppEventType.values > TimeUnit.SECONDS.toMillis(2L);
            AFb1pSDK aFb1pSDK = new AFb1pSDK(str, jCurrentTimeMillis, !z2);
            aFe1sSDK.AFInAppEventParameterName.values("afUninstallToken", aFb1pSDK.AFInAppEventType);
            aFe1sSDK.AFInAppEventParameterName.AFInAppEventType("afUninstallToken_received_time", aFb1pSDK.values);
            aFe1sSDK.AFInAppEventParameterName.valueOf("afUninstallToken_queued", aFb1pSDK.AFInAppEventParameterName());
            if (z2) {
                AFe1sSDK.AFKeystoreWrapper(str);
            }
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void validateAndLogInAppPurchase(Context context, String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        onConversionDataFail = (onAppOpenAttribution + 25) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        valueOf().afErrorLogForExcManagerOnly().AFInAppEventParameterName("validateAndTrackInAppPurchase", str, str2, str3, str4, str5, map == null ? "" : map.toString());
        if (!isStopped()) {
            StringBuilder sb = new StringBuilder("Validate in app called with parameters: ");
            sb.append(str3);
            sb.append(" ");
            sb.append(str4);
            sb.append(" ");
            sb.append(str5);
            AFLogger.afInfoLog(sb.toString());
        }
        if (str != null && str4 != null) {
            int i3 = onAppOpenAttribution;
            onConversionDataFail = (i3 + 73) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (str2 != null) {
                int i4 = i3 + 79;
                onConversionDataFail = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                if (i4 % 2 != 0) {
                    throw null;
                }
                if (str5 != null && str3 != null) {
                    new Thread(new AFa1iSDK(context.getApplicationContext(), valueOf().getLevel().values, valueOf().AFInAppEventParameterName(), str, str2, str3, str4, str5, map)).start();
                    return;
                }
            }
        }
        AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = AFInAppEventParameterName;
        if (appsFlyerInAppPurchaseValidatorListener != null) {
            onConversionDataFail = (onAppOpenAttribution + 25) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure("Please provide purchase parameters");
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void waitForCustomerUserId(boolean z2) {
        String strConcat;
        boolean z3;
        int i3 = onConversionDataFail + 47;
        onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            strConcat = "initAfterCustomerUserID: ".concat(String.valueOf(z2));
            z3 = false;
        } else {
            strConcat = "initAfterCustomerUserID: ".concat(String.valueOf(z2));
            z3 = true;
        }
        AFLogger.afInfoLog(strConcat, z3);
        values(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, z2);
        onAppOpenAttribution = (onConversionDataFail + 3) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void AFInAppEventParameterName(AFd1dSDK aFd1dSDK) {
        if (aFd1dSDK == AFd1dSDK.SUCCESS) {
            int i3 = onConversionDataFail + 67;
            onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i3 % 2 == 0) {
                valueOf().onResponseErrorNative().AFKeystoreWrapper();
                throw null;
            }
            valueOf().onResponseErrorNative().AFKeystoreWrapper();
        }
        int i4 = onAppOpenAttribution + 103;
        onConversionDataFail = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i4 % 2 != 0) {
            int i5 = 75 / 0;
        }
    }

    private static String AFKeystoreWrapper(String str) {
        int i3 = onAppOpenAttribution + 101;
        onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            AppsFlyerProperties.getInstance().getString(str);
            throw null;
        }
        String string = AppsFlyerProperties.getInstance().getString(str);
        int i4 = onAppOpenAttribution + 57;
        onConversionDataFail = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i4 % 2 != 0) {
            int i5 = 45 / 0;
        }
        return string;
    }

    private static void afErrorLog(Context context) {
        onAppOpenAttribution = (onConversionDataFail + 29) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        try {
            List listAsList = Arrays.asList(context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions);
            if (!listAsList.contains("android.permission.INTERNET")) {
                int i3 = onAppOpenAttribution + 29;
                onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                if (i3 % 2 != 0) {
                    AFLogger.afWarnLog("Permission android.permission.INTERNET is missing in the AndroidManifest.xml");
                    throw null;
                }
                AFLogger.afWarnLog("Permission android.permission.INTERNET is missing in the AndroidManifest.xml");
            }
            if (!listAsList.contains("android.permission.ACCESS_NETWORK_STATE")) {
                int i4 = onAppOpenAttribution + 39;
                onConversionDataFail = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                if (i4 % 2 != 0) {
                    AFLogger.afWarnLog("Permission android.permission.ACCESS_NETWORK_STATE is missing in the AndroidManifest.xml");
                    throw null;
                }
                AFLogger.afWarnLog("Permission android.permission.ACCESS_NETWORK_STATE is missing in the AndroidManifest.xml");
            }
            if (Build.VERSION.SDK_INT <= 32 || listAsList.contains("com.google.android.gms.permission.AD_ID")) {
                return;
            }
            AFLogger.afWarnLog(KLAQHFCRAUejH.IDjE);
        } catch (Exception e3) {
            AFLogger.afErrorLog("Exception while validation permissions. ", e3);
        }
    }

    static /* synthetic */ boolean valueOf(AFa1bSDK aFa1bSDK, boolean z2) {
        int i3 = onConversionDataFail + 25;
        onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        int i4 = i3 % 2;
        aFa1bSDK.AFLogger$LogLevel = z2;
        if (i4 != 0) {
            return z2;
        }
        throw null;
    }

    static /* synthetic */ void values(AFa1bSDK aFa1bSDK) {
        onAppOpenAttribution = (onConversionDataFail + 39) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        aFa1bSDK.afErrorLogForExcManagerOnly();
        int i3 = onConversionDataFail + 61;
        onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            throw null;
        }
    }

    public final void AFInAppEventType(Context context) {
        AFc1xSDK aFc1xSDK = this.onDeepLinkingNative;
        if (context != null) {
            onConversionDataFail = (onAppOpenAttribution + 57) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            AFc1zSDK aFc1zSDK = aFc1xSDK.valueOf;
            if (context != null) {
                aFc1zSDK.values = context.getApplicationContext();
            }
        }
        onConversionDataFail = (onAppOpenAttribution + 63) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void logEvent(Context context, String str, Map<String, Object> map, AppsFlyerRequestListener appsFlyerRequestListener) {
        HashMap map2 = map == null ? null : new HashMap(map);
        AFInAppEventType(context);
        AFe1cSDK aFe1cSDK = new AFe1cSDK();
        aFe1cSDK.afErrorLog = str;
        aFe1cSDK.AFKeystoreWrapper = appsFlyerRequestListener;
        if (map2 != null && map2.containsKey(AFInAppEventParameterName.TOUCH_OBJ)) {
            HashMap map3 = new HashMap();
            Object obj = map2.get(AFInAppEventParameterName.TOUCH_OBJ);
            if (obj instanceof MotionEvent) {
                MotionEvent motionEvent = (MotionEvent) obj;
                HashMap map4 = new HashMap();
                map4.put("x", Float.valueOf(motionEvent.getX()));
                map4.put("y", Float.valueOf(motionEvent.getY()));
                map3.put("loc", map4);
                map3.put("pf", Float.valueOf(motionEvent.getPressure()));
                map3.put("rad", Float.valueOf(motionEvent.getTouchMajor() / 2.0f));
            } else {
                map3.put("error", "Parsing failed due to invalid input in 'af_touch_obj'.");
                AFLogger.AFKeystoreWrapper("Parsing failed due to invalid input in 'af_touch_obj'.");
            }
            Map<String, ?> mapSingletonMap = Collections.singletonMap("tch_data", map3);
            map2.remove(AFInAppEventParameterName.TOUCH_OBJ);
            aFe1cSDK.valueOf(mapSingletonMap);
        }
        aFe1cSDK.AFInAppEventType = map2;
        AFb1ySDK aFb1ySDKAfErrorLogForExcManagerOnly = valueOf().afErrorLogForExcManagerOnly();
        Map map5 = aFe1cSDK.AFInAppEventType;
        if (map5 == null) {
            map5 = new HashMap();
        }
        aFb1ySDKAfErrorLogForExcManagerOnly.AFInAppEventParameterName("logEvent", str, new JSONObject(map5).toString());
        if (str == null) {
            values(context, AFe1fSDK.logEvent);
        }
        AFInAppEventType(aFe1cSDK, context instanceof Activity ? (Activity) context : null);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void start(Context context, String str) {
        onAppOpenAttribution = (onConversionDataFail + 73) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        start(context, str, null);
        int i3 = onAppOpenAttribution + 89;
        onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            throw null;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void subscribeForDeepLink(DeepLinkListener deepLinkListener, long j3) {
        onConversionDataFail = (onAppOpenAttribution + 11) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        valueOf().onInstallConversionDataLoadedNative().valueOf = deepLinkListener;
        valueOf().onInstallConversionDataLoadedNative().afRDLog = j3;
        onAppOpenAttribution = (onConversionDataFail + 113) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    public static AFa1bSDK values() {
        int i3 = onConversionDataFail;
        AFa1bSDK aFa1bSDK = afErrorLog;
        onAppOpenAttribution = (i3 + 1) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        return aFa1bSDK;
    }

    public final boolean AFKeystoreWrapper() {
        if (AFInAppEventType(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID)) {
            int i3 = onAppOpenAttribution + 77;
            onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i3 % 2 != 0) {
                AFInAppEventType();
                throw null;
            }
            if (AFInAppEventType() == null) {
                return true;
            }
        }
        int i4 = onConversionDataFail + 73;
        onAppOpenAttribution = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i4 % 2 != 0) {
            return false;
        }
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void start(Context context, String str, final AppsFlyerRequestListener appsFlyerRequestListener) {
        int i3 = onAppOpenAttribution + 85;
        onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            int i4 = 18 / 0;
            if (valueOf().onAttributionFailureNative().AFKeystoreWrapper()) {
                return;
            }
        } else if (valueOf().onAttributionFailureNative().AFKeystoreWrapper()) {
            return;
        }
        if (!this.afErrorLogForExcManagerOnly) {
            onAppOpenAttribution = (onConversionDataFail + 71) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            AFLogger.afWarnLog("ERROR: AppsFlyer SDK is not initialized! The API call 'start()' must be called after the 'init(String, AppsFlyerConversionListener)' API method, which should be called on the Application's onCreate.");
            if (str == null) {
                onConversionDataFail = (onAppOpenAttribution + 111) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                if (appsFlyerRequestListener != null) {
                    appsFlyerRequestListener.onError(41, "No dev key");
                    return;
                }
                return;
            }
        }
        AFInAppEventType(context);
        final AFe1hSDK aFe1hSDKAfErrorLog = valueOf().afErrorLog();
        aFe1hSDKAfErrorLog.values(AFa1uSDK.AFKeystoreWrapper(context));
        this.onAppOpenAttributionNative = (Application) context.getApplicationContext();
        valueOf().afErrorLogForExcManagerOnly().AFInAppEventParameterName("start", str);
        String str2 = valueOf;
        AFLogger.afInfoLog(String.format("Starting AppsFlyer: (v%s.%s)", "6.12.3", str2));
        StringBuilder sb = new StringBuilder("Build Number: ");
        sb.append(str2);
        AFLogger.afInfoLog(sb.toString());
        AppsFlyerProperties.getInstance().loadProperties(valueOf().AFKeystoreWrapper());
        if (!TextUtils.isEmpty(str)) {
            int i5 = onAppOpenAttribution + 11;
            onConversionDataFail = i5 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i5 % 2 != 0) {
                valueOf().getLevel().values = str;
                AFc1sSDK.AFInAppEventParameterName(str);
                int i6 = 91 / 0;
            } else {
                valueOf().getLevel().values = str;
                AFc1sSDK.AFInAppEventParameterName(str);
            }
        } else if (TextUtils.isEmpty(valueOf().getLevel().values)) {
            int i7 = onConversionDataFail + 7;
            onAppOpenAttribution = i7 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i7 % 2 != 0) {
                AFLogger.afWarnLog("ERROR: AppsFlyer SDK is not initialized! You must provide AppsFlyer Dev-Key either in the 'init' API method (should be called on Application's onCreate),or in the start() API (should be called on Activity's onCreate).");
                if (appsFlyerRequestListener != null) {
                    appsFlyerRequestListener.onError(41, "No dev key");
                }
                onAppOpenAttribution = (onConversionDataFail + 123) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                return;
            }
            AFLogger.afWarnLog("ERROR: AppsFlyer SDK is not initialized! You must provide AppsFlyer Dev-Key either in the 'init' API method (should be called on Application's onCreate),or in the start() API (should be called on Activity's onCreate).");
            throw null;
        }
        valueOf().afInfoLog().valueOf((AFe1zSDK) null);
        afErrorLogForExcManagerOnly();
        AFLogger(this.onAppOpenAttributionNative.getBaseContext());
        if (this.onInstallConversionDataLoadedNative) {
            values(this.onAppOpenAttributionNative.getApplicationContext());
        }
        this.onDeepLinkingNative.onAttributionFailureNative().valueOf(context, new AFb1iSDK.AFa1vSDK() { // from class: com.appsflyer.internal.AFa1bSDK.5
            @Override // com.appsflyer.internal.AFb1iSDK.AFa1vSDK
            public final void AFInAppEventType(Activity activity) {
                aFe1hSDKAfErrorLog.AFKeystoreWrapper();
                AFa1bSDK.this.valueOf().afInfoLog().valueOf((AFe1zSDK) null);
                AFa1bSDK.values(AFa1bSDK.this);
                AFa1bSDK aFa1bSDK = AFa1bSDK.this;
                int iValues = aFa1bSDK.values(aFa1bSDK.AFKeystoreWrapper(activity), false);
                AFLogger.afInfoLog("onBecameForeground");
                if (iValues < 2) {
                    AFa1bSDK.this.valueOf().afRDLog().AFInAppEventType();
                }
                AFe1dSDK aFe1dSDK = new AFe1dSDK();
                if (activity != null) {
                    AFa1bSDK.this.valueOf().onInstallConversionDataLoadedNative().AFKeystoreWrapper(aFe1dSDK.AFKeystoreWrapper(), activity.getIntent(), activity.getApplication());
                }
                AFa1bSDK aFa1bSDK2 = AFa1bSDK.this;
                aFe1dSDK.AFKeystoreWrapper = appsFlyerRequestListener;
                aFa1bSDK2.AFInAppEventType(aFe1dSDK, activity);
            }

            @Override // com.appsflyer.internal.AFb1iSDK.AFa1vSDK
            public final void AFInAppEventType(Context context2) {
                AFLogger.afInfoLog("onBecameBackground");
                AFe1hSDK aFe1hSDK = aFe1hSDKAfErrorLog;
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j3 = aFe1hSDK.afDebugLog;
                if (j3 != 0) {
                    long j4 = jCurrentTimeMillis - j3;
                    if (j4 > 0 && j4 < 1000) {
                        j4 = 1000;
                    }
                    long seconds = TimeUnit.MILLISECONDS.toSeconds(j4);
                    aFe1hSDK.AFLogger$LogLevel = seconds;
                    aFe1hSDK.AFInAppEventType.AFInAppEventType("prev_session_dur", seconds);
                } else {
                    AFLogger.afInfoLog("Metrics: fg ts is missing");
                }
                AFLogger.afInfoLog("callStatsBackground background call");
                AFa1bSDK.this.valueOf().onResponseErrorNative().AFInAppEventType();
                AFb1ySDK aFb1ySDKAfErrorLogForExcManagerOnly = AFa1bSDK.this.valueOf().afErrorLogForExcManagerOnly();
                if (aFb1ySDKAfErrorLogForExcManagerOnly.afInfoLog()) {
                    aFb1ySDKAfErrorLogForExcManagerOnly.values();
                    if (context2 != null && !AppsFlyerLib.getInstance().isStopped()) {
                        aFb1ySDKAfErrorLogForExcManagerOnly.AFInAppEventType(context2.getPackageName(), context2.getPackageManager(), AFa1bSDK.this.valueOf());
                    }
                    aFb1ySDKAfErrorLogForExcManagerOnly.AFKeystoreWrapper();
                } else {
                    AFLogger.afDebugLog("RD status is OFF");
                }
                AFa1bSDK.this.valueOf().afRDLog().AFKeystoreWrapper();
            }
        });
        int i8 = onConversionDataFail + 125;
        onAppOpenAttribution = i8 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i8 % 2 == 0) {
            int i9 = 87 / 0;
        }
    }

    public final AFc1ySDK valueOf() {
        AFc1xSDK aFc1xSDK;
        int i3 = onConversionDataFail + 63;
        int i4 = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        onAppOpenAttribution = i4;
        if (i3 % 2 == 0) {
            aFc1xSDK = this.onDeepLinkingNative;
            int i5 = 46 / 0;
        } else {
            aFc1xSDK = this.onDeepLinkingNative;
        }
        onConversionDataFail = (i4 + 105) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        return aFc1xSDK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void AFInAppEventParameterName(AFf1lSDK aFf1lSDK) throws UnsupportedEncodingException {
        onAppOpenAttribution = (onConversionDataFail + 105) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        AFb1fSDK aFb1fSDKAFKeystoreWrapper = AFKeystoreWrapper(this.onAppOpenAttributionNative);
        int iValues = valueOf().AFInAppEventParameterName().valueOf.values("appsFlyerCount", 0);
        boolean zAFInAppEventType = aFb1fSDKAFKeystoreWrapper.AFInAppEventType(AppsFlyerProperties.NEW_REFERRER_SENT);
        boolean z2 = aFf1lSDK.afDebugLog == AFf1jSDK.AFa1vSDK.NOT_STARTED;
        if (iValues == 1) {
            onAppOpenAttribution = (onConversionDataFail + 107) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (z2 || zAFInAppEventType) {
                valueOf(new AFe1iSDK());
            }
        }
    }

    private Runnable AFKeystoreWrapper(final AFf1lSDK aFf1lSDK) {
        onAppOpenAttribution = (onConversionDataFail + 83) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        Runnable runnable = new Runnable() { // from class: com.appsflyer.internal.c
            @Override // java.lang.Runnable
            public final void run() throws UnsupportedEncodingException {
                this.f65634a.AFInAppEventParameterName(aFf1lSDK);
            }
        };
        onAppOpenAttribution = (onConversionDataFail + 9) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        return runnable;
    }

    private static void values(String str, String str2) {
        int i3 = onAppOpenAttribution + 7;
        onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            AppsFlyerProperties.getInstance().set(str, str2);
            throw null;
        }
        AppsFlyerProperties.getInstance().set(str, str2);
        int i4 = onAppOpenAttribution + 21;
        onConversionDataFail = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i4 % 2 != 0) {
            int i5 = 49 / 0;
        }
    }

    public final void valueOf(Context context, Intent intent) {
        AFf1eSDK aFf1eSDK = new AFf1eSDK(intent);
        if (aFf1eSDK.AFInAppEventParameterName("appsflyer_preinstall") != null) {
            int i3 = onConversionDataFail + 3;
            onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i3 % 2 == 0) {
                valueOf(aFf1eSDK.AFInAppEventParameterName("appsflyer_preinstall"));
                throw null;
            }
            valueOf(aFf1eSDK.AFInAppEventParameterName("appsflyer_preinstall"));
        }
        AFLogger.afInfoLog("****** onReceive called *******");
        AppsFlyerProperties.getInstance();
        String strAFInAppEventParameterName = aFf1eSDK.AFInAppEventParameterName("referrer");
        AFLogger.afInfoLog("Play store referrer: ".concat(String.valueOf(strAFInAppEventParameterName)));
        if (strAFInAppEventParameterName != null) {
            onAppOpenAttribution = (onConversionDataFail + 95) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            AFKeystoreWrapper(context).values("referrer", strAFInAppEventParameterName);
            AppsFlyerProperties appsFlyerProperties = AppsFlyerProperties.getInstance();
            appsFlyerProperties.set("AF_REFERRER", strAFInAppEventParameterName);
            appsFlyerProperties.AFKeystoreWrapper = strAFInAppEventParameterName;
            if (AppsFlyerProperties.getInstance().AFInAppEventParameterName()) {
                AFLogger.afInfoLog("onReceive: isLaunchCalled");
                values(context, AFe1fSDK.onReceive);
                AFInAppEventType(context, strAFInAppEventParameterName);
            }
        }
    }

    private String AFKeystoreWrapper(Context context, String str) {
        int i3 = (onAppOpenAttribution + 71) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        onConversionDataFail = i3;
        if (context != null) {
            AFInAppEventType(context);
            return valueOf().AFInAppEventParameterName().AFInAppEventParameterName(str);
        }
        int i4 = i3 + 123;
        onAppOpenAttribution = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i4 % 2 != 0) {
            return null;
        }
        throw null;
    }

    private static void values(String str, boolean z2) {
        onAppOpenAttribution = (onConversionDataFail + 17) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        AppsFlyerProperties.getInstance().set(str, z2);
        int i3 = onConversionDataFail + 93;
        onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            int i4 = 22 / 0;
        }
    }

    private static void AFInAppEventType(JSONObject jSONObject) {
        String str;
        ArrayList arrayList = new ArrayList();
        Iterator<String> itKeys = jSONObject.keys();
        while (true) {
            if (!itKeys.hasNext()) {
                break;
            }
            try {
                JSONArray jSONArray = new JSONArray((String) jSONObject.get(itKeys.next()));
                onAppOpenAttribution = (onConversionDataFail + 109) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    onConversionDataFail = (onAppOpenAttribution + 31) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                    arrayList.add(Long.valueOf(jSONArray.getLong(i3)));
                }
            } catch (JSONException e3) {
                AFLogger.afErrorLogForExcManagerOnly("error at timeStampArr", e3);
            }
        }
        Collections.sort(arrayList);
        Iterator<String> itKeys2 = jSONObject.keys();
        onAppOpenAttribution = (onConversionDataFail + 73) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        loop2: while (true) {
            str = null;
            while (itKeys2.hasNext()) {
                onAppOpenAttribution = (onConversionDataFail + 41) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                if (str != null) {
                    break loop2;
                }
                String next = itKeys2.next();
                try {
                    JSONArray jSONArray2 = new JSONArray((String) jSONObject.get(next));
                    int i4 = 0;
                    while (i4 < jSONArray2.length()) {
                        if (jSONArray2.getLong(i4) == ((Long) arrayList.get(0)).longValue() || jSONArray2.getLong(i4) == ((Long) arrayList.get(1)).longValue() || jSONArray2.getLong(i4) == ((Long) arrayList.get(arrayList.size() - 1)).longValue()) {
                            break;
                        }
                        i4++;
                        str = next;
                    }
                } catch (JSONException e4) {
                    AFLogger.afErrorLogForExcManagerOnly("error at manageExtraReferrers", e4);
                }
            }
        }
        if (str != null) {
            jSONObject.remove(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003a A[PHI: r0 r4
      0x003a: PHI (r0v5 com.appsflyer.internal.AFe1hSDK) = (r0v4 com.appsflyer.internal.AFe1hSDK), (r0v8 com.appsflyer.internal.AFe1hSDK) binds: [B:8:0x0038, B:5:0x0022] A[DONT_GENERATE, DONT_INLINE]
      0x003a: PHI (r4v2 com.appsflyer.internal.AFe1kSDK) = (r4v1 com.appsflyer.internal.AFe1kSDK), (r4v6 com.appsflyer.internal.AFe1kSDK) binds: [B:8:0x0038, B:5:0x0022] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void values(android.content.Context r4, com.appsflyer.internal.AFe1fSDK r5) {
        /*
            r3 = this;
            int r0 = com.appsflyer.internal.AFa1bSDK.onConversionDataFail
            int r0 = r0 + 15
            int r1 = r0 % 128
            com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L25
            r3.AFInAppEventType(r4)
            com.appsflyer.internal.AFc1ySDK r0 = r3.valueOf()
            com.appsflyer.internal.AFe1hSDK r0 = r0.afErrorLog()
            com.appsflyer.internal.AFe1kSDK r4 = com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper(r4)
            boolean r1 = r0.AFInAppEventType()
            r2 = 6
            int r2 = r2 / 0
            if (r1 == 0) goto L50
            goto L3a
        L25:
            r3.AFInAppEventType(r4)
            com.appsflyer.internal.AFc1ySDK r0 = r3.valueOf()
            com.appsflyer.internal.AFe1hSDK r0 = r0.afErrorLog()
            com.appsflyer.internal.AFe1kSDK r4 = com.appsflyer.internal.AFa1uSDK.AFKeystoreWrapper(r4)
            boolean r1 = r0.AFInAppEventType()
            if (r1 == 0) goto L50
        L3a:
            java.util.Map<java.lang.String, java.lang.Object> r1 = r0.AFInAppEventParameterName
            java.lang.String r2 = "api_name"
            java.lang.String r5 = r5.toString()
            r1.put(r2, r5)
            r0.values(r4)
            int r4 = com.appsflyer.internal.AFa1bSDK.onConversionDataFail
            int r4 = r4 + 105
            int r4 = r4 % 128
            com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution = r4
        L50:
            r0.AFKeystoreWrapper()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1bSDK.values(android.content.Context, com.appsflyer.internal.AFe1fSDK):void");
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setUserEmails(AppsFlyerProperties.EmailsCryptType emailsCryptType, String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length + 1);
        arrayList.add(emailsCryptType.toString());
        arrayList.addAll(Arrays.asList(strArr));
        valueOf().afErrorLogForExcManagerOnly().AFInAppEventParameterName("setUserEmails", (String[]) arrayList.toArray(new String[strArr.length + 1]));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EMAIL_CRYPT_TYPE, emailsCryptType.getValue());
        HashMap map = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        int length = strArr.length;
        String str = null;
        int i3 = 0;
        while (i3 < length) {
            onAppOpenAttribution = (onConversionDataFail + 121) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            String str2 = strArr[i3];
            if (AnonymousClass1.AFInAppEventType[emailsCryptType.ordinal()] != 2) {
                arrayList2.add(AFc1rSDK.values(str2));
                str = "sha256_el_arr";
            } else {
                arrayList2.add(str2);
                str = "plain_el_arr";
            }
            i3++;
            onConversionDataFail = (onAppOpenAttribution + 99) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        map.put(str, arrayList2);
        AppsFlyerProperties.getInstance().setUserEmails(new JSONObject(map).toString());
    }

    public final AFb1fSDK AFKeystoreWrapper(Context context) {
        int i3 = onConversionDataFail + 113;
        onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            AFInAppEventType(context);
            AFb1fSDK aFb1fSDKAFKeystoreWrapper = valueOf().AFKeystoreWrapper();
            onConversionDataFail = (onAppOpenAttribution + 41) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            return aFb1fSDKAFKeystoreWrapper;
        }
        AFInAppEventType(context);
        valueOf().AFKeystoreWrapper();
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void AFInAppEventParameterName(android.content.Context r3, java.util.Map<java.lang.String, java.lang.Object> r4, com.appsflyer.internal.AFa1tSDK r5) {
        /*
            r2 = this;
            int r0 = com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution
            int r0 = r0 + 117
            int r1 = r0 % 128
            com.appsflyer.internal.AFa1bSDK.onConversionDataFail = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L1b
            r2.AFInAppEventType(r3)
            r5.valueOf(r4)
            boolean r4 = r3 instanceof android.app.Activity
            r0 = 90
            int r0 = r0 / 0
            if (r4 == 0) goto L28
            goto L25
        L1b:
            r2.AFInAppEventType(r3)
            r5.valueOf(r4)
            boolean r4 = r3 instanceof android.app.Activity
            if (r4 == 0) goto L28
        L25:
            android.app.Activity r3 = (android.app.Activity) r3
            goto L29
        L28:
            r3 = 0
        L29:
            r2.AFInAppEventType(r5, r3)
            int r3 = com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution
            int r3 = r3 + 91
            int r3 = r3 % 128
            com.appsflyer.internal.AFa1bSDK.onConversionDataFail = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1bSDK.AFInAppEventParameterName(android.content.Context, java.util.Map, com.appsflyer.internal.AFa1tSDK):void");
    }

    private boolean AFLogger() {
        int i3 = onConversionDataFail;
        int i4 = i3 + 37;
        onAppOpenAttribution = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i4 % 2 == 0) {
            throw null;
        }
        Map<String, Object> map = this.init;
        if (map == null) {
            return false;
        }
        onAppOpenAttribution = (i3 + 9) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (map.isEmpty()) {
            return false;
        }
        onConversionDataFail = (onAppOpenAttribution + 35) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        return true;
    }

    private int AFKeystoreWrapper(AFb1fSDK aFb1fSDK, boolean z2) {
        int i3 = onConversionDataFail + 15;
        onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            return AFInAppEventType(aFb1fSDK, "appsFlyerInAppEventCount", z2);
        }
        AFInAppEventType(aFb1fSDK, "appsFlyerInAppEventCount", z2);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String afDebugLog(Context context) {
        onConversionDataFail = (onAppOpenAttribution + 59) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        String attributionId = getAttributionId(context);
        int i3 = onAppOpenAttribution + 105;
        onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            return attributionId;
        }
        throw null;
    }

    private void values(AppsFlyerConversionListener appsFlyerConversionListener) {
        int i3 = onConversionDataFail + 41;
        onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            throw null;
        }
        if (appsFlyerConversionListener == null) {
            return;
        }
        this.AFKeystoreWrapper = appsFlyerConversionListener;
        int i4 = onConversionDataFail + 27;
        onAppOpenAttribution = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i4 % 2 == 0) {
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void AFInAppEventParameterName(android.content.Context r3, java.lang.String r4, java.util.Map<java.lang.String, java.lang.Object> r5, java.lang.String r6, java.lang.String r7) {
        /*
            r2 = this;
            if (r4 == 0) goto L28
            int r0 = com.appsflyer.internal.AFa1bSDK.onConversionDataFail
            int r0 = r0 + 11
            int r1 = r0 % 128
            com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L1f
            java.lang.String r0 = r4.trim()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L19
            goto L28
        L19:
            com.appsflyer.internal.AFe1cSDK r0 = new com.appsflyer.internal.AFe1cSDK
            r0.<init>()
            goto L35
        L1f:
            java.lang.String r3 = r4.trim()
            r3.isEmpty()
            r3 = 0
            throw r3
        L28:
            com.appsflyer.internal.AFe1dSDK r0 = new com.appsflyer.internal.AFe1dSDK
            r0.<init>()
            int r1 = com.appsflyer.internal.AFa1bSDK.onConversionDataFail
            int r1 = r1 + 13
            int r1 = r1 % 128
            com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution = r1
        L35:
            r2.AFInAppEventType(r3)
            r0.afErrorLog = r4
            r0.AFInAppEventType = r5
            r0.afRDLog = r6
            r0.AFInAppEventParameterName = r7
            r2.AFInAppEventParameterName(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1bSDK.AFInAppEventParameterName(android.content.Context, java.lang.String, java.util.Map, java.lang.String, java.lang.String):void");
    }

    final Map<String, Object> values(AFa1tSDK aFa1tSDK) throws UnsupportedEncodingException {
        final Context context = valueOf().afWarnLog().values;
        AFb1fSDK aFb1fSDKAFKeystoreWrapper = AFKeystoreWrapper(context);
        AFe1rSDK aFe1rSDKAFLogger = valueOf().AFLogger();
        boolean zAFInAppEventParameterName = aFa1tSDK.AFInAppEventParameterName();
        Map<String, Object> map = aFa1tSDK.values;
        AFa1eSDK.AFInAppEventType(context, map);
        Boolean bool = AFa1eSDK.AFInAppEventParameterName;
        if (bool != null) {
            onAppOpenAttribution = (onConversionDataFail + 59) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (!bool.booleanValue()) {
                AFInAppEventParameterName(map).put("ad_ids_disabled", Boolean.TRUE);
            }
        }
        long time = new Date().getTime();
        Object[] objArr = new Object[1];
        AFInAppEventType(null, "\u0089\u0086\u0081\u0084\u0088\u0087\u0086\u0085\u0084\u0083\u0082\u0081", null, TextUtils.lastIndexOf("", '0', 0, 0) + ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, objArr);
        map.put(((String) objArr[0]).intern(), Long.toString(time));
        try {
            if (!isStopped()) {
                StringBuilder sb = new StringBuilder("******* sendTrackingWithEvent: ");
                sb.append(zAFInAppEventParameterName ? "Launch" : aFa1tSDK.afErrorLog);
                AFLogger.afInfoLog(sb.toString());
            } else {
                AFLogger.afInfoLog("Reporting has been stopped");
            }
            valueOf().AppsFlyer2dXConversionCallback().AFInAppEventParameterName();
            afErrorLog(context);
            AppsFlyerProperties appsFlyerProperties = AppsFlyerProperties.getInstance();
            String str = valueOf().getLevel().values;
            if (str != null) {
                onConversionDataFail = (onAppOpenAttribution + 39) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                if (str.length() != 0) {
                    aFe1rSDKAFLogger.AFInAppEventParameterName(aFa1tSDK, this.onInstallConversionFailureNative, this.onResponseErrorNative);
                    aFe1rSDKAFLogger.AFKeystoreWrapper(map, this.afDebugLog);
                    aFe1rSDKAFLogger.AFKeystoreWrapper(map, isPreInstalledApp(context), new Function0() { // from class: com.appsflyer.internal.a
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return this.f65631a.afDebugLog(context);
                        }
                    });
                    if (zAFInAppEventParameterName) {
                        aFe1rSDKAFLogger.AFInAppEventParameterName(map, this.AFVersionDeclaration);
                        this.AFVersionDeclaration = null;
                        aFe1rSDKAFLogger.AFInAppEventParameterName(aFa1tSDK);
                    }
                    aFe1rSDKAFLogger.AFKeystoreWrapper(map);
                    int iValues = values(aFb1fSDKAFKeystoreWrapper, zAFInAppEventParameterName);
                    int iAFKeystoreWrapper = AFKeystoreWrapper(aFb1fSDKAFKeystoreWrapper, aFa1tSDK.afErrorLog != null);
                    if (zAFInAppEventParameterName && iValues == 1) {
                        appsFlyerProperties.values = true;
                    }
                    aFe1rSDKAFLogger.values(map, iValues, iAFKeystoreWrapper);
                    aFe1rSDKAFLogger.AFInAppEventType(aFa1tSDK, iValues, this.afRDLog);
                    return map;
                }
            }
            AFLogger.afInfoLog("AppsFlyer dev key is missing!!! Please use  AppsFlyerLib.getInstance().setAppsFlyerKey(...) to set it. ");
            AFLogger.afInfoLog("AppsFlyer will not track this event.");
            onAppOpenAttribution = (onConversionDataFail + 101) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            return null;
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getLocalizedMessage(), th, true);
            return map;
        }
    }

    public final void valueOf(Context context, String str) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONObject jSONObject;
        int i3 = onConversionDataFail + 65;
        onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        try {
            try {
                if (i3 % 2 != 0) {
                    AFLogger.afDebugLog("received a new (extra) referrer: ".concat(String.valueOf(str)));
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    String strAFKeystoreWrapper = AFKeystoreWrapper(context).AFKeystoreWrapper("extraReferrers", null);
                    if (strAFKeystoreWrapper == null) {
                        jSONObject = new JSONObject();
                        jSONArray2 = new JSONArray();
                    } else {
                        JSONObject jSONObject2 = new JSONObject(strAFKeystoreWrapper);
                        if (jSONObject2.has(str)) {
                            jSONArray = new JSONArray((String) jSONObject2.get(str));
                        } else {
                            jSONArray = new JSONArray();
                        }
                        jSONArray2 = jSONArray;
                        jSONObject = jSONObject2;
                    }
                    if (jSONArray2.length() < 5) {
                        int i4 = onAppOpenAttribution + 105;
                        onConversionDataFail = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        if (i4 % 2 != 0) {
                            jSONArray2.put(jCurrentTimeMillis);
                            int i5 = 79 / 0;
                        } else {
                            jSONArray2.put(jCurrentTimeMillis);
                        }
                    }
                    if (jSONObject.length() >= 4) {
                        onConversionDataFail = (onAppOpenAttribution + 75) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        AFInAppEventType(jSONObject);
                    }
                    jSONObject.put(str, jSONArray2.toString());
                    AFKeystoreWrapper(context).values("extraReferrers", jSONObject.toString());
                    return;
                }
                AFLogger.afDebugLog("received a new (extra) referrer: ".concat(String.valueOf(str)));
                System.currentTimeMillis();
                AFKeystoreWrapper(context).AFKeystoreWrapper("extraReferrers", null);
                throw null;
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder("Couldn't save referrer - ");
                sb.append(str);
                sb.append(": ");
                AFLogger.afErrorLog(sb.toString(), th);
            }
        } catch (JSONException e3) {
            AFLogger.afErrorLogForExcManagerOnly("error at addReferrer", e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void AFInAppEventType(AFc1ySDK aFc1ySDK) {
        onAppOpenAttribution = (onConversionDataFail + 57) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        aFc1ySDK.AppsFlyer2dXConversionCallback().values();
        int i3 = onAppOpenAttribution + 45;
        onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            throw null;
        }
    }

    private static boolean AFInAppEventType(String str) {
        onConversionDataFail = (onAppOpenAttribution + 97) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        boolean z2 = AppsFlyerProperties.getInstance().getBoolean(str, false);
        int i3 = onConversionDataFail + 15;
        onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            int i4 = 42 / 0;
        }
        return z2;
    }

    public static Map<String, Object> AFInAppEventParameterName(Map<String, Object> map) {
        Map<String, Object> map2;
        if (map.containsKey("meta")) {
            onConversionDataFail = (onAppOpenAttribution + 91) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            map2 = (Map) map.get("meta");
        } else {
            HashMap map3 = new HashMap();
            map.put("meta", map3);
            map2 = map3;
        }
        onConversionDataFail = (onAppOpenAttribution + 89) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        return map2;
    }

    public static String AFInAppEventType() {
        String strAFKeystoreWrapper;
        int i3 = onConversionDataFail + 15;
        onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            strAFKeystoreWrapper = AFKeystoreWrapper(AppsFlyerProperties.APP_USER_ID);
            int i4 = 2 / 0;
        } else {
            strAFKeystoreWrapper = AFKeystoreWrapper(AppsFlyerProperties.APP_USER_ID);
        }
        onConversionDataFail = (onAppOpenAttribution + 17) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        return strAFKeystoreWrapper;
    }

    private void AFInAppEventType(Context context, String str, Map<String, Object> map) {
        Activity activity;
        AFe1cSDK aFe1cSDK = new AFe1cSDK();
        aFe1cSDK.afErrorLog = str;
        aFe1cSDK.AFInAppEventType = map;
        if (context instanceof Activity) {
            activity = (Activity) context;
            onConversionDataFail = (onAppOpenAttribution + 123) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            activity = null;
        }
        AFInAppEventType(aFe1cSDK, activity);
        onAppOpenAttribution = (onConversionDataFail + 71) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    private int AFInAppEventParameterName(AFb1fSDK aFb1fSDK) {
        onConversionDataFail = (onAppOpenAttribution + 101) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        int iAFInAppEventType = AFInAppEventType(aFb1fSDK, "appsFlyerAdRevenueCount", true);
        onAppOpenAttribution = (onConversionDataFail + 61) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        return iAFInAppEventType;
    }

    private static String AFInAppEventParameterName(String str) {
        onConversionDataFail = (onAppOpenAttribution + 75) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        int iIndexOf = str.indexOf(63);
        if (iIndexOf != -1) {
            return str.substring(iIndexOf);
        }
        int i3 = (onConversionDataFail + 1) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        onAppOpenAttribution = i3;
        onConversionDataFail = (i3 + 17) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        return "";
    }

    final void AFInAppEventType(AFa1tSDK aFa1tSDK, Activity activity) {
        int i3;
        AFInAppEventParameterName(aFa1tSDK, activity);
        if (valueOf().getLevel().values == null) {
            int i4 = onAppOpenAttribution + 71;
            onConversionDataFail = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i4 % 2 == 0) {
                AFLogger.afWarnLog("[LogEvent/Launch] AppsFlyer's SDK cannot send any event without providing DevKey.");
                AppsFlyerRequestListener appsFlyerRequestListener = aFa1tSDK.AFKeystoreWrapper;
                if (appsFlyerRequestListener != null) {
                    appsFlyerRequestListener.onError(41, "No dev key");
                }
                int i5 = onAppOpenAttribution + 19;
                onConversionDataFail = i5 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                if (i5 % 2 == 0) {
                    return;
                } else {
                    i3 = 24;
                }
            } else {
                AFLogger.afWarnLog("[LogEvent/Launch] AppsFlyer's SDK cannot send any event without providing DevKey.");
                AppsFlyerRequestListener appsFlyerRequestListener2 = aFa1tSDK.AFKeystoreWrapper;
                throw null;
            }
        } else {
            String referrer = AppsFlyerProperties.getInstance().getReferrer(valueOf().AFKeystoreWrapper());
            if (referrer == null) {
                referrer = "";
            }
            aFa1tSDK.afRDLog = referrer;
            AFInAppEventParameterName(aFa1tSDK);
            int i6 = onConversionDataFail + 125;
            onAppOpenAttribution = i6 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i6 % 2 != 0) {
                return;
            } else {
                i3 = 88;
            }
        }
        int i7 = i3 / 0;
    }

    public static boolean AFInAppEventParameterName(Context context) {
        onConversionDataFail = (onAppOpenAttribution + 45) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        try {
        } catch (Throwable th) {
            AFLogger.afErrorLog("WARNING:  Google play services is unavailable. ", th);
        }
        if (GoogleApiAvailability.q().i(context) == 0) {
            return true;
        }
        onConversionDataFail = (onAppOpenAttribution + 29) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        try {
            context.getPackageManager().getPackageInfo("com.google.android.gms", 0);
            return true;
        } catch (PackageManager.NameNotFoundException e3) {
            AFLogger.afErrorLog("WARNING:  Google Play Services is unavailable. ", e3);
            return false;
        }
    }

    private void AFInAppEventParameterName(AFa1tSDK aFa1tSDK, Activity activity) {
        onConversionDataFail = (onAppOpenAttribution + 89) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        AFf1rSDK aFf1rSDKInit = valueOf().init();
        aFa1tSDK.AFInAppEventParameterName = aFf1rSDKInit.AFKeystoreWrapper(activity);
        aFa1tSDK.afDebugLog = aFf1rSDKInit.valueOf(activity);
        onConversionDataFail = (onAppOpenAttribution + 71) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    public static String valueOf(SimpleDateFormat simpleDateFormat, long j3) {
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String str = simpleDateFormat.format(new Date(j3));
        int i3 = onAppOpenAttribution + 15;
        onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            return str;
        }
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void valueOf(com.appsflyer.internal.AFa1tSDK r14) throws java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instruction units count: 555
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1bSDK.valueOf(com.appsflyer.internal.AFa1tSDK):void");
    }

    private void AFInAppEventParameterName(AFa1tSDK aFa1tSDK) {
        boolean z2;
        byte b3 = 0;
        if (aFa1tSDK.afErrorLog == null) {
            onAppOpenAttribution = (onConversionDataFail + 9) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            z2 = true;
        } else {
            z2 = false;
        }
        if (AFKeystoreWrapper()) {
            onConversionDataFail = (onAppOpenAttribution + 15) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            AFLogger.afInfoLog("CustomerUserId not set, reporting is disabled", true);
            return;
        }
        if (z2) {
            if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.LAUNCH_PROTECT_ENABLED, true)) {
                int i3 = onAppOpenAttribution + 33;
                onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                if (i3 % 2 == 0) {
                    if (afRDLog()) {
                        AppsFlyerRequestListener appsFlyerRequestListener = aFa1tSDK.AFKeystoreWrapper;
                        if (appsFlyerRequestListener != null) {
                            int i4 = onConversionDataFail + 47;
                            onAppOpenAttribution = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                            if (i4 % 2 == 0) {
                                appsFlyerRequestListener.onError(114, "Event timeout. Check 'minTimeBetweenSessions' param");
                                return;
                            } else {
                                appsFlyerRequestListener.onError(10, "Event timeout. Check 'minTimeBetweenSessions' param");
                                return;
                            }
                        }
                        return;
                    }
                } else {
                    afRDLog();
                    throw null;
                }
            } else {
                AFLogger.afInfoLog("Allowing multiple launches within a 5 second time window.");
            }
            this.AFLogger = System.currentTimeMillis();
        }
        values(valueOf().values(), new AFa1wSDK(this, aFa1tSDK, b3), 0L, TimeUnit.MILLISECONDS);
    }

    private void AFInAppEventType(Context context, String str) {
        byte b3 = 0;
        AFa1tSDK aFa1tSDKValues = new AFe1eSDK().values(valueOf().AFInAppEventParameterName().valueOf.values("appsFlyerCount", 0));
        aFa1tSDKValues.afRDLog = str;
        if (str != null) {
            int i3 = onAppOpenAttribution + 27;
            onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i3 % 2 != 0) {
                if (str.length() <= 2) {
                    return;
                }
            } else if (str.length() <= 5) {
                return;
            }
            onAppOpenAttribution = (onConversionDataFail + 123) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (valueOf(aFa1tSDKValues, AFKeystoreWrapper(context))) {
                values(valueOf().values(), new AFa1wSDK(this, aFa1tSDKValues, b3), 5L, TimeUnit.MILLISECONDS);
            }
        }
    }

    private int values(AFb1fSDK aFb1fSDK) {
        int i3 = onConversionDataFail + 17;
        onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        int iAFInAppEventType = AFInAppEventType(aFb1fSDK, "appsFlyerAdImpressionCount", i3 % 2 != 0);
        int i4 = onAppOpenAttribution + 77;
        onConversionDataFail = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i4 % 2 == 0) {
            return iAFInAppEventType;
        }
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:
    
        if (r9.matches("fb\\d*?://authorize.*") == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        r0 = com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution + 27;
        com.appsflyer.internal.AFa1bSDK.onConversionDataFail = r0 % com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:
    
        if ((r0 % 2) != 0) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0037, code lost:
    
        if (r9.contains("access_token") == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
    
        r0 = AFInAppEventParameterName(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0041, code lost:
    
        if (r0.length() != 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0043, code lost:
    
        return r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0044, code lost:
    
        r3 = new java.util.ArrayList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
    
        if (r0.contains("&") == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0051, code lost:
    
        r3 = new java.util.ArrayList(java.util.Arrays.asList(r0.split("&")));
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005f, code lost:
    
        r3.add(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0062, code lost:
    
        r5 = new java.lang.StringBuilder();
        r3 = r3.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006f, code lost:
    
        if (r3.hasNext() == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0071, code lost:
    
        r6 = com.appsflyer.internal.AFa1bSDK.onConversionDataFail + 99;
        com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution = r6 % com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007b, code lost:
    
        if ((r6 % 2) == 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007d, code lost:
    
        r6 = (java.lang.String) r3.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0087, code lost:
    
        if (r6.contains("access_token") == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0089, code lost:
    
        r3.remove();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0091, code lost:
    
        if (r5.length() == 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0093, code lost:
    
        com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution = (com.appsflyer.internal.AFa1bSDK.onConversionDataFail + 95) % com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        r5.append("&");
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009f, code lost:
    
        r7 = androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy.bkP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a6, code lost:
    
        if (r6.startsWith(r7) != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a8, code lost:
    
        r5.append(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ab, code lost:
    
        r5.append(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00af, code lost:
    
        ((java.lang.String) r3.next()).contains("access_token");
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b8, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c1, code lost:
    
        return r9.replace(r0, r5.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c2, code lost:
    
        r9.contains("access_token");
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c5, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c6, code lost:
    
        return r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0011, code lost:
    
        if (r9 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0014, code lost:
    
        if (r9 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0016, code lost:
    
        com.appsflyer.internal.AFa1bSDK.onConversionDataFail = (r0 + 15) % com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001c, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String values(java.lang.String r9) {
        /*
            int r0 = com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution
            int r1 = r0 + 97
            int r2 = r1 % 128
            com.appsflyer.internal.AFa1bSDK.onConversionDataFail = r2
            int r1 = r1 % 2
            r2 = 0
            if (r1 == 0) goto L14
            r1 = 51
            int r1 = r1 / 0
            if (r9 != 0) goto L1d
            goto L16
        L14:
            if (r9 != 0) goto L1d
        L16:
            int r0 = r0 + 15
            int r0 = r0 % 128
            com.appsflyer.internal.AFa1bSDK.onConversionDataFail = r0
            return r2
        L1d:
            java.lang.String r0 = "fb\\d*?://authorize.*"
            boolean r0 = r9.matches(r0)
            if (r0 == 0) goto Lc6
            int r0 = com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution
            int r0 = r0 + 27
            int r1 = r0 % 128
            com.appsflyer.internal.AFa1bSDK.onConversionDataFail = r1
            int r0 = r0 % 2
            java.lang.String r1 = "access_token"
            if (r0 != 0) goto Lc2
            boolean r0 = r9.contains(r1)
            if (r0 == 0) goto Lc6
            java.lang.String r0 = AFInAppEventParameterName(r9)
            int r3 = r0.length()
            if (r3 != 0) goto L44
            return r9
        L44:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.lang.String r4 = "&"
            boolean r5 = r0.contains(r4)
            if (r5 == 0) goto L5f
            java.util.ArrayList r3 = new java.util.ArrayList
            java.lang.String[] r5 = r0.split(r4)
            java.util.List r5 = java.util.Arrays.asList(r5)
            r3.<init>(r5)
            goto L62
        L5f:
            r3.add(r0)
        L62:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.util.Iterator r3 = r3.iterator()
        L6b:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto Lb9
            int r6 = com.appsflyer.internal.AFa1bSDK.onConversionDataFail
            int r6 = r6 + 99
            int r7 = r6 % 128
            com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution = r7
            int r6 = r6 % 2
            if (r6 == 0) goto Laf
            java.lang.Object r6 = r3.next()
            java.lang.String r6 = (java.lang.String) r6
            boolean r7 = r6.contains(r1)
            if (r7 == 0) goto L8d
            r3.remove()
            goto L6b
        L8d:
            int r7 = r5.length()
            if (r7 == 0) goto L9f
            int r7 = com.appsflyer.internal.AFa1bSDK.onConversionDataFail
            int r7 = r7 + 95
            int r7 = r7 % 128
            com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution = r7
            r5.append(r4)
            goto Lab
        L9f:
            r7 = 0
            java.lang.String r7 = androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy.bkP
            boolean r8 = r6.startsWith(r7)
            if (r8 != 0) goto Lab
            r5.append(r7)
        Lab:
            r5.append(r6)
            goto L6b
        Laf:
            java.lang.Object r9 = r3.next()
            java.lang.String r9 = (java.lang.String) r9
            r9.contains(r1)
            throw r2
        Lb9:
            java.lang.String r1 = r5.toString()
            java.lang.String r9 = r9.replace(r0, r1)
            return r9
        Lc2:
            r9.contains(r1)
            throw r2
        Lc6:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1bSDK.values(java.lang.String):java.lang.String");
    }

    private void AFInAppEventType(Map<String, Object> map) {
        int i3 = onAppOpenAttribution + 9;
        onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0 ? !AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false) : !AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, true)) {
            if (!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false) && map.get("advertiserId") != null) {
                try {
                    if (AFb1tSDK.AFKeystoreWrapper(this.afRDLog) && map.remove("android_id") != null) {
                        AFLogger.afInfoLog("validateGaidAndIMEI :: removing: android_id");
                        onConversionDataFail = (onAppOpenAttribution + 61) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                    }
                    if (!AFb1tSDK.AFKeystoreWrapper(valueOf().getLevel().AFLogger) || map.remove("imei") == null) {
                        return;
                    }
                    int i4 = onConversionDataFail + 41;
                    onAppOpenAttribution = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                    if (i4 % 2 != 0) {
                        AFLogger.afInfoLog("validateGaidAndIMEI :: removing: imei");
                        return;
                    } else {
                        AFLogger.afInfoLog("validateGaidAndIMEI :: removing: imei");
                        throw null;
                    }
                } catch (Exception e3) {
                    AFLogger.afErrorLog("failed to remove IMEI or AndroidID key from params; ", e3);
                }
            }
        }
        int i5 = onAppOpenAttribution + 123;
        onConversionDataFail = i5 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i5 % 2 != 0) {
            int i6 = 43 / 0;
        }
    }

    private static String AFInAppEventType(Activity activity) {
        String string = null;
        if (activity != null) {
            int i3 = onConversionDataFail + 37;
            onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i3 % 2 != 0) {
                Intent intent = activity.getIntent();
                if (intent != null) {
                    int i4 = onAppOpenAttribution + 1;
                    onConversionDataFail = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                    try {
                        if (i4 % 2 == 0) {
                            Bundle extras = intent.getExtras();
                            if (extras != null && (string = extras.getString("af")) != null) {
                                int i5 = onConversionDataFail + 99;
                                onAppOpenAttribution = i5 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                                if (i5 % 2 == 0) {
                                    AFLogger.afInfoLog("Push Notification received af payload = ".concat(string));
                                    extras.remove("af");
                                    activity.setIntent(intent.putExtras(extras));
                                    int i6 = 77 / 0;
                                } else {
                                    AFLogger.afInfoLog("Push Notification received af payload = ".concat(string));
                                    extras.remove("af");
                                    activity.setIntent(intent.putExtras(extras));
                                }
                            }
                        } else {
                            intent.getExtras();
                            throw null;
                        }
                    } catch (Throwable th) {
                        AFLogger.afErrorLog(th.getMessage(), th);
                    }
                }
            } else {
                activity.getIntent();
                throw null;
            }
        }
        onAppOpenAttribution = (onConversionDataFail + 5) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        return string;
    }

    public static String values(AFb1fSDK aFb1fSDK, String str) {
        int i3 = onConversionDataFail + 9;
        onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            String strAFKeystoreWrapper = aFb1fSDK.AFKeystoreWrapper("CACHED_CHANNEL", null);
            if (strAFKeystoreWrapper != null) {
                int i4 = onAppOpenAttribution + 77;
                onConversionDataFail = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                if (i4 % 2 == 0) {
                    return strAFKeystoreWrapper;
                }
                throw null;
            }
            aFb1fSDK.values("CACHED_CHANNEL", str);
            return str;
        }
        aFb1fSDK.AFKeystoreWrapper("CACHED_CHANNEL", null);
        throw null;
    }

    public final int values(AFb1fSDK aFb1fSDK, boolean z2) {
        int i3 = onAppOpenAttribution + 43;
        onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        int i4 = i3 % 2;
        int iAFInAppEventType = AFInAppEventType(aFb1fSDK, "appsFlyerCount", z2);
        if (i4 != 0) {
            int i5 = 94 / 0;
        }
        return iAFInAppEventType;
    }

    private static void values(ScheduledExecutorService scheduledExecutorService, Runnable runnable, long j3, TimeUnit timeUnit) {
        int i3 = onConversionDataFail + 53;
        onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        try {
            try {
                if (i3 % 2 != 0) {
                    scheduledExecutorService.schedule(runnable, j3, timeUnit);
                } else {
                    scheduledExecutorService.schedule(runnable, j3, timeUnit);
                    throw null;
                }
            } catch (RejectedExecutionException e3) {
                AFLogger.afErrorLog("scheduleJob failed with RejectedExecutionException Exception", e3);
            }
        } catch (Throwable th) {
            AFLogger.afErrorLog("scheduleJob failed with Exception", th);
        }
    }

    private void values(Context context) {
        this.init = new HashMap();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        final AFa1sSDK.AFa1zSDK aFa1zSDK = new AFa1sSDK.AFa1zSDK() { // from class: com.appsflyer.internal.AFa1bSDK.2
            @Override // com.appsflyer.internal.AFa1sSDK.AFa1zSDK
            public final void AFInAppEventType(String str) {
                AFa1bSDK.valueOf(AFa1bSDK.this).put("error", str);
            }

            @Override // com.appsflyer.internal.AFa1sSDK.AFa1zSDK
            public final void values(String str, String str2, String str3) {
                if (str != null) {
                    AFLogger.afInfoLog("Facebook Deferred AppLink data received: ".concat(str));
                    AFa1bSDK.valueOf(AFa1bSDK.this).put("link", str);
                    if (str2 != null) {
                        AFa1bSDK.valueOf(AFa1bSDK.this).put("target_url", str2);
                    }
                    if (str3 != null) {
                        HashMap map = new HashMap();
                        HashMap map2 = new HashMap();
                        map2.put(ShareConstants.PROMO_CODE, str3);
                        map.put(ShareConstants.DEEPLINK_CONTEXT, map2);
                        AFa1bSDK.valueOf(AFa1bSDK.this).put("extras", map);
                    }
                } else {
                    AFa1bSDK.valueOf(AFa1bSDK.this).put("link", "");
                }
                AFa1bSDK.valueOf(AFa1bSDK.this).put("ttr", String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
            }
        };
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            FacebookSdk.class.getMethod("sdkInitialize", Context.class).invoke(null, context);
            final Class<AppLinkData> cls = AppLinkData.class;
            String str = AppLinkData.ARGUMENTS_TAPTIME_KEY;
            Method method = AppLinkData.class.getMethod("fetchDeferredAppLinkData", Context.class, String.class, AppLinkData.CompletionHandler.class);
            Object objNewProxyInstance = Proxy.newProxyInstance(AppLinkData.CompletionHandler.class.getClassLoader(), new Class[]{AppLinkData.CompletionHandler.class}, new InvocationHandler() { // from class: com.appsflyer.internal.AFa1sSDK.2
                @Override // java.lang.reflect.InvocationHandler
                public final Object invoke(Object obj, Method method2, Object[] objArr) throws Throwable {
                    String string;
                    String string2;
                    String string3;
                    Bundle bundle;
                    if (!method2.getName().equals("onDeferredAppLinkDataFetched")) {
                        AFa1zSDK aFa1zSDK2 = aFa1zSDK;
                        if (aFa1zSDK2 != null) {
                            aFa1zSDK2.AFInAppEventType("onDeferredAppLinkDataFetched invocation failed");
                        }
                        return null;
                    }
                    Object obj2 = objArr[0];
                    if (obj2 != null) {
                        Bundle bundle2 = (Bundle) Bundle.class.cast(cls.getMethod("getArgumentBundle", null).invoke(cls.cast(obj2), null));
                        if (bundle2 != null) {
                            string2 = bundle2.getString(AppLinkData.ARGUMENTS_NATIVE_URL);
                            string3 = bundle2.getString("target_url");
                            Bundle bundle3 = bundle2.getBundle("extras");
                            string = (bundle3 == null || (bundle = bundle3.getBundle(ShareConstants.DEEPLINK_CONTEXT)) == null) ? null : bundle.getString(ShareConstants.PROMO_CODE);
                        } else {
                            string = null;
                            string2 = null;
                            string3 = null;
                        }
                        AFa1zSDK aFa1zSDK3 = aFa1zSDK;
                        if (aFa1zSDK3 != null) {
                            aFa1zSDK3.values(string2, string3, string);
                        }
                    } else {
                        AFa1zSDK aFa1zSDK4 = aFa1zSDK;
                        if (aFa1zSDK4 != null) {
                            aFa1zSDK4.values(null, null, null);
                        }
                    }
                    return null;
                }
            });
            String string = context.getString(context.getResources().getIdentifier("facebook_app_id", LegacyTokenHelper.TYPE_STRING, context.getPackageName()));
            if (TextUtils.isEmpty(string)) {
                int i3 = onAppOpenAttribution + 103;
                onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                if (i3 % 2 == 0) {
                    aFa1zSDK.AFInAppEventType("Facebook app id not defined in resources");
                    return;
                } else {
                    aFa1zSDK.AFInAppEventType("Facebook app id not defined in resources");
                    throw null;
                }
            }
            method.invoke(null, context, string, objNewProxyInstance);
            onConversionDataFail = (onAppOpenAttribution + 53) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } catch (ClassNotFoundException e3) {
            AFLogger.afErrorLogForExcManagerOnly("FB class missing error", e3);
            aFa1zSDK.AFInAppEventType(e3.toString());
        } catch (IllegalAccessException e4) {
            AFLogger.afErrorLogForExcManagerOnly("FB illegal access", e4);
            aFa1zSDK.AFInAppEventType(e4.toString());
        } catch (NoSuchMethodException e5) {
            AFLogger.afErrorLogForExcManagerOnly("FB method missing error", e5);
            aFa1zSDK.AFInAppEventType(e5.toString());
        } catch (InvocationTargetException e6) {
            AFLogger.afErrorLogForExcManagerOnly("FB invocation error", e6);
            aFa1zSDK.AFInAppEventType(e6.toString());
        }
    }

    public final void AFInAppEventType(Context context, Map<String, Object> map, Uri uri) {
        AFInAppEventType(context);
        if (!map.containsKey("af_deeplink")) {
            String strValues = values(uri.toString());
            AFb1sSDK aFb1sSDKOnInstallConversionDataLoadedNative = valueOf().onInstallConversionDataLoadedNative();
            String str = aFb1sSDKOnInstallConversionDataLoadedNative.AFInAppEventParameterName;
            if (str != null && aFb1sSDKOnInstallConversionDataLoadedNative.AFInAppEventType != null && strValues.contains(str)) {
                Uri.Builder builderBuildUpon = Uri.parse(strValues).buildUpon();
                Uri.Builder builderBuildUpon2 = Uri.EMPTY.buildUpon();
                onConversionDataFail = (onAppOpenAttribution + 27) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                for (Map.Entry<String, String> entry : aFb1sSDKOnInstallConversionDataLoadedNative.AFInAppEventType.entrySet()) {
                    builderBuildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
                    builderBuildUpon2.appendQueryParameter(entry.getKey(), entry.getValue());
                    onAppOpenAttribution = (onConversionDataFail + 75) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                }
                strValues = builderBuildUpon.build().toString();
                map.put("appended_query_params", builderBuildUpon2.build().getEncodedQuery());
            }
            map.put("af_deeplink", strValues);
        }
        HashMap map2 = new HashMap();
        map2.put("link", uri.toString());
        AFd1gSDK aFd1gSDK = new AFd1gSDK(valueOf(), UUID.randomUUID(), uri);
        if (aFd1gSDK.AFVersionDeclaration()) {
            map.put("isBrandedDomain", Boolean.TRUE);
        }
        AFa1fSDK.AFInAppEventParameterName(context, map2, uri);
        if (aFd1gSDK.AFLogger$LogLevel()) {
            aFd1gSDK.AFLogger = valueOf(map2);
            AFd1xSDK aFd1xSDKAFLogger$LogLevel = valueOf().AFLogger$LogLevel();
            aFd1xSDKAFLogger$LogLevel.valueOf.execute(aFd1xSDKAFLogger$LogLevel.new AnonymousClass4(aFd1gSDK));
            return;
        }
        valueOf().onInstallConversionDataLoadedNative().valueOf(map2);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean valueOf(com.appsflyer.internal.AFa1tSDK r6, com.appsflyer.internal.AFb1fSDK r7) {
        /*
            r5 = this;
            r0 = 0
            int r1 = r5.values(r7, r0)
            r2 = 1
            if (r1 != r2) goto L1c
            int r3 = com.appsflyer.internal.AFa1bSDK.onConversionDataFail
            int r3 = r3 + 107
            int r4 = r3 % 128
            com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution = r4
            int r3 = r3 % 2
            if (r3 == 0) goto L1a
            boolean r6 = r6 instanceof com.appsflyer.internal.AFe1iSDK
            if (r6 != 0) goto L1c
            r6 = r2
            goto L1d
        L1a:
            r6 = 0
            throw r6
        L1c:
            r6 = r0
        L1d:
            java.lang.String r3 = "newGPReferrerSent"
            boolean r7 = r7.AFInAppEventType(r3)
            if (r7 != 0) goto L36
            int r7 = com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution
            int r3 = r7 + 97
            int r3 = r3 % 128
            com.appsflyer.internal.AFa1bSDK.onConversionDataFail = r3
            if (r1 != r2) goto L36
            int r7 = r7 + 27
            int r7 = r7 % 128
            com.appsflyer.internal.AFa1bSDK.onConversionDataFail = r7
            goto L40
        L36:
            int r7 = com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution
            int r7 = r7 + 31
            int r7 = r7 % 128
            com.appsflyer.internal.AFa1bSDK.onConversionDataFail = r7
            if (r6 == 0) goto L41
        L40:
            return r2
        L41:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1bSDK.valueOf(com.appsflyer.internal.AFa1tSDK, com.appsflyer.internal.AFb1fSDK):boolean");
    }

    private AFd1gSDK.AFa1vSDK valueOf(final Map<String, String> map) {
        AFd1gSDK.AFa1vSDK aFa1vSDK = new AFd1gSDK.AFa1vSDK() { // from class: com.appsflyer.internal.AFa1bSDK.4
            @Override // com.appsflyer.internal.AFd1gSDK.AFa1vSDK
            public final void AFInAppEventType(Map<String, String> map2) {
                for (String str : map2.keySet()) {
                    map.put(str, map2.get(str));
                }
                AFa1bSDK.this.valueOf().onInstallConversionDataLoadedNative().valueOf(map);
            }

            @Override // com.appsflyer.internal.AFd1gSDK.AFa1vSDK
            public final void valueOf(String str) {
                AFa1bSDK.this.valueOf().onInstallConversionDataLoadedNative().valueOf(str, DeepLinkResult.Error.NETWORK);
            }
        };
        onAppOpenAttribution = (onConversionDataFail + 3) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        return aFa1vSDK;
    }

    private static void valueOf(String str) {
        try {
            if (new JSONObject(str).has("pid")) {
                int i3 = onAppOpenAttribution + 1;
                onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                if (i3 % 2 == 0) {
                    values("preInstallName", str);
                    onAppOpenAttribution = (onConversionDataFail + 61) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                    return;
                } else {
                    values("preInstallName", str);
                    throw null;
                }
            }
            AFLogger.afWarnLog("Cannot set preinstall attribution data without a media source");
        } catch (JSONException e3) {
            AFLogger.afErrorLog("Error parsing JSON for preinstall", e3);
        }
    }

    private int AFInAppEventType(AFb1fSDK aFb1fSDK, String str, boolean z2) {
        int iValues = aFb1fSDK.values(str, 0);
        if (z2) {
            int i3 = onConversionDataFail + 19;
            onAppOpenAttribution = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            iValues = i3 % 2 == 0 ? iValues + 105 : iValues + 1;
            aFb1fSDK.AFInAppEventParameterName(str, iValues);
            onConversionDataFail = (onAppOpenAttribution + 61) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (valueOf().afErrorLogForExcManagerOnly().afInfoLog()) {
            valueOf().afErrorLogForExcManagerOnly().values(String.valueOf(iValues));
        }
        onAppOpenAttribution = (onConversionDataFail + 83) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        return iValues;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0028 A[Catch: all -> 0x001e, TRY_LEAVE, TryCatch #2 {all -> 0x001e, blocks: (B:4:0x0003, B:6:0x0010, B:23:0x0045, B:17:0x0028, B:19:0x003c, B:21:0x0041, B:22:0x0044, B:12:0x001d, B:15:0x0020, B:18:0x002c, B:8:0x0018), top: B:32:0x0003, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized android.content.SharedPreferences valueOf(android.content.Context r5) {
        /*
            java.lang.Class<com.appsflyer.internal.AFa1bSDK> r0 = com.appsflyer.internal.AFa1bSDK.class
            monitor-enter(r0)
            int r1 = com.appsflyer.internal.AFa1bSDK.onConversionDataFail     // Catch: java.lang.Throwable -> L1e
            int r1 = r1 + 13
            int r2 = r1 % 128
            com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution = r2     // Catch: java.lang.Throwable -> L1e
            int r1 = r1 % 2
            r2 = 0
            if (r1 != 0) goto L20
            com.appsflyer.internal.AFa1bSDK r1 = values()     // Catch: java.lang.Throwable -> L1e
            android.content.SharedPreferences r1 = r1.AppsFlyer2dXConversionCallback     // Catch: java.lang.Throwable -> L1e
            r3 = 93
            int r3 = r3 / r2
            if (r1 != 0) goto L45
            goto L28
        L1c:
            r5 = move-exception
            throw r5     // Catch: java.lang.Throwable -> L1e
        L1e:
            r5 = move-exception
            goto L55
        L20:
            com.appsflyer.internal.AFa1bSDK r1 = values()     // Catch: java.lang.Throwable -> L1e
            android.content.SharedPreferences r1 = r1.AppsFlyer2dXConversionCallback     // Catch: java.lang.Throwable -> L1e
            if (r1 != 0) goto L45
        L28:
            android.os.StrictMode$ThreadPolicy r1 = android.os.StrictMode.allowThreadDiskReads()     // Catch: java.lang.Throwable -> L1e
            com.appsflyer.internal.AFa1bSDK r3 = values()     // Catch: java.lang.Throwable -> L40
            android.content.Context r5 = r5.getApplicationContext()     // Catch: java.lang.Throwable -> L40
            java.lang.String r4 = "appsflyer-data"
            android.content.SharedPreferences r5 = r5.getSharedPreferences(r4, r2)     // Catch: java.lang.Throwable -> L40
            r3.AppsFlyer2dXConversionCallback = r5     // Catch: java.lang.Throwable -> L40
            android.os.StrictMode.setThreadPolicy(r1)     // Catch: java.lang.Throwable -> L1e
            goto L45
        L40:
            r5 = move-exception
            android.os.StrictMode.setThreadPolicy(r1)     // Catch: java.lang.Throwable -> L1e
            throw r5     // Catch: java.lang.Throwable -> L1e
        L45:
            com.appsflyer.internal.AFa1bSDK r5 = values()     // Catch: java.lang.Throwable -> L1e
            android.content.SharedPreferences r5 = r5.AppsFlyer2dXConversionCallback     // Catch: java.lang.Throwable -> L1e
            int r1 = com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution     // Catch: java.lang.Throwable -> L1e
            int r1 = r1 + 55
            int r1 = r1 % 128
            com.appsflyer.internal.AFa1bSDK.onConversionDataFail = r1     // Catch: java.lang.Throwable -> L1e
            monitor-exit(r0)
            return r5
        L55:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1e
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1bSDK.valueOf(android.content.Context):android.content.SharedPreferences");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ void AFInAppEventType(android.content.Context r6, android.content.Intent r7) {
        /*
            r5 = this;
            int r0 = com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution
            int r0 = r0 + 65
            int r0 = r0 % 128
            com.appsflyer.internal.AFa1bSDK.onConversionDataFail = r0
            r5.AFInAppEventType(r6)
            com.appsflyer.internal.AFc1ySDK r0 = r5.valueOf()
            com.appsflyer.internal.AFb1sSDK r0 = r0.onInstallConversionDataLoadedNative()
            com.appsflyer.internal.AFc1ySDK r1 = r5.valueOf()
            com.appsflyer.internal.AFb1fSDK r1 = r1.AFKeystoreWrapper()
            r2 = 0
            if (r7 == 0) goto L2f
            java.lang.String r3 = "android.intent.action.VIEW"
            java.lang.String r4 = r7.getAction()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L2f
            android.net.Uri r3 = r7.getData()
            goto L30
        L2f:
            r3 = r2
        L30:
            if (r3 == 0) goto L46
            int r4 = com.appsflyer.internal.AFa1bSDK.onConversionDataFail
            int r4 = r4 + 85
            int r4 = r4 % 128
            com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution = r4
            java.lang.String r3 = r3.toString()
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L46
            r3 = 1
            goto L4f
        L46:
            int r3 = com.appsflyer.internal.AFa1bSDK.onAppOpenAttribution
            int r3 = r3 + 101
            int r3 = r3 % 128
            com.appsflyer.internal.AFa1bSDK.onConversionDataFail = r3
            r3 = 0
        L4f:
            java.lang.String r4 = "ddl_sent"
            boolean r1 = r1.AFInAppEventType(r4)
            if (r1 == 0) goto L5f
            if (r3 != 0) goto L5f
            java.lang.String r6 = "No direct deep link"
            r0.valueOf(r6, r2)
            return
        L5f:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r0.AFKeystoreWrapper(r1, r7, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1bSDK.AFInAppEventType(android.content.Context, android.content.Intent):void");
    }

    @Deprecated
    public static String valueOf(HttpURLConnection httpURLConnection) {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        StringBuilder sb = new StringBuilder();
        try {
            try {
                InputStream errorStream = httpURLConnection.getErrorStream();
                if (errorStream == null) {
                    errorStream = httpURLConnection.getInputStream();
                }
                InputStreamReader inputStreamReader2 = new InputStreamReader(errorStream, Charset.defaultCharset());
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader2);
                    onAppOpenAttribution = (onConversionDataFail + 3) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                    boolean z2 = false;
                    while (true) {
                        try {
                            String line = bufferedReader2.readLine();
                            if (line == null) {
                                break;
                            }
                            sb.append(z2 ? '\n' : "");
                            sb.append(line);
                            z2 = true;
                        } catch (Throwable th) {
                            bufferedReader = bufferedReader2;
                            th = th;
                            inputStreamReader = inputStreamReader2;
                            try {
                                StringBuilder sb2 = new StringBuilder("Could not read connection response from: ");
                                sb2.append(httpURLConnection.getURL().toString());
                                AFLogger.afErrorLog(sb2.toString(), th);
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                if (inputStreamReader != null) {
                                    int i3 = onAppOpenAttribution + 109;
                                    onConversionDataFail = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                                    if (i3 % 2 != 0) {
                                        inputStreamReader.close();
                                        throw null;
                                    }
                                    inputStreamReader.close();
                                }
                            } catch (Throwable th2) {
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Throwable th3) {
                                        AFLogger.afErrorLogForExcManagerOnly("readServerResponse error", th3);
                                        throw th2;
                                    }
                                }
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                throw th2;
                            }
                        }
                    }
                    bufferedReader2.close();
                    inputStreamReader2.close();
                } catch (Throwable th4) {
                    th = th4;
                    inputStreamReader = inputStreamReader2;
                    bufferedReader = null;
                }
            } catch (Throwable th5) {
                th = th5;
                bufferedReader = null;
                inputStreamReader = null;
            }
        } catch (Throwable th6) {
            AFLogger.afErrorLogForExcManagerOnly("readServerResponse error", th6);
        }
        String string = sb.toString();
        try {
            new JSONObject(string);
            return string;
        } catch (JSONException e3) {
            AFLogger.afErrorLogForExcManagerOnly("error while parsing readServerResponse", e3);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("string_response", string);
                return jSONObject.toString();
            } catch (JSONException e4) {
                AFLogger.afErrorLogForExcManagerOnly("RESPONSE_NOT_JSON error", e4);
                return new JSONObject().toString();
            }
        }
    }

    private static void AFInAppEventType(String str, String str2, int[] iArr, int i3, Object[] objArr) throws UnsupportedEncodingException {
        Object bytes = str2;
        if (str2 != null) {
            bytes = str2.getBytes("ISO-8859-1");
        }
        byte[] bArr = (byte[]) bytes;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (AFg1hSDK.AFInAppEventType) {
            try {
                char[] cArr2 = onConversionDataSuccess;
                int i4 = onAttributionFailureNative;
                if (onDeepLinking) {
                    int length = bArr.length;
                    AFg1hSDK.valueOf = length;
                    char[] cArr3 = new char[length];
                    AFg1hSDK.values = 0;
                    while (AFg1hSDK.values < AFg1hSDK.valueOf) {
                        int i5 = AFg1hSDK.values;
                        int i6 = AFg1hSDK.valueOf - 1;
                        int i7 = AFg1hSDK.values;
                        cArr3[i5] = (char) (cArr2[bArr[i6 - i7] + i3] - i4);
                        AFg1hSDK.values = i7 + 1;
                    }
                    objArr[0] = new String(cArr3);
                    return;
                }
                if (onResponseNative) {
                    int length2 = cArr.length;
                    AFg1hSDK.valueOf = length2;
                    char[] cArr4 = new char[length2];
                    AFg1hSDK.values = 0;
                    while (AFg1hSDK.values < AFg1hSDK.valueOf) {
                        int i8 = AFg1hSDK.values;
                        int i9 = AFg1hSDK.valueOf - 1;
                        int i10 = AFg1hSDK.values;
                        cArr4[i8] = (char) (cArr2[cArr[i9 - i10] - i3] - i4);
                        AFg1hSDK.values = i10 + 1;
                    }
                    objArr[0] = new String(cArr4);
                    return;
                }
                int length3 = iArr.length;
                AFg1hSDK.valueOf = length3;
                char[] cArr5 = new char[length3];
                AFg1hSDK.values = 0;
                while (AFg1hSDK.values < AFg1hSDK.valueOf) {
                    int i11 = AFg1hSDK.values;
                    int i12 = AFg1hSDK.valueOf - 1;
                    int i13 = AFg1hSDK.values;
                    cArr5[i11] = (char) (cArr2[iArr[i12 - i13] - i3] - i4);
                    AFg1hSDK.values = i13 + 1;
                }
                objArr[0] = new String(cArr5);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
