package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhmb {
    private HashMap zza = new HashMap();

    public final zzhmc zza() {
        if (this.zza == null) {
            throw new IllegalStateException("cannot call build() twice");
        }
        zzhmc zzhmcVar = new zzhmc(Collections.unmodifiableMap(this.zza), null);
        this.zza = null;
        return zzhmcVar;
    }
}
