package com.google.android.gms.internal.ads;

import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzabn {
    private final Handler zza;
    private final zzabp zzb;
    private boolean zzc;

    public zzabn(Handler handler, zzabp zzabpVar) {
        this.zza = handler;
        this.zzb = zzabpVar;
    }

    public final void zza() {
        this.zzc = true;
    }

    final /* synthetic */ Handler zzb() {
        return this.zza;
    }

    final /* synthetic */ zzabp zzc() {
        return this.zzb;
    }

    final /* synthetic */ boolean zzd() {
        return this.zzc;
    }
}
