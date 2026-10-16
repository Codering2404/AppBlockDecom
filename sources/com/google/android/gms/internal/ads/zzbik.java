package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbik implements zzblg {
    final /* synthetic */ SharedPreferences zza;

    zzbik(zzbio zzbioVar, SharedPreferences sharedPreferences) {
        this.zza = sharedPreferences;
        Objects.requireNonNull(zzbioVar);
    }

    @Override // com.google.android.gms.internal.ads.zzblg
    public final Boolean zza(String str, boolean z2) {
        try {
            return Boolean.valueOf(this.zza.getBoolean(str, z2));
        } catch (ClassCastException unused) {
            return Boolean.valueOf(this.zza.getString(str, String.valueOf(z2)));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzblg
    public final Long zzb(String str, long j3) {
        try {
            return Long.valueOf(this.zza.getLong(str, j3));
        } catch (ClassCastException unused) {
            return Long.valueOf(this.zza.getInt(str, (int) j3));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzblg
    public final Double zzc(String str, double d3) {
        try {
            return Double.valueOf(this.zza.getFloat(str, (float) d3));
        } catch (ClassCastException unused) {
            return Double.valueOf(this.zza.getString(str, String.valueOf(d3)));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzblg
    public final String zzd(String str, String str2) {
        return this.zza.getString(str, str2);
    }
}
