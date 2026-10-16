package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzbka {
    private final String zza;
    private final Object zzb;
    private final int zzc;

    protected zzbka(String str, Object obj, int i3) {
        this.zza = str;
        this.zzb = obj;
        this.zzc = i3;
    }

    public static zzbka zza(String str, boolean z2) {
        return new zzbka(str, Boolean.valueOf(z2), 1);
    }

    public static zzbka zzb(String str, long j3) {
        return new zzbka(str, Long.valueOf(j3), 2);
    }

    public static zzbka zzc(String str, double d3) {
        return new zzbka(str, Double.valueOf(d3), 3);
    }

    public static zzbka zzd(String str, String str2) {
        return new zzbka("gad:dynamite_module:experiment_id", "", 4);
    }

    public final Object zze() {
        zzblg zzblgVarZza = zzbli.zza();
        if (zzblgVarZza != null) {
            int i3 = this.zzc - 1;
            return i3 != 0 ? i3 != 1 ? i3 != 2 ? zzblgVarZza.zzd(this.zza, (String) this.zzb) : zzblgVarZza.zzc(this.zza, ((Double) this.zzb).doubleValue()) : zzblgVarZza.zzb(this.zza, ((Long) this.zzb).longValue()) : zzblgVarZza.zza(this.zza, ((Boolean) this.zzb).booleanValue());
        }
        if (zzbli.zzb() != null) {
            zzbli.zzb().zza();
        }
        return this.zzb;
    }
}
