package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzatc implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzate zzc;

    zzatc(zzate zzateVar, String str, long j3) {
        this.zza = str;
        this.zzb = j3;
        Objects.requireNonNull(zzateVar);
        this.zzc = zzateVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzate zzateVar = this.zzc;
        zzateVar.zzx().zza(this.zza, this.zzb);
        zzateVar.zzx().zzb(zzateVar.toString());
    }
}
