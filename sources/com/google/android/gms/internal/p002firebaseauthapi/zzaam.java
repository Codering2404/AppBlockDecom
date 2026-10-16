package com.google.android.gms.internal.p002firebaseauthapi;

import java.math.BigInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaam {
    private final BigInteger zza;

    private zzaam(BigInteger bigInteger) {
        this.zza = bigInteger;
    }

    public static zzaam zza(BigInteger bigInteger, zzch zzchVar) {
        if (zzchVar != null) {
            return new zzaam(bigInteger);
        }
        throw new NullPointerException("SecretKeyAccess required");
    }

    public final BigInteger zza(zzch zzchVar) {
        if (zzchVar != null) {
            return this.zza;
        }
        throw new NullPointerException("SecretKeyAccess required");
    }
}
