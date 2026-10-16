package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzpn<P> {
    private final Map<zzaaj, List<P>> zza = new HashMap();

    public final zzpn<P> zza(zzaaj zzaajVar, P p3) throws GeneralSecurityException {
        List<P> list;
        if (zzaajVar.zza() != 0 && zzaajVar.zza() != 5) {
            throw new GeneralSecurityException("PrefixMap only supports 0 and 5 byte prefixes");
        }
        if (this.zza.containsKey(zzaajVar)) {
            list = this.zza.get(zzaajVar);
        } else {
            ArrayList arrayList = new ArrayList();
            this.zza.put(zzaajVar, arrayList);
            list = arrayList;
        }
        list.add(p3);
        return this;
    }

    public final zzpl<P> zza() {
        return new zzpl<>(this.zza);
    }
}
