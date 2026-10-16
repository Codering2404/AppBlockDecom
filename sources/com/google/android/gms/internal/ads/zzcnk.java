package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcnk {
    private VersionInfoParcel zza;
    private Context zzb;
    private long zzc;
    private WeakReference zzd;

    public final zzcnk zza(VersionInfoParcel versionInfoParcel) {
        this.zza = versionInfoParcel;
        return this;
    }

    public final zzcnk zzb(Context context) {
        this.zzd = new WeakReference(context);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.zzb = context;
        return this;
    }

    public final zzcnk zzc(long j3) {
        this.zzc = j3;
        return this;
    }

    final /* synthetic */ VersionInfoParcel zzd() {
        return this.zza;
    }

    final /* synthetic */ Context zze() {
        return this.zzb;
    }

    final /* synthetic */ long zzf() {
        return this.zzc;
    }

    final /* synthetic */ WeakReference zzg() {
        return this.zzd;
    }
}
