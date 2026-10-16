package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbrm implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzcfw zza;
    final /* synthetic */ zzbro zzb;

    zzbrm(zzbro zzbroVar, zzcfw zzcfwVar) {
        this.zza = zzcfwVar;
        Objects.requireNonNull(zzbroVar);
        this.zzb = zzbroVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        try {
            this.zza.zzc(this.zzb.zzc().zzp());
        } catch (DeadObjectException e3) {
            this.zza.zzd(e3);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i3) {
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 23);
        sb.append("onConnectionSuspended: ");
        sb.append(i3);
        this.zza.zzd(new RuntimeException(sb.toString()));
    }
}
