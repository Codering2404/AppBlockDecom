package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzake implements Comparable {
    private final long zza;
    private final long zzb;
    private final long zzc;

    /* synthetic */ zzake(long j3, long j4, long j5, byte[] bArr) {
        this.zza = j3;
        this.zzb = j4;
        this.zzc = j5;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return Long.compare(this.zza, ((zzake) obj).zza);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzake)) {
            return false;
        }
        zzake zzakeVar = (zzake) obj;
        return this.zza == zzakeVar.zza && this.zzb == zzakeVar.zzb && this.zzc == zzakeVar.zzc;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.zza), Long.valueOf(this.zzb), Long.valueOf(this.zzc));
    }

    final /* synthetic */ long zza() {
        return this.zza;
    }

    final /* synthetic */ long zzb() {
        return this.zzb;
    }

    final /* synthetic */ long zzc() {
        return this.zzc;
    }
}
