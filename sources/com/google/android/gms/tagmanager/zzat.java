package com.google.android.gms.tagmanager;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzat {
    public final String zza;
    public final Object zzb;

    zzat(String str, Object obj) {
        this.zza = str;
        this.zzb = obj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzat)) {
            return false;
        }
        zzat zzatVar = (zzat) obj;
        if (this.zza.equals(zzatVar.zza)) {
            Object obj2 = this.zzb;
            if (obj2 == null && zzatVar.zzb == null) {
                return true;
            }
            return obj2 != null && obj2.equals(zzatVar.zzb);
        }
        return false;
    }

    public final int hashCode() {
        Preconditions.m(this.zzb);
        return Arrays.hashCode(new Integer[]{Integer.valueOf(this.zza.hashCode()), Integer.valueOf(this.zzb.hashCode())});
    }

    public final String toString() {
        return "Key: " + this.zza + " value: " + String.valueOf(this.zzb);
    }
}
