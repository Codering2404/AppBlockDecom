package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzvw {
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;

    public zzvw(String str, boolean z2, boolean z3) {
        this.zza = str;
        this.zzb = z2;
        this.zzc = z3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == zzvw.class) {
            zzvw zzvwVar = (zzvw) obj;
            if (TextUtils.equals(this.zza, zzvwVar.zza) && this.zzb == zzvwVar.zzb && this.zzc == zzvwVar.zzc) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.zza.hashCode() + 31) * 31) + (true != this.zzb ? 1237 : 1231)) * 31) + (true != this.zzc ? 1237 : 1231);
    }
}
