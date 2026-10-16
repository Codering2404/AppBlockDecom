package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbgw implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzbgx zza;

    zzbgw(zzbgx zzbgxVar) {
        Objects.requireNonNull(zzbgxVar);
        this.zza = zzbgxVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zzbgx zzbgxVar = this.zza;
        synchronized (zzbgxVar.zzh()) {
            try {
                zzbgxVar.zzk(null);
                if (zzbgxVar.zzi() != null) {
                    zzbgxVar.zzj(null);
                }
                zzbgxVar.zzh().notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
