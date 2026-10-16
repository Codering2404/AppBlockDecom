package com.google.android.gms.internal.identity_credentials;

import com.google.android.gms.common.Feature;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zze {
    public static final Feature zza;
    public static final Feature zzb;
    public static final Feature zzc;
    public static final Feature[] zzd;

    static {
        Feature feature = new Feature("GET_CREDENTIAL", 1L);
        zza = feature;
        Feature feature2 = new Feature("CREDENTIAL_REGISTRY", 1L);
        zzb = feature2;
        Feature feature3 = new Feature("CLEAR_REGISTRY", 1L);
        zzc = feature3;
        zzd = new Feature[]{feature, feature2, feature3};
    }
}
