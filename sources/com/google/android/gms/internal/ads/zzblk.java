package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzblk {
    private final Context zza;

    public zzblk(Context context) {
        this.zza = context;
    }

    public final void zza(zzcae zzcaeVar) {
        try {
            ((zzbll) com.google.android.gms.ads.internal.util.client.zzs.a(this.zza, "com.google.android.gms.ads.flags.FlagRetrieverSupplierProxy", zzblj.zza)).zze(zzcaeVar);
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.f("Error calling setFlagsAccessedBeforeInitializedListener: ".concat(String.valueOf(e3.getMessage())));
        } catch (com.google.android.gms.ads.internal.util.client.zzr e4) {
            com.google.android.gms.ads.internal.util.client.zzo.f("Could not load com.google.android.gms.ads.flags.FlagRetrieverSupplierProxy:".concat(String.valueOf(e4.getMessage())));
        }
    }
}
