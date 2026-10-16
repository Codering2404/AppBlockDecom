package com.google.android.gms.internal.ads;

import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzajv {
    public final long zza;
    public final long zzb;
    public final int zzc;

    public zzajv(long j3, long j4, int i3) {
        zzgtj.zza(j3 < j4);
        this.zza = j3;
        this.zzb = j4;
        this.zzc = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzajv.class == obj.getClass()) {
            zzajv zzajvVar = (zzajv) obj;
            if (this.zza == zzajvVar.zza && this.zzb == zzajvVar.zzb && this.zzc == zzajvVar.zzc) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.zza), Long.valueOf(this.zzb), Integer.valueOf(this.zzc));
    }

    public final String toString() {
        Object[] objArr = {Long.valueOf(this.zza), Long.valueOf(this.zzb), Integer.valueOf(this.zzc)};
        String str = zzfl.zza;
        return String.format(Locale.US, "Segment: startTimeMs=%d, endTimeMs=%d, speedDivisor=%d", objArr);
    }
}
