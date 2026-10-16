package com.google.android.gms.internal.common;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzi {
    private final Class zza;
    private final Object zzb;

    private zzi(Class cls, Object obj) {
        this.zza = cls;
        this.zzb = obj;
    }

    public static zzi zzb(Class cls, Object obj) {
        return new zzi(cls, obj);
    }

    public final Class zzc() {
        return this.zza;
    }

    public final Object zzd() {
        return this.zzb;
    }

    /* synthetic */ zzi(Class cls, Object obj, byte[] bArr) {
        this(cls, obj);
    }
}
