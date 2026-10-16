package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzok {
    public static final zzok zza = new zzoj().zza();
    private final Map<String, String> zzb;

    public final boolean equals(Object obj) {
        if (obj instanceof zzok) {
            return this.zzb.equals(((zzok) obj).zzb);
        }
        return false;
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    public final String toString() {
        return this.zzb.toString();
    }

    public final boolean zza() {
        return this.zzb.isEmpty();
    }

    private zzok(Map<String, String> map) {
        this.zzb = map;
    }
}
