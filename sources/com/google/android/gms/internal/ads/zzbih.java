package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzbih {
    private final int zza;
    private final String zzb;
    private final Object zzc;
    private final Object zzd;

    /* synthetic */ zzbih(int i3, String str, Object obj, Object obj2, byte[] bArr) {
        this.zza = i3;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        com.google.android.gms.ads.internal.client.zzba.b().zza(this);
    }

    public static zzbih zzh(int i3, String str, int i4, int i5) {
        return new zzbid(1, str, Integer.valueOf(i4), Integer.valueOf(i5));
    }

    public static zzbih zzi(int i3, String str, long j3, long j4) {
        return new zzbie(1, str, Long.valueOf(j3), Long.valueOf(j4));
    }

    public static zzbih zzj(int i3, String str, float f3, float f4) {
        return new zzbif(1, str, Float.valueOf(f3), Float.valueOf(f4));
    }

    public static zzbih zzk(int i3, String str) {
        zzbig zzbigVar = new zzbig(1, "gads:sdk_core_constants:experiment_id", null, null);
        com.google.android.gms.ads.internal.client.zzba.b().zzb(zzbigVar);
        return zzbigVar;
    }

    public static zzbih zzl(int i3, String str) {
        zzbig zzbigVar = new zzbig(1, "gads:sdk_core_constants_service:experiment_id", null, null);
        com.google.android.gms.ads.internal.client.zzba.b().zzc(zzbigVar);
        return zzbigVar;
    }

    public abstract Object zza(Bundle bundle);

    public abstract void zzb(SharedPreferences.Editor editor, Object obj);

    protected abstract Object zzc(JSONObject jSONObject);

    protected abstract Object zzd(SharedPreferences sharedPreferences);

    public final String zze() {
        return this.zzb;
    }

    public final Object zzf() {
        return com.google.android.gms.ads.internal.client.zzba.c().zzb() ? this.zzd : this.zzc;
    }

    public final Object zzg() {
        return com.google.android.gms.ads.internal.client.zzba.c().zzd(this);
    }

    public final int zzm() {
        return this.zza;
    }
}
