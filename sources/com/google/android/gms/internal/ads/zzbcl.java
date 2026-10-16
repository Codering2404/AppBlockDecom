package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbcl implements Callable {
    private final zzbbs zza;
    private final zzaxm zzb;

    public zzbcl(zzbbs zzbbsVar, zzaxm zzaxmVar) {
        this.zza = zzbbsVar;
        this.zzb = zzaxmVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzbbs zzbbsVar = this.zza;
        if (zzbbsVar.zzm() != null) {
            zzbbsVar.zzm().get();
        }
        zzaym zzaymVarZzl = zzbbsVar.zzl();
        if (zzaymVarZzl == null) {
            return null;
        }
        try {
            zzaxm zzaxmVar = this.zzb;
            synchronized (zzaxmVar) {
                zzaxmVar.zzaY(zzaymVarZzl.zzaN(), zzido.zza());
            }
            return null;
        } catch (zziet | NullPointerException unused) {
            return null;
        }
    }
}
