package com.google.android.gms.tagmanager;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzay implements Runnable {
    final /* synthetic */ List zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzbd zzc;

    zzay(zzbd zzbdVar, List list, long j3) {
        this.zzc = zzbdVar;
        this.zza = list;
        this.zzb = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zzl(this.zza, this.zzb);
    }
}
