package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzoj {
    private HashMap<String, String> zza = new HashMap<>();

    public final zzok zza() {
        if (this.zza == null) {
            throw new IllegalStateException("cannot call build() twice");
        }
        zzok zzokVar = new zzok(Collections.unmodifiableMap(this.zza));
        this.zza = null;
        return zzokVar;
    }
}
