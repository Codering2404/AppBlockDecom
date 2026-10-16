package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhnu {
    private final Class zza;
    private final zziaz zzb;

    /* synthetic */ zzhnu(Class cls, zziaz zziazVar, byte[] bArr) {
        this.zza = cls;
        this.zzb = zziazVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhnu)) {
            return false;
        }
        zzhnu zzhnuVar = (zzhnu) obj;
        return zzhnuVar.zza.equals(this.zza) && zzhnuVar.zzb.equals(this.zzb);
    }

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb);
    }

    public final String toString() {
        zziaz zziazVar = this.zzb;
        String simpleName = this.zza.getSimpleName();
        String strValueOf = String.valueOf(zziazVar);
        StringBuilder sb = new StringBuilder(simpleName.length() + 21 + strValueOf.length());
        sb.append(simpleName);
        sb.append(", object identifier: ");
        sb.append(strValueOf);
        return sb.toString();
    }
}
