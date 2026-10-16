package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhmc implements zzhdj {
    private final Map zza;

    static {
        new zzhmb().zza();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzhmc) {
            return this.zza.equals(((zzhmc) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return this.zza.toString();
    }

    public final boolean zza() {
        return this.zza.isEmpty();
    }
}
