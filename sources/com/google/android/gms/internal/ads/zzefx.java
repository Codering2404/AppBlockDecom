package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzefx extends zzegc {
    private final Context zzg;
    private final VersionInfoParcel zzh;
    private final zzefw zzi;

    zzefx(Context context, VersionInfoParcel versionInfoParcel, zzefw zzefwVar, zzcag zzcagVar) {
        this.zzg = context;
        this.zzh = versionInfoParcel;
        this.zzi = zzefwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzegc, com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.zzb) {
            if (!this.zzd) {
                this.zzd = true;
                try {
                    this.zzf.zzp().zzi(this.zzh.f70149a);
                    this.zzi.zza();
                } catch (RemoteException e3) {
                    this.zzi.zzb(e3);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzegc, com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
        this.zzi.zzb(new RemoteException("Connection failed: ".concat(String.valueOf(connectionResult.O()))));
    }

    @Override // com.google.android.gms.internal.ads.zzegc, com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i3) {
        int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.a("Cannot connect to remote service, fallback to local instance.");
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 33);
        sb.append("Connection suspended with cause: ");
        sb.append(i3);
        this.zzi.zzb(new RemoteException(sb.toString()));
    }

    public final void zza() {
        synchronized (this.zzb) {
            try {
                if (this.zzc) {
                    return;
                }
                this.zzc = true;
                zzcaf zzcafVar = new zzcaf(this.zzg, com.google.android.gms.ads.internal.zzt.w().a(), this, this);
                this.zzf = zzcafVar;
                zzcafVar.checkAvailabilityAndConnect();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
