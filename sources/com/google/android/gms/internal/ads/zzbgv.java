package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbgv implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzbgx zza;

    zzbgv(zzbgx zzbgxVar) {
        Objects.requireNonNull(zzbgxVar);
        this.zza = zzbgxVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzbgx zzbgxVar = this.zza;
        synchronized (zzbgxVar.zzh()) {
            try {
            } catch (DeadObjectException e3) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Unable to obtain a cache service instance.", e3);
                this.zza.zzg();
            }
            if (zzbgxVar.zzi() != null) {
                zzbgxVar.zzk(zzbgxVar.zzi().zzq());
                this.zza.zzh().notifyAll();
            } else {
                this.zza.zzh().notifyAll();
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i3) {
        zzbgx zzbgxVar = this.zza;
        synchronized (zzbgxVar.zzh()) {
            zzbgxVar.zzk(null);
            zzbgxVar.zzh().notifyAll();
        }
    }
}
