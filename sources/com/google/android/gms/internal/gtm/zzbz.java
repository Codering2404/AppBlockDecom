package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbz {
    private final String zza;
    private final String zzb;
    private final boolean zzc;
    private long zzd;
    private final Map zze;

    public zzbz(long j3, String str, String str2, boolean z2, long j4, Map map) {
        Preconditions.g(str);
        Preconditions.g(str2);
        this.zza = str;
        this.zzb = str2;
        this.zzc = z2;
        this.zzd = j4;
        if (map != null) {
            this.zze = new HashMap(map);
        } else {
            this.zze = Collections.EMPTY_MAP;
        }
    }

    public final long zza() {
        return this.zzd;
    }

    public final String zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final Map zzd() {
        return this.zze;
    }

    public final void zze(long j3) {
        this.zzd = j3;
    }

    public final boolean zzf() {
        return this.zzc;
    }
}
