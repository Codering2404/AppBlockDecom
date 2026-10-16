package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzbdf implements Callable {
    protected final zzbbs zza;
    protected final String zzb;
    protected final String zzc;
    protected final zzaxm zzd;
    protected Method zze;
    protected final int zzf;
    protected final int zzg;

    public zzbdf(zzbbs zzbbsVar, String str, String str2, zzaxm zzaxmVar, int i3, int i4) {
        this.zza = zzbbsVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzaxmVar;
        this.zzf = i3;
        this.zzg = i4;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        int i3;
        try {
            long jNanoTime = System.nanoTime();
            zzbbs zzbbsVar = this.zza;
            Method methodZzo = zzbbsVar.zzo(this.zzb, this.zzc);
            this.zze = methodZzo;
            if (methodZzo == null) {
                return null;
            }
            zza();
            zzbaj zzbajVarZzh = zzbbsVar.zzh();
            if (zzbajVarZzh == null || (i3 = this.zzf) == Integer.MIN_VALUE) {
                return null;
            }
            zzbajVarZzh.zza(this.zzg, i3, (System.nanoTime() - jNanoTime) / 1000, null, null);
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    protected abstract void zza() throws IllegalAccessException, InvocationTargetException;
}
