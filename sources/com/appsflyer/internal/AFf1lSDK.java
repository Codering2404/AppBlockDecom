package com.appsflyer.internal;

import android.content.Context;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFf1jSDK;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AFf1lSDK extends AFf1nSDK {
    public final Map<String, Object> AFInAppEventType;
    private final ExecutorService AFKeystoreWrapper;

    /* JADX INFO: renamed from: com.appsflyer.internal.AFf1lSDK$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class AnonymousClass4 implements InstallReferrerStateListener {
        final /* synthetic */ Context val$context;
        final /* synthetic */ InstallReferrerClient val$referrerClient;

        AnonymousClass4(InstallReferrerClient installReferrerClient, Context context) {
            this.val$referrerClient = installReferrerClient;
            this.val$context = context;
        }

        @Override // com.android.installreferrer.api.InstallReferrerStateListener
        public final void onInstallReferrerServiceDisconnected() {
            AFLogger.afDebugLog("Install Referrer service disconnected");
        }

        @Override // com.android.installreferrer.api.InstallReferrerStateListener
        public final void onInstallReferrerSetupFinished(final int i3) {
            ExecutorService executorService = AFf1lSDK.this.AFKeystoreWrapper;
            final InstallReferrerClient installReferrerClient = this.val$referrerClient;
            final Context context = this.val$context;
            executorService.execute(new Runnable() { // from class: com.appsflyer.internal.v
                @Override // java.lang.Runnable
                public final void run() {
                    AFf1lSDK.AFInAppEventParameterName(AFf1lSDK.this, installReferrerClient, context, i3);
                }
            });
        }
    }

    public AFf1lSDK(Runnable runnable, ExecutorService executorService) {
        super(ProductResponseJsonKeys.STORE, "google", runnable);
        this.AFInAppEventType = new HashMap();
        this.AFKeystoreWrapper = executorService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void AFInAppEventParameterName(AFf1lSDK aFf1lSDK, InstallReferrerClient installReferrerClient, Context context, int i3) {
        aFf1lSDK.AFInAppEventType.put("code", String.valueOf(i3));
        aFf1lSDK.valueOf.put("api_ver", Long.valueOf(AFa1fSDK.AFInAppEventParameterName(context, "com.android.vending")));
        aFf1lSDK.valueOf.put("api_ver_name", AFa1fSDK.AFKeystoreWrapper(context, "com.android.vending"));
        if (i3 == -1) {
            AFLogger.afWarnLog("InstallReferrer SERVICE_DISCONNECTED");
            aFf1lSDK.valueOf.put("response", "SERVICE_DISCONNECTED");
        } else if (i3 == 0) {
            aFf1lSDK.valueOf.put("response", "OK");
            try {
                AFLogger.afDebugLog("InstallReferrer connected");
                if (installReferrerClient.isReady()) {
                    ReferrerDetails installReferrer = installReferrerClient.getInstallReferrer();
                    String installReferrer2 = installReferrer.getInstallReferrer();
                    if (installReferrer2 != null) {
                        aFf1lSDK.AFInAppEventType.put("val", installReferrer2);
                        aFf1lSDK.valueOf.put("referrer", installReferrer2);
                    }
                    long referrerClickTimestampSeconds = installReferrer.getReferrerClickTimestampSeconds();
                    aFf1lSDK.AFInAppEventType.put("clk", Long.toString(referrerClickTimestampSeconds));
                    aFf1lSDK.valueOf.put("click_ts", Long.valueOf(referrerClickTimestampSeconds));
                    long installBeginTimestampSeconds = installReferrer.getInstallBeginTimestampSeconds();
                    aFf1lSDK.AFInAppEventType.put("install", Long.toString(installBeginTimestampSeconds));
                    aFf1lSDK.valueOf.put("install_begin_ts", Long.valueOf(installBeginTimestampSeconds));
                    HashMap map = new HashMap();
                    try {
                        boolean googlePlayInstantParam = installReferrer.getGooglePlayInstantParam();
                        aFf1lSDK.AFInAppEventType.put("instant", Boolean.valueOf(googlePlayInstantParam));
                        map.put("instant", Boolean.valueOf(googlePlayInstantParam));
                    } catch (NoSuchMethodError e3) {
                        AFLogger.afErrorLogForExcManagerOnly("getGooglePlayInstantParam not exist", e3);
                    }
                    try {
                        map.put("click_server_ts", Long.valueOf(installReferrer.getReferrerClickTimestampServerSeconds()));
                        map.put("install_begin_server_ts", Long.valueOf(installReferrer.getInstallBeginTimestampServerSeconds()));
                        map.put("install_version", installReferrer.getInstallVersion());
                    } catch (NoSuchMethodError e4) {
                        AFLogger.afErrorLogForExcManagerOnly("some method not exist", e4);
                    }
                    if (!map.isEmpty()) {
                        aFf1lSDK.valueOf.put("google_custom", map);
                    }
                    installReferrerClient.endConnection();
                } else {
                    AFLogger.afWarnLog("ReferrerClient: InstallReferrer is not ready");
                    aFf1lSDK.AFInAppEventType.put("err", "ReferrerClient: InstallReferrer is not ready");
                }
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder("Failed to get install referrer: ");
                sb.append(th.getMessage());
                AFLogger.afWarnLog(sb.toString());
                aFf1lSDK.AFInAppEventType.put("err", th.getMessage());
                AFLogger.afErrorLogForExcManagerOnly("Failed to get install referrer", th);
            }
        } else if (i3 == 1) {
            aFf1lSDK.valueOf.put("response", "SERVICE_UNAVAILABLE");
            AFLogger.afWarnLog("InstallReferrer not supported");
        } else if (i3 == 2) {
            AFLogger.afWarnLog("InstallReferrer FEATURE_NOT_SUPPORTED");
            aFf1lSDK.valueOf.put("response", "FEATURE_NOT_SUPPORTED");
        } else if (i3 != 3) {
            AFLogger.afWarnLog("responseCode not found.");
        } else {
            AFLogger.afWarnLog("InstallReferrer DEVELOPER_ERROR");
            aFf1lSDK.valueOf.put("response", "DEVELOPER_ERROR");
        }
        AFLogger.afDebugLog("Install Referrer collected locally");
        aFf1lSDK.AFKeystoreWrapper();
    }

    private static boolean AFKeystoreWrapper(Context context) {
        if (!AFf1nSDK.AFInAppEventType()) {
            return false;
        }
        try {
            if (AFa1fSDK.AFInAppEventType(context, "com.google.android.finsky.permission.BIND_GET_INSTALL_REFERRER_SERVICE")) {
                AFLogger.afDebugLog("Install referrer is allowed");
                return true;
            }
            AFLogger.afDebugLog("Install referrer is not allowed");
            return false;
        } catch (ClassNotFoundException e3) {
            AFLogger.afErrorLogForExcManagerOnly("InstallReferrerClient not found", e3);
            StringBuilder sb = new StringBuilder("Class ");
            sb.append("com.android.installreferrer.api.InstallReferrerClient");
            sb.append(" not found");
            AFLogger.afRDLog(sb.toString());
            return false;
        } catch (Throwable th) {
            AFLogger.afErrorLog("An error occurred while trying to verify manifest : ".concat("com.android.installreferrer.api.InstallReferrerClient"), th);
            return false;
        }
    }

    @Override // com.appsflyer.internal.AFf1jSDK
    public final void valueOf(Context context) {
        if (AFKeystoreWrapper(context)) {
            this.AFLogger = System.currentTimeMillis();
            this.afDebugLog = AFf1jSDK.AFa1vSDK.STARTED;
            addObserver(new AFf1jSDK.AnonymousClass3());
            try {
                InstallReferrerClient installReferrerClientBuild = InstallReferrerClient.newBuilder(context).build();
                AFLogger.afDebugLog("Connecting to Install Referrer Library...");
                installReferrerClientBuild.startConnection(new AnonymousClass4(installReferrerClientBuild, context));
            } catch (Throwable th) {
                AFLogger.afErrorLog("referrerClient -> startConnection", th);
            }
        }
    }
}
