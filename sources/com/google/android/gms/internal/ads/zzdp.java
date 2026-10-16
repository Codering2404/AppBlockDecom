package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdp {
    public static final zzdp zza = new zzdp(0, 0, false);
    private final int zzb;
    private final int zzc;
    private final boolean zzd;

    private zzdp(int i3, int i4, boolean z2) {
        this.zzd = z2;
        this.zzb = i3;
        this.zzc = i4;
    }

    public final int zza() {
        zzgtj.zzi(this.zzd);
        return this.zzb;
    }

    public final int zzb() {
        zzgtj.zzi(this.zzd);
        return this.zzc;
    }

    public final boolean zzc() {
        return this.zzd;
    }

    public zzdp(int i3, int i4) {
        this(i3, i4, true);
    }
}
