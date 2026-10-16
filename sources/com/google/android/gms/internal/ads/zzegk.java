package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzegk implements zzdfx {
    private final Context zza;
    private final zzcdz zzb;

    zzegk(Context context, zzcdz zzcdzVar) {
        this.zza = context;
        this.zzb = zzcdzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfx
    public final void zzdQ(zzfkq zzfkqVar) {
        String str = zzfkqVar.zzb.zzb.zze;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        zzcdz zzcdzVar = this.zzb;
        Context context = this.zza;
        zzcdzVar.zzc(context, zzfkqVar.zza.zza.zzd);
        zzcdzVar.zzm(context, str);
    }

    @Override // com.google.android.gms.internal.ads.zzdfx
    public final void zzdP(zzcbd zzcbdVar) {
    }
}
