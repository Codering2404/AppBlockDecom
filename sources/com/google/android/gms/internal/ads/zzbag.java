package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbag implements Runnable {
    final /* synthetic */ zzbah zza;

    zzbag(zzbah zzbahVar) {
        Objects.requireNonNull(zzbahVar);
        this.zza = zzbahVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbah zzbahVar = this.zza;
        synchronized (zzbahVar.zzp()) {
            if (zzbahVar.zzq()) {
                return;
            }
            zzbahVar.zzr(true);
            try {
                zzbahVar.zzn();
            } catch (Exception e3) {
                this.zza.zzo().zzc(2023, -1L, e3);
            }
            zzbah zzbahVar2 = this.zza;
            synchronized (zzbahVar2.zzp()) {
                zzbahVar2.zzr(false);
            }
        }
    }
}
