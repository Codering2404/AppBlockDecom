package com.google.android.gms.internal.ads;

import java.security.spec.ECParameterSpec;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhuq {
    public static final zzhuq zza = new zzhuq("NIST_P256", zzhlg.zza);
    public static final zzhuq zzb = new zzhuq("NIST_P384", zzhlg.zzb);
    public static final zzhuq zzc = new zzhuq("NIST_P521", zzhlg.zzc);
    private final String zzd;
    private final ECParameterSpec zze;

    private zzhuq(String str, ECParameterSpec eCParameterSpec) {
        this.zzd = str;
        this.zze = eCParameterSpec;
    }

    public final String toString() {
        return this.zzd;
    }

    public final ECParameterSpec zza() {
        return this.zze;
    }
}
