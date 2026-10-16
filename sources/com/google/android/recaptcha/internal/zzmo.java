package com.google.android.recaptcha.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzmo {
    static final zzmo zza = new zzmo(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private final Map zzd;

    zzmo() {
        this.zzd = new HashMap();
    }

    public final zznc zza(zzoi zzoiVar, int i3) {
        return (zznc) this.zzd.get(new zzmn(zzoiVar, i3));
    }

    zzmo(boolean z2) {
        this.zzd = Collections.EMPTY_MAP;
    }
}
