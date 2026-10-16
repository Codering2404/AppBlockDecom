package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzeq implements Runnable {
    final long zzh;
    final long zzi;
    final boolean zzj;
    final /* synthetic */ zzfb zzk;

    zzeq(zzfb zzfbVar, boolean z2) {
        Objects.requireNonNull(zzfbVar);
        this.zzk = zzfbVar;
        this.zzh = zzfbVar.zza.currentTimeMillis();
        this.zzi = zzfbVar.zza.a();
        this.zzj = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzk.zzP()) {
            zzb();
            return;
        }
        try {
            zza();
        } catch (Exception e3) {
            this.zzk.zzN(e3, false, this.zzj);
            zzb();
        }
    }

    abstract void zza() throws RemoteException;

    protected void zzb() {
    }
}
