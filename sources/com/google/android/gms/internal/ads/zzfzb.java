package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.util.Log;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfzb {
    final /* synthetic */ zzfzc zza;
    private final byte[] zzb;
    private int zzc;
    private int zzd;

    /* synthetic */ zzfzb(zzfzc zzfzcVar, byte[] bArr, byte[] bArr2) {
        Objects.requireNonNull(zzfzcVar);
        this.zza = zzfzcVar;
        this.zzb = bArr;
    }

    public final synchronized void zza() {
        try {
            zzfzc zzfzcVar = this.zza;
            if (zzfzcVar.zzb) {
                zzfzf zzfzfVar = zzfzcVar.zza;
                zzfzfVar.zzg(this.zzb);
                zzfzfVar.zzh(this.zzc);
                zzfzfVar.zzi(this.zzd);
                zzfzfVar.zzf(null);
                zzfzfVar.zze();
            }
        } catch (RemoteException e3) {
            Log.d("GASS", "Clearcut log failed", e3);
        }
    }

    public final zzfzb zzb(int i3) {
        this.zzc = i3;
        return this;
    }

    public final zzfzb zzc(int i3) {
        this.zzd = i3;
        return this;
    }
}
