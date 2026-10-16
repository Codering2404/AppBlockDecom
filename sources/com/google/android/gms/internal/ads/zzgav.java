package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgav extends zzidy implements zzifq {
    private zzgav() {
        throw null;
    }

    public final zzgav zza(String str) {
        str.getClass();
        zzbg();
        ((zzgax) this.zza).zze().remove(str);
        return this;
    }

    public final Map zzb() {
        return Collections.unmodifiableMap(((zzgax) this.zza).zzb());
    }

    public final zzgav zzc(String str, zzgat zzgatVar) {
        str.getClass();
        zzgatVar.getClass();
        zzbg();
        ((zzgax) this.zza).zze().put(str, zzgatVar);
        return this;
    }

    /* synthetic */ zzgav(byte[] bArr) {
        super(zzgax.zzb);
    }
}
