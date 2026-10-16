package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzarf {
    public final int zza;
    public final String zzb;
    public final int zzc;
    public final List zzd;
    public final byte[] zze;

    public zzarf(int i3, String str, int i4, List list, byte[] bArr) {
        this.zza = i3;
        this.zzb = str;
        this.zzc = i4;
        this.zzd = list == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(list);
        this.zze = bArr;
    }

    public final int zza() {
        int i3 = this.zzc;
        if (i3 != 2) {
            return i3 != 3 ? 0 : 512;
        }
        return 2048;
    }
}
