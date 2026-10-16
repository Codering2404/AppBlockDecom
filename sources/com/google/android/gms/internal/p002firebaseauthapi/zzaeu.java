package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailabilityLight;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaeu {
    private static Boolean zza;

    public static boolean zza(Context context) {
        if (zza == null) {
            int iJ = GoogleApiAvailabilityLight.h().j(context, 12451000);
            zza = Boolean.valueOf(iJ == 0 || iJ == 2);
        }
        return zza.booleanValue();
    }
}
