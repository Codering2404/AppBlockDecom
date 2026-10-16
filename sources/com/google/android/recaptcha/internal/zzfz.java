package com.google.android.recaptcha.internal;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzfz {
    private final zzjj zza;

    public zzfz() {
        this(1);
    }

    public final List zwk() {
        return zza();
    }

    public final List zza() {
        return CollectionsKt.toList(this.zza);
    }

    public final boolean zzb(List list) {
        this.zza.add(list);
        return true;
    }

    public zzfz(int i3) {
        this.zza = zzjj.zza(i3);
    }
}
