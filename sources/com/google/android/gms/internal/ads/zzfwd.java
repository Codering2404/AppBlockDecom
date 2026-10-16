package com.google.android.gms.internal.ads;

import android.app.UiModeManager;
import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfwd {
    private static UiModeManager zza;

    public static void zza(Context context) {
        if (context != null) {
            zza = (UiModeManager) context.getSystemService("uimode");
        }
    }

    public static zzfuq zzb() {
        UiModeManager uiModeManager = zza;
        if (uiModeManager == null) {
            return zzfuq.OTHER;
        }
        int currentModeType = uiModeManager.getCurrentModeType();
        return currentModeType != 1 ? currentModeType != 4 ? zzfuq.OTHER : zzfuq.CTV : zzfuq.MOBILE;
    }
}
