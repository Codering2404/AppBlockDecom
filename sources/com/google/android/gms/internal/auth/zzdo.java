package com.google.android.gms.internal.auth;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdo {
    public static zzdj zza(zzdj zzdjVar) {
        return ((zzdjVar instanceof zzdm) || (zzdjVar instanceof zzdk)) ? zzdjVar : zzdjVar instanceof Serializable ? new zzdk(zzdjVar) : new zzdm(zzdjVar);
    }

    public static zzdj zzb(Object obj) {
        return new zzdn(obj);
    }
}
