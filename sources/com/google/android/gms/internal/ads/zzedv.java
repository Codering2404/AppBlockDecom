package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzedv {
    private final Context zza;
    private zzarx zzb;

    zzedv(Context context) {
        this.zza = context;
    }

    public final void zza() {
        this.zzb = zzarw.zza(this.zza);
    }

    public final void zzb(zzasa zzasaVar) {
        this.zzb.zzb(zzasaVar);
    }

    public final void zzc() {
        this.zzb.zzc();
    }

    public final zzasb zzd() {
        try {
            zzarx zzarxVar = this.zzb;
            if (zzarxVar == null || !zzarxVar.zza()) {
                return null;
            }
            return zzarxVar.zzd();
        } catch (RemoteException unused) {
            return null;
        }
    }
}
