package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfgg extends zzffn {
    public zzfgg(Context context, Executor executor, zzcnj zzcnjVar, zzfhw zzfhwVar, zzfge zzfgeVar, zzfkx zzfkxVar, VersionInfoParcel versionInfoParcel) {
        super(context, executor, zzcnjVar, zzfhwVar, zzfgeVar, zzfkxVar, versionInfoParcel);
    }

    @Override // com.google.android.gms.internal.ads.zzffn
    protected final /* bridge */ /* synthetic */ zzdby zzc(zzcvi zzcviVar, zzdcb zzdcbVar, zzdir zzdirVar) {
        zzcuy zzcuyVarZzk = this.zza.zzk();
        zzcuyVarZzk.zzd(zzdcbVar);
        zzcuyVarZzk.zze(zzdirVar);
        return zzcuyVarZzk;
    }
}
