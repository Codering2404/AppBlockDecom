package com.appsflyer.internal;

import android.content.SharedPreferences;
import androidx.legacy.content.Werj.QgXempTBEfV;
import com.appsflyer.AFLogger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFb1eSDK implements AFb1fSDK {
    private final SharedPreferences AFInAppEventType;

    public AFb1eSDK(SharedPreferences sharedPreferences) {
        this.AFInAppEventType = sharedPreferences;
    }

    @Override // com.appsflyer.internal.AFb1fSDK
    public final long AFInAppEventParameterName(String str, long j3) {
        try {
            return this.AFInAppEventType.getLong(str, j3);
        } catch (ClassCastException e3) {
            AFLogger.afErrorLog("Unexpected data type found for key ".concat(String.valueOf(str)), e3);
            return j3;
        }
    }

    @Override // com.appsflyer.internal.AFb1fSDK
    public final boolean AFInAppEventType(String str) {
        try {
            return this.AFInAppEventType.getBoolean(str, false);
        } catch (ClassCastException e3) {
            AFLogger.afErrorLog("Unexpected data type found for key ".concat(String.valueOf(str)), e3);
            return false;
        }
    }

    @Override // com.appsflyer.internal.AFb1fSDK
    public final String AFKeystoreWrapper(String str, String str2) {
        try {
            return this.AFInAppEventType.getString(str, str2);
        } catch (ClassCastException e3) {
            AFLogger.afErrorLog("Unexpected data type found for key ".concat(String.valueOf(str)), e3);
            return str2;
        }
    }

    @Override // com.appsflyer.internal.AFb1fSDK
    public final void valueOf(String str, boolean z2) {
        this.AFInAppEventType.edit().putBoolean(str, z2).apply();
    }

    @Override // com.appsflyer.internal.AFb1fSDK
    public final void values(String str, String str2) {
        this.AFInAppEventType.edit().putString(str, str2).apply();
    }

    @Override // com.appsflyer.internal.AFb1fSDK
    public final int values(String str, int i3) {
        try {
            return this.AFInAppEventType.getInt(str, i3);
        } catch (ClassCastException e3) {
            AFLogger.afErrorLog(QgXempTBEfV.VpsCw.concat(String.valueOf(str)), e3);
            return i3;
        }
    }

    @Override // com.appsflyer.internal.AFb1fSDK
    public final void AFInAppEventParameterName(String str, int i3) {
        this.AFInAppEventType.edit().putInt(str, i3).apply();
    }

    @Override // com.appsflyer.internal.AFb1fSDK
    public final void AFInAppEventType(String str, long j3) {
        this.AFInAppEventType.edit().putLong(str, j3).apply();
    }

    @Override // com.appsflyer.internal.AFb1fSDK
    public final void AFInAppEventParameterName(String str) {
        this.AFInAppEventType.edit().remove(str).apply();
    }

    @Override // com.appsflyer.internal.AFb1fSDK
    public final boolean values(String str) {
        return this.AFInAppEventType.contains(str);
    }
}
