package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzauc {
    private final int zza;
    private final List zzb;
    private final int zzc;
    private final InputStream zzd;

    public zzauc(int i3, List list, int i4, InputStream inputStream) {
        this.zza = i3;
        this.zzb = list;
        this.zzc = i4;
        this.zzd = inputStream;
    }

    public final int zza() {
        return this.zza;
    }

    public final List zzb() {
        return Collections.unmodifiableList(this.zzb);
    }

    public final int zzc() {
        return this.zzc;
    }

    public final InputStream zzd() {
        InputStream inputStream = this.zzd;
        if (inputStream != null) {
            return inputStream;
        }
        return null;
    }
}
