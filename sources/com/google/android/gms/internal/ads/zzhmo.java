package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhmo {
    private static final zzhmo zza = new zzhmo();
    private final AtomicReference zzb;

    zzhmo() {
        byte[] bArr = null;
        this.zzb = new AtomicReference(new zzhnj(new zzhng(bArr), bArr));
    }

    public static zzhmo zza() {
        return zza;
    }

    public final synchronized void zzb(zzhnf zzhnfVar) throws GeneralSecurityException {
        AtomicReference atomicReference = this.zzb;
        byte[] bArr = null;
        zzhng zzhngVar = new zzhng((zzhnj) atomicReference.get(), bArr);
        zzhngVar.zza(zzhnfVar);
        atomicReference.set(new zzhnj(zzhngVar, bArr));
    }

    public final synchronized void zzc(zzhnl zzhnlVar) throws GeneralSecurityException {
        AtomicReference atomicReference = this.zzb;
        byte[] bArr = null;
        zzhng zzhngVar = new zzhng((zzhnj) atomicReference.get(), bArr);
        zzhngVar.zzb(zzhnlVar);
        atomicReference.set(new zzhnj(zzhngVar, bArr));
    }

    public final Object zzd(zzhdq zzhdqVar, Class cls) throws GeneralSecurityException {
        return ((zzhnj) this.zzb.get()).zza(zzhdqVar, cls);
    }

    public final Object zze(zzhec zzhecVar, Class cls) throws GeneralSecurityException {
        return ((zzhnj) this.zzb.get()).zzb(zzhecVar, cls);
    }
}
