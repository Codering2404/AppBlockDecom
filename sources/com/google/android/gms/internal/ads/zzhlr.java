package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzhlr {
    private final zziaz zza;
    private final Class zzb;

    /* synthetic */ zzhlr(zziaz zziazVar, Class cls, byte[] bArr) {
        this.zza = zziazVar;
        this.zzb = cls;
    }

    public static zzhlr zzd(zzhlq zzhlqVar, zziaz zziazVar, Class cls) {
        return new zzhlp(zziazVar, cls, zzhlqVar);
    }

    public abstract zzhdq zza(zzhns zzhnsVar, @Nullable zzhel zzhelVar) throws GeneralSecurityException;

    public final zziaz zzb() {
        return this.zza;
    }

    public final Class zzc() {
        return this.zzb;
    }
}
