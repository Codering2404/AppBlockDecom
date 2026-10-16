package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzen {
    final /* synthetic */ zzer zza;
    private final WeakReference zzb;
    private final Executor zzc;

    public zzen(zzer zzerVar, zzel zzelVar, Executor executor) {
        Objects.requireNonNull(zzerVar);
        this.zza = zzerVar;
        this.zzb = new WeakReference(zzelVar);
        this.zzc = executor;
    }

    public final boolean zza() {
        return this.zzb.get() == null;
    }

    public final void zzb() {
        this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzem
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzc();
            }
        });
    }

    final /* synthetic */ void zzc() {
        zzel zzelVar = (zzel) this.zzb.get();
        if (zzelVar != null) {
            zzelVar.zza(this.zza.zzc());
        }
    }
}
