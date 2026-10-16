package com.google.android.gms.internal.ads;

import java.math.BigInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhlf {
    static final zzhlf zzd;
    final BigInteger zza;
    final BigInteger zzb;
    final BigInteger zzc;

    static {
        BigInteger bigInteger = BigInteger.ONE;
        zzd = new zzhlf(bigInteger, bigInteger, BigInteger.ZERO);
    }

    zzhlf(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.zza = bigInteger;
        this.zzb = bigInteger2;
        this.zzc = bigInteger3;
    }

    final boolean zza() {
        return this.zzc.equals(BigInteger.ZERO);
    }
}
