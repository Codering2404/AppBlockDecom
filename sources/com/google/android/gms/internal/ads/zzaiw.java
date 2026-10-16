package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaiw implements zzaiv {
    private final long zza;
    private final String zzb;

    public zzaiw(long j3, long j4, String str) {
        this.zza = j3;
        this.zzb = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaiw.class == obj.getClass()) {
            zzaiw zzaiwVar = (zzaiw) obj;
            if (this.zza == zzaiwVar.zza && Objects.equals(this.zzb, zzaiwVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((Long.hashCode(this.zza) + 527) * 31) + Long.hashCode(-9223372036854775807L)) * 31) + this.zzb.hashCode();
    }

    public final String toString() {
        long j3 = this.zza;
        Object objValueOf = j3 == -9223372036854775807L ? "UNSET" : Long.valueOf(j3);
        String str = this.zzb;
        String string = objValueOf.toString();
        int length = string.length();
        String strConcat = ", title=".concat(str);
        StringBuilder sb = new StringBuilder(length + 21 + strConcat.length());
        sb.append("Chapter: startTimeMs=");
        sb.append(string);
        sb.append("");
        sb.append(strConcat);
        return sb.toString();
    }
}
