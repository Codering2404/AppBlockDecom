package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfxq {
    private final Context zza;
    private final Looper zzb;

    public zzfxq(Context context, Looper looper) {
        this.zza = context;
        this.zzb = looper;
    }

    public final void zza(String str) {
        zzfya zzfyaVarZza = zzfyc.zza();
        Context context = this.zza;
        zzfyaVarZza.zza(context.getPackageName());
        zzfyaVarZza.zzc(2);
        zzfxy zzfxyVarZza = zzfxz.zza();
        zzfxyVarZza.zza(str);
        zzfxyVarZza.zzb(2);
        zzfyaVarZza.zzb(zzfxyVarZza);
        new zzfxr(context, this.zzb, (zzfyc) zzfyaVarZza.zzbu()).zza();
    }
}
