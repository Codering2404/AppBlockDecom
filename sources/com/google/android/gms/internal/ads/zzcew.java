package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcew {
    final /* synthetic */ zzcex zza;
    private long zzb;
    private long zzc;

    public zzcew(zzcex zzcexVar) {
        Objects.requireNonNull(zzcexVar);
        this.zza = zzcexVar;
        this.zzb = -1L;
        this.zzc = -1L;
    }

    public final long zza() {
        return this.zzc;
    }

    public final void zzb() {
        this.zzc = this.zza.zzk().a();
    }

    public final void zzc() {
        this.zzb = this.zza.zzk().a();
    }

    public final Bundle zzd() {
        Bundle bundle = new Bundle();
        bundle.putLong("topen", this.zzb);
        bundle.putLong("tclose", this.zzc);
        return bundle;
    }
}
