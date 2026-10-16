package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhmr {
    private static final zzhmr zza = (zzhmr) zzhny.zza(zzhmq.zza);
    private final AtomicReference zzb = new AtomicReference(new zzhnw(new zzhnt(), null));

    public static zzhmr zza() {
        return zza;
    }

    public final synchronized void zzb(zzhlu zzhluVar) throws GeneralSecurityException {
        AtomicReference atomicReference = this.zzb;
        zzhnt zzhntVar = new zzhnt((zzhnw) atomicReference.get());
        zzhntVar.zza(zzhluVar);
        atomicReference.set(new zzhnw(zzhntVar, null));
    }

    public final synchronized void zzc(zzhlr zzhlrVar) throws GeneralSecurityException {
        AtomicReference atomicReference = this.zzb;
        zzhnt zzhntVar = new zzhnt((zzhnw) atomicReference.get());
        zzhntVar.zzb(zzhlrVar);
        atomicReference.set(new zzhnw(zzhntVar, null));
    }

    public final synchronized void zzd(zzhmy zzhmyVar) throws GeneralSecurityException {
        AtomicReference atomicReference = this.zzb;
        zzhnt zzhntVar = new zzhnt((zzhnw) atomicReference.get());
        zzhntVar.zzc(zzhmyVar);
        atomicReference.set(new zzhnw(zzhntVar, null));
    }

    public final synchronized void zze(zzhmv zzhmvVar) throws GeneralSecurityException {
        AtomicReference atomicReference = this.zzb;
        zzhnt zzhntVar = new zzhnt((zzhnw) atomicReference.get());
        zzhntVar.zzd(zzhmvVar);
        atomicReference.set(new zzhnw(zzhntVar, null));
    }

    public final boolean zzf(zzhns zzhnsVar) {
        return ((zzhnw) this.zzb.get()).zza(zzhnsVar);
    }

    public final zzhdq zzg(zzhns zzhnsVar, @Nullable zzhel zzhelVar) throws GeneralSecurityException {
        return ((zzhnw) this.zzb.get()).zzb(zzhnsVar, zzhelVar);
    }

    public final zzhns zzh(zzhdq zzhdqVar, Class cls, @Nullable zzhel zzhelVar) throws GeneralSecurityException {
        return ((zzhnw) this.zzb.get()).zzc(zzhdqVar, cls, zzhelVar);
    }

    public final boolean zzi(zzhns zzhnsVar) {
        return ((zzhnw) this.zzb.get()).zzd(zzhnsVar);
    }

    public final zzheh zzj(zzhns zzhnsVar) throws GeneralSecurityException {
        return ((zzhnw) this.zzb.get()).zze(zzhnsVar);
    }

    public final zzhns zzk(zzheh zzhehVar, Class cls) throws GeneralSecurityException {
        return ((zzhnw) this.zzb.get()).zzf(zzhehVar, cls);
    }
}
