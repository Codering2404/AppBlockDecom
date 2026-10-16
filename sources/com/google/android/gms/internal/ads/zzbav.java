package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbav {
    private NetworkCapabilities zza;

    zzbav(ConnectivityManager connectivityManager) {
        if (connectivityManager != null) {
            try {
                connectivityManager.registerDefaultNetworkCallback(new zzbau(this));
            } catch (RuntimeException unused) {
                synchronized (zzbav.class) {
                    this.zza = null;
                }
            }
        }
    }

    public static zzbav zza(Context context) {
        if (context != null) {
            return new zzbav((ConnectivityManager) context.getSystemService("connectivity"));
        }
        return null;
    }

    public final NetworkCapabilities zzb() {
        return this.zza;
    }

    public final long zzc() {
        synchronized (zzbav.class) {
            try {
                NetworkCapabilities networkCapabilities = this.zza;
                if (networkCapabilities != null) {
                    if (networkCapabilities.hasTransport(4)) {
                        return 2L;
                    }
                    if (this.zza.hasTransport(1)) {
                        return 1L;
                    }
                    if (this.zza.hasTransport(0)) {
                        return 0L;
                    }
                }
                return -1L;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final /* synthetic */ void zzd(NetworkCapabilities networkCapabilities) {
        this.zza = networkCapabilities;
    }
}
