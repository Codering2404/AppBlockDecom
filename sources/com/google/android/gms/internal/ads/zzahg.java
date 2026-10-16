package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzahg extends zzagm {
    private final long zza;

    public zzahg(zzafz zzafzVar, long j3) {
        super(zzafzVar);
        zzgtj.zza(zzafzVar.zzn() >= j3);
        this.zza = j3;
    }

    @Override // com.google.android.gms.internal.ads.zzagm, com.google.android.gms.internal.ads.zzafz
    public final long zzm() {
        return super.zzm() - this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzagm, com.google.android.gms.internal.ads.zzafz
    public final long zzn() {
        return super.zzn() - this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzagm, com.google.android.gms.internal.ads.zzafz
    public final long zzo() {
        return super.zzo() - this.zza;
    }
}
