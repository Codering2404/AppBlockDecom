package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzlz {
    private long zza;
    private float zzb;
    private long zzc;

    public zzlz() {
        this.zza = -9223372036854775807L;
        this.zzb = -3.4028235E38f;
        this.zzc = -9223372036854775807L;
    }

    public final zzlz zza(long j3) {
        this.zza = j3;
        return this;
    }

    public final zzlz zzb(float f3) {
        boolean z2 = true;
        if (f3 <= 0.0f && f3 != -3.4028235E38f) {
            z2 = false;
        }
        zzgtj.zza(z2);
        this.zzb = f3;
        return this;
    }

    public final zzlz zzc(long j3) {
        boolean z2 = true;
        if (j3 < 0) {
            if (j3 == -9223372036854775807L) {
                j3 = -9223372036854775807L;
            } else {
                z2 = false;
            }
        }
        zzgtj.zza(z2);
        this.zzc = j3;
        return this;
    }

    public final zzma zzd() {
        return new zzma(this, null);
    }

    final /* synthetic */ long zze() {
        return this.zza;
    }

    final /* synthetic */ float zzf() {
        return this.zzb;
    }

    final /* synthetic */ long zzg() {
        return this.zzc;
    }

    /* synthetic */ zzlz(zzma zzmaVar, byte[] bArr) {
        this.zza = zzmaVar.zza;
        this.zzb = zzmaVar.zzb;
        this.zzc = zzmaVar.zzc;
    }
}
