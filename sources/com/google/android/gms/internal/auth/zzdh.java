package com.google.android.gms.internal.auth;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzdh implements Serializable {
    zzdh() {
    }

    public static zzdh zzc() {
        return zzdf.zza;
    }

    public static zzdh zzd(Object obj) {
        return new zzdi(obj);
    }

    public abstract Object zza();

    public abstract boolean zzb();
}
