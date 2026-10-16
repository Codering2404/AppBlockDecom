package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzde {
    private static final String zzd;
    private static final String zze;
    private static final String zzf;
    public final int zza;
    public final int zzb;
    public final int zzc;

    static {
        String str = zzfl.zza;
        zzd = Integer.toString(0, 36);
        zze = Integer.toString(1, 36);
        zzf = Integer.toString(2, 36);
    }

    public zzde(int i3, int i4, int i5) {
        this.zza = i3;
        this.zzb = i4;
        this.zzc = i5;
    }

    public final Bundle zza() {
        Bundle bundle = new Bundle();
        bundle.putInt(zzd, this.zza);
        bundle.putInt(zze, this.zzb);
        bundle.putInt(zzf, this.zzc);
        return bundle;
    }
}
