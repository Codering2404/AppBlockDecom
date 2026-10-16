package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbij {
    public static final SharedPreferences zza(Context context) {
        try {
            return context.getSharedPreferences("google_adapter_flags", 0);
        } catch (IllegalStateException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.g("", e3);
            return null;
        }
    }

    public static final SharedPreferences zzb(Context context) {
        try {
            return context.getSharedPreferences("google_ads_flags", 0);
        } catch (IllegalStateException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.g("", e3);
            return null;
        }
    }
}
