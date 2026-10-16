package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.InstallSourceInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.appsflyer.AFLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFb1tSDK {
    private final PackageManager AFInAppEventParameterName;
    private final Map<String, Object> AFKeystoreWrapper;
    private final String values;

    public AFb1tSDK() {
    }

    public static boolean AFInAppEventParameterName(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean AFKeystoreWrapper(String str) {
        return str == null || str.length() == 0;
    }

    public AFb1tSDK(AFc1zSDK aFc1zSDK, AFb1gSDK aFb1gSDK) {
        Intrinsics.checkNotNullParameter(aFc1zSDK, "");
        Intrinsics.checkNotNullParameter(aFb1gSDK, "");
        this.AFKeystoreWrapper = new LinkedHashMap();
        Context context = aFc1zSDK.values;
        this.AFInAppEventParameterName = context != null ? context.getPackageManager() : null;
        String packageName = aFb1gSDK.values.values.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "");
        this.values = packageName;
    }

    public final Map<String, Object> AFKeystoreWrapper() {
        InstallSourceInfo installSourceInfo;
        String installerPackageName;
        if (this.AFKeystoreWrapper.isEmpty()) {
            try {
                PackageManager packageManager = this.AFInAppEventParameterName;
                if (packageManager != null && (installerPackageName = packageManager.getInstallerPackageName(this.values)) != null) {
                    this.AFKeystoreWrapper.put("installer_package", installerPackageName);
                }
            } catch (Exception e3) {
                AFLogger.afErrorLog("Exception while getting the app's installer package. ", e3);
            }
            if (Build.VERSION.SDK_INT >= 30) {
                Map<String, Object> map = this.AFKeystoreWrapper;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                String str = this.values;
                PackageManager packageManager2 = this.AFInAppEventParameterName;
                if (packageManager2 != null && (installSourceInfo = packageManager2.getInstallSourceInfo(str)) != null) {
                    Intrinsics.checkNotNullExpressionValue(installSourceInfo, "");
                    linkedHashMap = new LinkedHashMap();
                    String initiatingPackageName = installSourceInfo.getInitiatingPackageName();
                    if (initiatingPackageName != null) {
                        linkedHashMap.put("initiating_package", initiatingPackageName);
                    }
                    String installingPackageName = installSourceInfo.getInstallingPackageName();
                    if (installingPackageName != null) {
                        linkedHashMap.put("installing_package", installingPackageName);
                    }
                    String originatingPackageName = installSourceInfo.getOriginatingPackageName();
                    if (originatingPackageName != null) {
                        linkedHashMap.put("originating_package", originatingPackageName);
                    }
                }
                map.put("install_source_info", linkedHashMap);
            }
        }
        return this.AFKeystoreWrapper;
    }
}
