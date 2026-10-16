package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzhlu {
    private final Class zza;
    private final Class zzb;

    /* synthetic */ zzhlu(Class cls, Class cls2, byte[] bArr) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzhlu zzd(zzhlt zzhltVar, Class cls, Class cls2) {
        return new zzhls(cls, cls2, zzhltVar);
    }

    public abstract zzhns zza(zzhdq zzhdqVar, @Nullable zzhel zzhelVar) throws GeneralSecurityException;

    public final Class zzb() {
        return this.zza;
    }

    public final Class zzc() {
        return this.zzb;
    }
}
