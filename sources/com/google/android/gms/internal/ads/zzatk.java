package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzatk {
    public final Object zza;
    public final zzasn zzb;
    public final zzatn zzc;
    public boolean zzd;

    private zzatk(zzatn zzatnVar) {
        this.zzd = false;
        this.zza = null;
        this.zzb = null;
        this.zzc = zzatnVar;
    }

    public static zzatk zza(Object obj, zzasn zzasnVar) {
        return new zzatk(obj, zzasnVar);
    }

    public static zzatk zzb(zzatn zzatnVar) {
        return new zzatk(zzatnVar);
    }

    public final boolean zzc() {
        return this.zzc == null;
    }

    private zzatk(Object obj, zzasn zzasnVar) {
        this.zzd = false;
        this.zza = obj;
        this.zzb = zzasnVar;
        this.zzc = null;
    }
}
