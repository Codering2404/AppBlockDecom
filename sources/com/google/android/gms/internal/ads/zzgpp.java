package com.google.android.gms.internal.ads;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgpp extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ zzgpr zza;

    zzgpp(zzgpr zzgprVar) {
        Objects.requireNonNull(zzgprVar);
        this.zza = zzgprVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        zzgpr zzgprVar = this.zza;
        synchronized (zzgprVar) {
            zzgprVar.zzf(networkCapabilities);
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        zzgpr zzgprVar = this.zza;
        synchronized (zzgprVar) {
            zzgprVar.zzf(null);
        }
    }
}
