package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhs {
    private Uri zza;
    private Map zzb;
    private long zzc;
    private final long zzd;
    private int zze;

    /* synthetic */ zzhs(zzht zzhtVar, byte[] bArr) {
        this.zza = zzhtVar.zza;
        this.zzb = zzhtVar.zzd;
        this.zzc = zzhtVar.zze;
        this.zzd = zzhtVar.zzf;
        this.zze = zzhtVar.zzg;
    }

    public final zzhs zza(Uri uri) {
        this.zza = uri;
        return this;
    }

    public final zzhs zzb(Map map) {
        this.zzb = map;
        return this;
    }

    public final zzhs zzc(long j3) {
        this.zzc = j3;
        return this;
    }

    public final zzhs zzd(int i3) {
        this.zze = 6;
        return this;
    }

    public final zzht zze() {
        zzgtj.zzk(this.zza, "The uri must be set.");
        return new zzht(this.zza, 0L, 1, null, this.zzb, this.zzc, this.zzd, null, this.zze, null, null);
    }

    public zzhs() {
        this.zzb = Collections.EMPTY_MAP;
        this.zzd = -1L;
    }
}
