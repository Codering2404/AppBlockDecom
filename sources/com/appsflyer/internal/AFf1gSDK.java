package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFf1jSDK;
import com.miui.referrer.api.GetAppsReferrerClient;
import com.miui.referrer.api.GetAppsReferrerDetails;
import com.miui.referrer.api.GetAppsReferrerStateListener;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFf1gSDK extends AFf1nSDK {
    public AFf1gSDK(Runnable runnable) {
        super(ProductResponseJsonKeys.STORE, "xiaomi", runnable);
    }

    private static boolean AFInAppEventParameterName() {
        if (!AFf1nSDK.AFInAppEventType()) {
            return false;
        }
        try {
            Class.forName("com.miui.referrer.api.GetAppsReferrerClient");
            AFLogger.afDebugLog("Xiaomi Install Referrer is allowed");
            return true;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb = new StringBuilder("Class ");
            sb.append("com.miui.referrer.api.GetAppsReferrerClient");
            sb.append(" not found");
            AFLogger.afRDLog(sb.toString());
            return false;
        } catch (Throwable th) {
            AFLogger.afErrorLog("An error occurred while trying to access GetAppsReferrerClient", th);
            return false;
        }
    }

    @Override // com.appsflyer.internal.AFf1jSDK
    public final void valueOf(final Context context) {
        if (AFInAppEventParameterName()) {
            this.AFLogger = System.currentTimeMillis();
            this.afDebugLog = AFf1jSDK.AFa1vSDK.STARTED;
            addObserver(new AFf1jSDK.AnonymousClass3());
            final GetAppsReferrerClient getAppsReferrerClientBuild = GetAppsReferrerClient.Companion.newBuilder(context).build();
            getAppsReferrerClientBuild.startConnection(new GetAppsReferrerStateListener() { // from class: com.appsflyer.internal.AFf1gSDK.1
                public final void onGetAppsReferrerSetupFinished(int i3) {
                    AFf1gSDK.this.valueOf.put("api_ver", Long.valueOf(AFa1fSDK.AFInAppEventParameterName(context, "com.xiaomi.mipicks")));
                    AFf1gSDK.this.valueOf.put("api_ver_name", AFa1fSDK.AFKeystoreWrapper(context, "com.xiaomi.mipicks"));
                    if (i3 == -1) {
                        AFLogger.afWarnLog("XiaomiInstallReferrer SERVICE_DISCONNECTED");
                        AFf1gSDK.this.valueOf.put("response", "SERVICE_DISCONNECTED");
                    } else if (i3 == 0) {
                        AFf1gSDK aFf1gSDK = AFf1gSDK.this;
                        GetAppsReferrerClient getAppsReferrerClient = getAppsReferrerClientBuild;
                        aFf1gSDK.valueOf.put("response", "OK");
                        try {
                            AFLogger.afDebugLog("XiaomiInstallReferrer connected");
                            if (getAppsReferrerClient.isReady()) {
                                GetAppsReferrerDetails installReferrer = getAppsReferrerClient.getInstallReferrer();
                                String installReferrer2 = installReferrer.getInstallReferrer();
                                if (installReferrer2 != null) {
                                    aFf1gSDK.valueOf.put("referrer", installReferrer2);
                                }
                                aFf1gSDK.valueOf.put("click_ts", Long.valueOf(installReferrer.getReferrerClickTimestampSeconds()));
                                aFf1gSDK.valueOf.put("install_begin_ts", Long.valueOf(installReferrer.getInstallBeginTimestampSeconds()));
                                HashMap map = new HashMap();
                                map.put("click_server_ts", Long.valueOf(installReferrer.getReferrerClickTimestampServerSeconds()));
                                map.put("install_begin_server_ts", Long.valueOf(installReferrer.getInstallBeginTimestampServerSeconds()));
                                map.put("install_version", installReferrer.getInstallVersion());
                                aFf1gSDK.valueOf.put("xiaomi_custom", map);
                            } else {
                                AFLogger.afWarnLog("XiaomiReferrerClient: XiaomiInstallReferrer is not ready");
                            }
                        } catch (Throwable th) {
                            StringBuilder sb = new StringBuilder("Failed to get Xiaomi install referrer: ");
                            sb.append(th.getMessage());
                            AFLogger.afWarnLog(sb.toString());
                        }
                    } else if (i3 == 1) {
                        AFf1gSDK.this.valueOf.put("response", "SERVICE_UNAVAILABLE");
                        AFLogger.afWarnLog("XiaomiInstallReferrer not supported");
                    } else if (i3 == 2) {
                        AFLogger.afWarnLog("XiaomiInstallReferrer FEATURE_NOT_SUPPORTED");
                        AFf1gSDK.this.valueOf.put("response", "FEATURE_NOT_SUPPORTED");
                    } else if (i3 == 3) {
                        AFLogger.afWarnLog("XiaomiInstallReferrer DEVELOPER_ERROR");
                        AFf1gSDK.this.valueOf.put("response", "DEVELOPER_ERROR");
                    } else if (i3 != 4) {
                        AFLogger.afWarnLog("responseCode not found.");
                    } else {
                        AFLogger.afWarnLog("XiaomiInstallReferrer DEVELOPER_ERROR");
                        AFf1gSDK.this.valueOf.put("response", "PERMISSION_ERROR");
                    }
                    AFLogger.afDebugLog("Xiaomi Install Referrer collected locally");
                    AFf1gSDK.this.AFKeystoreWrapper();
                    getAppsReferrerClientBuild.endConnection();
                }

                public final void onGetAppsServiceDisconnected() {
                }
            });
        }
    }
}
